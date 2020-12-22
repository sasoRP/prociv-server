package com.prosas.prociv.server.services;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import com.prosas.prociv.server.integration.client.ProCivClient;
import com.prosas.prociv.server.integration.client.ProCivClientImpl;
import com.prosas.prociv.server.integration.client.ProCivHttpClientException;
import com.prosas.prociv.server.integration.client.entities.Datum;
import com.prosas.prociv.server.integration.client.entities.Root;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.transform.stream.StreamSource;
import org.eclipse.yasson.internal.Unmarshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author prosas
 */
@Stateless
public class OccurrencesServiceImpl implements OccurrencesService {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(OccurrencesServiceImpl.class);

    @EJB
    private ProCivClient proCivClient;

    @Override
    public List<Occurrence> getOccurrencesByCouncil(int councilId) {
        List<Occurrence> occurrences = new ArrayList<>();

        try {
            String jsonResponse = proCivClient.getOccurrencesByCouncil(councilId);
            occurrences = parseResponse(jsonResponse);
        }
        catch (ProCivHttpClientException ex) {
            LOGGER.error("Returning an empty list of occurrences as there was an error raised by the ProCivClient: {}", ex.getMessage());
        }

        return occurrences;
    }

    private List<Occurrence> parseResponse(String jsonResponse) {
        List<Occurrence> occurrences = new ArrayList<>();

        try {
            LOGGER.debug("Parsing JSON data from ProCiv: {}", jsonResponse);

            Jsonb jsonb = JsonbBuilder.create();
            Root root = jsonb.fromJson(jsonResponse, Root.class);
            occurrences = mapRootToOccurrences(root);
        }
        catch (Exception ex) {
            LOGGER.error("Failed to parse ProCiv JSON data: {}", ex.getMessage());
        }

        return occurrences;
    }

    private List<Occurrence> mapRootToOccurrences(Root root) {
        List<Occurrence> occurrences = new ArrayList<>();
        List<Datum> datumList = root.getHistoryOccurrencesByLocationResult.ArrayInfo.get(0).Data;

        for (Datum datum: datumList) {
            Occurrence occurrence = new Occurrence();
            occurrence.setDescription(datum.Natureza.Nome);
            occurrence.setCouncilId(datum.Concelho.Id);
            occurrence.setExternalId(datum.Id);

            occurrences.add(occurrence);
        }

        return occurrences;
    }
}
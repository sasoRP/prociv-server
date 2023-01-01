package com.prosas.prociv.server.services;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import com.prosas.prociv.server.api.viewModels.OccurrenceLocation;
import com.prosas.prociv.server.api.viewModels.OccurrenceResources;
import com.prosas.prociv.server.integration.client.ProCivClient;
import com.prosas.prociv.server.integration.client.ProCivHttpClientException;
import com.prosas.prociv.server.integration.client.entities.Datum;
import com.prosas.prociv.server.integration.client.entities.Root;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author sasoRP
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

    @Override
    public List<Occurrence> getOccurrencesByDistrict(int districtId) {
        List<Occurrence> occurrences = new ArrayList<>();

        try {
            String jsonResponse = proCivClient.getOccurrencesByDistrict(districtId);
            occurrences = parseResponse(jsonResponse);
        }
        catch (ProCivHttpClientException ex) {
            LOGGER.error("Returning an empty list of occurrences as there was an error raised by the ProCivClient: {}", ex.getMessage());
        }

        return occurrences;
    }

    @Override
    public List<Occurrence> getOccurrencesByParish(int parishId) {
        List<Occurrence> occurrences = new ArrayList<>();

        try {
            String jsonResponse = proCivClient.getOccurrencesByParish(parishId);
            occurrences = parseResponse(jsonResponse);
        }
        catch (ProCivHttpClientException ex) {
            LOGGER.error("Returning an empty list of occurrences as there was an error raised by the ProCivClient: {}", ex.getMessage());
        }

        return occurrences;
    }

    @Override
    public List<Occurrence> getOccurrences() {
        List<Occurrence> occurrences = new ArrayList<>();

        try {
            String jsonResponse = proCivClient.getOccurrences();
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
            Occurrence occurrence = new Occurrence.Builder(datum.Id)
                    .withDate(new Date(buildDate(datum.DataOcorrencia)))
                    .withDescription(datum.Natureza.Nome)
                    .withStatus(datum.EstadoOcorrencia.Name)
                    .withLocation(buildLocation(datum))
                    .withResources(buildResources(datum))
                    .build();

            occurrences.add(occurrence);
        }

        return occurrences;
    }

    private long buildDate(String date) {
        int start = date.indexOf('(') + 1;
        int end = date.indexOf('+');

        String millisecondsString = date.substring(start, end);

        return Long.parseLong(millisecondsString);
    }

    private OccurrenceLocation buildLocation(Datum datum) {
        OccurrenceLocation location = new OccurrenceLocation();

        location.setDistrictId(datum.Distrito.Id);
        location.setDistrictName(datum.Distrito.Name);
        location.setCouncilId(datum.Concelho.Id);
        location.setCouncilName(datum.Concelho.Name);
        location.setParishId(datum.Freguesia.Id);
        location.setParishName(datum.Freguesia.Name);
        location.setLatitude(datum.Latitude);
        location.setLongitude(datum.Longitude);

        return location;
    }

    private OccurrenceResources buildResources(Datum datum) {
        OccurrenceResources resources = new OccurrenceResources();

        resources.setTotalAerialMeans(datum.NumeroMeiosAereosEnvolvidos);
        resources.setTotalTerrestrialMeans(datum.NumeroMeiosTerrestresEnvolvidos);
        resources.setTotalAerialHumans(datum.NumeroOperacionaisAereosEnvolvidos);
        resources.setTotalTerrestrialHumans(datum.NumeroOperacionaisTerrestresEnvolvidos);

        return resources;
    }
}
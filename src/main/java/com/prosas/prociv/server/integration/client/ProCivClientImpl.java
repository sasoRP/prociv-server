package com.prosas.prociv.server.integration.client;

import javax.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ejb.EJB;


/**
 *     
 * @author prosas
 */
@Stateless
public class ProCivClientImpl implements ProCivClient {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProCivClientImpl.class);
    private static final String ENDPOINT_GET_OCCURRENCES_BY_LOCATION = "http://www.prociv.pt/_vti_bin/ARM.ANPC.UI/ANPC_SituacaoOperacional.svc/GetHistoryOccurrencesByLocation";

    @EJB
    private ProCivHttpClient proCivHttpClient;

    @Override
    public String getOccurrencesByCouncil(int councilId) throws ProCivHttpClientException {
        String response = "";

        try {
            response = proCivHttpClient.getHistoryOccurrencesByLocation(null, councilId, null);
        }
        catch (Exception ex) {
            LOGGER.error("Failed to communicate with the prociv.pt server: {}", ex.getMessage());
            throw new ProCivHttpClientException();
        }

        if (response == null) {
            response = "";
        }

        return response;
    }
}
package com.prosas.prociv.server.integration.client;

import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *     
 * @author sasoRP
 */
@Stateless
public class ProCivClientImpl implements ProCivClient {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(ProCivClientImpl.class);

    @EJB
    private ProCivHttpClient proCivHttpClient;

    @Override
    public String getOccurrencesByCouncil(int councilId) throws ProCivHttpClientException {
        return getHistoryOccurrencesByLocation(null, councilId, null);
    }

    @Override
    public String getOccurrencesByDistrict(int districtId) throws ProCivHttpClientException {
        return getHistoryOccurrencesByLocation(districtId, null, null);
    }

    @Override
    public String getOccurrencesByParish(int parishId) throws ProCivHttpClientException {
        return getHistoryOccurrencesByLocation(null, null, parishId);
    }

    @Override
    public String getOccurrences() throws ProCivHttpClientException {
        return getHistoryOccurrencesByLocation(null, null, null);
    }

    private String getHistoryOccurrencesByLocation(Integer districtId, Integer councilId, Integer parishId) throws ProCivHttpClientException {
        String response = "";

        try {
            response = proCivHttpClient.getHistoryOccurrencesByLocation(districtId, councilId, parishId);
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
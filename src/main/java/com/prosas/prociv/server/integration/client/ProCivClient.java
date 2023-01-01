package com.prosas.prociv.server.integration.client;

import jakarta.ejb.Local;

/**
 *     
 * @author sasoRP
 */
@Local
public interface ProCivClient {

    String getOccurrencesByCouncil(int councilId) throws ProCivHttpClientException;

    String getOccurrencesByDistrict(int districtId) throws ProCivHttpClientException;

    String getOccurrencesByParish(int parishId) throws ProCivHttpClientException;

    String getOccurrences() throws ProCivHttpClientException;
}

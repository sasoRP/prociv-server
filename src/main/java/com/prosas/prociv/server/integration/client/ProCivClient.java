package com.prosas.prociv.server.integration.client;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import java.util.List;
import javax.ejb.Local;
import javax.json.Json;
import javax.json.JsonObject;

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

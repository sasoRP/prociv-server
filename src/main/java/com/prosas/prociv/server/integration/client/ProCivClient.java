package com.prosas.prociv.server.integration.client;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import java.util.List;
import javax.ejb.Local;
import javax.json.Json;
import javax.json.JsonObject;

/**
 *     
 * @author prosas
 */
@Local
public interface ProCivClient {

    String getOccurrencesByCouncil(int councilId) throws ProCivHttpClientException;
}

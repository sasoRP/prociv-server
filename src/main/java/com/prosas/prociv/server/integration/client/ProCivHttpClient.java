package com.prosas.prociv.server.integration.client;

import jakarta.ejb.Local;
import java.io.IOException;

/**
 *     
 * @author sasoRP
 */
@Local
public interface ProCivHttpClient {
    String getHistoryOccurrencesByLocation(Integer districtId, Integer councilId, Integer parishId) throws IOException, InterruptedException;
}

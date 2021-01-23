package com.prosas.prociv.server.integration.client;

import java.io.IOException;
import javax.ejb.Local;

/**
 *     
 * @author sasoRP
 */
@Local
public interface ProCivHttpClient {
    String getHistoryOccurrencesByLocation(Integer districtId, Integer councilId, Integer parishId) throws IOException, InterruptedException;
}

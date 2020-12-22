package com.prosas.prociv.server.integration.client;

import java.io.IOException;
import javax.ejb.Local;

/**
 *     
 * @author prosas
 */
@Local
public interface ProCivHttpClient {
    String getHistoryOccurrencesByLocation(Integer districtId, Integer councilId, Integer parishId) throws IOException, InterruptedException;
}

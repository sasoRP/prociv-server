package com.prosas.prociv.server.services;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import java.util.List;
import javax.ejb.Local;

/**
 *     
 * @author prosas
 */
@Local
public interface OccurrencesService {
    List<Occurrence> getOccurrencesByCouncil(int councilId);
}

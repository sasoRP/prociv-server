package com.prosas.prociv.server.services;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import jakarta.ejb.Local;
import java.util.List;

/**
 *     
 * @author sasoRP
 */
@Local
public interface OccurrencesService {
    List<Occurrence> getOccurrencesByCouncil(int councilId);

    List<Occurrence> getOccurrencesByDistrict(int districtId);

    List<Occurrence> getOccurrencesByParish(int parishId);

    List<Occurrence> getOccurrences();
}

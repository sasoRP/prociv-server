package com.prosas.prociv.server.api;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import com.prosas.prociv.server.services.OccurrencesService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/occurrences")
public class OccurrencesResource {

    @EJB
    private OccurrencesService occurrencesService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/councils/{councilId}")
    public List<Occurrence> getOccurrencesByCouncil(@PathParam("councilId")int councilId) {
        List<Occurrence> occurrences = occurrencesService.getOccurrencesByCouncil(councilId);

        if (occurrences == null) {
            return new ArrayList<>();
        } else {
            return occurrences;
        }
    }
}
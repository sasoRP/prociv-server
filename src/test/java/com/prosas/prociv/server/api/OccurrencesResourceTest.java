package com.prosas.prociv.server.api;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import com.prosas.prociv.server.api.viewModels.OccurrenceLocation;
import com.prosas.prociv.server.api.viewModels.OccurrenceResources;
import com.prosas.prociv.server.services.OccurrencesService;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class OccurrencesResourceTest {

    private static final int COUNCIL_ID = 1;

    @InjectMocks
    private OccurrencesResource occurrencesResource;

    @Mock
    private OccurrencesService occurrencesService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOccurrencesByCouncil_EmptyList() {
        // pre-conditions
        List<Occurrence> councilOccurrences = new ArrayList<>();
        when(occurrencesService.getOccurrencesByCouncil(COUNCIL_ID)).thenReturn(councilOccurrences);

        // action
        List<Occurrence> occurrencesList = occurrencesResource.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        assertEquals(councilOccurrences, occurrencesList);
    }

    @Test
    public void testGetOccurrencesByCouncil_NullList() {
        // pre-conditions
        when(occurrencesService.getOccurrencesByCouncil(COUNCIL_ID)).thenReturn(null);

        // action
        List<Occurrence> occurrencesList = occurrencesResource.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        List<Occurrence> expectedOccurrences = new ArrayList<>();
        assertEquals(expectedOccurrences, occurrencesList);
    }

    @Test
    public void testGetOccurrencesByCouncil_MockList() {
        // pre-conditions
        List<Occurrence> councilOccurrences = getMockOccurrences();
        when(occurrencesService.getOccurrencesByCouncil(COUNCIL_ID)).thenReturn(councilOccurrences);

        // action
        List<Occurrence> occurrencesList = occurrencesResource.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        assertEquals(councilOccurrences, occurrencesList);
    }

    private List<Occurrence> getMockOccurrences() {
        List<Occurrence> occurrences = new ArrayList<>();

        Occurrence occurrence1 = new Occurrence.Builder("1")
                .withLocation(getMockLocation())
                .withStatus("status1")
                .withDescription("desc1")
                .withResources(getMockResources())
                .build();

        Occurrence occurrence2 = new Occurrence.Builder("2")
                .withLocation(getMockLocation())
                .withStatus("status2")
                .withDescription("desc2")
                .withResources(getMockResources())
                .build();

        Occurrence occurrence3 = new Occurrence.Builder("3")
                .withLocation(getMockLocation())
                .withStatus("status3")
                .withDescription("desc3")
                .withResources(getMockResources())
                .build();

        occurrences.add(occurrence1);
        occurrences.add(occurrence2);
        occurrences.add(occurrence3);

        return occurrences;
    }

    private OccurrenceResources getMockResources() {
        OccurrenceResources resources = new OccurrenceResources();

        return resources;
    }

    private OccurrenceLocation getMockLocation() {
        OccurrenceLocation location = new OccurrenceLocation();

        return location;
    }
}
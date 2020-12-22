package com.prosas.prociv.server.api;

import com.prosas.prociv.server.api.viewModels.Occurrence;
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
        occurrences.add(new Occurrence("1", COUNCIL_ID, "desc1"));
        occurrences.add(new Occurrence("2", COUNCIL_ID, "desc2"));
        occurrences.add(new Occurrence("3", COUNCIL_ID, "desc3"));

        return occurrences;
    }
}
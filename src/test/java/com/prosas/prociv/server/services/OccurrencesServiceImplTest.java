package com.prosas.prociv.server.services;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import com.prosas.prociv.server.integration.client.ProCivClient;
import com.prosas.prociv.server.integration.client.ProCivHttpClientException;
import com.prosas.prociv.server.tests.Utilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class OccurrencesServiceImplTest {

    private static final int COUNCIL_ID = 1;
    private static final String SAMPLE_OCCURRENCES_LIST = "";

    @InjectMocks
    private OccurrencesServiceImpl occurrencesService;

    @Mock
    private ProCivClient proCivClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOccurrencesByCouncil_EmptyList() throws ProCivHttpClientException {
        // pre-conditions
        when(proCivClient.getOccurrencesByCouncil(COUNCIL_ID)).thenReturn("");

        // action
        List<Occurrence> occurrencesList = occurrencesService.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        List<Occurrence> expectedOccurrences = new ArrayList<Occurrence>();
        assertEquals(expectedOccurrences, occurrencesList);
    }

    @Test
    public void testGetOccurrencesByCouncil_NullList() throws ProCivHttpClientException {
        // pre-conditions
        when(proCivClient.getOccurrencesByCouncil(COUNCIL_ID)).thenReturn(null);

        // action
        List<Occurrence> occurrencesList = occurrencesService.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        List<Occurrence> expectedOccurrences = new ArrayList<>();
        assertEquals(expectedOccurrences, occurrencesList);
    }

    @Test
    public void testGetOccurrencesByCouncil_MockList() throws IOException, ProCivHttpClientException {
        // pre-conditions
        when(proCivClient.getOccurrencesByCouncil(COUNCIL_ID)).thenReturn(Utilities.readMock("GetHistoryOccurrencesByLocation.json"));

        // action
        List<Occurrence> occurrencesList = occurrencesService.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        assertEquals(getExpectedOccurrencesFromMock(), occurrencesList);
    }

    private List<Occurrence> getExpectedOccurrencesFromMock() {
        List<Occurrence> occurrences = new ArrayList<>();
        occurrences.add(new Occurrence("38465368", 148, "Riscos Tecnológicos / Incêndios em Equipamento e Produtos / Equipamentos"));
        occurrences.add(new Occurrence("38465360", 134, "Protecção e Assistência a Pessoas e Bens / Assistência em Saúde / Trauma"));
        occurrences.add(new Occurrence("38465364", 134, "Protecção e Assistência a Pessoas e Bens / Assistência em Saúde / Trauma"));

        return occurrences;
    }
}
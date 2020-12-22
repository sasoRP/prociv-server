package com.prosas.prociv.server.integration.client;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

public class ProCivClientImplTest {

    private static final int COUNCIL_ID = 1;

    @InjectMocks
    private ProCivClientImpl proCivClient;

    @Mock
    private ProCivHttpClient proCivHttpClient;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetOccurrencesByCouncil_JsonResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(getFakeResponse());

        // action
        String response = proCivClient.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        assertEquals(getFakeResponse(), response);
    }

    @Test
    public void testGetOccurrencesByCouncil_IOException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new IOException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrencesByCouncil(COUNCIL_ID);
        });
    }

    @Test
    public void testGetOccurrencesByCouncil_InterruptedException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new InterruptedException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrencesByCouncil(COUNCIL_ID);
        });
    }


    @Test
    public void testGetOccurrencesByCouncil_NullResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(null);

        // action
        String response = proCivClient.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications

        assertEquals("", response);
    }

    @Test
    public void testGetOccurrencesByCouncil_EmptyResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn("");

        // action
        String response = proCivClient.getOccurrencesByCouncil(COUNCIL_ID);

        // verifications
        assertEquals("", response);
    }

    private String getFakeResponse() {
        return "Fake Response";
    }
}
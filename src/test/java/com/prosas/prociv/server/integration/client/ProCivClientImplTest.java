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

    private static final int DISTRICT_ID = 1;
    private static final int COUNCIL_ID = 1;
    private static final int PARISH_ID = 1;

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

    @Test
    public void testGetOccurrencesByDistrict_JsonResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(getFakeResponse());

        // action
        String response = proCivClient.getOccurrencesByDistrict(DISTRICT_ID);

        // verifications
        assertEquals(getFakeResponse(), response);
    }

    @Test
    public void testGetOccurrencesByDistrict_IOException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new IOException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrencesByDistrict(DISTRICT_ID);
        });
    }

    @Test
    public void testGetOccurrencesByDistrict_InterruptedException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new InterruptedException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrencesByDistrict(DISTRICT_ID);
        });
    }


    @Test
    public void testGetOccurrencesByDistrict_NullResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(null);

        // action
        String response = proCivClient.getOccurrencesByDistrict(DISTRICT_ID);

        // verifications

        assertEquals("", response);
    }

    @Test
    public void testGetOccurrencesByDistrict_EmptyResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn("");

        // action
        String response = proCivClient.getOccurrencesByCouncil(DISTRICT_ID);

        // verifications
        assertEquals("", response);
    }

    @Test
    public void testGetOccurrencesByParish_JsonResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(getFakeResponse());

        // action
        String response = proCivClient.getOccurrencesByDistrict(PARISH_ID);

        // verifications
        assertEquals(getFakeResponse(), response);
    }

    @Test
    public void testGetOccurrencesByParish_IOException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new IOException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrencesByParish(PARISH_ID);
        });
    }

    @Test
    public void testGetOccurrencesByParish_InterruptedException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new InterruptedException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrencesByParish(PARISH_ID);
        });
    }


    @Test
    public void testGetOccurrencesByParish_NullResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(null);

        // action
        String response = proCivClient.getOccurrencesByParish(PARISH_ID);

        // verifications

        assertEquals("", response);
    }

    @Test
    public void testGetOccurrencesByParish_EmptyResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn("");

        // action
        String response = proCivClient.getOccurrencesByParish(PARISH_ID);

        // verifications
        assertEquals("", response);
    }

    @Test
    public void testGetOccurrences_JsonResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(getFakeResponse());

        // action
        String response = proCivClient.getOccurrences();

        // verifications
        assertEquals(getFakeResponse(), response);
    }

    @Test
    public void testGetOccurrences_IOException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new IOException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrences();
        });
    }

    @Test
    public void testGetOccurrences_InterruptedException() throws IOException, InterruptedException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenThrow(new InterruptedException());

        // action && verifications
        assertThrows(ProCivHttpClientException.class, () -> {
            proCivClient.getOccurrences();
        });
    }


    @Test
    public void testGetOccurrences_NullResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn(null);

        // action
        String response = proCivClient.getOccurrences();

        // verifications

        assertEquals("", response);
    }

    @Test
    public void testGetOccurrences_EmptyResponse() throws IOException, InterruptedException, ProCivHttpClientException {
        // pre-conditions
        when(proCivHttpClient.getHistoryOccurrencesByLocation(any(), any(), any())).thenReturn("");

        // action
        String response = proCivClient.getOccurrences();

        // verifications
        assertEquals("", response);
    }

    private String getFakeResponse() {
        return "Fake Response";
    }
}
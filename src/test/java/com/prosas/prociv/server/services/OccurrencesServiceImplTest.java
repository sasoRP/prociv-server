package com.prosas.prociv.server.services;

import com.prosas.prociv.server.api.viewModels.Occurrence;
import com.prosas.prociv.server.api.viewModels.OccurrenceLocation;
import com.prosas.prociv.server.api.viewModels.OccurrenceResources;
import com.prosas.prociv.server.integration.client.ProCivClient;
import com.prosas.prociv.server.integration.client.ProCivHttpClientException;
import com.prosas.prociv.server.tests.Utilities;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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

        Occurrence occurrence1 = new Occurrence.Builder("38465368")
                .withDate(new Date(1609035540000L))
                .withResources(getExpectedResources1())
                .withDescription("Riscos Tecnológicos / Incêndios em Equipamento e Produtos / Equipamentos")
                .withStatus("Despacho de 1º Alerta")
                .withLocation(getExpectedLocation1())
                .build();

        Occurrence occurrence2 = new Occurrence.Builder("38465360")
                .withDate(new Date(1608996060000L))
                .withResources(getExpectedResources2())
                .withDescription("Protecção e Assistência a Pessoas e Bens / Assistência em Saúde / Trauma")
                .withStatus("Chegada ao TO")
                .withLocation(getExpectedLocation2())
                .build();

        Occurrence occurrence3 = new Occurrence.Builder("38465364")
                .withDate(new Date(1608865800000L))
                .withResources(getExpectedResources3())
                .withDescription("Protecção e Assistência a Pessoas e Bens / Assistência em Saúde / Trauma")
                .withStatus("Chegada ao TO")
                .withLocation(getExpectedLocation3())
                .build();

        occurrences.add(occurrence1);
        occurrences.add(occurrence2);
        occurrences.add(occurrence3);

        return occurrences;
    }

    private OccurrenceLocation getExpectedLocation1() {
        OccurrenceLocation location = new OccurrenceLocation();

        location.setCouncilId(148);
        location.setCouncilName("MARINHA GRANDE");
        location.setDistrictId(11);
        location.setDistrictName("LEIRIA");
        location.setLatitude(39.777105);
        location.setLongitude(-8.928471);
        location.setParishId(2706);
        location.setParishName("Marinha Grande");

        return location;
    }

    private OccurrenceResources getExpectedResources1() {
        OccurrenceResources resources = new OccurrenceResources();

        resources.setTotalAerialHumans(0);
        resources.setTotalAerialMeans(0);
        resources.setTotalTerrestrialHumans(2);
        resources.setTotalTerrestrialMeans(1);

        return resources;
    }

    private OccurrenceLocation getExpectedLocation2() {
        OccurrenceLocation location = new OccurrenceLocation();

        location.setCouncilId(134);
        location.setCouncilName("LEIRIA");
        location.setDistrictId(11);
        location.setDistrictName("LEIRIA");
        location.setLatitude(39.79624276735543);
        location.setLongitude(-8.8715459328384032);
        location.setParishId(344);
        location.setParishName("Amor");

        return location;
    }

    private OccurrenceResources getExpectedResources2() {
        OccurrenceResources resources = new OccurrenceResources();

        resources.setTotalAerialHumans(0);
        resources.setTotalAerialMeans(0);
        resources.setTotalTerrestrialHumans(0);
        resources.setTotalTerrestrialMeans(0);

        return resources;
    }

    private OccurrenceLocation getExpectedLocation3() {
        OccurrenceLocation location = new OccurrenceLocation();

        location.setCouncilId(134);
        location.setCouncilName("LEIRIA");
        location.setDistrictId(11);
        location.setDistrictName("LEIRIA");
        location.setLatitude(39.716662274533732);
        location.setLongitude(-8.78399081055461);
        location.setParishId(2516);
        location.setParishName("Leiria, Pousos, Barreira e Cortes");

        return location;
    }

    private OccurrenceResources getExpectedResources3() {
        OccurrenceResources resources = new OccurrenceResources();

        resources.setTotalAerialHumans(0);
        resources.setTotalAerialMeans(0);
        resources.setTotalTerrestrialHumans(0);
        resources.setTotalTerrestrialMeans(0);

        return resources;
    }
}
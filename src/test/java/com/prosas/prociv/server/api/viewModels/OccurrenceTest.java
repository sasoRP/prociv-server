package com.prosas.prociv.server.api.viewModels;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class OccurrenceTest {

    @Test
    public void testToString() {
        // pre-conditions
        Occurrence occurrence = new Occurrence();
        occurrence.setExternalId("1");
        occurrence.setCouncilId(3);
        occurrence.setDescription("description");

        // action
        String actual = occurrence.toString();

        // validations
        String expected = "{ ExternalId: 1, Council: 3, Description: description }\n";
        assertEquals(expected, actual);
    }
}
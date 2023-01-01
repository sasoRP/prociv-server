
package com.prosas.prociv.server.integration.client.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.List;

/**
 *     
 * @author sasoRP
 */
public class ArrayInfo {
    @JsonbProperty("Data")
    public List<Datum> Data;

    @JsonbProperty("Total")
    public int Total;
}

package com.prosas.prociv.server.integration.client.entities;

import java.util.List;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 *     
 * @author prosas
 */
public class ArrayInfo {
    @JsonbProperty("Data")
    public List<Datum> Data;

    @JsonbProperty("Total")
    public int Total;
}
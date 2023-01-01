
package com.prosas.prociv.server.integration.client.entities;

import java.util.List;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 *     
 * @author sasoRP
 */
public class ArrayInfo2 {
    @JsonbProperty("Data")
    public List<Datum2> Data;

    @JsonbProperty("Total")
    public int Total;
}
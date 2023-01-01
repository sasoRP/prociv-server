
package com.prosas.prociv.server.integration.client.entities;

import jakarta.json.bind.annotation.JsonbProperty;
import java.util.List;

/**
 *     
 * @author sasoRP
 */
public class GetHistoryOccurrencesByLocationResult {
    public String __type;

    @JsonbProperty("ArrayInfo")
    public List<ArrayInfo> ArrayInfo;

    @JsonbProperty("Labels")
    public List<Object> Labels;

    @JsonbProperty("UserInfo")
    public Object UserInfo;

    @JsonbProperty("Variables")
    public List<Variable> Variables;

    public List<ArrayInfo2> arrayInfo2;

    public List<Object> labels2;

    public Object user;

    public List<Var> vars;
}
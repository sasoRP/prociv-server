
package com.prosas.prociv.server.integration.client.entities;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 *     
 * @author prosas
 */
public class Variable {
    @JsonbProperty("Key")
    public String Key;

    @JsonbProperty("Value")
    public String Value;
}
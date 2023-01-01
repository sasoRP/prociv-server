
package com.prosas.prociv.server.integration.client.entities;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 *     
 * @author sasoRP
 */
public class Var {
    @JsonbProperty("Key")
    public String Key;

    @JsonbProperty("Value")
    public String Value;
}

package com.prosas.prociv.server.integration.client.entities;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 *     
 * @author sasoRP
 */
public class EstadoOcorrencia2 {
    @JsonbProperty("Active")
    public boolean Active;

    @JsonbProperty("CreatedBy")
    public Object CreatedBy;

    @JsonbProperty("CreatedWhen")
    public String CreatedWhen;

    @JsonbProperty("ID")
    public int Id;

    @JsonbProperty("ModifiedBy")
    public Object ModifiedBy;

    @JsonbProperty("ModifiedWhen")
    public String ModifiedWhen;

    @JsonbProperty("Name")
    public String Name;
}
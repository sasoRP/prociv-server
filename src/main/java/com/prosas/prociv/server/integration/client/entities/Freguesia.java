
package com.prosas.prociv.server.integration.client.entities;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 *     
 * @author sasoRP
 */
public class Freguesia {
    @JsonbProperty("Active")
    public boolean Active;

    @JsonbProperty("Concelho")
    public Object Concelho;

    @JsonbProperty("ConcelhoID")
    public int ConcelhoID;

    @JsonbProperty("CreatedBy")
    public Object CreatedBy;

    @JsonbProperty("CreatedWhen")
    public String CreatedWhen;

    @JsonbProperty("DICOFRE")
    public String Dicofre;

    @JsonbProperty("ID")
    public int Id;

    @JsonbProperty("ModifiedBy")
    public Object ModifiedBy;

    @JsonbProperty("ModifiedWhen")
    public String ModifiedWhen;

    @JsonbProperty("Name")
    public String Name;

    @JsonbProperty("NumMeiosAereos")
    public int NumMeiosAereos;

    @JsonbProperty("NumMeiosTerrestres")
    public int NumMeiosTerrestres;

    @JsonbProperty("NumOccorencias")
    public int NumOccorencias;

    @JsonbProperty("NumOperacionais")
    public int NumOperacionais;
}
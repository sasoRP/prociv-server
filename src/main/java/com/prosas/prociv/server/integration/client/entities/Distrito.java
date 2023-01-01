
package com.prosas.prociv.server.integration.client.entities;

import java.util.Date;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 *     
 * @author sasoRP
 */
public class Distrito {
    @JsonbProperty("Active")
    public boolean Active;

    @JsonbProperty("CreatedBy")
    public Object CreatedBy;

    @JsonbProperty("CreatedWhen")
    public String CreatedWhen;

    @JsonbProperty("DI")
    public String Di;

    @JsonbProperty("Estado")
    public int Estado;

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
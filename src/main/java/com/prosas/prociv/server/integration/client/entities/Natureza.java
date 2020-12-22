
package com.prosas.prociv.server.integration.client.entities;

import java.util.Date;
import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;

/**
 *     
 * @author prosas
 */
public class Natureza {
    @JsonbProperty("Active")
    public boolean Active;

    @JsonbProperty("Codigo")
    public String Codigo;

    @JsonbProperty("CreatedBy")
    public Object CreatedBy;

    @JsonbProperty("CreatedWhen")
    public String CreatedWhen;

    @JsonbProperty("EspecieAbreviatura")
    public String EspecieAbreviatura;

    @JsonbProperty("EspecieCodigo")
    public int EspecieCodigo;

    @JsonbProperty("EspecieID")
    public int EspecieID;

    @JsonbProperty("FamiliaAbreviatura")
    public String FamiliaAbreviatura;

    @JsonbProperty("FamiliaCodigo")
    public int FamiliaCodigo;

    @JsonbProperty("FamiliaID")
    public int FamiliaID;

    @JsonbProperty("ID")
    public int Id;

    @JsonbProperty("ModifiedBy")
    public Object ModifiedBy;

    @JsonbProperty("ModifiedWhen")
    public String ModifiedWhen;

    @JsonbProperty("NaturezaAbreviatura")
    public String NaturezaAbreviatura;

    @JsonbProperty("Nome")
    public String Nome;
}
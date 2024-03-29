
package com.prosas.prociv.server.integration.client.entities;

import jakarta.json.bind.annotation.JsonbProperty;

/**
 *     
 * @author sasoRP
 */
public class Datum {
    @JsonbProperty("Concelho")
    public Concelho Concelho;

    @JsonbProperty("DataFechoOperacional")
    public Object DataFechoOperacional;

    @JsonbProperty("DataOcorrencia")
    public String DataOcorrencia;

    @JsonbProperty("Distrito")
    public Distrito Distrito;

    @JsonbProperty("EstadoOcorrencia")
    public EstadoOcorrencia EstadoOcorrencia;

    @JsonbProperty("EstadoOcorrenciaID")
    public int EstadoOcorrenciaID;

    @JsonbProperty("Freguesia")
    public Freguesia Freguesia;

    @JsonbProperty("ID")
    public String Id;

    @JsonbProperty("Latitude")
    public double Latitude;

    @JsonbProperty("Localidade")
    public String Localidade;

    @JsonbProperty("Longitude")
    public double Longitude;

    @JsonbProperty("Natureza")
    public Natureza Natureza;

    @JsonbProperty("Numero")
    public String Numero;

    @JsonbProperty("NumeroMeiosAereosEnvolvidos")
    public int NumeroMeiosAereosEnvolvidos;

    @JsonbProperty("NumeroMeiosTerrestresEnvolvidos")
    public int NumeroMeiosTerrestresEnvolvidos;

    @JsonbProperty("NumeroOperacionaisAereosEnvolvidos")
    public int NumeroOperacionaisAereosEnvolvidos;

    @JsonbProperty("NumeroOperacionaisTerrestresEnvolvidos")
    public int NumeroOperacionaisTerrestresEnvolvidos;
}
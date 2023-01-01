
package com.prosas.prociv.server.integration.client;

import jakarta.ejb.Stateless;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

/**
 *     
 * @author sasoRP
 */
@Stateless
public class ProCivHttpClientImpl implements ProCivHttpClient {

    private static final String ENDPOINT_GET_OCCURRENCES_BY_LOCATION = "http://www.prociv.pt/_vti_bin/ARM.ANPC.UI/ANPC_SituacaoOperacional.svc/GetHistoryOccurrencesByLocation";
    private static final String PAGE_SIZE = "100";
    private static final String PAGE_INDEX = "1";
    private static final String FOR_TODAY = "false";
    private static final String NATURE = "0";


    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();


    @Override
    public String getHistoryOccurrencesByLocation(Integer districtId, Integer councilId, Integer parishId) throws IOException, InterruptedException {
        // json formatted data
        String json = new StringBuilder()
                .append("{ ")
                .append(String.format("\"distritoID\": %s, ", districtId))
                .append(String.format("\"concelhoID\": %s, ", councilId))
                .append(String.format("\"freguesiaID\": %s, ", parishId))
                .append(String.format("\"pageSize\": %s, ", PAGE_SIZE))
                .append(String.format("\"pageIndex\": %s, ", PAGE_INDEX))
                .append(String.format("\"forToday\": %s, ", FOR_TODAY))
                .append(String.format("\"natureza\": %s ", NATURE))
                .append("}").toString();

        // add json header
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create(ENDPOINT_GET_OCCURRENCES_BY_LOCATION))
                .setHeader("User-Agent", "Java 11 HttpClient") // add request header
                .header("Content-Type", "application/json")
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
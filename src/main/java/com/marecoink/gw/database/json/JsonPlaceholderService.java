package com.marecoink.gw.database.json;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.marecoink.gw.database.station.Station;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@PropertySource("env.properties")
public class JsonPlaceholderService {
    private final String STATION_API_URL = "https://pomiary.gdanskiewody.pl/rest/stations";
    private final RestTemplate restTemplate;

    @Value("${api.key}")
    private String apiKey;

    public JsonPlaceholderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Station> getStations() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            ResponseEntity<String> responseEntity = restTemplate.exchange(
                    STATION_API_URL,
                    HttpMethod.GET,
                    entity,
                    String.class
            );

            String responseBody = responseEntity.getBody();

            if (responseBody != null) {
              JsonNode rootNode = Json.parse(responseBody);

                if (rootNode.has("data") && rootNode.get("data").isArray()) {
                    JsonNode dataNode = rootNode.get("data");
                    return Json.fromJson(dataNode, new TypeReference<List<Station>>() {});
                }
            }
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}



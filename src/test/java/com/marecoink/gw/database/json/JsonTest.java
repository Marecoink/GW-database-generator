package com.marecoink.gw.database.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.marecoink.gw.database.json.pojo.SimpleTestCaseJsonPOJO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String simpleTestCaseJsonSource = "{ \"status\": \"Success\", \"message\": \"Lista stacji\" }";

    @Test
    void parse() throws JsonProcessingException {
        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("status").asText(), "Success");
    }

    @Test
    void fromJson() throws JsonProcessingException {
        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        SimpleTestCaseJsonPOJO pojo = Json.fromJson(node, SimpleTestCaseJsonPOJO.class);
        assertEquals(pojo.getStatus(), "Success");
    }

    @Test
    void toJson() {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setStatus("Testing 123");
        JsonNode node = Json.toJson(pojo);
        assertEquals(node.get("status").asText(), "Testing 123");
    }

    @Test
    void stringify() throws JsonProcessingException {
        SimpleTestCaseJsonPOJO pojo = new SimpleTestCaseJsonPOJO();
        pojo.setStatus("Testing 123");
        JsonNode node = Json.toJson(pojo);

        System.out.println(Json.stringify(node));
        System.out.println(Json.prettyPrint(node));
    }
}
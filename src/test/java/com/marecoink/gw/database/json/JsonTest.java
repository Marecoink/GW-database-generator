package com.marecoink.gw.database.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String simpleTestCaseJsonSource = "{ \"status\": \"Success\" }";

    @Test
    void parse() throws JsonProcessingException {
        JsonNode node = Json.parse(simpleTestCaseJsonSource);
        assertEquals(node.get("status").asText(), "Success");
    }
}
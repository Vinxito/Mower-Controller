package com.seat_code.apps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.seat_code.shared.domain.bus.command.CommandBus;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public abstract class AcceptanceTestCase {

    @Autowired
    protected CommandBus commandBus;

    @Autowired
    protected MockMvc mockMvc;

    protected MvcResult result;

    @Autowired
    protected ObjectMapper mapper;

    protected MvcResult assertWithoutBody(String method, String endpoint) throws Exception {
        return mockMvc.perform(request(HttpMethod.valueOf(method), endpoint)
                        .contentType(APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }

    protected void assertWithSameBody(String body) throws UnsupportedEncodingException, JSONException {
        assertEquals(new JSONObject(body).toString(), new JSONObject(result.getResponse().getContentAsString()).toString());
    }


    protected void assertBooleanResponse(String endpoint, Integer expectedStatusCode, boolean expectedResponse) throws Exception {
        mockMvc.perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(content().string(String.valueOf(expectedResponse)));
    }

    protected void assertResponse(String endpoint, Integer expectedStatusCode, String expectedResponse) throws Exception {
        ResultMatcher response = expectedResponse.isEmpty()
                ? content().string("")
                : content().json(expectedResponse);

        mockMvc.perform(get(endpoint))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }

    protected void assertResponse(String endpoint, Integer expectedStatusCode,
                                  String expectedResponse, HttpHeaders headers) throws Exception {

        ResultMatcher response = expectedResponse.isEmpty() ?
                content().string("") : content().json(expectedResponse);
        mockMvc.perform(get(endpoint)
                        .headers(headers))
                .andExpect(status().is(expectedStatusCode))
                .andExpect(response);
    }

    protected void assertRequestWithBody(String method, String endpoint, String body,
                                         Integer expectedStatusCode) throws Exception {
        mockMvc.perform(request(HttpMethod.valueOf(method), endpoint)
                        .content(body)
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE))
                .andExpect(status()
                        .is(expectedStatusCode))
                .andExpect(content().string(""));
    }

}

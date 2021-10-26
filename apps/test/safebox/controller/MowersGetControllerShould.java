package mower.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import mower.WebAdapterTestCase;

import java.util.List;

final class MowersGetControllerShould extends WebAdapterTestCase {

    @Test
    void find_items() throws Exception {
        String id = "99ad55f5-6eab-4d73-b383-c63268e251e8";
        String body = "{\"name\": \"The best mower\", \"password\": \"1234\"}";

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("name", "The best mower");
        headers.set("password", "1234");

        givenThereIsAItem(id, body);

        assertResponse(String.format("/mower/%s/items", id), 200, body, headers);
    }

    @Test
    void no_find_a_non_existing_mower() throws Exception {
        String id = "4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661";
        String body = "{\"error_code\": \"mower_not_exists\", \"message\": \"The mower <4ecc0cb3-05b2-4238-b7e1-1fbb0d5d3661> doesn't exist\"}";

        assertResponse(String.format("/items/%s", id), 404, body);
    }

    private void givenThereIsAItem(String id, String body) throws Exception {
        assertRequestWithBody("PUT", String.format("/mower/%s/items", id), body, 201);
    }
}

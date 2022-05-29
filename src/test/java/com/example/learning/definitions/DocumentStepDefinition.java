package com.example.learning.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class DocumentStepDefinition {


    RestTemplate restTemplate = new RestTemplate();

    ResponseEntity<String> response;

    @Given("Send a request to the URL documents uuid to get document details with {string}")
    public void send_a_request_to_the_url_documents_uuid_to_get_document_details_with(String uuid) {

//        RestAssured.given()
//                .pathParam("uuid",uuid)
//                .when().get("http://localhost:8080/documents/{uuid}")
//                .then().body("studyEnvironmentUuid",containsString(uuid));

        //RestTemplate restTemplate = new RestTemplate();
        response
                = restTemplate.getForEntity("http://localhost:8081/documents/" + uuid, String.class);

    }

    @Then("the response will return status {int} and document details")

    public void the_response_will_return_status_and_document_details(Integer int1) {
        Assertions.assertEquals(response.getStatusCode(), HttpStatus.OK);
    }

    @Given("patch request with {string}")
    public void patch_request_with(String string) {

    }
    @Then("the response will return status {int} and value is update")
    public void the_response_will_return_status_and_value_is_update(Integer int1) {

    }

    @Then("calculate sum of the numbers")
    public void calculateSumOfTheNumbers() {
    }

    @Then("test")
    public void test() {
    }
}

package api.stepdefinitions;

import api.trellopojos.RequestPojo;
import api.trellopojos.ResponsePojo;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.openqa.selenium.json.Json;
import ui.utilities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreateListStepDefinition extends TestBaseApi {

    Response response;
    RequestPojo requestPojo;
    ResponsePojo responsePojo;

        @Given("POST request for create list")
        public void post_request_for_create_list() { setUp();
            spec.pathParams("param1", 1,"param2", "lists");

            HashMap<String, String> requestMap = new HashMap<>();
            requestMap.put("name", "ders");
            requestMap.put("idBoard", ConfigReader.getProperty("idBoard_for_list"));
            requestMap.put("key", ConfigReader.getProperty("key"));
            requestMap.put("token", ConfigReader.getProperty("token"));

            response= given().
                    contentType("application/json").
                    spec(spec).
                    body(requestMap).
                    when().
                    post("/{param1}/{param2}");
            response.prettyPrint();


        }
        @Then("verify response")
        public void verify_response() {
            Assert.assertEquals(200, response.getStatusCode());

            JsonPath json = response.jsonPath();
            Assert.assertEquals("ders", json.getString("name"));
            Assert.assertEquals(ConfigReader.getProperty("idBoard_for_list"), json.getString("idBoard"));

        }


    @Given("PUT request for update list")
    public void putRequestForUpdateList() {
            setUp();
            spec.pathParams("param1", 1,"param2", "list", "param3", ConfigReader.getProperty("idList"));

            /*
            HashMap<String, String> requestMapForUpdate = new HashMap<>();
            requestMapForUpdate.put("name", "updateName");
            requestMapForUpdate.put("key", ConfigReader.getProperty("key"));
            requestMapForUpdate.put("token", ConfigReader.getProperty("token"));
             */

        requestPojo = new RequestPojo("master", ConfigReader.getProperty("key"), ConfigReader.getProperty("token"));
            response= given().
                    contentType("application/json").
                    spec(spec).
                    body(requestPojo).
                    when().
                    put("/{param1}/{param2}/{param3}");

            response.prettyPrint();
    }

    @Then("Verify update list response")
    public void verifyUpdateListResponse() {
            JsonPath json = response.jsonPath();
            responsePojo=response.as(ResponsePojo.class);
            Assert.assertEquals(200, response.getStatusCode());
            Assert.assertEquals(ConfigReader.getProperty("idList"), json.getString("id"));

    }
}

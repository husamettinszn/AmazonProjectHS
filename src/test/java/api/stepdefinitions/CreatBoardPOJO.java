package api.stepdefinitions;


import api.trellopojos.RequestPojo;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ui.utilities.ConfigReader;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CreatBoardPOJO extends TestBaseApi {

    Response response;

    @Given("POST request fuer Erstellung board {string} mit pojo")
    public void postRequestFuerErstellungBoardMitPojo(String boardName) {
        setUp();
        spec.pathParams("param1", 1, "param2", "boards");

        RequestPojo requestPojo = new RequestPojo(boardName, ConfigReader.getProperty("key"), ConfigReader.getProperty("token"));

        response = given().
                contentType("application/json").
                spec(spec).
                body(requestPojo).
                when().
                post("/{param1}/{param2}");

        response.prettyPrint();

    }

    @And("assert response {string}")
    public void assertResponse(String arg0) {
    }


    @Given("nimm response mit pojo")
    public void nimm_response_mit_pojo() {

    }


}

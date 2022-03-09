package api.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import ui.utilities.ConfigReader;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;


public class CreatBoardStepDefinitions extends TestBaseApi {

    Response response;
    JsonPath jsonPath;

    @Given("User sent request, um {string} board zu erstellen")
    public void user_sent_request_um_board_zu_erstellen(String board) {
        //url tanimla
//expected data-request data
//request gönder
//responsu al
//assert et
        setUp();

        spec.pathParams("paramatre1", 1,"parametre2", "boards");

        HashMap<String, String> requestBody= new HashMap<>();

        requestBody.put("name", board);
        requestBody.put("key", ConfigReader.getProperty("key"));
        requestBody.put("token", ConfigReader.getProperty("token"));

        System.out.println(requestBody);

        response = given().
                spec(spec).
                contentType("application/json").
                body(requestBody).
                when().
                post("/{paramatre1}/{parametre2}");

        response.prettyPrint();

        jsonPath= response.jsonPath();
    }

    @Then("Assert status code {int}")
    public void assertStatusCode(int statusCode) {
        System.out.println(response.statusCode());
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @And("Assert board name ist {string}")
    public void assertBoardNameIst(String name) {
        System.out.println(jsonPath.getString("name"));
        Assert.assertEquals(name, jsonPath.getString("name"));
    }


}
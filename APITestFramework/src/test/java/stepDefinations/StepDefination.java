package stepDefinations;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.*;
import resources.TestDataBuild;
import resources.Utils;


public class StepDefination extends Utils {
	
	RequestSpecification req;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException{
	    		 
	 // Response Spec builder could be used to create basic specification for an API response
	    req= given().spec(RequestSpecification()).body(data.addPlacePayload(name, language, address));
	}

	@When("user calls {string} with POST http request")
	public void user_calls_with_post_http_request(String string) {
	    // Write code here that turns the phrase above into concrete actions
		resSpec =new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		response=req.when().post("/maps/api/place/add/json").
	    		then().spec(resSpec).extract().response();
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    assertEquals(response.getStatusCode(), 200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	    String resp = response.asString();
	    JsonPath js = new JsonPath(resp);
	    assertEquals(js.get(keyValue).toString(), expectedValue); 
	}

}

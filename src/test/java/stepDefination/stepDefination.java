package stepDefination;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resourses.APIResources;
import resourses.TestBuild;
import resourses.Utils;

public class stepDefination extends Utils {
	
	
	 RequestSpecification BaseReq;
	 RequestSpecification Res;
	 Response res;
	 ResponseSpecification Resp;
	 static String PlaceId;
	                                                                                                         
	 TestBuild payload = new TestBuild();
	// Utils util = new Utils();
	 
	
	 @Given("Add Place Paylod {string} {string} {string}")  
	 
	 
	 public void add_place_paylod(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		 
		 
		  
	   // Res = given().spec(util.requestSpecification()).body(payload.addPlacePayload(name, language, address));
		 
		    Res = given().spec(requestSpecification()).body(payload.addPlacePayload(name, language, address));

		 
		
		 
		// Res = given().baseUri(getGlobalValue("BaseUrl")).queryParam("key","qaclick123").contentType(ContentType.JSON).body(payload.addPlacePayload(name, language, address));
	    
	  
	    		 
	    
	}
	 @When("User call {string} with {string} http request")
	 public void user_calls_with_http_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		
		APIResources resourceAPI = APIResources.valueOf(resource);
		        
	
		System.out.println(resourceAPI.getResource());
		
		if(method.equalsIgnoreCase("POST"))
		
		res = Res.when().post(resourceAPI.getResource());
		else if(method.equalsIgnoreCase("GET"))
		res = Res.when().get(resourceAPI.getResource());    
  
			 
	}
	@Then("The API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		
		Resp =new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		
		res.then().spec(Resp);
		
		                          
		assertEquals(res.getStatusCode(),200);	
		
		
	}
	
	
	
                     
	@Then("{string} in the response body is {string}")
	public void in_the_response_body_is(String KeyValue, String ExpectedValue) {
	    // Write code here that turns the phrase above into concrete actions
				
		

	   
//	   String PlaceId = getJson(res, "place_id");
//	    Res = given().spec(requestSpecification()).queryParam("Place_ID",PlaceId);
		
	    assertEquals(getJson(res,KeyValue),ExpectedValue);                                     
		}

	@Then("Verify PlaceID created addplaceAPImaps and Verify name should match to {string}  using {string}")
	public void verify_place_id_created_addplace_ap_imaps_and_verify_name_should_match_to_using(String expectedvalue, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	    
	                                       
	   PlaceId = getJson(res, "place_id");
	  
	  System.out.println(PlaceId);
	                                                                                   
	    Res = given().spec(requestSpecification()).queryParam("place_id",PlaceId);
	    
	    user_calls_with_http_request(resource,"GET");
	    
	    String actualname = getJson(res,"name");
	    
	    System.out.println(actualname);      
	    
	    assertEquals(actualname, expectedvalue);
	    
	}     
	                                                                                                        
	
	@Given("Del Place Payload")
	public void del_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
	 Res = given().spec(requestSpecification()).body(payload.delPayload(PlaceId));
	}
               
	 
	
	                                                                                       
}

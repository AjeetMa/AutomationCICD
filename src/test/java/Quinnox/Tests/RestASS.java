package Quinnox.Tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import Quinnox.TestComponents.Payload;
public class RestASS {

	
	public static void main(String[] args) {
		
		//setting the base URI
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
		//given- all the inputs details 
		//when- Submit the API- response http methods
		//then - validate the response
		
		
		//verify the response with this below code 
		/*
		 * given().log().all().queryParam("key",
		 * "qaclick123").header("Content-Type","application/json")
		 * .body(Payload.getAddplace()).when().post("maps/api/place/add/json")
		 * .then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		 * .header("Server", "Apache/2.4.52 (Ubuntu)");
		 */
		        
		
		//for extrating the string data from response 
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(Payload.getAddplace()).when().post("maps/api/place/add/json")
		        .then().assertThat().statusCode(200).body("scope",equalTo("APP")).header("Server", "Apache/2.4.52 (Ubuntu)")
		        .extract().response().asString();
		System.out.println("This is the response"+"->"+response);
		
		
		  JsonPath js=new JsonPath(response); 
		  String Place_id=js.getString("place_id");
		  System.out.println(Place_id);
		  
		  
		  
		  
		  given().log().all().queryParam("key",
		  "qaclick123").header("Content-Type","application/json") .body("{\r\n" +
		  "\"place_id\":\""+Place_id+"\",\r\n" +
		  "\"address\":\"Ajeet Kumar near durga mandap, Giridih\",\r\n" +
		  "\"key\":\"qaclick123\"\r\n" + "}\r\n" + "")
		  .when().put("maps/api/place/add/json")
		  .then().assertThat().log().all().statusCode(200);
		 
	//Get place 
	
	
	
	
	
	
	
	
	}
}

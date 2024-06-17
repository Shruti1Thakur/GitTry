package APINew;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;

import datafiles.Payload1;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class firstapitest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//validate if add place API is working
		//given - all input details//when - submit the api -- resource and http method//Then - Validate the response
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
		.body(Payload1.addplace()).when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope",equalTo("APP"))
		.header("server","Apache/2.4.52 (Ubuntu)").extract().response().asString();
		
		System.out.println(response);
		
//Add place and update place with new address -->Get place to validate if new address is present in response
		
		JsonPath js= new JsonPath(response); //for parsing Json
		String placeID=js.getString("place_id");
		
		System.out.println(placeID);
		
		//Update place
		
		String newaddress="70 Summer Walk,Africa";
		
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\n"
				+ "\"place_id\":\""+placeID+"\",\n"
				+ "\"address\":\""+newaddress+"\",\n"
				+ "\"key\":\"qaclick123\"\n"
				+ "}\n"
				+ "").when().put("maps/api/place/update/json").then().assertThat().log().all().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//Get new place updated
		
			String getplaceResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeID).when().get("maps/api/place/get/json")
			.then().assertThat().log().all().statusCode(200).extract().asString();
			
			JsonPath jss=new JsonPath(getplaceResponse);
			String actualAddress =jss.getString("address");
			
			System.out.println(actualAddress);
			
			//JUIT and TestNG
			
			Assert.assertEquals(actualAddress,newaddress);
			
			
			
			

			
			
			
	}

}

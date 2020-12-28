package firstPackage;

import  org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

import java.util.Random;

public class FirstTest {
	
	
	
	@Test
	public void simpleRequest() {
		
		//Simple method which gets response code of a URI
		RestAssured.baseURI = "http://192.168.99.100:3000";
		
		RestAssured.given().get().then().assertThat().statusCode(200);
		RestAssured.given().get("/posts").then().assertThat().statusCode(200).
		contentType(ContentType.JSON).
		//check first entry on page is the default with author = typicode
		body("[0].author",equalTo("typicode"));
	}
	
	@Test
	
	public void postJSON() {
		
		//create random number for value to go into id key
		Random r = new Random();
		int low = 0;
		int hi = 200;
		int result = r.nextInt(hi-low) + low;
		
		 String payload = "{\n" +
		        "  \"id\": \"Some id "+result+"\",\n" +
		        "  \"title\": \"test 1\",\n" +
		        "  \"author\": \"test author\"\n" +
		        "}";
		
		RestAssured.baseURI = "http://192.168.99.100:3000";
		
		RestAssured.given().contentType(ContentType.JSON).
		body(payload).post("/posts").then().statusCode(201);
		
		System.out.print("Posted id = Some id "+result+"");
		
	}
	
}

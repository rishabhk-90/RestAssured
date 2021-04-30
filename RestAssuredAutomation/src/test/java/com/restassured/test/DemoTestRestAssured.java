package com.restassured.test;

import java.net.ResponseCache;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class DemoTestRestAssured {
	
	
	//baseURI = "http://restcountries.eu/rest/v1/name";
	
	@Test
	public void test_01(){
		String baseURI = "http://restcountries.eu/rest/v1/name";
		String resource = "/india";
		String url = baseURI + resource;
		int statusCode;
		Response response = RestAssured.get(url);
		//statusCode = response.getStatusCode();
		/*System.out.println("StatusCode : " +statusCode);
		System.out.println("Response Time in ms : " +response.getTimeIn(TimeUnit.MILLISECONDS));
		System.out.println("Response Time in sec : " +response.getTimeIn(TimeUnit.SECONDS));
		System.out.println("Respone Body: "+ response.getBody().asPrettyString());
		System.out.println("Respone Body: "+ response.getBody().asString().contains("Republic of India"));
		System.out.println("\nRespone Header: "+response.getHeaders()); */
		given().
			get(url).
		then().
			statusCode(200).
			body(hasItem("Republic of India")).
			log().all();
		//Assert.assertEquals(statusCode, 200);
		
	}
	
	
	public void test_01a() {
		String baseURI = "http://restcountries.eu/rest/v1/name";
		String resource = "/india";
		String url = baseURI + resource;
		Response response;
		RestAssured.given().
		response = RestAssured.get(url);
		then().
			statusCode(200).
			body("altSpellings", hasItem("Republic of India")).
			log().all();
				
	}
	
	@Test
	public void test_02() {
		String baseURI = "http://restcountries.eu/rest/v1/name";
		String resource = "/xyz";
		String url = baseURI + resource;
		
		RestAssured.given().
			get(url).
		then().
			statusCode(404).
			body("status", equalTo(404), "message", equalTo("Not Found")).
			log().all();
			
			
	}
}

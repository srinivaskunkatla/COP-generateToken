package com.cop.api.tests;

import static io.restassured.RestAssured.given; //import this

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.cop.api.helpers.JWTDecoder;
import com.cop.api.helpers.ReadDataFromTxtFile;
import com.cop.api.helpers.ResponseValidation;
import com.cop.api.helpers.TextFileutil;
import com.cop.api.utils.AllureLogger;
import com.cop.api.utils.BaseTest;
import com.cop.api.utils.FrameworkConstants;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;

public class Verify_JWT_Headers extends BaseTest {
	
    
	@Test(priority = 1,description="Verify JWT Token Headers")
	public void verifyHeaders() throws IOException{
	AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 200
		 ******************************************************/
		JSONObject jsonObject = returDefaultPayLoadObject(com.cop.api.utils.FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
		ResponseValidation rv=new ResponseValidation();
		Response response = null;
		try {
			response = given().
									spec(requestSpec).
									contentType("text/plain").
									body(ReadDataFromTxtFile.readtxtFile(FrameworkConstants.BASE_PATH)).
								when().
									post("/generateToken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().spec(responseSpec);
		String token = response.then().extract().body().asString();
		TextFileutil.updatetoken(token);
		Map<Object, String> test=JWTDecoder.decodeJwt(token);
		rv.validateHeaderJWT(test,token);
	}
	@Test(priority = 0,description="Verify JWT Token Headers")
	public void verifyHeaderswithgetMethod() throws IOException{
		AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 200
		 ******************************************************/
		JSONObject jsonObject = returDefaultPayLoadObject(com.cop.api.utils.FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
		ResponseValidation rv=new ResponseValidation();
		Response response = null;
		try {
			response = given().
					spec(requestSpec).
					contentType("text/plain").
					body(ReadDataFromTxtFile.readtxtFile(FrameworkConstants.BASE_PATH)).
					when().
					get("/generateToken");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().spec(responseSpec);
		String token = response.then().extract().body().asString();
		TextFileutil.updatetoken(token);
		Map<Object, String> test=JWTDecoder.decodeJwt(token);
		rv.validateHeaderJWT(test,token);
	}

	public static String readConfigurationFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.cop.api.tests;

import static io.restassured.RestAssured.given; //import this

import java.io.IOException;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.cop.api.helpers.ReadDataFromTxtFile;
import com.cop.api.helpers.TextFileutil;
import com.cop.api.utils.AllureLogger;
import com.cop.api.utils.BaseTest;
import com.cop.api.utils.FrameworkConstants;

import io.restassured.response.Response;

public class Generate_JWT extends BaseTest {
	
    
	@Test(description="To retrieve the JWT Token") 
	public void post_CreateAuth() throws IOException{
	AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 200
		 ******************************************************/
		JSONObject jsonObject = returDefaultPayLoadObject(com.cop.api.utils.FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
		Response response = null;
		try {
			  String en=URLEncoder.encode("/generateToken?");
//			    String url=URLDecoder.decode(en);
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
	}

	public static String readConfigurationFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

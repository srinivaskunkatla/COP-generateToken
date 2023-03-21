package com.cop.api.tests;

import static com.cop.api.helpers.ResponseValidation.responseSpec;
import static io.restassured.RestAssured.given; //import this

import java.io.IOException;
import java.util.Map;

//import com.aventstack.extentreports.ExtentTest;
import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cop.api.helpers.JWTDecoder;
import com.cop.api.helpers.ReadDataFromTxtFile;
import com.cop.api.helpers.ResponseValidation;
import com.cop.api.helpers.TextFileutil;
import com.cop.api.utils.BaseTest;
import com.cop.api.utils.FrameworkConstants;

import io.restassured.response.Response;

public class Verify_JWT_Headers extends BaseTest {
//	public static ExtentTest test;

	@Test(priority = 1,description="Verify JWT Token Headers")
	public void verifyHeaders() throws IOException{
//	AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 200
		 ******************************************************/
		String methodName = new Exception().getStackTrace()[0].getMethodName();
//		test = extent.createTest(methodName,"verifyHeaders");
//		JSONObject jsonObject = returDefaultPayLoadObject(com.cop.api.utils.FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
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
		
//		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().spec(responseSpec);
		String token = response.then().extract().body().asString();
		TextFileutil.updatetoken(token);
		if(token!=null) {
			Map<Object, String> test = JWTDecoder.decodeJwt(token);
			rv.validateHeaderJWT(test, token);
		}
	}
	@Test(priority = 2,description="Verify JWT Token Headers in valid method")
	public void verifyHeaderswithgetMethod() throws IOException{
//		AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 405
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

//		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().statusCode(405);
		String token = response.then().extract().body().asString();
		TextFileutil.updatetoken(token);
		Reporter.log("Expected Response code is : 405 and the Actual Response Code is "+  response.then().extract().statusCode());


	}
	@Test(priority = 3,description="Verify JWT Token Headers with invalid URL")
	public void verifyHeaderswithInvalidURL() throws IOException{
//		AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 404
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
					post("/generateToke");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().statusCode(404);

		String token = response.then().extract().body().asString();
		TextFileutil.updatetoken(token);
		Reporter.log("Expected Response code is : 404 and the Actual Response Code is "+  response.then().extract().statusCode());

	}
	@Test(priority = 4,description="Verify JWT Token Headers with invalid body")
	public void verifyHeaderswithInvalidbody() throws IOException{
//		AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 404
		 ******************************************************/
		JSONObject jsonObject = returDefaultPayLoadObject(com.cop.api.utils.FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
		ResponseValidation rv=new ResponseValidation();
		Response response = null;
		response = given().
				spec(requestSpec).
				contentType("text/plain").
				body("test").
				when().
				post("/generateToken");

//		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().statusCode(400);
		String token = response.then().extract().body().asString();
		TextFileutil.updatetoken(token);
		Reporter.log("Expected Response code is : 400 and the Actual Response Code is "+  response.then().extract().statusCode());


	}
	@Test(priority = 4,description="Verify JWT Token Headers with invalid header")
	public void verifyHeaderswithInvalidheader() throws IOException{
//		AllureLogger.logToAllure("Starting the test for POST method for create authentication");
		/*******************************************************
		 * Send a POST request to /generateToken?
		 * and check that the response has HTTP status code 404
		 ******************************************************/
		JSONObject jsonObject = returDefaultPayLoadObject(com.cop.api.utils.FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
		ResponseValidation rv=new ResponseValidation();
		Response response = null;
		response = given().
				spec(requestSpec).
				contentType("Application/json").
				body("test").
				when().
				post("/generateToken");

//		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().statusCode(400);
		String token = response.then().extract().body().asString();
		TextFileutil.updatetoken(token);
		Reporter.log("Expected Response code is : 400 and the Actual Response Code is "+  response.then().extract().statusCode());


	}
	public static String readConfigurationFile(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}

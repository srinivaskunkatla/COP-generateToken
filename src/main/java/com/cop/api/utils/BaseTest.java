package com.cop.api.utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;

import org.json.simple.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cop.api.helpers.TextFileutil;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public abstract class BaseTest extends FrameworkUtility {
	
	protected static RequestSpecification requestSpec;
	protected static ResponseSpecification responseSpec;
	
	@BeforeSuite
	
	public void setBaseURI() {
		
        AllureLogger.logToAllure("The base URI is : "+readConfigurationFile("Base_URI"));
		requestSpec = new RequestSpecBuilder().
                		setBaseUri(readConfigurationFile("Base_URI")).
                		build();
        
	}

	/*****************************************************************************************************************/
//	@AfterSuite
	public void afterSuite() {

	}
	
	/****************************************************************************************************************/
//	@BeforeClass

//		public void post_CreateAuth() throws IOException{
//			AllureLogger.logToAllure("Starting the test for GET method for create authentication");
//				/*******************************************************
//				 * Send a POST request to /generateToken?
//				 * and check that the response has HTTP status code 200
//				 ******************************************************/
//				JSONObject jsonObject = returDefaultPayLoadObject(com.cop.api.utils.FrameworkConstants.POSTRequest_AUTH_DEFAULT_REQUEST);
//				Response response = null;
//				try {
//					  String en=URLEncoder.encode("/generateToken?");
////					    String url=URLDecoder.decode(en);
//					response = given().
//											spec(requestSpec).
//											contentType("text/plain").
//											body(ReadDataFromTxtFile.readtxtFile(FrameworkConstants.BASE_PATH)).
//										when().
//											post("/generateToken");
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
//				response.then().spec(responseSpec);
//				String token = response.then().extract().body().asString();
//				TextFileutil.updatetoken(token);
//			}
	
	/****************************************************************************************************************/	
//	@AfterClass
	public void afterClass(){

	}
	
	/************************************************************************************************************************/
	@BeforeMethod
	public void beforeMethod() {
    	responseSpec = new ResponseSpecBuilder().expectStatusCode(200).build();        
	}

//	@AfterMethod
	public void afterMethod() {

	}

}
/*****************************************************************************************************************/
package com.cop.api.tests;

import static io.restassured.RestAssured.given; //import this

import org.testng.annotations.Test;

import com.cop.api.models.Request1;
import com.cop.api.utils.BaseTest;
//import com.cop.apitest.listeners.ExtentTestManager;
//import com.relevantcodes.extentreports.LogStatus;

import io.restassured.http.Method;
import io.restassured.response.Response;


public class CreateNewData extends BaseTest {
	
	public static String newID = "";
	
    
	@Test(description="Create New Data") 
	public void createNewBooking(Method method){
		
//		AllureLogger.logToAllure("Starting the test to create new details");
		/*******************************************************
		 * Send a POST request to /Create/{id}
		 * and check that the response has HTTP status code 200
		 ******************************************************/
		
		//Sending the GET request for a specific booking id and receiving the response
//		AllureLogger.logToAllure("Posting a new booking detail");
//		ExtentTestManager.startTest(method.getName(), "Description: Valid Login Scenario with username and password.");
		Request1 bookingDetails = new Request1();
		bookingDetails.setName("Srinivas");
		bookingDetails.setJob("Software Engineer");
		
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Sending the POST request to create new booking");		
//		AllureLogger.logToAllure("Sending the POST request to create new booking");
		Response response = given().
								spec(requestSpec).
								contentType("application/json").
					            body(bookingDetails).log().body().
					        when().
					        	post("/api/users");
		
		//Verify the response code
	
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Asserting the response if the status code returned is 200");
//		AllureLogger.logToAllure("Asserting the response if the status code returned is 200");
		response.then().spec(responseSpec);		

		//To log the response to report
		logResponseAsString(response);
		
		
		//To get the newly created bookign id
		newID = response.then().extract().path("id").toString();
//		ExtentTestManager.getTest().log(LogStatus.INFO, "Retrieved booking id : "+response.then().extract().path("id"));
//		AllureLogger.logToAllure("Retrieved booking id : "+response.then().extract().path("id"));
		
	}	
}

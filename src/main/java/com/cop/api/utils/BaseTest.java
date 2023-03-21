package com.cop.api.utils;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URLEncoder;



import org.json.simple.JSONObject;
import org.testng.annotations.*;

import com.cop.api.helpers.TextFileutil;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public abstract class BaseTest extends FrameworkUtility{

//	public static ExtentReports extent;
	protected static RequestSpecification requestSpec;
	protected static ResponseSpecification responseSpec;
		@BeforeTest(groups= {"SmokeTest"})
		public void setup() throws IOException {
//			ReportConfiguration reportConfiguration = new ReportConfiguration();
//			reportConfiguration.ExtendReportConfiguraiton();
//			initializeReport();
		}

//	    @AfterTest
//	    public void getResult(ITestResult result) throws Exception{
//	    	if(result.getStatus() == ITestResult.FAILURE){
//	    	//MarkupHelper is used to display the output in different colors
//	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
//	    	logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
//
//	    	String screenshotPath = common_methods.getScreenShot(driver, result.getName());
//
//	    	logger.fail("Test Case Failed Snapshot is below " + logger.addScreenCaptureFromPath(screenshotPath));
//	    	}
//	    	else if(result.getStatus() == ITestResult.SKIP){
//	    	logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
//	    	}
//	    	else if(result.getStatus() == ITestResult.SUCCESS)
//	    	{
//	    	logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
//	    	}
//	    	driver.quit();
//	    	}

		@AfterTest
//		public void flushReports() {
//			extent.flush();
//		}

//		public void initializeReport(){
//			ExtentSparkReporter htmlReporter =  new ExtentSparkReporter(System.getProperty("user.dir")+"/Reports/Test.html");
//			htmlReporter.config().setDocumentTitle("COP Report Demo Test");
//			htmlReporter.config().setReportName("Demo Test Report");
//			htmlReporter.config().setTheme(Theme.STANDARD);
//			htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
//			extent=new ExtentReports();
//			extent.attachReporter(htmlReporter);
//		}


	@BeforeSuite

	public void setBaseURI() {

//        AllureLogger.logToAllure("The base URI is : "+readConfigurationFile("Base_URI"));
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
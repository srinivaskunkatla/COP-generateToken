package com.cop.api.helpers;

import java.util.Map;

import org.json.JSONObject;
import org.junit.Assert;
import org.testng.Reporter;

import com.cop.api.utils.BaseTest;
import com.mongodb.util.JSON;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

public class ResponseValidation extends BaseTest {
	  
	protected static ResponseSpecification responseSpec;
	
	public void validateHeaderJWT(Map<Object,String> headers,String Token) {
		try {
		JSONObject obj = new JSONObject(headers.get("header"));
		Reporter.log("Generated JWT Token value is :" + Token);
		Assert.assertTrue(!obj.get("kid").toString().isEmpty());
		Reporter.log(" ");
		Reporter.log("kid value Expected in Header is : String and Actual Values is : " + obj.get("kid"));
		Assert.assertEquals(obj.get("typ"), "JWT");
		Reporter.log("typ value Expected in Header is :JWT and Actual Values is : " + obj.get("typ"));
		Assert.assertEquals(obj.get("alg"), "PS256");
		Reporter.log("alg value Expected in Header is :PS256 and Actual Values is : " + obj.get("alg"));
			
		}
		catch(Exception e) {
			
		}
	}
}

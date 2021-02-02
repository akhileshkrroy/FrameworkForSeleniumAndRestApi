package com.automation.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automation.utils.Utility;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Properties;

public class ExapmeRestApiValidationSteps {
	String baseUri=null;
	@And("set base uri of api$")
	public void setBaseUri()
	{
		Properties prop=Utility.loadProperties();
		baseUri=prop.getProperty("apiuri");
		
	}
	
	@And("user validate \"([^\"]*)\" for \"([^\"]*)\"$")
	public void validateGetAndDelete(String methodType,String expectedStatus)
	{
		RestAssured.baseURI=baseUri;
		
		Response response=given().header("Content-Type","application/json")
		.when().get("/api/v1/employees");
		
		System.out.println(response.asString());
		JsonPath path=new JsonPath(response.asString());
		String actualstatus = path.getString("status");

		// Assert that correct status code is returned.
		Assert.assertEquals(expectedStatus,actualstatus);
		
	}
	
	@And("user validate for employee id \"([^\"]*)\" name is \"([^\"]*)\"$")
	public void validateEmployeeDetail(String id,String expectedName)
	{
		RestAssured.baseURI=baseUri;
		
		Response response=given().header("Content-Type","application/json")
				.pathParam("id", id)
		.when().get("/api/v1/employee/{id}");
		
		System.out.println(response.asString());
		JsonPath path=new JsonPath(response.asString());
		String actualName = path.getString("data.employee_name");

		// Assert that correct status code is returned.
		Assert.assertEquals(expectedName,actualName);
		
	}
	
	@And("user validate deleted message is \"([^\"]*)\" for employee id \"([^\"]*)\"$")
	public void validateDeleteMessage(String expectedMessage,String id)
	{
		RestAssured.baseURI=baseUri;
		
		Response response=given().header("Content-Type","application/json")
				.pathParam("id", id)
		.when().delete("api/v1/delete/{id}");
		
		System.out.println(response.asString());
		JsonPath path=new JsonPath(response.asString());
		String actualMessage = path.getString("message");

		// Assert that correct status code is returned.
		Assert.assertEquals(expectedMessage,actualMessage );
		
	}
}

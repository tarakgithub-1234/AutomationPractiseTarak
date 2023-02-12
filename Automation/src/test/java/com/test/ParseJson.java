package com.test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ParseJson {

	@Test(priority = 0, enabled = false)
	public void parseJson() {
		Response rs = given().contentType(ContentType.JSON).when().get("https://reqres.in/api/users");
		// Assert.assertEquals(rs.getStatusCode(),200);
		// String value=rs.jsonPath().get("data[0].first_name").toString();
		// System.out.println("the value " +value);
		JSONObject data = new JSONObject(rs.asString());
		for (int i = 0; i < data.getJSONArray("data").length(); i++) {
			String name = data.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println("the value " + name);
		}
	}

	@Test(priority = 1, enabled = false)
	public void parsexml() {
		Response rs = given().contentType(ContentType.XML).when()
				.get("http://restapi.adequateshop.com/api/Traveler?page=1");
		// Assert.assertEquals(rs.getStatusCode(),200);
		// String value=rs.jsonPath().get("data[0].first_name").toString();
		// System.out.println("the value " +value);
		XmlPath data = new XmlPath(rs.asString());
		List<String> counttraveler = data.getList("TravelerinformationResponse.travelers.Travelerinformation");
		System.out.println("the value " + counttraveler.size());

	}

	@Test(priority = 2, enabled = false)
	public void authenticationxml() {

		given().auth().basic("postman", "password").get("https://postman-echo.com/basic-auth").then().log().all();

	}

	@Test(priority = 3, enabled = false)
	public void premptiveauthenticationxml() {

		Response rs = given().auth().preemptive().basic("postman", "password")
				.get("https://postman-echo.com/basic-auth");
		System.out.print("the value is " + rs.getStatusCode());
		String value = rs.jsonPath().get("authenticated").toString();
		System.out.print("the value is " + value);
		JSONObject js = new JSONObject(rs.asString());
		String val = js.get("authenticated").toString();
		System.out.print("the value is " + val);
	}

	@Test(priority = 4, enabled = false)
	public void bearertokenauthenticationxml() {

		given().headers("Authorization", "Bearer" + "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").when()
				.get("https://api.github.com/user").then().log().all();
		

	}
	@Test(priority = 5, enabled = false)
	public void oauth2authentication() {

		given().auth().oauth2("access token").when()
				.get("https://api.github.com/user").then().log().all();
		

	}
	@Test(priority = 6, enabled = true)
	public void apikeyauthentication() {

		given().queryParam("key","value").when()
				.get("https://api.github.com/user").then().log().all();
		

	}

}

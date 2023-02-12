package APITest;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateUser {

	@Test(priority=0,enabled=false)
	public void createUseAPIr() {
		JSONObject data = new JSONObject();
		data.put("name", "jakson");
		data.put("job", "doctor");

		Response rs = given().contentType("application/json").body(data.toString()).

				when().post("https://reqres.in/api/user");
		String id = rs.jsonPath().get("id").toString();
		
		System.out.print("the value is " + id);
	}
	@Test(priority=1)
	public void createUseAPIBookStore() {
		JSONObject data = new JSONObject();
		data.put("isbn", "7003354011");
		data.put("userId","TQ123");

	Response rs = given().contentType("application/json").body(data.toString()).

				when().post("https://demoqa.com/BookStore/v1/Books");
    System.out.println("the response is" +rs.getBody().asString());
	}
}


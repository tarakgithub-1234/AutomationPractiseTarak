package APITest;

import static io.restassured.RestAssured.given;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class GetUser {

	@Test(priority=0,enabled=false)
	public void getUseAPIr() {

       Response rs =given().contentType("application.JSON").

				when().get("https://reqres.in/api/user/2");
    System.out.print(rs.statusLine());  
    System.out.print(rs.header("Content-Type"));
	JSONObject data = new JSONObject(rs.asString());
	String name = data.getJSONObject("data").get("id").toString();
	System.out.println("the value " + name);
	
		
	}
	@Test(priority=1)
	public void getDetails() {

      Response response= given().contentType("application.JSON").

				when().get("https://demoqa.com/BookStore/v1/Books");
      System.out.println("the response is" +response.getBody().asString());
    
		
	}
	}
	


package com.test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Utils.BrowserFactory;
import com.Utils.PageObjectManager;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.pages.BaseClass;
import com.pages.LoginPage;

import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class TestCase extends BaseClass {
   static	WebDriver driver;
	PageObjectManager pom=new PageObjectManager(driver);
	//LoginPage loginpage=new LoginPage(driver);
	LoginPage loginpage;
	
	@BeforeTest
	public void launchBrowser() {
	//	BrowserFactory.launchBrowser(driver,"chrome","https://www.opencart.com/");
	   
		//driver.quit();
   }
	@Test(priority=0,enabled=false)
	public void display() throws InterruptedException {
		logger=report.createTest("Login success");
		loginpage=pom.getLoginPage();
		loginpage.login();
		logger.info("This is an info");
		logger.pass("Loggin success");
	}
	
	@Test(priority=1,enabled=false)
	public void getData() throws InterruptedException {
	Response rs =  given().queryParam("id","2")
	   .when().get("https://reqres.in/api/users");
Map<String, String> cookie_value=rs.getCookies();
for(String str:cookie_value.keySet()) {
	System.out.println("values are" +str);
}
	
	
	}
	
	
	@Test(priority=3,enabled=false)
	public void postData() throws InterruptedException {
	 JSONObject data=new JSONObject();
		//HashMap data =new HashMap();
	    data.put("name","kamal");
	    data.put("job","doctor");
	  given().contentType("application/json").body(data.toString())
	  .when().post("https://reqres.in/api/user").then().log().all();
	}
	
	@Test(priority=4,enabled=false)
	public void putData() throws InterruptedException {
	 JSONObject data=new JSONObject();
		//HashMap data =new HashMap();
	    data.put("name","kamal");
	    data.put("job","doctor");
	  given().contentType("application/json").body(data.toString())
	  .when().put("https://reqres.in/api/user").then().log().all();
	}
	
	
	@Test(priority=5,enabled=false)
	public void deleteData() throws InterruptedException {
	   when().delete("https://reqres.in/api/users").then().statusCode(200).log().all();	}
	@AfterMethod
	public void teardown() {
		//report.flush();
		//BrowserFactory.closebrowser(driver);
	}
}

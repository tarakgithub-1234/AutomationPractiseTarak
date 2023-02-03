package StepDefinetion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	WebDriver driver;
	@Given("User launches the Application")
	public void user_launches_the_application() {
		System.setProperty("webdriver.chrome.driver","D:\\workspace\\Testing\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.opencart.com/");
	}

	@When("User clicks on Login link")
	public void user_clicks_on_login_link() {
		driver.findElement(By.xpath("(//*[text()='Login'])[2]")).click();
		//driver.quit();
	}

	@Then("Login page should be displayed")
	public void login_page_should_be_displayed() {

	}
	@When("^User enter \"(.*)\" and \"(.*)\"$")
	public void user_enters_UserName_and_Password(String username, String password) {
		driver.findElement(By.xpath("(//*[text()='Login'])[2]")).click();
		driver.findElement(By.name("email")).sendKeys(username); 	 
	    driver.findElement(By.name("password")).sendKeys(password);
	 
	}


}

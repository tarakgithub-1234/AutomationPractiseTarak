package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver Idriver) {
		this.driver = Idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "(//*[text()='Login'])[2]")
	private WebElement loginlink;
	@FindBy(name = "email")
	private WebElement username;

	public void login() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[text()='Login'])[2]")).click();
		username.sendKeys("tarak");
		driver.findElement(By.name("password")).sendKeys("abc");
	}
}

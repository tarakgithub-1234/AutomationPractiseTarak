package com.Utils;

import org.openqa.selenium.WebDriver;

import com.pages.LoginPage;

public class PageObjectManager {
	
	private WebDriver driver;
	 private LoginPage loginpage;
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}

	public  LoginPage getLoginPage() {
		return (loginpage == null) ? loginpage = new LoginPage(driver) : loginpage;
	}
}

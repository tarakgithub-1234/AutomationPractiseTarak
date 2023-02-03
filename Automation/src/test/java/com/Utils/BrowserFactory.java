package com.Utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	public static void launchBrowser(WebDriver driver, String browser, String url) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Testing\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get(url);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
	}
	public static void closebrowser(WebDriver driver)
	{
		//driver.quit();
	}
}
package com.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.BaseClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Appium extends BaseClass {

	AndroidDriver driver;
	AppiumDriverLocalService obj;

	@BeforeClass()
	public void startApp() throws MalformedURLException {
		obj = new AppiumServiceBuilder()
				.withAppiumJS(
						new File("C://Users//user//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		// obj.start();
		UiAutomator2Options ui = new UiAutomator2Options();
		ui.setDeviceName("TarakEmulator");
		ui.setApp(
				"C:\\Users\\user\\git\\AutomationPractiseTarak\\Automation\\src\\test\\resources\\ApiDemos-debug.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), ui);

	}

	@Test(priority = 0)
	public void openCalculator() throws MalformedURLException {

		driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Accessibility Service']")).click();

		// driver.findElement(AppiumBy.accessibilityId("Accessibility")).click();
	}

	@AfterClass()
	public void teardown() {
		obj.stop();
		driver.quit();
	}
}

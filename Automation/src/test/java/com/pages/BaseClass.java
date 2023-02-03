package com.pages;

import java.io.File;

import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public ExtentReports report;
	public ExtentTest    logger;
	@BeforeSuite
	public void setupSuite() {
		ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"Reports/Myreport.html"));
		 report=new ExtentReports();
		 report.attachReporter(extent);
		//add file
		 //testfie
	}
}


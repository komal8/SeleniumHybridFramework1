package com.visionIT.FreeCrm.Testbase;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.visionIT.FreeCrm.Utility.ConfigDataProvider;
import com.visionIT.FreeCrm.Utility.ExcelDataProvider;
import com.visionIT.FreeCrm.Utility.Helper1;



public class BaseClass {

		public static WebDriver driver;

		public ExcelDataProvider excelDataProvider;

		public static ConfigDataProvider configDataProvider;
		
		public static ExtentReports extent;
		
		public static ExtentTest logger;

		@BeforeSuite
		public void intitialize() {

			Reporter.log("Initializing pre object like configData , excelData provider and html reports .. ",true);
			configDataProvider = new ConfigDataProvider();
			excelDataProvider = new ExcelDataProvider();
			
			String dirPath=System.getProperty("user.dir");
			
			
			ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(dirPath+"//Reports//FreeCrm_"+Helper1.getCurrentDataTime()+".html"));
		
			ExtentReports extent=new ExtentReports();
			
			extent.attachReporter(reporter);
			
			Reporter.log("prequisit is ready start the application...", true);
		
		}

		public static void browserStartUp(String brName, String url) {

			if (brName.equals("Firefox")) {

				System.setProperty("webdriver.gecko.driver", "");

				driver = new FirefoxDriver();

			} else if (brName.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");

				driver = new ChromeDriver();

			} else if (brName.equals("IE")) {
				System.setProperty("webdriver.ie.driver", "");

				driver = new InternetExplorerDriver();
			} else {
				System.out.println("Driver exe not able to found and hence IllegleStaeException");
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(url);

			
		}

		@AfterMethod
		public void tearDown(ITestResult results) throws IOException {
		
			Reporter.log("Test is about to end...", true);

			if (results.getStatus() == ITestResult.FAILURE) {

				//Helper.captureScreenShots(driver);
				
				logger.fail("testcase failed..",MediaEntityBuilder.createScreenCaptureFromPath(Helper1.captureScreenShots(driver)).build());

			} else if (results.getStatus() == ITestResult.SUCCESS) {

			} else if (results.getStatus() == ITestResult.SKIP) {

			}
			
			extent.flush();
		}

		/*
		 * public static void main(String[] args) { browserStartUp("Chrome",
		 * "https://www.crmpro.com/"); }
		 */
	}



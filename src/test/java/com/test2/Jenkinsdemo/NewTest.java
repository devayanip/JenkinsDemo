package com.test2.Jenkinsdemo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
  @Test
  public void f() throws IOException 
  {
	  MyCommonUtility common = new MyCommonUtility(driver);
	  
	  try 
	  {
		  New n=new New(driver);
		  n.test();
		  test.info("Method run");
	  }
	  catch (Exception e) 
	  {
		test.fail("error").addScreenCaptureFromPath(common.screenshot("prob2"));
		/*MediaEntityModelProvider mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(common.screenshot("prob1")).build();
		test.fail("error in sign up",mediaModel);*/
	  }
  }
  
  @Parameters("browserName")
  @BeforeTest
  public void beforeTest(String brow) 
  {
	  ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("Resource/ExtentReport.html");
	  htmlReporter.config().setTheme(Theme.DARK);
	  htmlReporter.config().setChartVisibilityOnOpen(true);
	  htmlReporter.setAppendExisting(true);
		
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  test=extent.createTest("Deva test");
	  test.pass("Started test");
	  
	  String br=brow;
	  	
	  if(br.equalsIgnoreCase("chrome")) 
	  {
		  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		 
		  driver=new ChromeDriver(); 
		  
		  test.info("Chrome pass");
	  }
		 
	  if(br.equalsIgnoreCase("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		  
		  driver=new InternetExplorerDriver();
		  
		  test.info("IE Pass");
	  }
	  
	  driver.get("https://phptravels.org/clientarea.php");
	  
	  //Assert.assertEquals(driver.getTitle(), "Client Area - PHPTRAVELS");
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  test.pass("URL successfully opened");
  }

  @AfterTest
  public void afterTest() 
  {
	  //test.info("Close all");
	  //System.out.println("abcdefghijklmnopqrstuvwxyz");
	  driver.quit();
	  extent.flush();
  }

}

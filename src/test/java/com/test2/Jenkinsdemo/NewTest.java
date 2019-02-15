package com.test2.Jenkinsdemo;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
  @Test
  public void f() 
  {
	  New n=new New(driver);
	  n.test();
  }
  
  @Parameters("browser")
  @BeforeTest
  public void beforeTest(String brow) 
  {
	  ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("Resource/ExtentReport.html");
	  extent=new ExtentReports();
	  extent.attachReporter(htmlReporter);
	  ExtentTest test=extent.createTest("Deva test");
	  test.pass("Started test");
	  
	  String br=brow;
	  
		
	  if(br.equalsIgnoreCase("chrome")) 
	  {
		  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		 
		  driver=new ChromeDriver(); 
		  
		  test.pass("Chrome pass");
	  }
		 
	  if(br.equalsIgnoreCase("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		  
		  driver=new InternetExplorerDriver();
		  
		  test.pass("IE Pass");
	  }
	  
	  driver.get("https://phptravels.org/clientarea.php");
	  
	  Assert.assertEquals(driver.getTitle(), "Client Area - PHPTRAVELS");
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  test.pass("URL successfully opened");
  }

  @AfterTest
  public void afterTest() 
  {
	  test.pass("Close all");
	  //System.out.println("abcdefghijklmnopqrstuvwxyz");
	  driver.quit();
	  extent.flush();
  }

}

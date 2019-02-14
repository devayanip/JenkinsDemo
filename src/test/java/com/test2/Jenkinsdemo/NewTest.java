package com.test2.Jenkinsdemo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class NewTest {
	
	WebDriver driver;
	
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
	  String br=brow;
	  
	  if(br.equalsIgnoreCase("chrome"))
	  {
		  System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
		  
		  driver=new ChromeDriver();
	  }
	  
	  if(br.equalsIgnoreCase("ie"))
	  {
		  System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
		  
		  driver=new ChromeDriver();
	  }
	  
	  driver.get("https://phptravels.org/clientarea.php");
	  
	  Assert.assertEquals(driver.getTitle(), "Client Area - PHPTRAVELS");
	  
	  driver.manage().window().maximize();
	  
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.quit();
  }

}

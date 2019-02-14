package com.test2.Jenkinsdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class New 
{
	WebDriver driver;
	
	@FindBy(linkText="Register")
	WebElement reg;
	
	@FindBy(id="inputFirstName")
	WebElement fname;
	
	@FindBy(id="inputLastName")
	WebElement lname;
	
	public New(WebDriver driver2) 
	{
		driver=driver2;
		
		PageFactory.initElements(driver, this);
	}

	public void test()
	{	
		reg.click();
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://phptravels.org/register.php");
		
		fname.sendKeys("Jack");

		System.out.println("damini deokar");
		System.out.println("deva");

		lname.sendKeys("Jonas");
	}
		
}

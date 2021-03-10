package com.amazontest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.AmazonTestBase;
import com.amazonpom.HomePage;
import com.amazonpom.SignInPage;

public class HomePageTest extends AmazonTestBase{
	
	HomePage homePage;
	SignInPage signInPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		LaunchBrowser();
		homePage = new HomePage();
	}
	
	@Test
	public void CheckHomePageTitleTest() {		
		//Verification of Home Page Title
		String ActualTitle = homePage.CheckTitle();
		String ExpectedTitle = properties.getProperty("HomePageTitle");
		Assert.assertEquals(ExpectedTitle, ActualTitle, "Amazon Page Title is displayed incorrect");
	}
	
	@Test
	public void ClicktoSignIn() {	
		//Click on SignIn
		signInPage = homePage.SignInClick();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}

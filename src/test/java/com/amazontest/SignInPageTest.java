package com.amazontest;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.AmazonTestBase;
import com.amazon.Util.AmazonTestUtil;
import com.amazonpom.HomePage;
import com.amazonpom.SearchPage;
import com.amazonpom.SignInPage;

public class SignInPageTest extends AmazonTestBase{
	
	SignInPage signInPage;
	SearchPage searchPage;
	HomePage homePage;
	
	public SignInPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		LaunchBrowser();
		homePage = new HomePage();
		signInPage = homePage.SignInClick();
	}
	
	@Test
	public void CheckSignInPageTitle(){		
		//Validate Page Title
		String ActualTitle = signInPage.CheckTitle();
		String ExpectedTitle = properties.getProperty("SignInPageTitle");
		Assert.assertEquals(ActualTitle, ExpectedTitle, "SignIn Page Title is displayed Incorrect");	
	}
	
	@Test
	public void Login() {
		try {
			Map<String, String> map = AmazonTestUtil.getAmazonTestData();
			signInPage.SignIn(map.get("Email_Id"), map.get("Password"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
		
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}

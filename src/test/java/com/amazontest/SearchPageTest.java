package com.amazontest;

import java.io.IOException;
import java.util.Map;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.AmazonTestBase;
import com.amazon.Util.AmazonTestUtil;
import com.amazonpom.HomePage;
import com.amazonpom.SearchPage;
import com.amazonpom.SignInPage;

public class SearchPageTest extends AmazonTestBase{
	
	SignInPage signInPage;
	SearchPage searchPage;
	HomePage homePage;

	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		LaunchBrowser();
		homePage = new HomePage();
		signInPage = homePage.SignInClick();
		Map<String, String> map = AmazonTestUtil.getAmazonTestData();
		searchPage = signInPage.SignIn(map.get("Email_Id"), map.get("Password"));
	}
	
	@Test
	public void CheckSearchPageTitle(){		
		//Validate Page Title
		String ActualTitle = searchPage.getSearchPageTitle();
		System.out.println("Actual Search Page Title: "+ActualTitle);
	}
	
	@Test
	public void SearchRequiredProduct() throws IOException {
		Map<String, String> map = AmazonTestUtil.getAmazonTestData();
		searchPage.SearchProduct(map.get("ProductName"));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}

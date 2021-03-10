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
import com.amazonpom.SearchResultsPage;
import com.amazonpom.SignInPage;

public class SearchResultsPageTest extends AmazonTestBase{
	
	SignInPage signInPage;
	SearchPage searchPage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;

	public SearchResultsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		LaunchBrowser();
		homePage = new HomePage();
		signInPage = homePage.SignInClick();
		Map<String, String> map = AmazonTestUtil.getAmazonTestData();
		searchPage = signInPage.SignIn(map.get("Email_Id"), map.get("Password"));
		searchResultsPage = searchPage.SearchProduct(map.get("ProductName"));
	}
	
	@Test
	public void CheckSearchResultsPageTitle(){		
		//Validate Page Title
		String ActualTitle = searchResultsPage.getSearchResultsPageTitle();
		System.out.println("Actual Search Results Page Title: "+ActualTitle);
		String ExpectedTitle = properties.getProperty("ProductTitle");
		Assert.assertEquals(ExpectedTitle,ActualTitle, "Failed to verify Search Results Page Title");
	}
	
	@Test
	public void LaunchProduct() throws IOException {
		searchResultsPage.ClickProduct();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}

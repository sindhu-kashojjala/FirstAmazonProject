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
import com.amazonpom.ProductPage;
import com.amazonpom.SearchPage;
import com.amazonpom.SearchResultsPage;
import com.amazonpom.SignInPage;

public class ProductPageTest extends AmazonTestBase {
	
	SignInPage signInPage;
	SearchPage searchPage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ProductPage productPage;

	public ProductPageTest() {
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
		productPage = searchResultsPage.ClickProduct();
	}
	
	@Test
	public void CheckProductPageTitle(){		
		//Validate Page Title
		String ActualTitle = productPage.getProductPageTitle();
		String ExpectedTitle = properties.getProperty("ProductTitle");
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Failed to display correct Product");
		System.out.println("Actual Product Page Title: "+ActualTitle);
	}
	
	@Test
	public void PurchaseRequiredProduct() throws IOException {
	    productPage.ClickBuyNowButton();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}

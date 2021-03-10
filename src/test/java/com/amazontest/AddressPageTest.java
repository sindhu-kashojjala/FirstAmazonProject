package com.amazontest;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazon.AmazonTestBase;
import com.amazon.Util.AmazonTestUtil;
import com.amazonpom.AddressPage;
import com.amazonpom.HomePage;
import com.amazonpom.ProductPage;
import com.amazonpom.SearchPage;
import com.amazonpom.SearchResultsPage;
import com.amazonpom.SignInPage;

public class AddressPageTest extends AmazonTestBase{
	
	SignInPage signInPage;
	SearchPage searchPage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ProductPage productPage;
	AddressPage addressPage;

	public AddressPageTest() {
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
		addressPage = productPage.ClickBuyNowButton();
	}
	
	@Test
	public void CheckAddressPageTitle(){		
		String ActualTitle = addressPage.getAddressPageTitle();
		String ExpectedTitle = properties.getProperty("AddressPageTitle");
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Failed to navigate to address page");
		System.out.println("Actual Address Page Title: "+ActualTitle);
	}
	
	@Test
	public void ChooseDeliveryAddress(){
		addressPage.selectdeliveryaddress();
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}


}

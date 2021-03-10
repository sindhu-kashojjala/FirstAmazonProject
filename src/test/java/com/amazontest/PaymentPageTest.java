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
import com.amazonpom.PaymentPage;
import com.amazonpom.ProductPage;
import com.amazonpom.SearchPage;
import com.amazonpom.SearchResultsPage;
import com.amazonpom.SignInPage;

public class PaymentPageTest extends AmazonTestBase{
	
	SignInPage signInPage;
	SearchPage searchPage;
	HomePage homePage;
	SearchResultsPage searchResultsPage;
	ProductPage productPage;
	AddressPage addressPage;
	PaymentPage paymentPage;

	public PaymentPageTest() {
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
		paymentPage = addressPage.selectdeliveryaddress();
	}
	
	@Test
	public void CheckPaymentPageTitle(){		
		//Validate Page Title
		String ActualTitle = paymentPage.getPaymentPageTitle();
		String ExpectedTitle = properties.getProperty("PaymentPageTitle");
		Assert.assertEquals(ActualTitle, ExpectedTitle, "Failed to navigate to address page");
		System.out.println("Actual Address Page Title: "+ActualTitle);
	}
	
	@Test
	public void EnterPaymentDetails() throws IOException{
		Map<String, String> map = AmazonTestUtil.getAmazonTestData();
		System.out.println("Account Holder Name: "+map.get("AccountHolderName"));
		System.out.println("Account Number: "+map.get("AccountNumber"));
		String Message = paymentPage.paymentdetails(map.get("AccountHolderName"), map.get("AccountNumber"));
		System.out.println("Message displayed when incorrect card details are provided: "+Message);
		Assert.assertEquals(Message, properties.getProperty("ErrorMessage"));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}

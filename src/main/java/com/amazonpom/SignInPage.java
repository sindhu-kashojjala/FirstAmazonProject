package com.amazonpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class SignInPage extends AmazonTestBase{
	
	//find required objects
	@FindBy(id="ap_email")
	WebElement UserName;
	
	@FindBy(id="continue")
	WebElement ContinueBtn;
		
	@FindBy(id="ap_password")
	WebElement password;
	
	@FindBy(id="signInSubmit")
	WebElement submit;
	
	public SignInPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
		public String CheckTitle() {
			return driver.getTitle();
		}
	
		public SearchPage SignIn(String emailId, String passwrd) {
			UserName.sendKeys(emailId);
			ContinueBtn.click();
			password.sendKeys(passwrd);
			submit.click();
			return new SearchPage();
		}
	}

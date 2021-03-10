package com.amazonpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class HomePage extends AmazonTestBase{
	
	//Define required objects	
	@FindBy(xpath="//span[@id='nav-link-accountList-nav-line-1']")
	WebElement SignIn;

	//Initializing the Page Objects
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String CheckTitle() {
		return driver.getTitle();
	}
	
	public SignInPage SignInClick() {
		SignIn.click();
		return new SignInPage();
	}

}

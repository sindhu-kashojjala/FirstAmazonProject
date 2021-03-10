package com.amazonpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class AddressPage extends AmazonTestBase{
	
	@FindBy(id="nav-inner")
	WebElement deliverypageimage;
	
	@FindBy(xpath="(//a[@class='a-declarative a-button-text '])[1]")
	WebElement delivertoAddressBtn;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getAddressPageTitle() {
		return driver.getTitle();
	}
	
	public PaymentPage selectdeliveryaddress() {
		delivertoAddressBtn.click();
		return new PaymentPage();
	}

}

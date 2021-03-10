package com.amazonpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class PaymentPage extends AmazonTestBase{

	@FindBy(xpath="//input[@value='SelectableAddCreditCard']")
	WebElement addcard;
	
	@FindBy(xpath="//input[@name='ppw-accountHolderName']")
	WebElement accountholdername;
	
	@FindBy(xpath="//input[@name='addCreditCardNumber']")
	WebElement accountnumber;
	
	@FindBy(name="ppw-widgetEvent:AddCreditCardEvent")
	WebElement addcreditcard;
	
	@FindBy(xpath="//span[text()='Card number is not correct.']")
	WebElement incorrectcardnumber;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getPaymentPageTitle() {
		return driver.getTitle();
	}
	
	public String paymentdetails(String accholdername, String accnumber) {
		addcard.click();
		accountholdername.clear();
		accountholdername.sendKeys(accholdername);
		accountnumber.sendKeys(accnumber);
		addcreditcard.click();
		return incorrectcardnumber.getText();
	}
	
}

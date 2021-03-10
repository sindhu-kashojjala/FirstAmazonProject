package com.amazonpom;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class ProductPage extends AmazonTestBase {
	
	@FindBy(xpath="//span[@class='a-button a-button-oneclick a-button-icon onml-buy-now-button']")
	WebElement BuyNowButton;
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getProductPageTitle() {
		return driver.getTitle();
	}

	public AddressPage ClickBuyNowButton() {
		String parentwindowhandle = driver.getWindowHandle();
	    System.out.println("parent window name: "+parentwindowhandle);
	    Set<String> newwindowname = driver.getWindowHandles();
	      if(driver.getWindowHandles().size()>0) {
	    	  System.out.println("Searched Product is sucessfully launched in new tab");
	      }else{
	    	  System.out.println("Failed to search product");
	      }
	      Iterator<String> I1= newwindowname.iterator();
	      while(I1.hasNext())
	      {
	    	  String child_window=I1.next();
	    	  if(!parentwindowhandle.equals(child_window)){
	    		  driver.switchTo().window(child_window);
	    		  System.out.println(driver.switchTo().window(child_window).getTitle());
	    	  }
	      }
	      driver.findElement(By.xpath(properties.getProperty("buynowbutton"))).click();
		//BuyNowButton.click();
		return new AddressPage();
	}


}

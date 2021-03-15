package com.amazonpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class SearchResultsPage extends AmazonTestBase{
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'Samsung Galaxy M31 (Ocean Blue, 6GB RAM, 128GB Storage)')]")
	WebElement ProductPath;
	
	public SearchResultsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchResultsPageTitle() {
		return driver.getTitle();
	}

	public ProductPage ClickProduct() {
		ProductPath.click();
		return new ProductPage();
	}

}

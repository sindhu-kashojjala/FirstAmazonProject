package com.amazonpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class SearchResultsPage extends AmazonTestBase{
	
	@FindBy(xpath="//span[contains(text(),'Redmi 9 (Sky Blue, 4GB RAM, 64GB Storage)')]")
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

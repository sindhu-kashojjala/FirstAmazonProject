package com.amazonpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.AmazonTestBase;

public class SearchPage extends AmazonTestBase{
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement SearchButton;
	
	public SearchPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String getSearchPageTitle() {
		return driver.getTitle();
	}

	public SearchResultsPage SearchProduct(String ProductName) {
		SearchBox.sendKeys(ProductName);
		SearchButton.click();
		return new SearchResultsPage();
	}
	

}

package com.automation.pim.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automation.pim.locators.PageObjectsLocators;

public class PurchasePage {
	WebDriver ldriver;

	public PurchasePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath=PageObjectsLocators.Purchase_Button)
	public WebElement btnPurchase;
	
	@FindBy(xpath = PageObjectsLocators.Purchase_Close_Button)
	public WebElement btnClose;
	
	@FindBy(xpath=PageObjectsLocators.Purchase_Ok_Button)
	public WebElement btnPurchaseOk;
	
	@FindBy(xpath=PageObjectsLocators.Purchase_Details)
	public WebElement pDetails;

	public void purchase() {
		btnPurchase.click();

	}

	public void close() {
		btnClose.click();
	}
	
	public void confirm() {
		btnPurchaseOk.click();
	}
	
	public String purchaseDetails() {
		
	    String popupText = pDetails.getText();
		return popupText;

	}

}

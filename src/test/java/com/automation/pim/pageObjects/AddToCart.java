package com.automation.pim.pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pim.locators.PageObjectsLocators;

public class AddToCart {

	WebDriver ldriver;

	public AddToCart(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = PageObjectsLocators.Phone_Category)
	public WebElement lnkPhones;

	@FindBy(xpath = PageObjectsLocators.First_Phone)
	public WebElement selctPhone;

	@FindBy(xpath = PageObjectsLocators.Add_To_Cart_Button)
	public WebElement addToCartBtn;

	@FindBy(xpath = PageObjectsLocators.Home_Link)
	public WebElement home;

	@FindBy(xpath = PageObjectsLocators.Second_Phone)
	public WebElement selctPhone2;

	@FindBy(xpath = PageObjectsLocators.Cart_Link)
	public WebElement lnkCart;

	@FindBy(xpath = PageObjectsLocators.Delete_Item)
	public WebElement delItem;

	@FindBy(xpath = PageObjectsLocators.PlaceOrder_Button)
	public WebElement placeOrderBtn;

	@FindBy(id = PageObjectsLocators.Form_Modal)
	public WebElement formDetails;

	@FindBy(id=PageObjectsLocators.Total_ItemPrice)
	public WebElement totalPrice;
	
	public void lnkPh() {
		lnkPhones.click();
	}

	public void selectPh() {
		selctPhone.click();
	}

	public void addToCart() {
		addToCartBtn.click();
	}

	public void homePg() {
		home.click();
	}

	public void selectPh2() {
		selctPhone2.click();
	}

	public void cart() {
		lnkCart.click();
	}

	public void delete() {
		delItem.click();
	}

	public void placeOrder() {
		placeOrderBtn.click();
	}

	public void username(String uname) {
		WebElement name = formDetails.findElement(By.xpath(PageObjectsLocators.Form_User_Name));
		name.sendKeys(uname);
	}

	public void ucountry() {
		WebElement country = formDetails.findElement(By.xpath(PageObjectsLocators.Form_Country));
		country.sendKeys("Canada");
	}

	public void ucity() {
		WebElement city = formDetails.findElement(By.xpath(PageObjectsLocators.Form_City));
		city.sendKeys("Toronto");
	}

	public void ucreditcard(String creditCardDetails) {
		WebElement creditCard = formDetails.findElement(By.xpath(PageObjectsLocators.Form_CreditCard));
		creditCard.sendKeys(creditCardDetails);
	}

	public void uccmonth() {
		WebElement month = formDetails.findElement(By.xpath(PageObjectsLocators.Form_CC_Month));
		month.sendKeys("04");
	}

	public void uyear() {
		WebElement year = formDetails.findElement(By.xpath(PageObjectsLocators.Form_CC_Year));
		year.sendKeys("2026");
	}
	
	public void waitForLoginModalToAppear() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(formDetails));
	}

	public String total() {
		
		String price=totalPrice.getText();
		System.out.println(price);
		return price;
		
	}
	

}

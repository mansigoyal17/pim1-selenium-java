package com.automation.pim.pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.pim.locators.PageObjectsLocators;

public class CategoryPage {

	WebDriver ldriver;

	public CategoryPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = PageObjectsLocators.Main_Category)
	public WebElement mainCategoryList;

	@FindBy(xpath = PageObjectsLocators.Phone_Category)
	public WebElement phlink;

	@FindBy(xpath = PageObjectsLocators.Laptop_Category)
	public WebElement laptopLink;

	@FindBy(xpath = PageObjectsLocators.Monitor_Category)
	public WebElement monitorLink;
	
	@FindBy(id=PageObjectsLocators.Main_Category_Next_Button)
	public WebElement nxtBtn;
	

	public List<WebElement> mainCategory() {
		return ldriver.findElements(By.xpath(PageObjectsLocators.Items_Title));
	}
	
	public List<WebElement> mainCategory2() {
		return ldriver.findElements(By.xpath(PageObjectsLocators.Items_Title));
	}

	public void waitForLoginModalToDisappear() {
		WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id(PageObjectsLocators.Login_Modal_Label)));
	}

	public List<WebElement> phList() {
		return ldriver.findElements(By.xpath(PageObjectsLocators.Items_Title));

	}

	public List<WebElement> laptopList() {
		return ldriver.findElements(By.xpath(PageObjectsLocators.Items_Title));

	}

	public List<WebElement> monitorList() {
		return ldriver.findElements(By.xpath(PageObjectsLocators.Items_Title));

	}

}

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

public class SignUpPage {

	WebDriver ldriver;
	
	public SignUpPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}	
 	
	@FindBy(id=	PageObjectsLocators.SignUp_Link)
	WebElement lnkSignUp;
	
	@FindBy(id=	PageObjectsLocators.SignUp_Modal)
	WebElement modalElement;
	
	
	public void signUpbtn() {
		lnkSignUp.click();
	}
	
	public void setUsername(String uname) {
        WebElement inputUser=modalElement.findElement(By.xpath(PageObjectsLocators.SignUp_Username));
        inputUser.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
        WebElement inputPwd=modalElement.findElement(By.xpath(PageObjectsLocators.SignUp_Password));
        inputPwd.sendKeys(pwd);
	}
	
	public void submit() {
        modalElement.findElement(By.xpath(PageObjectsLocators.SignUp_Button)).click();
	}
	
	public void close() {
        modalElement.findElement(By.xpath(PageObjectsLocators.SignUp_Close_Button)).click();
	}
	
	
	
}

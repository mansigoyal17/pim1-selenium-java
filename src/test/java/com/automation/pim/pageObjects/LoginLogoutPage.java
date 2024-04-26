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

public class LoginLogoutPage {

	WebDriver ldriver;
	
	public LoginLogoutPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}	
	
	@FindBy(id=PageObjectsLocators.Login_Link)
	public WebElement lnkLogin;
	
	@FindBy(id=PageObjectsLocators.Login_Modal)
	public WebElement modalLogin;
	
	@FindBy(id=PageObjectsLocators.Logout_Link)
	public WebElement lnkLogout;
	
	public void loginLink() {
		lnkLogin.click();
	}
	
	public void loginUsername(String uname) {
        WebElement inputUser=modalLogin.findElement(By.xpath(PageObjectsLocators.Login_Username));
        inputUser.sendKeys(uname);
	}
	
	public void loginPassword(String pwd) {
        WebElement inputPwd=modalLogin.findElement(By.xpath(PageObjectsLocators.Login_Password));
        inputPwd.sendKeys(pwd);
	}
	
	public void loginbtn() {
		modalLogin.findElement(By.xpath(PageObjectsLocators.Login_Button)).click();
	}
	
	public void logoutbtn() {
		lnkLogout.click();
	}
	
}

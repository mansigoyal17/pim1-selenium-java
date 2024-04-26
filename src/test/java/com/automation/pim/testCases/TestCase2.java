package com.automation.pim.testCases;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pim.pageObjects.AddToCart;
import com.automation.pim.pageObjects.LoginLogoutPage;
import com.automation.pim.pageObjects.PurchasePage;

public class TestCase2 extends BaseClass {
	
	private static Logger logger;
	static {
		System.setProperty("logFilename", "TestCase2");
		logger = Logger.getLogger(TestCase2.class);
		PropertyConfigurator.configure("log4j.properties");
	}

	@Test(priority = 2)
	public void addtoCart() throws InterruptedException {
		try {
			logger.info("<---Test Case 2--->");
	
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			LoginLogoutPage llp = new LoginLogoutPage(driver);
			
			wait.until(ExpectedConditions.elementToBeClickable(llp.lnkLogin));
			logger.info("<---Login--->");
			llp.loginLink();
			wait.until(ExpectedConditions.visibilityOf(llp.modalLogin));
			llp.loginUsername(username);
			logger.info("Username input for login done");
			llp.loginPassword(password);
			logger.info("Password input for login done");
			llp.loginbtn();
			logger.info("<---Login Successful--->");

			AddToCart atc = new AddToCart(driver);
			
			logger.info("<---Add Phones to Cart--->");
			Thread.sleep(2000);
			atc.lnkPh();
			atc.selectPh();
			atc.addToCart();
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			atc.homePg();
			atc.selectPh2();
			atc.addToCart();
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			atc.cart();
			atc.delete();
			Thread.sleep(3000);
			atc.placeOrder();
			logger.info("<---Enter User Information--->");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			atc.username(uname);
			logger.info("Name details entered");
			atc.ucountry();
			logger.info("Country details entered");
			atc.ucity();
			logger.info("City details entered");
			atc.ucreditcard(creditCardNumber);
			logger.info("Credit card details entered");
			atc.uccmonth();
			logger.info("Month details entered");
			atc.uyear();
			logger.info("Year details entered");
			logger.info("<---User Information Added--->");
		} catch (UnhandledAlertException e) {
			System.out.println("Alert Exception: " + e.getMessage());
		} catch (ElementNotInteractableException e) {
			System.out.println("Element not interactable: " + e.getMessage());		
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	
	@Test(priority=3)
	public void purchase() throws InterruptedException {
		try {
			logger.info("<---Test Case 3--->");
			
			PurchasePage pp = new PurchasePage(driver);
			AddToCart atc = new AddToCart(driver);

			pp.purchase();
			logger.info("<---Order Placed--->");
			String popupText = pp.purchaseDetails();
			String priceDetails = atc.total();

			Assert.assertTrue(popupText.contains(priceDetails), "Price details do not match");
			Assert.assertTrue(popupText.contains(creditCardNumber), "Credit Card details do not match");
			Assert.assertTrue(popupText.contains(uname), "Username do not match");

		}  catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}

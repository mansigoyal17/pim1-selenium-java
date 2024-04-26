package com.automation.pim.testCases;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pim.pageObjects.LoginLogoutPage;
import com.automation.pim.pageObjects.SignUpPage;



public class TestCase1 extends BaseClass {
	
	private static Logger logger;
	static {
		System.setProperty("logFilename", "TestCase1");
		logger = Logger.getLogger(TestCase1.class);
		PropertyConfigurator.configure("log4j.properties");

	}

	@Test(priority = 1)
	public void signUpTest() throws IOException, InterruptedException {
		try {


			logger.info("<---Test Case 1--->");

			SignUpPage sp = new SignUpPage(driver);

			logger.info("<---SignUp--->");
			sp.signUpbtn();
			sp.setUsername(signUpUsername);
			logger.info("Username input for Signup done");
			sp.setPassword(signUpPassword);
			logger.info("Password input for Signup done");
			sp.submit();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			String text = alert.getText();
			if (text.equalsIgnoreCase("This user already exist.")) {
				System.out.println("User already exist");
				logger.info("User Already Exists");
				alert.accept();
				sp.close();
			} else if (text.equalsIgnoreCase("Sign up successful.")) {
				System.out.println("Sign up successful.");
				logger.info("Sign up successful");
				alert.accept();
			}

			LoginLogoutPage llp = new LoginLogoutPage(driver);
			wait.until(ExpectedConditions.elementToBeClickable(llp.lnkLogin));
			logger.info("<---Login--->");
			llp.loginLink();
			llp.loginUsername(username);
			logger.info("Username input for login done");
			llp.loginPassword(password);
			logger.info("Password input for login done");
			llp.loginbtn();

			boolean isUsernamePresent = isElementPresent(By.partialLinkText("Welcome"));
			Assert.assertTrue(isUsernamePresent, "Login was successful");
			logger.info("<---Login Successful--->");

			logger.info("<---Logout--->");
			wait.until(ExpectedConditions.elementToBeClickable(llp.lnkLogout));
			llp.logoutbtn();
			wait.until(ExpectedConditions.visibilityOf(llp.lnkLogin));
			if (llp.lnkLogin.isDisplayed()) {
				System.out.println("Logout successful");
				logger.info("<---Logout Successful--->");
			} else {
				System.out.println("Logout failure");
				logger.info("<---Logout Failure--->");
			}

			logger.info("<---Login Invalid User--->");
			llp.loginLink();
			llp.loginUsername(username1);
			logger.info("Invalid username input for login done");
			llp.loginPassword(password1);
			logger.info("Invalid password input for login done");
			llp.loginbtn();
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
			String text1 = alert.getText();
			if (text1.equalsIgnoreCase("User does not exist.")) {
				System.out.println("Invalid user");
				logger.info("Invalid user");
				alert.accept();
			}

		} catch (UnhandledAlertException e) {
			System.out.println("Alert Exception: " + e.getMessage());
		} 
			  catch (Exception e) { System.out.println("Exception: " + e.getMessage());
			 
		}
	}

	public boolean isElementPresent(By locator) {
		try {
			WebElement element = driver.findElement(locator);
			System.out.println("Log in Successful");
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}

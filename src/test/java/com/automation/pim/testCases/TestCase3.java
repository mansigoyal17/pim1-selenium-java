package com.automation.pim.testCases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pim.pageObjects.CategoryPage;
import com.automation.pim.pageObjects.LoginLogoutPage;

public class TestCase3 extends BaseClass {
	
	private static Logger logger;
	static {
		System.setProperty("logFilename", "TestCase3");
		logger = Logger.getLogger(TestCase3.class);
		PropertyConfigurator.configure("log4j.properties");
	}
	
	@Test(priority = 4)
	public void category() {
		try {

			logger.info("<---Test Case 4--->");

			LoginLogoutPage llp = new LoginLogoutPage(driver);

			List<String> phoneList = new ArrayList<>();
			List<String> laptopList = new ArrayList<>();
			List<String> monitorList = new ArrayList<>();
			List<String> combinedList = new ArrayList<>();
			List<String> categoryListItems = new ArrayList<>();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

			CategoryPage cp = new CategoryPage(driver);
			cp.waitForLoginModalToDisappear();

			System.out.println("PHONES ---- >>>>>>>");
			wait.until(ExpectedConditions.elementToBeClickable(cp.phlink)).click();
			Thread.sleep(2000);
			List<WebElement> phItems = cp.phList();
			for (WebElement item : phItems) {
				String phName = item.getText();
				phoneList.add(phName);
			}
			System.out.println("PHONES LIST ---- >>>>>>>" + phoneList);
			logger.info("Phones added to list");

			System.out.println("LAPTOPS ---- >>>>>>>");
			wait.until(ExpectedConditions.elementToBeClickable(cp.laptopLink)).click();
			Thread.sleep(2000);
			List<WebElement> laptopItems = cp.laptopList();
			for (WebElement item : laptopItems) {
				String laptopName = item.getText();
				laptopList.add(laptopName);
			}
			System.out.println("LAPTOPS LIST ---- >>>>>>>" + laptopList);
			logger.info("Laptops added to list");

			System.out.println("MONITORS ---- >>>>>>>");
			wait.until(ExpectedConditions.elementToBeClickable(cp.monitorLink)).click();
			Thread.sleep(2000);
			List<WebElement> monitorItems = cp.monitorList();
			for (WebElement item : monitorItems) {
				String monitorName = item.getText();
				monitorList.add(monitorName);
			}
			System.out.println("MONITORS LIST ---- >>>>>>>" + monitorList);
			logger.info("Monitors added to list");

			combinedList.addAll(phoneList);
			combinedList.addAll(laptopList);
			combinedList.addAll(monitorList);

			List<String> combinedListSorted = combinedList.stream().sorted().collect(Collectors.toList());

			System.out.println("Combined List items are       :" + combinedListSorted);
			logger.info("Sorted Combined list of all elements created");

			wait.until(ExpectedConditions.elementToBeClickable(cp.mainCategoryList)).click();
			Thread.sleep(3000);
			List<WebElement> mainCategories = cp.mainCategory();
			for (WebElement mainList : mainCategories) {
				String mainListItems = mainList.getText();
				categoryListItems.add(mainListItems);

			}

			wait.until(ExpectedConditions.elementToBeClickable(cp.nxtBtn)).click();
			Thread.sleep(3000);
			List<WebElement> mainCategories2 = cp.mainCategory2();
			for (WebElement mainList2 : mainCategories2) {
				String mainListItems2 = mainList2.getText();
				categoryListItems.add(mainListItems2);
			}

			List<String> categoryListItemsSorted = categoryListItems.stream().sorted().collect(Collectors.toList());
			System.out.println("Main categories List items are:" + categoryListItemsSorted);
			logger.info("Sorted Main categories list of all elements created");

			Assert.assertEquals(categoryListItems.size(), combinedList.size(), "Lists have different sizes");

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
}
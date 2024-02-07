package com.agrichain.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.agrichain.qa.base.Base;
import com.agrichain.qa.pageObject.HomePage;

public class HomePageTest extends Base {
	public WebDriver driver;
	HomePage homePage;

	@BeforeMethod
	public void setup() {
		loadPropertiesFile();
		driver = initializeBrowserAndOpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void checkforCharString() {
		homePage.inputBoxText(dataProp.getProperty("checkforCharString"));
		homePage.clickOnSubmitButton();
	}

	@Test
	public void checkfornumericString() {
		homePage.inputBoxText(dataProp.getProperty("checkfornumericString"));
		homePage.clickOnSubmitButton();
	}

	@Test
	public void checkforalphanumericString() {
		homePage.inputBoxText(dataProp.getProperty("checkforalphanumericString"));
		homePage.clickOnSubmitButton();

	}
}

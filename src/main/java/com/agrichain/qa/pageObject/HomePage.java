package com.agrichain.qa.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "inputbox")
	private WebElement inputbox;
	
	@FindBy(linkText = "submitButton")
	private WebElement submitButton;

	
	
	public void inputBoxText(String checkString) {
		inputbox.sendKeys(checkString);
	}
	
	public void clickOnSubmitButton() {
		submitButton.click();
	}

	
}

package com.agrichain.qa.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	WebDriver driver;
	public static final int IMPLICITE_WAIT_TIME = 10;
	public static final int PAGE_WAIT_TIME = 5;
	
	public Utilities(WebDriver driver) {
		this.driver=driver;
	}

	
	public static WebDriverWait explicitlyWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait;
		
	}
	
	public static String captureScreenshot(WebDriver driver , String testName) {
		File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
		try {
			FileHandler.copy(screenShot, new File(screenShotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return screenShotPath;
	}
}

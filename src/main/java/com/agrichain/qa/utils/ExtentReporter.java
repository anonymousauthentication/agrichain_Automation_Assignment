package com.agrichain.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	public static ExtentReports generateExtentReport() {

		ExtentReports extentReports = new ExtentReports();
		File extentFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("TutorialNinja Text Automation Report");
		sparkReporter.config().setReportName("TN Automation Report name");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm::ss");
		extentReports.attachReporter(sparkReporter);
		Properties extentConfig = new Properties();
		File extentConfigFile = new File(System.getProperty("user.dir")
				+ "\\src\\main\\java\\com\\tutorialninja\\qa\\config\\config.properties");
		try {
			FileInputStream fis = new FileInputStream(extentConfigFile);
			extentConfig.load(fis);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		extentReports.setSystemInfo("Application URL", extentConfig.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", extentConfig.getProperty("browser"));
		extentReports.setSystemInfo("Valid Email", extentConfig.getProperty("validemail"));
		return extentReports;
	}
}


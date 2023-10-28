package com.wipro.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.*;
import java.util.*;

public class TestBaseClass {

	public static WebDriver driver = null;

	Properties properties = new Properties();
	FileReader filereader;

	@BeforeSuite
	public void setUp() throws IOException {
		if (driver == null) {
			filereader = new FileReader(
					"C:\\Users\\SunilKumar\\eclipse-workspace\\CapstonetByUsingfindBy.zip_expanded\\CapstonetByUsingfindBy\\src\\test\\resources\\configfiles\\config.properties");
			properties.load(filereader);
		}
		if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "/Users/su20463093/eclipse-workspace/BackUpProject/CapstroneProject.zip_expanded/CapstonetByUsingfindBy/src/test/resources/driverfiles/chromedriver");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(properties.getProperty("testurl"));
			driver.manage().window().maximize();
		} else if (properties.getProperty("browser").equalsIgnoreCase("edge")) {
			// System.setProperty("webdriver.edge.driver",
			// "/Users/su20463093/eclipse-workspace/BackUpProject/CapstroneProject.zip_expanded/CapstonetByUsingfindBy/src/test/resources/driverfiles/msedgedriver");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(properties.getProperty("testurl"));
			driver.manage().window().maximize();
		} else if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			// System.setProperty("webdriver.gecko.driver",
			// "/Users/su20463093/eclipse-workspace/BackUpProject/CapstroneProject.zip_expanded/CapstonetByUsingfindBy/src/test/resources/driverfiles/geckodriver");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(properties.getProperty("testurl"));
			driver.manage().window().maximize();
		} else {
			// System.setProperty("webdriver.safari.driver", "");
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			driver.get(properties.getProperty("testurl"));
			driver.manage().window().maximize();
		}

	}

	@AfterSuite
	public void windUp() {
		driver.close();
		driver.quit();
	}
}

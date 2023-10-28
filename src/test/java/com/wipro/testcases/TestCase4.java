package com.wipro.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import com.wipro.base.TestBaseClass;
import com.wipro.pages.*;
import com.wipro.utilities.*;

public class TestCase4 extends TestBaseClass{
	
	// to create an object of Screenshot class
	Screenshot screenShot = new Screenshot();

	@Test(priority = 0, dataProvider = "testdata1")
	public void login4(String email, String password) throws InterruptedException, IOException {
		
		// to create an object to call the function
		LoginPage loginpage = new LoginPage(driver);
		
		// to call the function by using the object
		loginpage.loginTest(email, password);
	}

	@DataProvider(name = "testdata1")
	public Object[][] testdata1() throws EncryptedDocumentException, IOException {
		
		// to store the value from the excel sheet
		Object[][] data = ReadXLData.getData("login");
		
		// to return the stored data
		return data;
	}

	@Test(priority = 1)

	public void mymenu() throws IOException {
		
		// to create an object to call the function
		MenuLinksClickPage menuliksclickpage = new MenuLinksClickPage(driver);
		
		// to call the function
		menuliksclickpage.menuLinksTest();
	}

	@Test(priority = 3)

	public void logout4() throws IOException {
		
		// to create an object to call the function
		LogoutPage logoutpage = new LogoutPage(driver);
		
		// to call the function
		logoutpage.logoutTest();
		
		// syntax for calling TakeScreenShot Method by using screenShot object reference
		screenShot.TakeScreenShot(driver, "logout2");

	}

}

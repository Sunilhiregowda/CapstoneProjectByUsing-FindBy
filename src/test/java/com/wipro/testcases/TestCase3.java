package com.wipro.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import com.wipro.base.TestBaseClass;
import com.wipro.pages.*;
import com.wipro.utilities.ReadXLData;

public class TestCase3 extends TestBaseClass {

	@Test(priority = 0, dataProvider = "testdata1")
	public void login3(String email, String password) throws InterruptedException, IOException {

		// to create an object of LoginPage class to call the function loginTest
		LoginPage loginpage = new LoginPage(driver);

		// to call the function by using the object reference
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

		// to create an object of MenuPage class to call the function menuTest
		MenuPage menupage = new MenuPage(driver);

		// to call the function
		menupage.menuTest();

	}

	@Test(priority = 2)
	public void myselect() throws IOException {

		// to create an object SelectPage class to call the function selectTest
		SelectPage selectpage = new SelectPage(driver);

		// to call the function
		selectpage.selectTest();

	}

}

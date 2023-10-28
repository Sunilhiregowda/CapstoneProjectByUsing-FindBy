package com.wipro.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import com.wipro.utilities.*;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import com.wipro.base.TestBaseClass;
import com.wipro.pages.*;

public class TestCase1 extends TestBaseClass {

	@Test(priority = 0, dataProvider = "testdata1")
	public void register(String firstname, String lastname, String email, String password,
			String confirmpassword) throws InterruptedException, IOException {

		// to create an object of RegisterPage class to call the function registerTest
		RegisterPage registerpage = new RegisterPage(driver);

		// to call the function by using the object refernce
		registerpage.registerTest(firstname, lastname, email, password, confirmpassword);

	}

	@DataProvider(name = "testdata1")
	public Object[][] testdata1() throws EncryptedDocumentException, IOException {

		// to store the value from the excel sheet
		Object[][] data = ReadXLData.getData("RegisterPage");

		// to return the stored data
		return data;
	}

	@Test(priority = 1, dataProvider = "testdata2")
	public void login1(String email, String password) throws InterruptedException {

		// to create an object of LoginPage class to call the function LoginTest
		LoginPage loginpage = new LoginPage(driver);

		// to call the function by using the object refernce
		loginpage.loginTest(email, password);

	}

	@DataProvider(name = "testdata2")
	public Object[][] testdata2() throws EncryptedDocumentException, IOException {

		// to store the value from the excel sheet
		Object[][] data = ReadXLData.getData("login");

		// to return the stored data
		return data;

	}

	@Test(priority = 2)
	public void logout1() throws IOException {

		// to create an object of LogoutPage class to call the function logoutTest
		LogoutPage logoutpage = new LogoutPage(driver);

		// to call the function by using the object refernce
		logoutpage.logoutTest();
	}

}

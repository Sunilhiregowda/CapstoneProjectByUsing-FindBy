package com.wipro.testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import com.wipro.base.TestBaseClass;
import com.wipro.pages.*;
import com.wipro.utilities.ReadXLData;

public class TestCase2 extends TestBaseClass {

	@Test(priority = 0, dataProvider = "testdata1")
	public void login2(String email, String password) throws InterruptedException, IOException {

		// to create an object of LoginPage class to call the function loginTest
		LoginPage loginpage = new LoginPage(driver);

		// to call the function by using the object refernce
		loginpage.loginTest(email, password);

	}

	@DataProvider(name = "testdata1")
	public String[][] testdata1() throws EncryptedDocumentException, IOException {

		// to store the value from the excel sheet
		String[][] data = ReadXLData.getData("login");

		// to return the stored data
		return data;

	}

	@Test(priority = 1)
	public void myAccFunctionality() {

		// to create an object of MyAccountPage class to call the function myacctTest
		MyAccountPage myaccountpage = new MyAccountPage(driver);

		// to call the function by using the object refernce
		myaccountpage.myacctTest();

	}

	@Test(priority = 2, dataProvider = "testdata2")
	public void addressFuctionality(String fname, String lname, String email, String country, String city,
			String address, String pin, String phone) throws IOException {

		// to create an object of AddressPage Class to call the function addressTest
		AddressPage addresspage = new AddressPage(driver);

		// to call the function by using the object
		addresspage.addressTest(fname, lname, email, country, city, address, pin, phone);
	}

	@DataProvider(name = "testdata2")
	public Object[][] testdata2() throws EncryptedDocumentException, IOException {

		// to store the value from the excel sheet
		Object[][] data = ReadXLData.getData("Address");

		// to return the stored data
		return data;

	}

}

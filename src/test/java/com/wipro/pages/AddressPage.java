package com.wipro.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wipro.base.TestBaseClass;
import com.wipro.utilities.Screenshot;

public class AddressPage extends TestBaseClass {

	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='customer-addresses inactive']//a[normalize-space()='Addresses']") // (//a[contains(text(),'Addresses')])[1]
	WebElement add_link;

	@FindBy(xpath = "//button[normalize-space()='Add new']") // button[contains(text(),'Add new')]
	WebElement add_new;

	@FindBy(xpath = "//input[@id='Address_FirstName']")
	WebElement first_name;

	@FindBy(xpath = "//input[@id='Address_LastName']")
	WebElement last_name;

	@FindBy(xpath = "//input[@id='Address_Email']")
	WebElement e_mail;

	@FindBy(xpath = "//select[@id='Address_CountryId']")
	WebElement country_name;

	@FindBy(xpath = "//input[@id='Address_City']")
	WebElement city_name;

	@FindBy(xpath = "//input[@id='Address_Address1']")
	WebElement address_no;

	@FindBy(xpath = "//input[@id='Address_ZipPostalCode']")
	WebElement pin_code;

	@FindBy(xpath = "//input[@id='Address_PhoneNumber']")
	WebElement phone_no;

	@FindBy(xpath = "//button[normalize-space()='Save']") // button[contains(text(),'Save')]
	WebElement save_button;

	@FindBy(xpath = "//span[@title='Close']")
	WebElement close;

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement log_out;

	public void addressTest(String fname, String lname, String email, String country, String city, String address,
			String pin, String phone) throws IOException {

		// to create an object of screenshot class
		Screenshot screenShot = new Screenshot();

		// to click on the add address button
		add_link.click();

		// to click on the new button to add the address
		add_new.click();

		// to get firstname from excel sheet and enter firstname
		first_name.sendKeys(fname);

		// to get lastname from excel sheet and enter lastname
		last_name.sendKeys(lname);

		// to get email details from excel and enter email
		e_mail.sendKeys(email);

		// to get country name from excel and enter country
		country_name.sendKeys(country);

		// to get city name details from excel and enter city name
		city_name.sendKeys(city);

		// to get address details from excel and enter address
		address_no.sendKeys(address);

		// to get pincode from excel and enter pincode
		pin_code.sendKeys(pin);

		// to get phone number details from excel and enter phone number
		phone_no.sendKeys(phone);

		// to click on save button
		save_button.click();

		// to close the popup
		close.click();

		// to take screenshot
		screenShot.TakeScreenShot(driver, "addressTest");

		// to click on the log_out button
		log_out.click();

	}

}

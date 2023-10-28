package com.wipro.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.*;
import com.wipro.utilities.*;
import com.wipro.base.TestBaseClass;

public class RegisterPage extends TestBaseClass {

	public RegisterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement register_link;

	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement gender;

	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement first_name;

	@FindBy(xpath = "//input[@id='LastName']")
	WebElement last_name;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement register_email;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement register_password;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement confirm_password;

	@FindBy(xpath = "//button[@id='register-button']")
	WebElement register_button;

	public void registerTest(String fname, String lname, String email, String pwd, String cpwd)
			throws IOException, InterruptedException {

		// to locate the textfile with the path
		FileWriter fileWriter = new FileWriter(
				"C:\\Users\\SunilKumar\\eclipse-workspace\\CapstonetByUsingfindBy.zip_expanded\\CapstonetByUsingfindBy\\src\\test\\resources\\output_data\\RegistrationSuccessfullMessage.txt");

		// to click on the register link
		register_link.click();

		// to click on the male gender
		gender.click();

		// to get firstname from excel sheet and enter firstname
		first_name.sendKeys(fname);

		// to get lastname from excel sheet and enter lastname
		last_name.sendKeys(lname);

		// to get email details from excel and enter email
		register_email.sendKeys(email);

		// to get password details from excel and enter password
		register_password.sendKeys(pwd);

		// to get confirm password details from excel and enter confirm password
		confirm_password.sendKeys(cpwd);

		// to click on the register button
		register_button.click();

		// to get xpath of the result and store it in webelement regSuccessMessage
		WebElement regSuccessMessage = driver.findElement(By.xpath("//div[@class='result']"));

		// to get text from web element regSuccessMessage
		String regSuccessfulMessage = regSuccessMessage.getText();

		// to write the text in the text file
		fileWriter.write(regSuccessfulMessage);

		// to close the text file
		fileWriter.close();

		// to create an object of screenshot class
		Screenshot screenShot = new Screenshot();
		screenShot.TakeScreenShot(driver, "success");

	}

}

package com.wipro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wipro.base.TestBaseClass;

public class LoginPage extends TestBaseClass {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-login']")
	WebElement log_in;

	@FindBy(xpath = "//input[@id='Email']")
	WebElement login_email;

	@FindBy(xpath = "//input[@id='Password']")
	WebElement login_password;

	@FindBy(xpath = "//input[@id='RememberMe']")
	WebElement remember_me;

	@FindBy(xpath = "//button[normalize-space()='Log in']")
	WebElement login_button;

	public void loginTest(String email, String password) throws InterruptedException {

		// click on login button
		log_in.click();

		// get email details from excel and enter email
		login_email.sendKeys(email);

		// get password details from excel and enter password
		login_password.sendKeys(password);

		// to click on the remember me button
		remember_me.click();

		// click on login button
		login_button.click();
	}

}

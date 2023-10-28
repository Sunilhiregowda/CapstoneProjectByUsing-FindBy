package com.wipro.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wipro.base.TestBaseClass;

public class MyAccountPage extends TestBaseClass {

	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-account']")
	WebElement myAcc;

	public void myacctTest() {

		// to click the my account link button
		myAcc.click();
	}

}

package com.wipro.pages;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wipro.base.TestBaseClass;
import com.wipro.utilities.Screenshot;

public class MenuPage extends TestBaseClass {

	public MenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
	WebElement computer;

	@FindBy(xpath = "//a[@title='Show products in category Desktops'][normalize-space()='Desktops']")
	WebElement desktop;

	public void menuTest() throws IOException {

		// to creat an object of Screenshot class to call the TakeScreenShot function
		Screenshot screenShot = new Screenshot();

		// to take screenshot
		screenShot.TakeScreenShot(driver, "login");

		// click on computer link button
		computer.click();

		// click on desktop link button
		desktop.click();

		// to take screenshot of the page
		screenShot.TakeScreenShot(driver, "desktop");

	}

}

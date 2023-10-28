package com.wipro.pages;

import java.io.FileWriter;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wipro.base.TestBaseClass;

public class LogoutPage extends TestBaseClass {

	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement log_out;

	public void logoutTest() throws IOException {

		// click on logout
		log_out.click();

		// to locate the textfile with the path
		FileWriter fileWriter = new FileWriter(
				"C:\\Users\\SunilKumar\\eclipse-workspace\\CapstonetByUsingfindBy.zip_expanded\\CapstonetByUsingfindBy\\src\\test\\resources\\output_data\\LogoutSuccessfullMessage.txt");
		fileWriter.write("logout successful");

		// close the textfile
		fileWriter.close();
	}
}

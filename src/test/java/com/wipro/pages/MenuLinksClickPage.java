package com.wipro.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wipro.base.TestBaseClass;
import com.wipro.utilities.Screenshot;

public class MenuLinksClickPage extends TestBaseClass {

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
	WebElement computers;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
	WebElement electronics;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
	WebElement apparel;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
	WebElement digital;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
	WebElement book;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
	WebElement jewelry;

	@FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
	WebElement gift;

	public MenuLinksClickPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void menuLinksTest() throws IOException {

		/// to create an object of screenshot class
		Screenshot screenShot = new Screenshot();

		// to click on the computers link button
		computers.click();
		// to take the screenshot of computer
		screenShot.TakeScreenShot(driver, "computer");

		// to click on the electronics link button
		electronics.click();
		// to take the screenshot of electronics
		screenShot.TakeScreenShot(driver, "electronics");

		// to crlick on the Apparel link button
		apparel.click();
		// to take the screenshot of apparel
		screenShot.TakeScreenShot(driver, "apparel");

		// to click on the digital link button
		digital.click();
		// to take the screenshot of digital
		screenShot.TakeScreenShot(driver, "digital download");

		// to click on the book link button
		book.click();
		// to take the screenshot of book
		screenShot.TakeScreenShot(driver, "book");

		// to click on the Jewelry link button
		jewelry.click();
		// to take the screenshot of jewelry
		screenShot.TakeScreenShot(driver, "jewelry");

		// to click on the gift link button
		gift.click();
		// to take the screenshot of gift
		screenShot.TakeScreenShot(driver, "gift card");

		// to locate the textfile with the path
		FileWriter fileWriter = new FileWriter(
				"C:\\Users\\SunilKumar\\eclipse-workspace\\CapstonetByUsingfindBy.zip_expanded\\CapstonetByUsingfindBy\\src\\test\\resources\\output_data\\NoOfLinksInHomePage.txt");
		// to get xpath of the result and store it in webelement list
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='top-menu notmobile']/*)"));
		System.out.println(list.size());
		int nums = list.size();
		fileWriter.write("Total menus are :" + " " + nums);
		fileWriter.write("\n");
		for (int i = 0; i < nums; i++) {
			String values = list.get(i).getText();
			fileWriter.write(i + 1 + "." + " " + "menu is" + " " + values);
			fileWriter.write("\n");
		}

		// to close the text file
		fileWriter.close();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

}

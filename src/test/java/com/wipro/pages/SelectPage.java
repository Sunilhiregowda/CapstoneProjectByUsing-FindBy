package com.wipro.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wipro.base.TestBaseClass;
import com.wipro.utilities.Screenshot;

public class SelectPage extends TestBaseClass {

	public SelectPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='product-title']//a[contains(text(),'Digital Storm VANQUISH 3 Custom Performance PC')]")
	WebElement sct;

	@FindBy(xpath = "//button[@id='add-to-cart-button-2']")
	WebElement addcart;

	@FindBy(xpath = "(//a[normalize-space()='shopping cart'])[1]")
	WebElement shop;

	@FindBy(xpath = "//input[@id='termsofservice']")
	WebElement agree;

	@FindBy(xpath = "//button[@id='checkout']")
	WebElement button;

	@FindBy(xpath = "//button[@onclick='Billing.save()']")
	WebElement contu1;

	@FindBy(xpath = "(//button[@class='button-1 shipping-method-next-step-button'])[1]")
	WebElement contu2;

	@FindBy(xpath = "(//button[@class='button-1 payment-method-next-step-button'])[1]")
	WebElement contu3;

	@FindBy(xpath = "//button[@class='button-1 payment-info-next-step-button']")
	WebElement contu4;

	@FindBy(xpath = "//button[normalize-space()='Confirm']")
	WebElement confirm;

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	WebElement log_out;

	public void selectTest() throws IOException {

		// to create the object of screenshot class
		Screenshot screenShot = new Screenshot();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// to click on select button
		sct.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// to click on add to cart button
		addcart.click();

		// to locate the textfile with the path
		FileWriter filewriter = new FileWriter(
				"C:\\Users\\SunilKumar\\eclipse-workspace\\CapstonetByUsingfindBy.zip_expanded\\CapstonetByUsingfindBy\\src\\test\\resources\\output_data\\PrizeOfTheDigitalStormVanquish3CustomePerformancePC.txt");

		// to get xpath of the result and store it in Webelement webelement1
		WebElement webelement1 = driver.findElement(By.xpath("//span[@id='price-value-2']"));

		// to get text from web element webelement1
		String a = webelement1.getText();

		// to get xpath of the result and store it in webelement webelement2
		WebElement webelement2 = driver
				.findElement(By.xpath("//h1[normalize-space()='Digital Storm VANQUISH 3 Custom Performance PC']"));

		// to get text from web element webelement2
		String b = webelement2.getText();

		// to write the text in the text file
		filewriter.write("The prize is :");
		filewriter.write(a);
		filewriter.write("\n");
		filewriter.write(b);

		// to close the text file
		filewriter.close();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// to click on add to cart link button in the pop up message
		shop.click();

		// to enable the agree check-box
		agree.click();

		// to click on checkout button
		button.click();

		// to click the continue button at Billing Address
		contu1.click();

		// to click the continue button at Shipping method
		contu2.click();

		// to click the continue button at Payment method
		contu3.click();

		// to click the continue button at Payment information
		contu4.click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// to click on confirm button
		confirm.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// to take screenshot of the page
		screenShot.TakeScreenShot(driver, "confirm");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// to log_out from the page
		log_out.click();

	}

}

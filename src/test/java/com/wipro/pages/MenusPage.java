package com.wipro.pages;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wipro.base.TestBaseClass;
import com.wipro.utilities.Screenshot;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MenusPage extends TestBaseClass {

	WebDriver driver;
	By comp = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']");
	By elect = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']");
	By apparel = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']");
	By digi = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']");
	By book = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Books']");
	By jewelry = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']");
	By gift = By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']");
	By link = By.xpath("//ul[@class='top-menu notmobile']/*");

	By log_in = By.xpath("//a[@class='ico-login']");
	By login_email = By.id("Email");
	By login_password = By.id("Password");
	By login_button = By.xpath("//button[normalize-space()='Log in']");
	By log_out = By.xpath("//a[@class='ico-logout']");

	// to create an object of screenshot class
	Screenshot screenShot = new Screenshot();

	@Given("^Open browser and navigate to url$")
	public void open_browser_and_navigate_to_url() {
		driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");

	}

	@When("^I enter the email as (.+) and password as (.+) and login$")
	public void i_enter_the_email_as_and_password_as_abc123_and_login(String email, String password)
			throws InterruptedException {
		driver.findElement(log_in).click();
//		Thread.sleep(2000);
//		login_email.sendKeys(email);
		driver.findElement(login_email).sendKeys(email);
//		login_password.sendKeys(password);
		driver.findElement(login_password).sendKeys(password);
//		login_button.click();
		driver.findElement(login_button).click();
	}

	@And("count number of links and navigate to each page")
	public void count_number_of_links_and_navigate_to_each_page() throws IOException {
		// to create an object of screenshot class
		Screenshot screenShot = new Screenshot();
//		comp.click();
		driver.findElement(comp).click();
		screenShot.TakeScreenShot(driver, "computer");
//		elect.click();
		driver.findElement(elect).click();
		screenShot.TakeScreenShot(driver, "electronics");
//		apparel.click();
		driver.findElement(apparel).click();
		screenShot.TakeScreenShot(driver, "apparel");
//		digi.click();
		driver.findElement(digi).click();
		screenShot.TakeScreenShot(driver, "digital download");
//		book.click();
		driver.findElement(book).click();
		screenShot.TakeScreenShot(driver, "book");
//		jewelry.click();
		driver.findElement(jewelry).click();
		screenShot.TakeScreenShot(driver, "jewelry");
//		gift.click();
		driver.findElement(gift).click();
		screenShot.TakeScreenShot(driver, "gift card");

		FileWriter fileWriter = new FileWriter(
				"C:\\Users\\SunilKumar\\eclipse-workspace\\CapstonetByUsingfindBy.zip_expanded\\CapstonetByUsingfindBy\\src\\test\\resources\\output_data\\NoOfLinksInHomePage.txt");

//		List<WebElement> list = driver.findElements((By) link);
		List<WebElement> list = driver.findElements(By.xpath("(//ul[@class='top-menu notmobile']/*)"));
		System.out.println(list.size());
		int nums = list.size();
		fileWriter.write("Total menus are :" + " " + nums);
		fileWriter.write("\n");
		for (int i = 0; i < nums; i++)

		{
			String values = list.get(i).getText();
			fileWriter.write(i + 1 + "." + " " + "menu is" + " " + values);
			fileWriter.write("\n");
		}

		fileWriter.close();
	}

	@Then("logout")
	public void logout() throws IOException {
//		log_out.click();
		driver.findElement(log_out).click();
	}

	@Then("close browser")
	public void close_browser() {
		// closeing the browser
		driver.close();
	}

}

package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import base.BasePage;
import pages.LoginPage;

public class LoginTest extends BasePage {
	LoginPage loginPage;
	WebDriver driver;

	@BeforeMethod
	public void setup(ITestContext context) throws InterruptedException {
		driver = setupDriver(driver, context);
	}

	@Test(priority = 0, description = "This test valids whether user is able to login with valid credentials")
	public void verifyLoginWithValidCredentials() throws InterruptedException {
		loginPage = new LoginPage(driver);

		loginPage.login("validUsername", "validPassword");
		String actualTitle = loginPage.getLoginPageTitle();
		String expectedTitle = "Products";

		Assert.assertTrue(actualTitle.equals(expectedTitle));
	}
	
	@Test(priority = 1, description = "This test valids whether user is able to login with invalid credentials")
	public void verifyLoginWithInvalidCredentials() throws InterruptedException {
		loginPage = new LoginPage(driver);

		loginPage.login("invalidUsername", "invalidPassword");
		String actualTitle = loginPage.getErrorMessageInvalidCreds();
		String expectedTitle = "Epic sadface: Username and password do not match any user in this service";

		Assert.assertTrue(actualTitle.equals(expectedTitle));
	}
	
	@Test(priority = 3, description = "This test valids whether user is able to login with invalid username")
	public void verifyLoginWithInvalidUsername() throws InterruptedException {
		loginPage = new LoginPage(driver);

		loginPage.login("invalidUsername", "validPassword");
		String actualTitle = loginPage.getErrorMessageInvalidCreds();
		String expectedTitle = "Epic sadface: Username and password do not match any user in this service";

		Assert.assertTrue(actualTitle.equals(expectedTitle));
	}
	
	@Test(priority = 2, description = "This test valids whether user is able to login with invalid password")
	public void verifyLoginWithInvalidPassword() throws InterruptedException {
		loginPage = new LoginPage(driver);

		loginPage.login("validUsername", "invalidPassword");
		String actualTitle = loginPage.getErrorMessageInvalidCreds();
		String expectedTitle = "Epic sadface: Username and password do not match any user in this service";

		Assert.assertTrue(actualTitle.equals(expectedTitle));
	}

	@AfterMethod
	public void closeDown() throws IOException {
		BasePage.tearDown();

	}
}

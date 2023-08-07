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
import pages.LogoutPage;

public class LogoutTest extends BasePage {
	LoginPage login;
	LogoutPage logout;
	WebDriver driver;

	@BeforeMethod
	public void setup(ITestContext context) throws InterruptedException {
		driver = setupDriver(driver, context);
	}

	@Test(priority = 5, description = "This test valids logout functionality")
	public void verifyAddToCartFunctionality() throws InterruptedException {
		login = new LoginPage(driver);
		logout = new LogoutPage(driver);

		login.login("validUsername", "validPassword");		
		logout.logoutFunctionality();
		
		Boolean isLogoutSuccessful = login.isUserOnLoginPage();
				
		Assert.assertTrue(isLogoutSuccessful);
	}

	@AfterMethod
	public void closeDown() throws IOException {
		BasePage.tearDown();

	}
}



//package tests;
//
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
//
//public class AddToCartTest {
//  
//	@BeforeMethod
//	public void setup(ITestContext context) throws InterruptedException {
//		driver = setupDriver(driver, context);
//	}
//
//  @Test
//  public void f() {
//  }
//  
//  @AfterMethod
//  public void afterMethod() {
//  }
//
//}
package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import base.BasePage;
import pages.AddToCartPage;
import pages.LoginPage;

public class AddToCartTest extends BasePage {
	LoginPage login;
	AddToCartPage addToCart;
	WebDriver driver;

	@BeforeMethod
	public void setup(ITestContext context) throws InterruptedException {
		driver = setupDriver(driver, context);
	}

	@Test
	public void verifyAddToCartFunctionality() throws InterruptedException {
		login = new LoginPage(driver);
		addToCart = new AddToCartPage(driver);

		login.login("validUsername", "validPassword");		
		addToCart.clickAddToCart();
		
		String expectedCartCountAfterAddToCart = "1";
		String actualCartCountAfterAddToCart = addToCart.getCartQuantity();
				
		Assert.assertTrue(actualCartCountAfterAddToCart.equals(expectedCartCountAfterAddToCart));
	}

	@AfterMethod
	public void closeDown() throws IOException {
		BasePage.tearDown();

	}
}



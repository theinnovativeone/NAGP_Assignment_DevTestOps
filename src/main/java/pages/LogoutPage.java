package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.PropertyFileReader;

public class LogoutPage extends BasePage {
	protected final WebDriver driver;
	
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	WebElement mainMenu;
	
	@FindBy(linkText = "Logout")
	WebElement logoutOption;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public void logoutFunctionality() throws InterruptedException {
		
		Thread.sleep(1000);
		mainMenu.click();
		System.out.println("clicked on menu menu");
		
		Thread.sleep(1000);
		logoutOption.click();
		System.out.println("clicked on logout");

	}
}
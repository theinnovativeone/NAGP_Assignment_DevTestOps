package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BasePage;

public class AddToCartPage extends BasePage {
	protected final WebDriver driver;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement addToCartButton;
	
	@FindBy(xpath = "//span[contains(text(),'1')]")
	WebElement cartQuantity;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public String getCartQuantity() {
		return cartQuantity.getText();
	}
	
	public void clickAddToCart() {
		addToCartButton.click();
	}
	
	public void addToCart() throws InterruptedException {
		
		Thread.sleep(1000);
		addToCartButton.click();
		
	}
	
	
}
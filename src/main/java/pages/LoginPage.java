package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BasePage;
import utils.PropertyFileReader;

public class LoginPage extends BasePage {
	protected final WebDriver driver;
	
	@FindBy(xpath = "//input[@id='user-name']")
	WebElement usernameField;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//input[@id='login-button']")
	WebElement loginButton;
	
	@FindBy(xpath = "//span[contains(text(),'Products')]")
	WebElement plp;
		
	@FindBy(xpath = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/h3[1]")
	WebElement errorMessageInvalidLogin;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	public String getUsername() {
		return usernameField.getText();
	}
	
	public String getPassword() {
		return passwordField.getText();
	}
	
	public String getLoginPageTitle() {
		return plp.getText();
	}
	
	public String getErrorMessageInvalidCreds() {
		return errorMessageInvalidLogin.getText();
	}
	
	public void login(String username, String pswd) throws InterruptedException {
		
		usernameField.sendKeys(PropertyFileReader.getData(username));
		passwordField.sendKeys(PropertyFileReader.getData(pswd));
		
		Thread.sleep(600);
		loginButton.click();		
	}
	
	public Boolean isUserOnLoginPage() throws InterruptedException {
		
		Thread.sleep(1000);
		if(loginButton.isDisplayed())
			return true;
		else 
			return false;
	}
}
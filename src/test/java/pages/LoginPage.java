package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class LoginPage extends BasePage {

	public LoginPage() {

	}

	@FindBy(id = "username")
	private WebElement txt_username;

	@FindBy(id = "password")
	private WebElement txt_password;

	@FindBy(xpath = "//button[@class='btn login-btn']")
	private WebElement btn_Login;

	//@Test(priority = 2)
	public void login() {
		txt_username.sendKeys("demo");
		txt_password.sendKeys("demo");
		btn_Login.click();

	}

}

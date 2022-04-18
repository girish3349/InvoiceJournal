package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	// Page elements
	// private final String Username_id = "username";
	// private final String Password_id = "password";
	// private final String Login_xpath = "//input[@value='Login']";

	@FindBy(id = "username")
	private WebElement Username_id;

	@FindBy(id = "password")
	private WebElement Password_id;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement Login_xpath;


	// Page methods
	public void Fillusername(String username) {
		fillTextBox(Username_id, username);
	}

	public void FillPassword(String password) {
		fillTextBox(Password_id, password);
	}

	public void ClickLogin_btn() {
		clickElement(Login_xpath);
	}

}

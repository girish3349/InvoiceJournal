package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import utilities.CommonMethods;

public class BasePage extends CommonMethods {

	@FindBy(className = "profile-pic")
	private WebElement btn_Account;

	@FindBy(linkText = "Logout")
	private WebElement btn_Logout;

	@Test(priority = 2)
	public void logoutApplication() {
		btn_Account.click();
		btn_Logout.click();
	}

}

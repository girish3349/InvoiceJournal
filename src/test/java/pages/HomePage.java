package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	// Page Elements
	@FindBy(xpath = "//*[@id=\"header\"]/*/div[1]/a/font")
	private WebElement btn_LogoutMent1;
	
	@FindBy(linkText ="Logout")
	private WebElement btn_LogoutMenu2;
	
	@FindBy(linkText ="Home")
	private WebElement menu_Home;
	
	
	@FindBy(linkText ="Estimates")
	private WebElement menu_Estimates;
	
	@FindBy(linkText ="Invoices")
	private WebElement menu_Invoices;
	
	
	@FindBy(id ="createinvlink")
	private WebElement menu_CreateInv;
	
	
	
	
	
	

	public void logout() {
		btn_LogoutMent1.click();
		btn_LogoutMenu2.click();

	}
	
	
	public void NavToCreateEstimate() {
		
		
		
	}
	
	public void NavToCreateInv() {
		NavigateToMenu(menu_Invoices,menu_CreateInv);
	}
		
		
}

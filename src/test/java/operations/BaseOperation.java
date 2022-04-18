package operations;

import pages.HomePage;
import pages.LoginPage;
import utilities.CommonMethods;

public class BaseOperation extends CommonMethods{
	
	LoginPage loginPage;
	HomePage homePage;
	
	public void Login(String username, String password) {
		homePage = new HomePage();
		loginPage = new LoginPage();
		
		loginPage.Fillusername(username);
		loginPage.FillPassword(password);
		loginPage.ClickLogin_btn();
		
		homePage.NavToCreateInv();
	}
	
	public void Logout() {
		homePage.logout();
	}

}

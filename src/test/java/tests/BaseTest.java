package tests;

import org.testng.annotations.Test;

import models.User;
import operations.BaseOperation;
import utilities.CommonMethods;
import utilities.ExcelUtility;
import utilities.XMLHelper;

public class BaseTest extends CommonMethods{
	
	BaseOperation bo = new BaseOperation();
	
	XMLHelper xu = new XMLHelper("Estimates.xml"); 
	
	//@Test (dataProvider = "Login_Data", dataProviderClass= ExcelUtility.class)
	public void login(String user, String pass) {
		readProperties();
		initDriver();
		//if (username != null && password != null)
		bo.Login(user, pass);
		bo.Logout();
		bo.quitBrowser();
		
		
	}
	
	@Test
	public void printxml() {
		
		//User userdata= 
		
		xu.getuserData();
		//xu.getProductData();
		
		
	}

}

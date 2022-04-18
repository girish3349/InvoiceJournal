package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWrapper {

	// Global variables

	public static WebDriver driver;
	public static Actions actions;
	public static WebDriverWait wait;
	public static TakesScreenshot takeScreenshot;
	public static JavascriptExecutor jsExecutor;
	public static Select select;

	String msg = "";

	public SeleniumWrapper() {
		PageFactory.initElements(driver, this);
	}

	// TestBox operations
	public void fillTextBox(WebElement element, String data) {
		element.clear();
		element.sendKeys(data);
	}

	public String getTextFromTextBox(WebElement element) {
		msg = element.getAttribute("value");
		return msg;
	}

	public void clearTextBox(WebElement element) {
		element.clear();
	}
	
	//End TextBox

	// Button, links,radio btn and checkboxes operations
	public void clickElement(WebElement element) {
		element.click();
	}

	public void select_Checkbox(WebElement element) {
		if (!(element.isSelected())) {
			clickElement(element);
		}
	}

	public void deSelect_CheckBox(WebElement element) {
		if (element.isSelected()) {
			clickElement(element);
		}
	}

	public String getLabelText(WebElement element) {
		msg = element.getText();
		return msg;
	}

	// dropdowns operations
	public void selectByIndex(WebElement element, int index) {
		select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectbyValue(WebElement element, String value) {
		select = new Select(element);
		select.selectByValue(value);
	}

	public void selectbyVisableText(WebElement element, String visableText) {
		select = new Select(element);
		select.selectByVisibleText(visableText);
	}

	public void deselectbyValue(WebElement element, String value) {
		select = new Select(element);
		select.deselectByValue(value);
	}

	public void deselectbyVisableText(WebElement element, String visableText) {
		select = new Select(element);
		select.deselectByVisibleText(visableText);
	}

	public void deselectbyIndex(WebElement element, int index) {
		select = new Select(element);
		select.deselectByIndex(index);
	}

	public List<WebElement> getAlloptionsfromDropdown(WebElement element) {
		select = new Select(element);
		return (select.getOptions());
	}

	public String getSelectedOptionText(WebElement element) {
		select = new Select(element);
		return (select.getFirstSelectedOption().getText());
	}

	public List<WebElement> getAllSelectedOption(WebElement element) {
		select = new Select(element);
		return (select.getAllSelectedOptions());
	}

	public void deSelecteAllDropdown(WebElement element) {
		select = new Select(element);
		select.deselectAll();
	}

	// Browser Navigation
	public void navagateTo(String Url) {
		driver.navigate().to(Url);

	}

	public void navagateBack() {
		driver.navigate().back();

	}
	
	public void navagateForward() {
		driver.navigate().forward();

	}
	public void refreshPage() {
		driver.navigate().refresh();
	}
	
	//Alerts & Confirm and Prompt 
	public String getAlertText() {
		return (driver.switchTo().alert().getText());
	}
	
	public void acceptAlertBox() {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlertBox() {
		driver.switchTo().alert().dismiss();
	}
	
	public void enterTextInAlert(String promptText) {
		driver.switchTo().alert().sendKeys(promptText);
	}
	
	public String getTextandAcceptAlert() {
		msg = getAlertText();
		acceptAlertBox();
		return msg;
	}
}
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods extends SeleniumWrapper {

	public static String browser, url;
	public String defaultUser, defaultPass;

	public void initDriver() {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers//chromedriver.exe");
		driver = new ChromeDriver();

		actions = new Actions(driver);
		takeScreenshot = (TakesScreenshot) driver;
		jsExecutor = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofMinutes(2));

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.get(url);
	}

	public void quitBrowser() {
		if (driver != null)
			driver.quit();
	}

	public void readProperties() {

		InputStream input;
		try {

			input = new FileInputStream(System.getProperty("user.dir") + "//config.properties");
			Properties prop = new Properties();

			// load a properties file
			prop.load(input);

			// get the property value
			browser = prop.getProperty("browser");
			url = prop.getProperty("URL");
			defaultUser = prop.getProperty("defaultUser");
			defaultPass = prop.getProperty("defaultPass");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShot() {

		File file = takeScreenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/Image1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void NavigateToMenu(WebElement mainMenu, WebElement subMenu) {
		
		mainMenu.click();
		subMenu.click();

	}

	public void NavigateToMenu(WebElement mainMenu) {
		

	}
}

package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CommonMethods {

	String str;
	public static WebDriver driver;
	public static Actions actions;
	public static WebDriverWait wait;

	FileReader reader;
	Properties prop;

	public CommonMethods() {

		//PageFactory.initElements(driver, this);

		try {

			reader = new FileReader("config.properties");
			prop = new Properties();
			prop.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@BeforeTest
	public void startUp() {

		String browser = prop.getProperty("browser");
		browser.toLowerCase();
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			driver = new ChromeDriver();
			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			driver = new FirefoxDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		System.out.println(prop.getProperty("URL").toString());
		String url = prop.getProperty("URL").toString();
		driver.get(url);
		PageFactory.initElements(driver, this);

	}

	@Test(priority = 9)
	public void firstTest() throws InterruptedException {
		Thread.sleep(3000);
	}

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	public void takescreenshot() {

	}

}

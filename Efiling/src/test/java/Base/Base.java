package Base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	WebDriverWait wait;
	@BeforeSuite
	public static void configProperty() {

		try {
//saurav
			if (ConfigProp.browser == "chrome") {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
			} else if (ConfigProp.browser == "firefox") {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			} else if (ConfigProp.browser == "ie") {
				WebDriverManager.edgedriver().setup();
				driver = new InternetExplorerDriver();
			}
			driver.manage().window().maximize();
			driver.navigate().to(ConfigProp.site);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}



	/*
	 * public void click(String locator) {
	 * 
	 * if (locator.endsWith("_CSS")) {
	 * driver.findElement(By.cssSelector(prop.getProperty(locator))).click(); } else
	 * if (locator.endsWith("_XPATH")) {
	 * driver.findElement(By.xpath(prop.getProperty(locator))).click(); } else if
	 * (locator.endsWith("_ID")) {
	 * driver.findElement(By.id(prop.getProperty(locator))).click(); }
	 * 
	 * }
	 * 
	 * public void type(String locator, String value) {
	 * 
	 * if (locator.endsWith("_CSS")) {
	 * driver.findElement(By.cssSelector(prop.getProperty(locator))).sendKeys(value)
	 * ; } else if (locator.endsWith("_XPATH")) {
	 * driver.findElement(By.xpath(prop.getProperty(locator))).sendKeys(value); }
	 * else if (locator.endsWith("_ID")) {
	 * driver.findElement(By.id(prop.getProperty(locator))).sendKeys(value); }
	 * 
	 * }
	 * 
	 * static WebElement dropdown;
	 * 
	 * public void select(String locator, String value) {
	 * 
	 * if (locator.endsWith("_CSS")) { dropdown =
	 * driver.findElement(By.cssSelector(prop.getProperty(locator))); } else if
	 * (locator.endsWith("_XPATH")) { dropdown =
	 * driver.findElement(By.xpath(prop.getProperty(locator))); } else if
	 * (locator.endsWith("_ID")) { dropdown =
	 * driver.findElement(By.id(prop.getProperty(locator))); }
	 * 
	 * Select select = new Select(dropdown); select.selectByVisibleText(value);
	 * 
	 * }
	 */
//	public static String testpath = null;

	public static String captureScreenShot(String screenshot) {
		String path = null;
		try {

			File theDir = new File("screenshots"); // Defining Directory/Folder Name

			if (theDir.exists()) { // Checks that Directory/Folder Doesn't Exists!
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example copy somewhere
				path = System.getProperty("user.dir") + "\\screenshots\\" + screenshot + "_"
						+ formater.format(calendar.getTime()) + ".png";

				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + screenshot
						+ "_" + formater.format(calendar.getTime()) + ".png"));
				return path;

			} else {
				theDir.mkdir();
				Calendar calendar = Calendar.getInstance();
				SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

				File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				// Now you can do whatever you need to do with it, for example copy somewhere
				path = System.getProperty("user.dir") + "\\screenshots\\" + screenshot + "_"
						+ formater.format(calendar.getTime()) + ".png";

				FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\screenshots\\" + screenshot
						+ "_" + formater.format(calendar.getTime()) + ".png"));
				return path;
			}

		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return path;
	}

	@AfterSuite
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();

	}
}

package Base;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JFileChooser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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

	static String fileDictName = "";
	public static WebDriver driver;
	public static String url;
	public static WebDriverWait wait;
	

	@BeforeSuite
	public static void configProperty() {

		try {

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

	public void click_Xpath(String locator) {

	
		driver.findElement(By.xpath(locator)).click();

	}

	public void type_Xpath(String locator, String value) {
		driver.findElement(By.xpath(locator)).sendKeys(value);

	}

	public void click_CSS(String locator) {
	
		driver.findElement(By.cssSelector(locator)).click();

	}

	public void type_CSS(String locator, String value) {

		driver.findElement(By.cssSelector(locator)).sendKeys(value);

	}

	public void click_ID(String locator) {
		driver.findElement(By.id(locator)).click();
	}

	public void type_ID(String locator, String value) {
		driver.findElement(By.id(locator)).sendKeys(value);
		//dfg
	}

	/*
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
	 * 
	 * public static String testpath = null;
	 */
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

	public static String fileChooser(String filechoose) {
		try {

			Robot r = new Robot();
			// Create instance of Robot class
			Robot robot = new Robot();
			// Create instance of Clipboard class
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			// Set the String to Enter
			StringSelection stringSelection = new StringSelection(filechoose);
			// Copy the String to Clipboard
			clipboard.setContents(stringSelection, null);
			// Use Robot class instance to simulate CTRL+C and CTRL+V key events :

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			// Simulate Enter key event
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println(e + " issue with filechooser method");
		}
		return filechoose;
	}

	public static String fileURL(String test) {
		try {
			test = "1";
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setAcceptAllFileFilterUsed(false);
			fileChooser.setDialogTitle("Save the dictionary file");
			fileChooser.setSelectedFile(new File(url));
			int userSelection = fileChooser.showSaveDialog(fileChooser);
			if (userSelection == JFileChooser.APPROVE_OPTION) {
				url = fileChooser.getSelectedFile().getAbsolutePath();
				System.out.println(url);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return url;
	}

	public static String urlMethod() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogTitle("Save the dictionary file");
		fileChooser.setSelectedFile(new File(fileDictName));
		int userSelection = fileChooser.showSaveDialog(fileChooser);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			fileDictName = fileChooser.getSelectedFile().getAbsolutePath();
			System.out.println(fileDictName);
		}
		return fileDictName;
	}

	public static void matchMethod() {
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);

			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);

			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	/*@AfterSuite
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();

	}*/
}

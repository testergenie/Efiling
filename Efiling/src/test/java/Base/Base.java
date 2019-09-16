package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base  {
	

	public static WebDriver driver;
	
	WebDriverWait wait; 
	public static Properties prop;
	public static Properties prop1;
	final static Logger logger = Logger.getLogger(Base.class);

	//private static final Logger logger = LoggerFactory.getLogger(Base.class);
	
	
	
	private static String propPath = (System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\objectRepository.properties");
	private static String configPath = (System.getProperty("user.dir")+"\\src\\test\\resources\\Properties\\config.properties");
	
	public static void objectRepository() {
		try {
			FileInputStream fis = new FileInputStream(propPath);
			prop = new Properties();
			prop.load(fis);
			Reporter.log("object reporsitory is loaded");
			logger.debug("object reposiory is loaded");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void configProperty() {

		try {
			
			FileInputStream con = new FileInputStream(configPath);
			prop1 = new Properties();
			prop1.load(con);
			Reporter.log("config file is loaded");
			
			if (prop1.getProperty("browser").equals("firefox")) {

				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				
				//driver.get("http://13.126.78.123/taxgenie_development/");
			

			} else if (prop1.getProperty("browser").equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();
				Reporter.log("Chrome opened");
				
				//driver.navigate().to("http://13.126.78.123");
				// driver.manage().window().maximize();
			} else if (prop1.getProperty("browser").equals("ie")) {

				System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				driver.navigate().to(System.getProperty("site"));
			

			}
			driver.navigate().to(System.getProperty("site"));

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@BeforeSuite
	public void LaunchBrowser() {
	
		try {
			Base.objectRepository();
			Base.configProperty();
			Reporter.log("all file are loaded");
			driver.get(prop1.getProperty("site"));
			// Thread.sleep(5000);
			Reporter.log("browser is launched");
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	public static String testpath = null;
	

public static  String captureScreenShot(String screenshot)
{
	String path = null;
    try {
	   Calendar calendar = Calendar.getInstance();
	   SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	  
	   File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	   // Now you can do whatever you need to do with it, for example copy somewhere
	   path="E:\\Efiling\\screenshots\\"+screenshot+"_"+formater.format(calendar.getTime())+".png";
	   
	   FileUtils.copyFile(scrFile, new File("E:\\Efiling\\screenshots\\"+screenshot+"_"+formater.format(calendar.getTime())+".png"));
	   return path;
	} catch (Exception e) {
		// TODO: handle exception
	}
    return path;
}
	


	
	@AfterSuite(alwaysRun = true)
	public void tearDown() throws Exception {
	Thread.sleep(3000);
	driver.quit();
	
	}
}

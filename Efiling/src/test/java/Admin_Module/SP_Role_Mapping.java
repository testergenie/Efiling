package Admin_Module;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SP_Role_Mapping {

	
	@Test
	public void SPRole() throws Exception {
	
	
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
  	WebDriver driver = new ChromeDriver();
  	JavascriptExecutor js = (JavascriptExecutor) driver;
	WebDriverWait wait = new WebDriverWait(driver,30);
	
	driver.get("http://13.233.174.232/taxgenie_transfer/");
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.findElement(By.id("user")).sendKeys("admin@taxgenie.in");
	driver.findElement(By.id("password")).sendKeys("Transfer@123");
	String captchaVal = driver.findElement(By.id("captcha")).getText();
	WebElement captcha = driver.findElement(By.id("captcha1"));
		captcha.sendKeys(captchaVal);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("save")));
		Thread.sleep(1000);
		driver.findElement(By.id("save")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div[2]/div/div[2]/table/tbody/tr/td[7]/button/span[2]")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-product-page/div/div[1]/a/div/h2")).click();
	
		
		
	
	}
}

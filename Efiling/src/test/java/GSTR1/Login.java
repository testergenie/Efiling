package GSTR1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Base.Base;

public class Login extends Base {

	@Test(priority = 0, description = "login in TG Portal")
	public void LoginPage() throws Exception {
		String path =null;
		try {
			
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			driver.manage().window().maximize();
			Thread.sleep(1000);
			path = Base.captureScreenShot("Login Page");
			System.out.println("path : "+path);
			Reporter.log("<a href="+path+">Login Page</a>");
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
			driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys("demo2@taxgenie.in"); 
			driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys("dev@tg");
			
			String Cap = driver.findElement(By.xpath(prop.getProperty("captcha"))).getText();
			Reporter.log("Copied Captcha");
			driver.findElement(By.xpath(prop.getProperty("captchaText"))).sendKeys(Cap);
			Reporter.log("Entered Captcha");
			driver.findElement(By.xpath(prop.getProperty("LogIn"))).click();
			Reporter.log("Login Successful");
			path = Base.captureScreenShot("LoggedIN");
			Reporter.log("<a href="+path+">LoggedIN</a>");
			String Alert = driver.switchTo().alert().getText();
			Reporter.log(Alert);
			System.out.println(Alert);
			//driver.findElement(By.xpath(prop.getProperty("LogIn"))).click();
		} catch (Exception e)  {
			Reporter.getOutput();
		}

	}
	

}

package Admin_Module;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Base.Base;

public class Login_Functionality {
	


	public class Login1 extends Base {

		@Test(priority = 0, description = "login in TG admin Portal")
		public void LoginPage() throws Exception {
			String path =null;
	
			try {	
				System.setProperty("org.uncommons.reportng.escape-output", "false");
				driver.manage().window().maximize();
				Thread.sleep(1000);
				path = Base.captureScreenShot("Login Page");
				System.out.println("path : "+path);
				Reporter.log("<a href="+path+">LoginPage</a>");
				WebDriverWait wait = new WebDriverWait(driver,30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
				driver.findElement(By.xpath(prop.getProperty("username"))).sendKeys("TG_Admin@tg.in"); 
				driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys("dev@tg");
				
				String Cap = driver.findElement(By.xpath(prop.getProperty("captcha"))).getText();
				Reporter.log("Copied Captcha");
				driver.findElement(By.xpath(prop.getProperty("captchaText"))).sendKeys(Cap);
				Reporter.log("Entered Captcha");
				driver.findElement(By.xpath(prop.getProperty("LogIn"))).click();
				Reporter.log("Login Successful");
				Thread.sleep(3000);
				path = Base.captureScreenShot("LoggedIN");
				Reporter.log("<a href="+path+">LoggedIN</a>");
				
		
				Thread.sleep(3000);
				driver.findElement(By.xpath("//tr[@class='ng-star-inserted']/td[7]/button/i")).click();	
				Thread.sleep(3000);
				driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[2]/div[1]/a/div/div[1]/h2")).click();
				Thread.sleep(3000);
			}
			catch(Exception e){
				 
				System.out.println(e);
			}
				
				
						//driver.findElement(By.xpath(prop.getProperty("LogIn"))).click();
		//	catch (Exception e)  {
			//	Reporter.getOutput();
				//Assert.fail();
				
		//	}

		}
		

	}

}

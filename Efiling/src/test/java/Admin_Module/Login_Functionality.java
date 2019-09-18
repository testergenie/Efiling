package Admin_Module;

import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Base.Base;
import Base.ObjectRepository;



public class Login_Functionality {

	public class Login1 extends Base {

		@Test(priority = 0, description = "login in TG admin Portal")
		public void LoginPage() throws Exception {
			String path;		

			try {
				Thread.sleep(5000);
				path = Base.captureScreenShot("LoginPage");
				System.out.println("path : " + path);
				Reporter.log("<a href=" + path + ">LoginPage</a>");
				WebDriverWait wait = new WebDriverWait(driver, 30);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));

				driver.findElement(By.xpath(ObjectRepository.username)).sendKeys("admin@taxgenie.in");
				driver.findElement(By.xpath(ObjectRepository.password)).sendKeys("newS@Tg");
				String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
				Thread.sleep(2000);
				driver.findElement(By.xpath(ObjectRepository.captchaText)).sendKeys(captchaVal);
				Reporter.log("Entered Captcha");
				driver.findElement(By.xpath(ObjectRepository.LogIn)).click();

				Reporter.log("Login Successful");
				Thread.sleep(3000);
				path = Base.captureScreenShot("LoggedIN");
				Reporter.log("<a href=" + path + ">LoggedIN</a>");

				Thread.sleep(3000);
				// Work On this
				driver.findElement(By.xpath(
						"/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr/td[8]/button"))
						.click();
				Thread.sleep(3000);
				path = Base.captureScreenShot("WorkOnThis");
				Reporter.log("<a href=" + path + ">WorkOnThis</a>");
				Thread.sleep(3000);
				// Product Selection
				driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[4]/a/div"))
						.click();

				Thread.sleep(3000);
				path = Base.captureScreenShot("adminpage");
				Reporter.log("<a href=" + path + ">adminpage</a>");
				Thread.sleep(3000);
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}

		}

	}

}

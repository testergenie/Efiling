package GSTR1;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Base.Base;
import Base.ObjectRepository;

public class Login extends Base {
	public static String product;

	
	@Test(priority = 0, description = "login in TG Portal")
	public void LoginPage() throws Exception {
		String path;

		try {
			Thread.sleep(5000);
			path = Base.captureScreenShot("LoginPage");
			System.out.println("path : " + path);
			Reporter.log("<a href=" + path + ">LoginPage</a>");
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
			
			type_Xpath(ObjectRepository.username, "saurav@taxgenie.in");
			type_Xpath(ObjectRepository.password, "Taxgenie@123");
			 String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
			Thread.sleep(2000);
			type_Xpath(ObjectRepository.captchaText, captchaVal);
			Reporter.log("Entered Captcha");
			click_Xpath(ObjectRepository.LogIn);
	
			Reporter.log("Login Successful");
			Thread.sleep(3000);
			path = Base.captureScreenShot("LoggedIN");
			Reporter.log("<a href=" + path + ">LoggedIN</a>");

			Thread.sleep(3000);
			// Work On this
			driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr[1]/td[8]/button"))
					.click();
			Thread.sleep(3000);
			path = Base.captureScreenShot("WorkOnThis");
			Reporter.log("<a href=" + path + ">WorkOnThis</a>");
			Thread.sleep(3000);
			for (int i = 1; i < 13; i++) {

				product = driver
						.findElement(By.xpath(
								"/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i + "]/a/div/h2"))
						.getText();
				System.out.println(product);
				if (product.equals("E-FILING")) {
					driver.findElement(By.xpath(
							"/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i + "]/a/div/h2"))
							.click();
					break;
				}

			}
			Thread.sleep(3000);
			path = Base.captureScreenShot(product);
			Reporter.log("<a href=" + path + ">" + product + "</a>");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}

}

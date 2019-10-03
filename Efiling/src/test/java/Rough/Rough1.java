package Rough;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class Rough1 extends Base {

	
	public static String product;
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
			


			driver.findElement(By.xpath(ObjectRepository.username)).sendKeys("saurav@taxgenie.in");
			driver.findElement(By.xpath(ObjectRepository.password)).sendKeys("Taxgenie@123");
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
					"/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr[8]/td[8]/button"))
					.click();
			Thread.sleep(3000);
			path = Base.captureScreenShot("WorkOnThis");
			Reporter.log("<a href=" + path + ">WorkOnThis</a>");
			Thread.sleep(3000);
			// Product Selection
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
			Reporter.log("<a href=" + path + ">product</a>");
			Thread.sleep(3000);
			driver.findElement(By.xpath(ObjectRepository.temclick)).click();
			Thread.sleep(3000);
			for (int i = 1; i <=3; i++) {
				String year=driver.findElement(By.xpath("//app-upload-data/div/div[1]/div/div/div/div[2]/div[1]/div/ng-select/ng-dropdown-panel/div/div[2]/div["+i+"]/span")).getText();
				System.out.println(year);
				if(year.equals("Upload From Excel Template")) {
					driver.findElement(By.xpath("//app-upload-data/div/div[1]/div/div/div/div[2]/div[1]/div/ng-select/ng-dropdown-panel/div/div[2]/div["+i+"]/span")).click();
					break;
				}
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath(ObjectRepository.finyearclick)).click();
			Thread.sleep(3000);
			for (int i = 1; i <=3; i++) {
				String finyear=driver.findElement(By.xpath("//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[1]/ng-select/ng-dropdown-panel/div[1]/div[2]/div["+i+"]/span")).getText();
				System.out.println(finyear);				//app-opt-gstr3-bvs2-a/div[1]/div/div/div/div[2]/app-vendor-date-picker/div/div[1]/ng-select/ng-dropdown-panel/div/div/div[1]/span
				if(finyear.equals("2017-2018")) {
					driver.findElement(By.xpath("//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[1]/ng-select/ng-dropdown-panel/div[1]/div[2]/div["+i+"]/span")).click();
					break;
				}
				
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath(ObjectRepository.MONTHCLICK)).click();
			Thread.sleep(3000);
			for (int i = 1; i < 24; i++) {
				String month =driver.findElement(By.xpath("//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["+i+"]/span")).getText();
				System.out.println(month);
				if(month.equals("Dec 2017")) {
					driver.findElement(By.xpath("//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["+i+"]/span")).click();
					break;
					
				}
			}
			Thread.sleep(3000);
			driver.findElement(By.xpath(ObjectRepository.chooseFile)).click();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}
	
	

}

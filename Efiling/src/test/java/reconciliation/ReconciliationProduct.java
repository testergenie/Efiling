package reconciliation;

import java.awt.Robot;

import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;


import Base.Base;
import Base.ObjectRepository;

public class ReconciliationProduct extends Base {
	public static String product;
	public static String path;


	@Test(priority = 0, description = "login done")
	public void Login() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		try {
			Thread.sleep(3000);
			path = Base.captureScreenShot("LoginPage");
			System.out.println("path : " + path);
			Reporter.log("<a href=" + path + ">LoginPage</a>");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));

			type_Xpath(ObjectRepository.username, "saurav@taxgenie.in");
			type_Xpath(ObjectRepository.password, "Taxgenie@123");
			String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
			type_Xpath(ObjectRepository.captchaText, captchaVal);
			Reporter.log("Entered Captcha");
			click_Xpath(ObjectRepository.LogIn);

			Reporter.log("Login Successful");
			Thread.sleep(3000);
			path = Base.captureScreenShot("LoggedIN");
			Reporter.log("<a href=" + path + ">LoggedIN</a>");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Test(priority = 1, description = "company selection tab")
	public void companySelection() {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ObjectRepository.pageNo)));
		
		try {
			driver.findElement(By.xpath(
					"/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr[8]/td[8]/button"))
					.click();
			Thread.sleep(3000);
			path = Base.captureScreenShot("WorkOnThis");
			Reporter.log("<a href=" + path + ">WorkOnThis</a>");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@Test(priority = 2, description = "recon product selected")
	public void ReconProduct() {		
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			for (int i = 1; i < 13; i++) {

				product = driver
						.findElement(By.xpath(
								"/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i + "]/a/div/h2"))
						.getText();
				System.out.println(product);
				if (product.equals("RECONCILIATION")) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i +"]/a/div/h2")));
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
		}

	}

	@Test(priority = 3, description = "selecting financial year and month   ")
	public void periodforRecon() {
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(ObjectRepository.reconFY)).click();
			Thread.sleep(2000);
			for (int i = 1; i < 3; i++) {

				product = driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				if (product.equals("2018-2019")) {
					driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath(ObjectRepository.reconM1)).click();
			Thread.sleep(2000);
			for (int i = 1; i < 12; i++) {

				product = driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				if (product.equals("Dec 2018")) {
					driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}

			}
			Thread.sleep(1000);
			driver.findElement(By.xpath(ObjectRepository.reconM2)).click();
			Thread.sleep(1000);
			for (int i = 1; i < 12; i++) {

				product = driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["+ i +"]/span"))
						.getText();
				if (product.equals("Dec 2018")) {
					driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
									+ i + "]/span"))
							.click();
					break;
				}

			}
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"btnSectionofMnth\"]/button")).click();
			Thread.sleep(2000);
			//table data in recon
			driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[5]/table/tbody/tr[7]/td[10]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[1]/div[3]/div[2]/button[3]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[3]/div/div/table/tbody/tr/td[5]/button")).click();
		Thread.sleep(3000);
		
		//manual match final page
		for (int i = 1; i < 150; i++) {
			
			String date1 =driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[5]")).getText();
			driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[5]")).click();
			
			
			for (int j = 1; j < 150; j++) {
				
				String date2 = driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+j+"]/td[5]")).getText();
				if(date1.equals(date2))
				{
					try {
						driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/div[2]/div/div[2]/table/tbody/tr[\"+j+\"]/td[5]")).click();
						Thread.sleep(2000);
						String invoiceValue = driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[1]/div/div/table/thead/tr[2]/td[1]")).getText();
						String r=invoiceValue.replace(",", "");
						System.out.println(r);
						double inv = Double.parseDouble(r);
						System.out.println(inv);
						String round=driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[1]/div/p[3]")).getText();
						System.out.println(round);
						String splitround[]= round.split(" ");
						System.out.println(splitround[splitround.length-1]);
						double roundoff= Double.parseDouble(splitround[splitround.length-1]);
						double nroundoff=Double.parseDouble("-"+splitround[splitround.length-1]);
						System.out.println(nroundoff + "   " +roundoff);
						if(inv >= nroundoff && inv <=roundoff)
						{
							Base.matchMethod();
						}
						else
						{
							System.out.println("no match for the system");
							
						}
					} catch (Exception e) {
						e.printStackTrace();
						// TODO: handle exception
					}
					
					
				break;	
				}	
			
			}
		
			
			
			
			
			
			
		}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}

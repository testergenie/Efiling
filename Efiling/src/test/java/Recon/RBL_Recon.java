package Recon;

import static org.testng.Assert.assertEquals;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class RBL_Recon extends Base{
	@Test(priority = 0, description = "login in TG admin Portal")
	public void Login() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
		
	try{	
		//Username
		String Username = JOptionPane.showInputDialog("Please enter the Username:");
		driver.findElement(By.xpath(ObjectRepository.user)).sendKeys(Username);
		//Password
		String password = JOptionPane.showInputDialog("Please enter the Password:");
		driver.findElement(By.xpath(ObjectRepository.password)).sendKeys(password);
		
/*		driver.findElement(By.xpath(ObjectRepository.username)).sendKeys("ajay@taxgenie.in");
		driver.findElement(By.xpath(ObjectRepository.password)).sendKeys("Taxgenie@123");*/
		
		//Captcha
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		driver.findElement(By.xpath(ObjectRepository.captchaText)).sendKeys(captchaVal);
		driver.findElement(By.xpath(ObjectRepository.LogIn)).click();
	}//try
	
	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
		Assert.fail("Unable to Login");
	}//Catch
		}//Login
	
	@Test(priority = 1, description = "Company Selection")
	public void Company_Select() throws Exception {
		By ORGCreation = By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[1]/div/table/thead/tr[1]/th[1]");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		
		try{
			WebElement Search = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/div/div/input"));
			String OrganisationName = JOptionPane.showInputDialog("Please enter the Organisation Name:");
			Search.sendKeys(OrganisationName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr[1]/td[8]/button")).click();
			
			//Recon Product Selection
			for (int i = 1; i < 15; i++) {
				
				WebElement  Product = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i + "]/a/div/h2"));
				wait.until(ExpectedConditions.visibilityOf(Product));
				String Product_Name = Product.getText();
				System.out.println(Product_Name);
				
				if(Product_Name.equals("RECONCILIATION")) {
					wait.until(ExpectedConditions.elementToBeClickable(Product));
				Product.click();
					break;
				}//if 
				else {
					System.out.println("No Recon Prod");
					return;
					}//else
			
			
			
			/*String a[] = new String [100];
			for (int i = 1; i <= 100; i++) {
				WebElement state = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr["+i+"]/td[3]"));
				if(state.isDisplayed()) {
					a[i] = state.getText();
					System.out.println("State Name"+a[i]);
					
				}//if
				else {
					break;
				}//else
*/			
				}//for
//			System.out.println(a.length);
		
		
		
			
		
			
		}//try
		
		
		catch(Exception e){
			System.out.println(e);
		}
	
		
	
	
	
	
	
	
	
	
		}//Company Selection
	

	@Test(priority = 3, description = "selecting financial year and month   ")
	public void periodforRecon() {
        JavascriptExecutor js = (JavascriptExecutor) driver;

		WebDriverWait wait = new WebDriverWait(driver, 120);
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath(ObjectRepository.reconFY)).click();
		Thread.sleep(2000);
		for (int i = 1; i < 3; i++) {

			String period = driver.findElement(By.xpath(
					"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div["+ i + "]/span")).getText();
			if (period.equals("2018-2019")) {
				driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div["+ i + "]/span")).click();
				break;
			}
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath(ObjectRepository.reconM1)).click();
		Thread.sleep(2000);
		for (int i = 1; i < 12; i++) {

		 String	M1 = driver.findElement(By.xpath(
					"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
							+ i + "]/span"))
					.getText();
			if (M1.equals("Dec 2018")) {
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

			String M2 = driver.findElement(By.xpath(
					"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["+ i +"]/span"))
					.getText();
			if (M2.equals("Dec 2018")) {
				driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
								+ i + "]/span"))
						.click();
				break;
			}

		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//app-reconcilation/div/div/div/div/div[3]/div/button")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-reconcilation/div[1]/div/div/div/div[5]/table/tbody/tr[7]/td[10]/button")));
		//table data in recon
		driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[5]/table/tbody/tr[7]/td[10]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[1]/div[3]/div[2]/button[3]")).click();
		
		//Vendor Selection
		WebElement VendorName= 		driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[3]/div/div/table/tbody/tr[40]/td[5]/button"));
		js.executeScript("arguments[10].scrollIntoView();", VendorName);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[3]/div/div/table/tbody/tr[40]/td[5]/button")));
		VendorName.click();
		Thread.sleep(3000);
	
	//manual match final page
	String LP = JOptionPane.showInputDialog("Please enter the Last Page No in GSTR2A Table:");
	int LP2A = Integer.parseInt(LP);
	


for (int k = 1; k <=LP2A; k++) {
	for (int i = 1; i <= 10; i++) {
		
	/*	String date1 =driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[5]")).getText();
	
		driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[5]")).click();
	*/	
		try {
			WebElement FinYear2A = driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+i+"]/td[4]"));
			js.executeScript("arguments[0].scrollIntoView();", FinYear2A);
			String finyearGSTR2A =FinYear2A.getText();
			FinYear2A.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // this for main for look int i
	driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/p-paginator/div/a[3]/span")).click();
} // this end is for k

//driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/p-paginator/div/span/a[2]")).click();

	
	} //this close is for test priorty 3
	catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}

}
	

	
	
}//RBL_Recon

package GSTR1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;


public class File_GSTR1 extends Base {
	String path = null;
	
	
	@Test(priority=5)
	public void upload( ) {
		try {
		
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop.getProperty("Upload")))));
			driver.findElement(By.linkText("Upload")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("salesupload"))).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(prop.getProperty("purchaseupload"))).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("salesupload"))).click();
		}
		catch(Exception e) {
			System.out.println("Unable to click on upload");
			Assert.fail();
			
		}
	}
	@Test(priority = 6)
	public void uploadfiletype() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop.getProperty("GSTR1")))));
			Thread.sleep(6000);
			driver.findElement(By.xpath(prop.getProperty("Choosetemplatetype"))).click();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Government Standard Template")).click();
			Thread.sleep(3000);
			
		}
		catch (Exception e) {
			System.out.println(e);
			Assert.fail("Unable to selectupload template");
		}
	}


	@Test(priority =6)
	public void fileselection() {
		try {
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(prop.getProperty("choose")))));
			driver.findElement(By.xpath(prop.getProperty("choose"))).click();
			Runtime.getRuntime().exec("C:\\Users\\Admin\\Documents\\UploadFile.exe");
			Thread.sleep(3000);
			driver.findElement(By.xpath(prop.getProperty("cancelbutton"))).click();
			Thread.sleep(10000);
			path = Base.captureScreenShot("Selectedfile");
 			Reporter.log("<a href="+path+">Selectedfile</a>");
 			Thread.sleep(10000);
			
		}
	catch(Exception e) {
		System.out.println(e);
		Assert.fail();
	}
	}
	



}

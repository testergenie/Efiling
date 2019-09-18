package GSTR1;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class View_GSTR1_Invoice extends Base {
	String path = null;
@Test(priority = 3)
	
	public void Gstr_1Details(){
		
		
		try{
			WebDriverWait wait = new WebDriverWait(driver,30);
			Thread.sleep(10000);        
		             path = Base.captureScreenShot("E-filingView");
		 			Reporter.log("<a href="+path+">E-filingView</a>");

	driver.findElement(By.xpath(ObjectRepository.Year)).click();
	Thread.sleep(2000);
	System.out.println("Selected Year drop down");
	driver.findElement(By.linkText("2018-2019")).click();
	System.out.println("Selected 2018-2019");
	Thread.sleep(12000);
	
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(ObjectRepository.month))));
	driver.findElement(By.xpath(ObjectRepository.month)).click();
	driver.findElement(By.linkText("Nov 2018")).click();
	
	Thread.sleep(6000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	Thread.sleep(3000);
	System.out.println("Scrolled the page");



		}
		catch(Exception e){
			
			System.out.println(e);
			Assert.fail();
		}
	}

	@Test(priority = 4)
	public void B2B_View() {
		try {
			
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepository.ViewB2B)));
Thread.sleep(5000);
		driver.findElement(By.xpath(ObjectRepository.ViewB2B)).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
		
		}
		catch(Exception e) {
			System.out.println(e);
			Assert.fail("Unable to click on View B2C");
		}
	}

}

package GSTR2;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class GSTR2_Summary extends Base{
	String path =null;

	@Test()
	public void GSTR2Summary() {
		try { 
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ObjectRepository.GSTR1)));
		Thread.sleep(3000);
		driver.findElement(By.xpath(ObjectRepository.GSTR2)).click();
		path = Base.captureScreenShot("GSTR2Summary");
		Reporter.log("<a href="+path+">GSTR2Summary</a>");
		Thread.sleep(3000);
		
	}
	catch(Exception e) {
		Assert.fail("Unable to click on GSTR2");
		System.out.println(e);
	}
	}
	
	
}

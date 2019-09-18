package GSTR1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class DashboardPage1 extends Base{
	String path = null;

	
	@Test(priority = 1)
	public void DashboardPage() throws Exception{
		try {
		
		
		WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ObjectRepository.Demonewbutn)));
			path = Base.captureScreenShot("LOC");
			
			Reporter.log("<a href="+path+">LOC</a>");
					
			driver.findElement(By.xpath(ObjectRepository.Demonewbutn)).click();
		
			
			Reporter.log("Selected company");
			Thread.sleep(3000);
			
			path = Base.captureScreenShot("LOC");
			Reporter.log("<a href="+path+">LOC</a>");
		
		}
		catch(Exception e) {
			Assert.fail("Unable to select the organisation");
		}
	}

}

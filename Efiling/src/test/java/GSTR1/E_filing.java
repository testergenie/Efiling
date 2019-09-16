package GSTR1;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;





public class E_filing extends Base{
	 @Test(priority=2)
	
	public void efiling() {
		String path =null;
	
	
try {
	WebDriverWait	wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty("efiling"))));
	path = Base.captureScreenShot("E-filing selection TAB");
	Reporter.log("<a href="+path+">E-filing selection TAB</a>");
	driver.findElement(By.xpath(prop.getProperty("efiling"))).click();
	
}
catch(Exception e) {
	Assert.fail("Unable to select E-filing");
	System.out.println(e);
	
}
	
}
}
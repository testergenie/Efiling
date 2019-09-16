package Admin_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;

public class TGDS_Create extends Base{
	String path =null;
  
	@Test(priority = 1, description = "create TGDS Company")
	public void TGDSCompanycreation() throws Exception {
	try {
	

		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a")).click();
		Thread.sleep(1000);
		path = Base.captureScreenShot("Organisation Creation");
		Reporter.log("<a href="+path+">Organisation Creation</a>");
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navs ng-star-inserted'][1]/li/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='tabbable footer']/ul/li[1]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='col-md-12']/div/button")).click();
		Thread.sleep(2000);
		
		path = Base.captureScreenShot("AddNEWTGDS");
		Reporter.log("<a href="+path+">AddNEWTGDS</a>");
		
		
	Thread.sleep(1000);
	String TGDSGSTINNO =prop.getProperty("TGDSGSTIN");
	
		driver.findElement(By.xpath(prop.getProperty("TGDSGSTINFIELD"))).sendKeys(TGDSGSTINNO);
		
		//Product_For_Sale
		WebElement TGDSProductSelect = driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[2]/div/div/ng-select/div"));
		Select productselect = new Select(TGDSProductSelect);
		productselect.selectByVisibleText("TGDS_Product"); 
		driver.findElement(By.xpath(prop.getProperty("TGDSNAME"))).sendKeys(prop.getProperty("TGDSCENTRENAME" ));
		driver.findElement(By.xpath(prop.getProperty("AddressTab"))).sendKeys(prop.getProperty("TGDSADDRESS", "Mumbai"));
		
		
		
		
	}
	catch(Exception e){
		Assert.fail();
		System.out.println(e);
	}
	}
	
		
	@Test(priority = 2, description = "create TGDS User")
	
	public void TGDSusercreation() throws Exception {
		
		
	try {
		driver.findElement(By.xpath("//div[@class='tabbable footer']/ul/li[4]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		path = Base.captureScreenShot("TGDSUserCreation");
		Reporter.log("<a href="+path+">TGDSUserCreation</a>");
		
		WebElement TGDSLIST = driver.findElement(By.xpath("//div[@class='col-md-6']/div/div/select"));
		

Select oSelect = new Select(TGDSLIST);

oSelect.selectByVisibleText("TGDS3");
         Thread.sleep(1000);
         WebElement  TGDSUSERFirstname = driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[1]/div/div/input"));
         WebElement TGDSUSERLastname=driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[2]/div/div/input"));
         WebElement  TGDSUSEREmail = driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[3]/div/div/input"));
         WebElement TGDSUserPW=driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[4]/div/div/input"));
         WebElement TGDSUSERMobile=driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[5]/div/div/input"));
         WebElement TGDSUSERSUBMIT=driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[2]/div/div/form/div[3]/button[1]"));
         
        TGDSUSERFirstname.sendKeys("RAMTGDSUSER");
         TGDSUSERLastname.sendKeys("TESTING");
         TGDSUSEREmail.sendKeys("TGDS3@tg.in");
         TGDSUserPW.sendKeys("Dev@tg123");
         TGDSUSERMobile.sendKeys("7777777777");
         
         path = Base.captureScreenShot("TGDS User Data");
 		Reporter.log("<a href="+path+">TGDS User Data</a>");
         Thread.sleep(3000);
         TGDSUSERSUBMIT.click();
         
         Thread.sleep(3000);
         WebElement cancel = driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-creation/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));
         
         if(cancel.isDisplayed());
         cancel.click();
         Thread.sleep(1000);
     
        		 

		
	}
		
	catch(Exception e) {
		System.out.println(e);
	}
	}
		
	@Test(priority = 3, description = "create TGDS UserRole Mapping")
	public void TGDSUserMapping() throws Exception {
		try {
			Thread.sleep(2000);
		
			driver.findElement(By.xpath("//div[@class='tabbable footer']/ul/li[7]/a")).click();
			Thread.sleep(2000);
			//Assign Role Button
			driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-role-mapping/div[1]/div[2]/div/div/div/button")).click();
	         path = Base.captureScreenShot("TGDS User Role Mapping");
	  		Reporter.log("<a href="+path+">TGDS User Role Mapping</a>");
	  		Thread.sleep(1000);
	  		WebElement TGDSRoleList = driver.findElement(By.xpath("//div[@class='col-md-6'][2]/div/div/select"));
	  		WebElement TGDSUserList = driver.findElement(By.xpath("//div[@class='modal-content']/div[3]/div[1]/div/div/select"));
	  		WebElement TGDSCentre = driver.findElement(By.xpath("//div[@class='modal-content']/div[2]/div/div/div/select"));
	  		
	  		Select oSelect = new Select(TGDSCentre);

	  		oSelect.selectByVisibleText("TGDS3");
	  		Thread.sleep(1000);
	  		Select Select1 = new Select(TGDSRoleList);
	  		Select1.selectByVisibleText("TGDS Admin Demo");
	  		Thread.sleep(1000);
	  		
	  		Select Select2 = new Select(TGDSUserList);
	  		Select2.selectByVisibleText("RAMTGDSUSER");
	  	  path = Base.captureScreenShot("TGDS User Role Assign");
	  		Reporter.log("<a href="+path+">TGDS User Role Assign</a>");
	  		Thread.sleep(2000);
	  		driver.findElement(By.xpath("/html/body/app-root/app-tgds-user-role-mapping/div[2]/div/div/div[4]/button")).click();

	  		Thread.sleep(3000);
	  		
		}
		
		
	catch (Exception e) {
		System.out.println(e);
	}
	}
	
	
		
	}

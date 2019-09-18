package Admin_Module;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;

public class TGDS_Create extends Base{
	String path =null;
	  static String TGDSAUTTEST;
	 String TGDSUSER ;
	 String TGDSUSEREMAIL;
  
	@Test(priority = 0, description = "create TGDS Company")
	public void TGDSCompanycreation() throws Exception {
	try {
	
		//Organisation Creation
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a")).click();
		Thread.sleep(1000);
		path = Base.captureScreenShot("Organisation Creation");
		Reporter.log("<a href="+path+">Organisation Creation</a>");
		//TGDS 
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navs']/li[1]/a")).click();
		Thread.sleep(3000);
		//TGDS CReation
		driver.findElement(By.xpath("//ul[@class='nav nav-tabs wizard']/li[1]/a")).click();
		Thread.sleep(2000);
		//Create TGDS Button
		driver.findElement(By.xpath("//div[@class='col-md-12']/div/button")).click();
		Thread.sleep(2000);

		path = Base.captureScreenShot("AddNEWTGDS");
		Reporter.log("<a href="+path+">AddNEWTGDS</a>");
		System.out.println("<a href="+path+">AddNEWTGDS</a>");

		
		
	Thread.sleep(1000);
		TGDSAUTTEST = JOptionPane.showInputDialog("TGDS Name:");
		//Product_For_Sale
		WebElement TGDSProductSelect = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[2]/div/div/ng-select/div/span"));
		TGDSProductSelect.click();
		driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[2]/div/div/ng-select/div/div/div[2]/input")).sendKeys("Tgds_Product");
		Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        //TGDS Center Name*
       
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[3]/div/div/input")).sendKeys(TGDSAUTTEST);
        //Address
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[4]/div/div/textarea")).sendKeys("Address TEST");
        //State
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[5]/div/div/input")).sendKeys("Maharastra");
        //City
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[6]/div/div/input")).sendKeys("Mumbai");
        //Designation Select
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[7]/div/div/ng-select/div/span")).click();
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[7]/div/div/ng-select/div/div/div[2]/input")).sendKeys("Manager");
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        //PinCode
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[8]/div/div/input")).sendKeys("400101");
        //Contact Person Name
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[9]/div/div/input")).sendKeys("Automation Engineer");
        //Contact Number
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[10]/div/div/input")).sendKeys("9999999999");
        //Contact Email
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[2]/form/div/div[11]/div/div/input")).sendKeys("Aut1@sele.in");
        Thread.sleep(3000);
        
        
        //Submit
        driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgdssp-creation/div[3]/div/div/div[3]/button[1]")).click();
        
        Thread.sleep(2000);
       
        }
	catch(Exception e){
		System.out.println(e);
		Assert.fail();
		
		
	}
	}
	
		
	@Test(priority = 1, description = "create TGDS User")
	
	public void TGDSusercreation() throws Exception {
		System.out.println("hello");
		
	try {
		Thread.sleep(2000);
		//TGDSUSERManagement
		driver.findElement(By.xpath("//ul[@class='nav nav-tabs wizard']/li[2]/a")).click();
		//Add TGDS User Button
		driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		path = Base.captureScreenShot("TGDSUserCreation");
		Reporter.log("<a href="+path+">TGDSUserCreation</a>");
		TGDSUSER = JOptionPane.showInputDialog("TGDS User Firstname:");
		TGDSUSEREMAIL = JOptionPane.showInputDialog("TGDS User Email:");
		
		WebElement TGDSLIST = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[2]/div/div/div[2]/form/div[1]/div/div/div/ng-select/div/div/div[2]/input"));
		TGDSLIST.sendKeys(TGDSAUTTEST);
		Robot robot = new Robot();
		 robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        Thread.sleep(1000);
         WebElement  TGDSUSERFirstname = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[2]/div/div/div[2]/form/div[2]/div[1]/div/div/input"));
         WebElement TGDSUSERLastname=driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[2]/div/div/div[2]/form/div[2]/div[2]/div/div/input"));
         WebElement  TGDSUSEREmail = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[2]/div/div/div[2]/form/div[2]/div[3]/div/div/input"));
         WebElement TGDSUserPW=driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[2]/div/div/div[2]/form/div[2]/div[4]/div/div/input"));
         WebElement TGDSUSERMobile=driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[2]/div/div/div[2]/form/div[2]/div[5]/div/div/input"));
         WebElement TGDSUSERSUBMIT=driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-creation/div[1]/div/div[2]/div/div/div[3]/button[1]"));
         
        TGDSUSERFirstname.sendKeys(TGDSUSER);
         TGDSUSERLastname.sendKeys("TESTING");
         TGDSUSEREmail.sendKeys(TGDSUSEREMAIL);
         TGDSUserPW.sendKeys("Dev@tg123");
         TGDSUSERMobile.sendKeys("7777777777");
         
         	path = Base.captureScreenShot("TGDS User Data");
 			Reporter.log("<a href="+path+">TGDS User Data</a>");
         Thread.sleep(3000);
         TGDSUSERSUBMIT.click();
         
         Thread.sleep(3000);
      
         Thread.sleep(2000);
     
        		 

		
	}
		
	catch(Exception e) {
		System.out.println(e);
		Assert.fail();
	}
	}
		
	@Test(priority = 2, description = "create TGDS UserRole Mapping")
	public void TGDSUserMapping() throws Exception {
		try {
			Thread.sleep(2000);
			//TGDS User Role Mapping
		
			driver.findElement(By.xpath("//ul[@class='nav nav-tabs wizard']/li[3]/a")).click();
			Thread.sleep(2000);
			//Assign Role Button
			driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-role-mapping/div[1]/div/div/div/div/button/span[2]")).click();
	        path = Base.captureScreenShot("TGDS User Role Mapping");
	  		Reporter.log("<a href="+path+">TGDS User Role Mapping</a>");
	  		Thread.sleep(1000);
	  		WebElement TGDSCentre = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-role-mapping/div[2]/div/div/div[2]/form/div[1]/div[1]/div/div/ng-select/div/div/div[2]/input"));
	  		WebElement TGDSUserList = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-role-mapping/div[2]/div/div/div[2]/form/div[1]/div[2]/div/div/ng-select/div/div/div[2]/input"));
	  		WebElement TGDSRoleList = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-role-mapping/div[2]/div/div/div[2]/form/div[2]/div/div/div/ng-select/div/div/div[2]/input"));
	  		TGDSCentre.sendKeys(TGDSAUTTEST);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		     
		    TGDSUserList.sendKeys(TGDSUSER);
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		    TGDSRoleList.sendKeys("TGDS_Admin");
			robot.keyPress(KeyEvent.VK_ENTER);
		    robot.keyRelease(KeyEvent.VK_ENTER);
		    
		    
		    Thread.sleep(3000);
	      	path = Base.captureScreenShot("TGDS User Role Mapping");
	 			Reporter.log("<a href="+path+">TGDS User Role Mapping</a>");
		    //Submit
		    
		    
		        
	  		driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-tgds-user-role-mapping/div[2]/div/div/div[3]/button")).click();

	  		Thread.sleep(3000);
	  		
	  		
		}
		
		
	catch (Exception e) {
		System.out.println(e);
		Assert.fail();
	}
	}
	
	
		
	}

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

public class SPCA_Create extends Base {
	String path =null;	
	  static String SPCAAUTTEST;
	 String SPCAUSER ;
	 String SPCAUSEREMAIL;
	  
	  @Test(priority = 0, description = "create SPCA Company")
		public void SPCACOMPANYcreation() throws Exception {
		try {
		
			//Organisation Creation
			driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a")).click();
			Thread.sleep(1000);
			path = Base.captureScreenShot("Organisation Creation");
			Reporter.log("<a href="+path+">Organisation Creation</a>");
			//SPCA 
			driver.findElement(By.xpath("/ul[@class='nav navbar-nav navs']/li[4]/a")).click();
			Thread.sleep(3000);
			//SPCA CReation
			driver.findElement(By.xpath("//ul[@class='nav nav-tabs wizard']/li[1]/a")).click();
			Thread.sleep(2000);
			//Create SPCA Button
			driver.findElement(By.xpath("//div[@class='col-md-12']/div/button")).click();
			Thread.sleep(2000);

			path = Base.captureScreenShot("AddNEWSPCA");
			Reporter.log("<a href="+path+">AddNEWSPCA</a>");
			System.out.println("<a href="+path+">AddNEWSPCA</a>");

			
			
		Thread.sleep(1000);
			SPCAAUTTEST = JOptionPane.showInputDialog("SPCA Name:");
			//Product_For_Sale
			WebElement SPCAProductSelect = driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[2]/div/div/ng-select/div/span"));
			SPCAProductSelect.click();
			driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[2]/div/div/ng-select/div/div/div[2]/input")).sendKeys("SPCA_Product");
			Robot robot = new Robot();
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        //SPCA Center Name*
	       
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[3]/div/div/input")).sendKeys(SPCAAUTTEST);
	        //Address
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[4]/div/div/textarea")).sendKeys("Address TEST");
	        //State
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[5]/div/div/input")).sendKeys("Maharastra");
	        //City
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[6]/div/div/input")).sendKeys("Mumbai");
	        //Designation Select
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[7]/div/div/ng-select/div/span")).click();
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[7]/div/div/ng-select/div/div/div[2]/input")).sendKeys("Manager");
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        //PinCode
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[8]/div/div/input")).sendKeys("400101");
	        //Contact Person Name
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[9]/div/div/input")).sendKeys("Automation Engineer");
	        //Contact Number
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[10]/div/div/input")).sendKeys("9999999999");
	        //Contact Email
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div/div/div/div[2]/form/div/div[11]/div/div/input")).sendKeys("Aut1@sele.in");
	        Thread.sleep(3000);
	        
	        
	        //Submit
	        driver.findElement(By.xpath("//div/app-sp-ca-creation/div[3]/div/div/div[3]/button[1]")).click();
	        
	        Thread.sleep(2000);
	       
	        }
		catch(Exception e){
			System.out.println(e);
			Assert.fail();
			
			
		}
		}
		

	
}


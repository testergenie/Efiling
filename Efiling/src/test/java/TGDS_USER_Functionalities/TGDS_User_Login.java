package TGDS_USER_Functionalities;



	import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.Reporter;
	import org.testng.annotations.Test;
	import Base.Base;
import Base.ObjectRepository;
		


	public class TGDS_User_Login extends Base {
		String path =null;

			@Test(priority = 0, description = "login in TGDS admin Portal")
			public void LoginPage() throws Exception {
				
		
				try {	
					System.setProperty("org.uncommons.reportng.escape-output", "false");
					driver.manage().window().maximize();
					Thread.sleep(1000);
					path = Base.captureScreenShot("Login Page");
					
					Reporter.log("<a href="+path+">Login Page</a>");
					WebDriverWait wait = new WebDriverWait(driver,30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
					driver.findElement(By.xpath(ObjectRepository.username)).sendKeys("TGDSUSER1@tg.in"); 
					driver.findElement(By.xpath(ObjectRepository.password)).sendKeys("Dev@tg123");
					
					String Cap = driver.findElement(By.xpath(ObjectRepository.captcha)).getText();
					Reporter.log("Copied Captcha");
					driver.findElement(By.xpath(ObjectRepository.captchaText)).sendKeys(Cap);
					Reporter.log("Entered Captcha");
					driver.findElement(By.xpath(ObjectRepository.LogIn)).click();
					Reporter.log("Login Successful");
					Thread.sleep(3000);
					path = Base.captureScreenShot("TGDSLoggedIN");
					Reporter.log("<a href="+path+">TGDSLoggedIN</a>");
					
			
					Thread.sleep(3000);
					//LOC Selection
					driver.findElement(By.xpath("//tr[@class='ng-star-inserted']/td[6]/button/i")).click();	
					Thread.sleep(3000);
					//TGDS Admin Role selection	
					driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[2]/div[1]/a/div/div[1]/h2")).click();
					Thread.sleep(3000);
				}
				catch(Exception e){
					 Assert.fail();
					System.out.println(e);
				}
					
					
		/*		driver.findElement(By.xpath(prop.getProperty("LogIn"))).click();
					catch (Exception e)  {
				Reporter.getOutput();
				Assert.fail();
				}
*/
			}
			

			@Test(priority = 1	, description = "Select THE TGDS Admin work and create new SP ")
			
			public void CreateNewSP() throws Exception {
				try {
					Thread.sleep(3000);
					//Organisation Creation.
					driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/li[1]/a")).click();
					//SP
					driver.findElement(By.xpath("//ul[@class='nav navbar-nav navs ng-star-inserted']/li[1]/a")).click();
					//SP Details
					driver.findElement(By.xpath("//ul[@class='nav nav-tabs wizard']/li[1]/a")).click();
					Thread.sleep(3000);

					//Add New SP
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[1]/div[2]/div[1]/div/div/div/button")).click();

					//EnterGSTIN
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[1]/div/div/input")).sendKeys("27aadsp0123W2ZS");
					//CompanyName
					
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[2]/div/div/input")).sendKeys("auttestapzero");
					//Address
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[3]/div/div/textarea")).sendKeys("SPTESTER, Mumbai");
					//Pincode
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[4]/div/div/input")).sendKeys("500016");
					//state
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[5]/div/div/input")).sendKeys("Maharastra");
					//city
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[6]/div/div/input")).sendKeys("Mumbai");
					//persondesignation
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[7]/div/input")).sendKeys("Tester");
					
					
					//PersonName
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[8]/div/div/input")).sendKeys("TESTERSP");
					//MobileNO
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[9]/div/div/input")).sendKeys("5555555555");
					//Email
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[10]/div/div/input")).sendKeys("auttestapzero@tg.in");
					//Submit
					driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-sp-creation/div[4]/div/div/form/div/div[11]/button[1]")).click();
				
					path = Base.captureScreenShot("SP_Creation");
					
					Reporter.log("<a href="+path+">SP_Creation</a>");
					Thread.sleep(3000);
				} 
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Assert.fail();
				}
				
			}
			
@Test(priority = 2	, description = "CReate New SP User ")
			
			public void CreateSPUSER() throws Exception {
	
	try {
		//SPUsermanagement
		driver.findElement(By.xpath("//ul[@class='nav nav-tabs wizard']/li[4]/a")).click();
		
		path = Base.captureScreenShot("SPUSERMANAGEMENT");
		Reporter.log("<a href="+path+">SPUSERMANAGEMENT</a>");
		Thread.sleep(2000);
		//AddNewSPUser
		driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[1]/div/div/div/button")).click();
		Thread.sleep(2000);
		//SelectSP
		WebElement SelectSP = driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/ng-select/div/div/div[2]"));
		Select oSelect = new Select(SelectSP);

  		oSelect.selectByVisibleText("auttestapzero");
  		//Username
  		driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[1]/div/div/input")).sendKeys("AUTSPUSER");
  		driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[2]/div/div/input")).sendKeys("D");
  		//Email
  		driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[3]/div/div/input")).sendKeys("auttestapzero@tg.in");
  		//Password
  		driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[4]/div/div/input")).sendKeys("Dev@tg123");
  		//Mobile
  		driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[2]/div/div/form/div[2]/div[5]/div/div/input")).sendKeys("8888888888");
  		path = Base.captureScreenShot("SPUSERDATA");
		Reporter.log("<a href="+path+">SPUSERDATA</a>");
		
  		//Submit
  		driver.findElement(By.xpath("/html/body/app-root/app-tgdssp-user-creation/div[1]/div[2]/div[2]/div/div/form/div[3]/button[1]")).click();
  		Thread.sleep(3000);
  		
	}
	
	catch(Exception e) {
		
		
	Assert.fail();
	System.out.println(e);
	}
}
@Test(priority = 3	, description = "Sp User Role Mapping ")

public void SPUSERROLE() throws Exception {
	
	try {
		//SPCOMPANYMAPPING
		driver.findElement(By.xpath("//ul[@class='nav nav-tabs wizard']/li[4]/a")).click();
		Thread.sleep(2000);
		path = Base.captureScreenShot("SPCOMPANYMAPPING");
		Reporter.log("<a href="+path+">SPCOMPANYMAPPING</a>");
		//AddNewSpRole
		driver.findElement(By.xpath("/html/body/app-root/app-tgds-spmapping/div[1]/div[2]/div/div/div/button")).click();
		Thread.sleep(2000);

		WebElement selectsp = driver.findElement(By.xpath("/html/body/app-root/app-tgds-spmapping/div[2]/div/div/form/div[1]/div/div/div/ng-select/div"));
		WebElement Userlist = driver.findElement(By.xpath("/html/body/app-root/app-tgds-spmapping/div[2]/div/div/form/div[2]/div[1]/div/div/ng-select/div"));
		WebElement Rolelist = driver.findElement(By.xpath("/html/body/app-root/app-tgds-spmapping/div[2]/div/div/form/div[2]/div[2]/div/div/ng-select/div/div/div[2]"));
		
		Select Select1 = new Select(selectsp);
		Select Select2 = new Select(Userlist);
		Select Select3 = new Select(Rolelist);
		Select1.selectByVisibleText("auttestapzero");
		Select2.selectByVisibleText("AUTSPUSER");
		Select3.selectByVisibleText("SP Admin Role");

		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/app-root/app-tgds-spmapping/div[2]/div/div/div[2]/button[1]")).click();
		
		path = Base.captureScreenShot("MappedRole");
		Reporter.log("<a href="+path+">MappedRole</a>");
		Thread.sleep(2000);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		Assert.fail();
	}
	
}


			
			
			}



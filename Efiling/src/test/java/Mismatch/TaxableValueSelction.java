package Mismatch;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TaxableValueSelction {
	
	


	@Test
	public void TAXSELECT() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Efiling\\src\\test\\resources\\drivers\\chromedriver.exe");
	          	WebDriver driver = new ChromeDriver();
	          	JavascriptExecutor js = (JavascriptExecutor) driver;
				WebDriverWait wait = new WebDriverWait(driver,30);
				
				driver.get("http://13.233.174.232/");
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.findElement(By.id("user")).sendKeys("ceat.limited@taxgenie.in");
				driver.findElement(By.id("password")).sendKeys("preprod@tg");
				String captchaVal = driver.findElement(By.id("captcha")).getText();
//				String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
         		WebElement captcha = driver.findElement(By.id("captcha1"));
         		captcha.sendKeys(captchaVal);
         		wait.until(ExpectedConditions.elementToBeClickable(By.id("save")));
         		Thread.sleep(1000);
         		driver.findElement(By.id("save")).click();
         		driver.manage().window().maximize();
         		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"tax-filling-1\"]")));
         		Thread.sleep(10000);
         		driver.findElement(By.xpath("//*[@id=\"tax-filling-1\"]")).click();//Taxfiling Selection
         		driver.findElement(By.xpath("//tbody[@id='getallca']/tr[1]/td/a/span")).click();//Company Selection
         		Thread.sleep(5000);
         		driver.findElement(By.xpath("//div[@class='col-md-12']/div[2]/div/div/a")).click();//GSTR2
         		Thread.sleep(5000);
         		driver.findElement(By.linkText("Mismatch Reports")).click();//Mismatch Reports
         		Thread.sleep(2000);
         		WebElement FromDate = driver.findElement(By.id("fromDatepicker"));
         		Select FRMDT = new Select(FromDate);
         		FRMDT.selectByVisibleText("Aug 2017");
         		WebElement TODATE = driver.findElement(By.id("toDatepicker"));
         		Select todt = new Select(TODATE);
         		todt.selectByVisibleText("Aug 2017");
         		driver.findElement(By.id("submitButton")).click();
         		Thread.sleep(5000);
         		driver.findElement(By.id("btn_mismatch")).click();
//         		wait.until(ExpectedConditions.elementToBeClickable(By.id("btn_mismatch")));
         		Thread.sleep(5000);
         		driver.findElement(By.xpath("//*[@id=\"tbl_mismatched_filter\"]/label/input")).sendKeys("taxablevalue");
         		Thread.sleep(2000);
         		WebElement Count = driver.findElement(By.xpath("//*[@id=\"tbl_mismatched_length\"]/label/select"));
         		Select Cnt = new Select(Count);
         		Cnt.selectByVisibleText("100");
         		Thread.sleep(2000);
//         		String lastpage = driver.findElement(By.xpath("//*[@id=\"tbl_mismatched_paginate\"]/span/a[6]")).getText();
         		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
         		Thread.sleep(2000);
         		
         		String Noofpages = JOptionPane.showInputDialog("Please enter no of pages:");
         		int LP = Integer.parseInt(Noofpages);
         		
				for(int i=1; i<=LP; i++){
					try {
						for( int a=1; a<=100; a++) {
							try {
								String MismatchReason = driver.findElement(By.xpath("//table[@id='tbl_mismatched']/tbody/tr["+a+"]/td[38]")).getText();
								System.out.println(a +MismatchReason);
								if(MismatchReason .equalsIgnoreCase("taxableValue|")){
									driver.findElement(By.xpath("//table[@id='tbl_mismatched']/tbody/tr["+a+"]/td[1]")).click();
								
									}//if 
								
								}	//TRY	for a
						
							catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									break;
									}//CATCH for a
						}//For a
						
					driver.findElement(By.linkText("Next")).click();
					}//try for i
					catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						break;
					 	}//Catch for i 
			
			
				}//For i
         	try {
				driver.findElement(By.xpath("//*[@id=\"tbl_mismatched_wrapper\"]/div[1]/a[1]")).click();//Keep GSTR2A
				Thread.sleep(2000);
				driver.findElement(By.id("addRemarkForAction")).sendKeys("2ATESTTaxable");
				driver.findElement(By.id("addAndSkipRemark")).click();
				Thread.sleep(5000);
				
				wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='response_itc']/div[@id=\"response_modal\"]/div/div[1]/button")));
				driver.findElement(By.xpath("//div[@id='response_itc']/div[@id=\"response_modal\"]/div/div[1]/button")).click();
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
         		
				
				
				
				
				
				

}
}


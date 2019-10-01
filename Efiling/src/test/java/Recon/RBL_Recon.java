package Recon;

import static org.testng.Assert.assertEquals;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class RBL_Recon extends Base{
	@Test(priority = 0, description = "login in TG admin Portal")
	public void Login() throws Exception {
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
		
	try{	
	/*	//Username
		String Username = JOptionPane.showInputDialog("Please enter the Username:");
		driver.findElement(By.xpath(ObjectRepository.username)).sendKeys(Username);
		//Password
		String password = JOptionPane.showInputDialog("Please enter the Password:");
		driver.findElement(By.xpath(ObjectRepository.password)).sendKeys(password);*/
		
		driver.findElement(By.xpath(ObjectRepository.username)).sendKeys("ajay@taxgenie.in");
		driver.findElement(By.xpath(ObjectRepository.password)).sendKeys("Taxgenie@123");
		
		//Captcha
		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
		driver.findElement(By.xpath(ObjectRepository.captchaText)).sendKeys(captchaVal);
		driver.findElement(By.xpath(ObjectRepository.LogIn)).click();
	}//try
	
	catch (Exception e) {
		e.printStackTrace();
		System.out.println(e);
		Assert.fail("Unable to Login");
	}//Catch
		}//Login
	
	@Test(priority = 1, description = "Company Selection")
	public void Company_Select() throws Exception {
		By ORGCreation = By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[1]/div/table/thead/tr[1]/th[1]");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ORGCreation));
		
		try{
			WebElement Search = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/div/div/input"));
			String OrganisationName = JOptionPane.showInputDialog("Please enter the Organisation Name:");
			Search.sendKeys(OrganisationName);
			String a[] = new String [100];
			for (int i = 1; i <= 100; i++) {
				WebElement state = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr["+i+"]/td[3]"));
				if(state.isDisplayed()) {
					a[i] = state.getText();
					System.out.println("State Name"+a[i]);
					
				}//if
				else {
					break;
				}//else
			}//for
			System.out.println(a.length);
			
		
			
		}//try
		
		
		catch(Exception e){
			System.out.println(e);
		}
	
	
	
	
	
	
	
	
	
		}//Company Selection

}//RBL_Recon

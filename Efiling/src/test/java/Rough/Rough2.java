package Rough;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class Rough2 extends Base {
	public static String product;
	public static String path;

	@Test(priority = 0, description = "login done")
	public void Login() {

		try {
			Thread.sleep(3000);
			path = Base.captureScreenShot("LoginPage");
			System.out.println("path : " + path);
			Reporter.log("<a href=" + path + ">LoginPage</a>");
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));

			type_Xpath(ObjectRepository.username, "saurav@taxgenie.in");
			type_Xpath(ObjectRepository.password, "Taxgenie@123");
			String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
			type_Xpath(ObjectRepository.captchaText, captchaVal);
			Reporter.log("Entered Captcha");
			click_Xpath(ObjectRepository.LogIn);

			Reporter.log("Login Successful");
			Thread.sleep(3000);
			path = Base.captureScreenShot("LoggedIN");
			Reporter.log("<a href=" + path + ">LoggedIN</a>");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Test(priority = 1, description = "company selection tab")
	public void companySelection() {
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ObjectRepository.pageNo)));
		driver.findElement(By.xpath(ObjectRepository.lastPage)).click();
		String s=driver.findElement(By.xpath(ObjectRepository.lastpage1)).getText();
		System.out.println(s);
		
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * String[] date=
	 * {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17",
	 * "18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	 * String[] month= {"1","2","3","4","5","6","7","8","9","10","11","12"};
	 * String[] year={"2016","2017","2018","2019","2020"}; JComboBox jcd = new
	 * JComboBox(date); JComboBox jcm = new JComboBox(date); JComboBox jcy= new
	 * JComboBox(date); jcd.setEditable(true); jcm.setEditable(true);
	 * jcy.setEditable(true); JOptionPane.showMessageDialog( null, jcd, "Date",
	 * JOptionPane.QUESTION_MESSAGE); JOptionPane.showMessageDialog( null, jcm,
	 * "Month", JOptionPane.QUESTION_MESSAGE); JOptionPane.showMessageDialog( null,
	 * jcy, "Year", JOptionPane.QUESTION_MESSAGE);
	 * 
	 * 
	 * }
	 */}

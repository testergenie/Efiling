package ICEGATE;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;

public class IceGateLogin {
	
//	
//	XSSFWorkbook workbook;
//	
//	    XSSFSheet sheet;
//	
//	    XSSFCell cell;
	   
	   
	   


	public class IcegateLogin1 extends Base {
		String path =null;
		
		@Test(priority = 0, description = "Login to ICEGATE Portal")
		public void Icegateloginpage() throws Exception {
		
		
				System.setProperty("org.uncommons.reportng.escape-output", "false");
				driver.manage().window().maximize();
				Thread.sleep(1000);
				path = Base.captureScreenShot("Ice gate Login Page");
				Reporter.log("<a href="+path+">Ice gate Login Page</a>");
				WebDriverWait wait = new WebDriverWait(driver,30);
				//GOV.GST.in
			
				try
				{
				
				     File src=new File("E:\\ICEGATELOGIN\\Sample.xlsx");
				
				     //String excelFilePath = "Books.xlsx";
					FileInputStream finput = new FileInputStream(src);
						
	
					Workbook workbook = WorkbookFactory.create(finput);
				
						 Sheet sheet = workbook.getSheetAt(0); 
						 System.out.println("Sheet name: " + sheet.getSheetName().toString());
				
				     for( int i=1; i<= sheet.getLastRowNum(); i++)
				
				     {
								
				        Cell cell = sheet.getRow(i).getCell(0);
				
				         cell.setCellType(Cell.CELL_TYPE_STRING);
				
				         driver.findElement(By.id("username")).sendKeys(cell.getStringCellValue());
				

				         cell = sheet.getRow(i).getCell(1);
				
				         cell.setCellType(Cell.CELL_TYPE_STRING);
				
				         driver.findElement(By.id("user_pass")).sendKeys(cell.getStringCellValue());
				
				         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imgCaptcha")));
				
				String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
				WebElement captcha = driver.findElement(By.id("captcha"));
				
			
				
				captcha.sendKeys(captchaVal);
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-6 col-sm-6 col-xs-6']/button")).click();
				Thread.sleep(1000);
				
				

				
				
				Thread.sleep(5000);
				
				path = Base.captureScreenShot("LoggedIN");
		
				Reporter.log("<a href="+path+">LoggedIN</a>");
				WebElement Dashboard = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div/div[1]/div[5]/div/div/button"));
				Thread.sleep(2000);
			
				Thread.sleep(2000);
				Dashboard.click();
				Thread.sleep(5000);
				
//				String data = driver.findElement(By.cssSelector("table.table.table-striped.dptbl")).getText();
//				System.out.println(data);
				File path= new File("F:\\ICEGATENEW", "Data.xlsx");
				FileOutputStream fis=new FileOutputStream(path);
				XSSFWorkbook workbook1 = new XSSFWorkbook();
				XSSFSheet sheet1= workbook1.createSheet("Data1");
//				XSSFRow row =sheet1.createRow(0);
//				XSSFCell xssfcell= row.createCell(0);
//				xssfcell.setCellValue(data);
//				workbook1.write(fis);
//				fis.close();
				
				for( int a=1; a<= 5; a++)
				{
					
					String Header = driver.findElement(By.xpath("//div[@class='table-responsive']/table/thead/tr/th["+a+"]")).getText();
//					File path= new File("F:\\ICEGATENEW", "Data.xlsx");
//					FileOutputStream fis=new FileOutputStream(path);
//					XSSFWorkbook workbook1 = new XSSFWorkbook();
//					XSSFSheet sheet1= workbook1.createSheet("Data1");
					XSSFRow row =sheet1.createRow(0);
					XSSFCell xssfcell= row.createCell(a);
					System.out.println(Header);
					xssfcell.setCellValue(Header);
					workbook1.write(fis);
				
					Thread.sleep(1000);
					
				}
				
				  
				
				
		
			
//				
				
				
				Thread.sleep(2000);
				
				WebElement Dropdown = driver.findElement(By.xpath("/html/body/div[1]/ng-include[1]/header/div[2]/div/div/ul/li/div/a"));
				Thread.sleep(2000);
				
				Dropdown.click();
				driver.findElement(By.linkText("Logout")).click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("here")));
				driver.findElement(By.linkText("here")).click();

//				Select oSelect = new Select(Dropdown);	
//				
//				oSelect.selectByVisibleText(" Logout");
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
				     }
				
				
	}catch(Exception e)
			     {
   	 e.printStackTrace();
    }
				
				
				
			
				     }
		}

			
		}

		
	


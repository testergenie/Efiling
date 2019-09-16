package GOVGSTINSTATUS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JOptionPane;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Base.Base;

public class GSTINSTATUS extends Base {
	
	
	
		
		@Test
		public void PANSEARCH() throws Exception {
					WebDriverWait wait = new WebDriverWait(driver,30);
					driver.findElement(By.id("username")).sendKeys("rakeshdube17");
			

	
					driver.findElement(By.id("user_pass")).sendKeys("Regime@2019");
	
	         		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imgCaptcha")));
	         
	
	         		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
	         		WebElement captcha = driver.findElement(By.id("captcha"));
	

	
	         			captcha.sendKeys(captchaVal);
	         				Thread.sleep(2000);
	         			driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-6 col-sm-6 col-xs-6']/button")).click();
	
			
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			
				driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[5]/a")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[5]/ul[1]/li[2]/a")).click();
			

		File src=new File("E:\\ICEGATELOGIN\\Sample.xlsx");
			
			FileInputStream finput = new FileInputStream(src);
			
			
			Workbook workbook = WorkbookFactory.create(finput);

			 Sheet sheet = workbook.getSheetAt(0); 
			 System.out.println("Sheet name: " + sheet.getSheetName().toString());
			 File path= new File("F:\\ICEGATENEW", "PANDATANEW.xlsx");
			 FileOutputStream fis=new FileOutputStream(path);
			Workbook workbook1 = new XSSFWorkbook();
			workbook1.createSheet("Data1");
				
			try {
				
			
			 for( int i=1; i<= sheet.getLastRowNum(); i++) {
				 
				Cell cell = sheet.getRow(i).getCell(0);
					
		        cell.setCellType(Cell.CELL_TYPE_STRING);
		        driver.findElement(By.id("for_gstin")).clear();
		  
		
		        driver.findElement(By.id("for_gstin")).sendKeys(cell.getStringCellValue());
		        Thread.sleep(1000);
				driver.findElement(By.id("lotsearch")).click();
	
				String BeforeXpath_Sno = "//tbody/tr[";
				String AfterXpath_Sno = "]/td[1]";
				String BeforeXpath_GSTINNO = "//tbody/tr[";
				String AfterXpath_GSTINNO = "]/td[2]";
				
				String BeforeXpath_GSTINSTATUS = "//tbody/tr[";
				String AfterXpath_GSTINSTATUS = "]/td[3]";
				String BeforeXpath_State = "//tbody/tr[";
				String AfterXpath_State= "]/td[4]";
				
				for(int j=1; j<=100; j++){					
					Sheet sheet1= workbook1.getSheet("Data1");										
					try{
						for( int a=1; a<=10; a++ ){		

							int b = sheet1.getLastRowNum();
							Row row =sheet1.createRow(b+1);
						
							try {
								//Thread.sleep(1000);
								String ActualXpath_Sno = BeforeXpath_Sno + a + AfterXpath_Sno;
									row.createCell(0).setCellValue(cell.getStringCellValue());
								String Sno = driver.findElement(By.xpath(ActualXpath_Sno)).getText();
								System.out.println(Sno);
								String ActualXpath_GSTINNO = BeforeXpath_GSTINNO + a + AfterXpath_GSTINNO;
								String GSTINNO = driver.findElement(By.xpath(ActualXpath_GSTINNO)).getText();
								System.out.println(GSTINNO);
								String ActualXpath_GSTINSTATUS = BeforeXpath_GSTINSTATUS + a + AfterXpath_GSTINSTATUS;
								String GSTINSTATUS = driver.findElement(By.xpath(ActualXpath_GSTINSTATUS)).getText();
								System.out.println(GSTINSTATUS);
								String ActualXpath_STATE = BeforeXpath_State + a + AfterXpath_State;
								String STATE = driver.findElement(By.xpath(ActualXpath_STATE)).getText();
								System.out.println(STATE);
								Thread.sleep(1000);
						
								row.createCell(1).setCellValue(Sno);
								row.createCell(2).setCellValue(GSTINNO);
								row.createCell(3).setCellValue(GSTINSTATUS);
								row.createCell(4).setCellValue(STATE);
								
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								row.createCell(1).setCellValue("No Data further");
								break;
							}					
						}//for loop			
						
						WebElement next = driver.findElement(By.xpath("//ul[@class='pagination ng-table-pagination']/li["+(j+2)+"]/a"));
					
					
						next.click();
					}
				catch(Exception ex){
						System.out.println(ex);
						
						break;
					
				}
											
		 } 
 
	}//for( int i=1; i<= sheet.getLastRowNum(); i++) {
		
			 workbook1.write(fis);
				fis.close();

			}
			catch(Exception ex1) {
				
				System.out.println(ex1);
				
				
			}
		
	}//class
	


             @Test
              public void PANSEARCH1() throws Exception {
			WebDriverWait wait = new WebDriverWait(driver,30);
			driver.findElement(By.id("username")).sendKeys("rakeshdube17");
	


			driver.findElement(By.id("user_pass")).sendKeys("Regime@2019");

     		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("imgCaptcha")));
     

     		String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
     		WebElement captcha = driver.findElement(By.id("captcha"));



     			captcha.sendKeys(captchaVal);
     				Thread.sleep(2000);
     			driver.findElement(By.xpath("//div[@class='col-lg-6 col-md-6 col-sm-6 col-xs-6']/button")).click();

	
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	driver.manage().window().maximize();
	Thread.sleep(5000);
	
		driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[5]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[5]/ul[1]/li[2]/a")).click();
	

File src=new File("E:\\ICEGATELOGIN\\Sample.xlsx");
	
	FileInputStream finput = new FileInputStream(src);
	
	
	Workbook workbook = WorkbookFactory.create(finput);

	 Sheet sheet = workbook.getSheetAt(0); 
	 System.out.println("Sheet name: " + sheet.getSheetName().toString());
	 File path= new File("F:\\ICEGATENEW", "PANDATANEW1.xlsx");
	 FileOutputStream fis=new FileOutputStream(path);
	Workbook workbook1 = new XSSFWorkbook();
	workbook1.createSheet("Data1");
		
	try {
		
	
	 for( int i=1; i<= sheet.getLastRowNum(); i++) {
		 
		Cell cell = sheet.getRow(i).getCell(1);
			
        cell.setCellType(Cell.CELL_TYPE_STRING);
        driver.findElement(By.id("for_gstin")).clear();
  

        driver.findElement(By.id("for_gstin")).sendKeys(cell.getStringCellValue());
        Thread.sleep(1000);
		driver.findElement(By.id("lotsearch")).click();

		String BeforeXpath_Sno = "//tbody/tr[";
		String AfterXpath_Sno = "]/td[1]";
		String BeforeXpath_GSTINNO = "//tbody/tr[";
		String AfterXpath_GSTINNO = "]/td[2]";
		
		String BeforeXpath_GSTINSTATUS = "//tbody/tr[";
		String AfterXpath_GSTINSTATUS = "]/td[3]";
		String BeforeXpath_State = "//tbody/tr[";
		String AfterXpath_State= "]/td[4]";
		
		for(int j=1; j<=100; j++){					
			Sheet sheet1= workbook1.getSheet("Data1");										
			try{
				for( int a=1; a<=10; a++ ){		

					int b = sheet1.getLastRowNum();
					Row row =sheet1.createRow(b+1);
				
					try {
						//Thread.sleep(1000);
						String ActualXpath_Sno = BeforeXpath_Sno + a + AfterXpath_Sno;
							row.createCell(0).setCellValue(cell.getStringCellValue());
						String Sno = driver.findElement(By.xpath(ActualXpath_Sno)).getText();
						System.out.println(Sno);
						String ActualXpath_GSTINNO = BeforeXpath_GSTINNO + a + AfterXpath_GSTINNO;
						String GSTINNO = driver.findElement(By.xpath(ActualXpath_GSTINNO)).getText();
						System.out.println(GSTINNO);
						String ActualXpath_GSTINSTATUS = BeforeXpath_GSTINSTATUS + a + AfterXpath_GSTINSTATUS;
						String GSTINSTATUS = driver.findElement(By.xpath(ActualXpath_GSTINSTATUS)).getText();
						System.out.println(GSTINSTATUS);
						String ActualXpath_STATE = BeforeXpath_State + a + AfterXpath_State;
						String STATE = driver.findElement(By.xpath(ActualXpath_STATE)).getText();
						System.out.println(STATE);
						Thread.sleep(1000);
				
						row.createCell(1).setCellValue(Sno);
						row.createCell(2).setCellValue(GSTINNO);
						row.createCell(3).setCellValue(GSTINSTATUS);
						row.createCell(4).setCellValue(STATE);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						row.createCell(1).setCellValue("No Data further");
						break;
					}					
				}//for loop			
				
				WebElement next = driver.findElement(By.xpath("//ul[@class='pagination ng-table-pagination']/li["+(j+2)+"]/a"));
			
			
				next.click();
			}
		catch(Exception ex){
				System.out.println(ex);
				
				break;
			
		}
									
 } 

}//for( int i=1; i<= sheet.getLastRowNum(); i++) {

	 workbook1.write(fis);
		fis.close();

	}
	catch(Exception ex1) {
		
		System.out.println(ex1);
		
		
	}

}//class
}

	

	
	



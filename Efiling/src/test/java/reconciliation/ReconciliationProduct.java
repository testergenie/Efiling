package reconciliation;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class ReconciliationProduct extends Base {
	public static String product;
	public static String path;

	@Test(priority = 0, description = "login done")
	public void Login() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			path = Base.captureScreenShot("LoginPage");
			System.out.println("path : " + path);
			Reporter.log("<a href=" + path + ">LoginPage</a>");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));

			type_Xpath(ObjectRepository.username, "ajay@taxgenie.in");
			type_Xpath(ObjectRepository.password, "Taxgenie@123");
			String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
			type_Xpath(ObjectRepository.captchaText, captchaVal);
			Reporter.log("Entered Captcha");
			click_Xpath(ObjectRepository.LogIn);

			Reporter.log("Login Successful");
			path = Base.captureScreenShot("LoggedIN");
			Reporter.log("<a href=" + path + ">LoggedIN</a>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 1, description = "company selection tab")
	public void companySelection() {
		By ORGCreation = By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[1]/div/table/thead/tr[1]/th[1]");
		WebDriverWait wait = new WebDriverWait(driver, 30);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(ORGCreation));
		try{
			WebElement Search = driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/div/div/input"));
			String GSTIN_NO = JOptionPane.showInputDialog("Please enter the GSTIN NO");
			Search.sendKeys(GSTIN_NO);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/app-root/div/div/div/div/app-main-login/div[1]/div/div/div/p-table/div/div/div/div[2]/table/tbody/tr[1]/td[8]/button")).click();
		
			path = Base.captureScreenShot("WorkOnThis");
			Reporter.log("<a href=" + path + ">WorkOnThis</a>");
		} catch (Exception e) {
			e.printStackTrace();
			
		}

		
	}

	@Test(priority = 2, description = "recon product selected")
	public void ReconProduct() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 120);
			for (int i = 1; i < 13; i++) {

				product = driver
						.findElement(By.xpath(
								"/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i + "]/a/div/h2"))
						.getText();
				System.out.println(product);
				if (product.equals("RECONCILIATION")) {
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
							"/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i + "]/a/div/h2")));
					driver.findElement(By.xpath(
							"/html/body/app-root/div/div/div/div/app-product-page/div[2]/div[" + i + "]/a/div/h2"))
							.click();
					break;
				}

			}
			path = Base.captureScreenShot(product);
			Reporter.log("<a href=" + path + ">" + product + "</a>");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 3, description = "selecting financial year and month   ")
	public void periodforRecon() {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		try {
			Thread.sleep(2000);
			driver.findElement(By.xpath(ObjectRepository.reconFY)).click();
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-reconcilation/div[1]/div/div/div/div[5]/table/tbody/tr/td[1]/b")));
			String[] FINYEAR = {"2017-2018", "2018-2019", "2019-2020"};
		    String fininput = (String) JOptionPane.showInputDialog(null, "Choose Financial Period Now now...",
		        "The Choice of a Financial Year", JOptionPane.QUESTION_MESSAGE, null, // Use
		                                                                        // default
		                                                                        // icon
		        FINYEAR, // Array of choices
		        FINYEAR[1]); // Initial choice
			for (int i = 1; i < 3; i++) {

				product = driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				
				
				
				
				if (product.equals(fininput)) {
					driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[1]/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}
			}
			Thread.sleep(2000);
			driver.findElement(By.xpath(ObjectRepository.reconM1)).click();
			Thread.sleep(2000);
			
			if(fininput=="2017-2018") {
				String[] M1 = {"July 2017", "Aug 2017", "Sep 2017","Oct 2017","Nov 2017","Dec 2017","Jan 2018","Feb 2018","Mar 2018"};
			    String M1Inp = (String) JOptionPane.showInputDialog(null, "Choose From Month  Now...",
			        "The Choice of a From Month", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                        // default
			                                                                        // icon
			        M1, // Array of choices
			        M1[1]); // Initial choice
			
			for (int i = 1; i < 12; i++) {

				product = driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				
				
				
				if (product.equals(M1Inp)) {
					driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}

			}
			}//if(fininput=="2017-2018")
			else if(fininput=="2018-2019") {
				String[] M1 = {"Apr 2018","May 2018","Jun 2018","July 2018", "Aug 2018", "Sep 2018","Oct 2018","Nov 2018","Dec 2018","Jan 2019","Feb 2019","Mar 2019"};
			    String M1Inp = (String) JOptionPane.showInputDialog(null, "Choose From Month  Now...",
			        "The Choice of a From Month", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                        // default
			                                                                        // icon
			        M1, // Array of choices
			        M1[1]); // Initial choice
			
			for (int i = 1; i < 12; i++) {

				product = driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				
				
				
				if (product.equals(M1Inp)) {
					driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}

			}
			}//if(fininput=="2018-2019")
			else if(fininput=="2019-2020") {
				String[] M1 = {"Apr 2019","May 2019","Jun 2019","July 2019", "Aug 2019", "Sep 2019","Oct 2019","Nov 2019","Dec 2019","Jan 2020","Feb 2020","Mar 2020"};
			    String M1Inp = (String) JOptionPane.showInputDialog(null, "Choose From Month  Now...",
			        "The Choice of a From Month", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                        // default
			                                                                        // icon
			        M1, // Array of choices
			        M1[1]); // Initial choice
			
			for (int i = 1; i < 12; i++) {

				product = driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				
				
				
				if (product.equals(M1Inp)) {
					driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}//if
				else {
					   JFrame parent = new JFrame();

					    JOptionPane.showMessageDialog(parent, "Invalid Month Selection");
				}

			}
			}//if(fininput=="2019-2020")
			
			Thread.sleep(1000);
			driver.findElement(By.xpath(ObjectRepository.reconM2)).click();
			Thread.sleep(1000);
			if(fininput=="2017-2018") {
				String[] M1 = {"July 2017", "Aug 2017", "Sep 2017","Oct 2017","Nov 2017","Dec 2017","Jan 2018","Feb 2018","Mar 2018"};
			    String M1Inp = (String) JOptionPane.showInputDialog(null, "Choose From Month  Now...",
			        "The Choice of a From Month", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                        // default
			                                                                        // icon
			        M1, // Array of choices
			        M1[1]); // Initial choice
			
				for (int i = 1; i < 12; i++) {

					product = driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
									+ i + "]/span"))
							.getText();
					if (product.equals(M1Inp)) {
						driver.findElement(By.xpath(
								"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
										+ i + "]/span"))
								.click();
						break;
					}

				}
				
			}//if(fininput=="2017-2018")
			else if(fininput=="2018-2019") {
				String[] M1 = {"Apr 2018","May 2018","Jun 2018","July 2018", "Aug 2018", "Sep 2018","Oct 2018","Nov 2018","Dec 2018","Jan 2019","Feb 2019","Mar 2019"};
			    String M1Inp = (String) JOptionPane.showInputDialog(null, "Choose From Month  Now...",
			        "The Choice of a From Month", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                        // default
			                                                                        // icon
			        M1, // Array of choices
			        M1[1]); // Initial choice
			
				for (int i = 1; i < 12; i++) {

					product = driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
									+ i + "]/span"))
							.getText();
					if (product.equals(M1Inp)) {
						driver.findElement(By.xpath(
								"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
										+ i + "]/span"))
								.click();
						break;
					}

				}
				
			}//if(fininput=="2018-2019")
			else if(fininput=="2019-2020") {
				String[] M1 = {"Apr 2019","May 2019","Jun 2019","July 2019", "Aug 2019", "Sep 2019","Oct 2019","Nov 2019","Dec 2019","Jan 2020","Feb 2020","Mar 2020"};
			    String M1Inp = (String) JOptionPane.showInputDialog(null, "Choose From Month  Now...",
			        "The Choice of a From Month", JOptionPane.QUESTION_MESSAGE, null, // Use
			                                                                        // default
			                                                                        // icon
			        M1, // Array of choices
			        M1[1]); // Initial choice
			
				for (int i = 1; i < 12; i++) {

					product = driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
									+ i + "]/span"))
							.getText();
					if (product.equals(M1Inp)) {
						driver.findElement(By.xpath(
								"//app-reconcilation/div[1]/div/div/div/div[3]/app-vendor-date-picker/div/div[3]/ng-select/ng-dropdown-panel/div/div/div["
										+ i + "]/span"))
								.click();
						break;
					}//if
					else {
						   JFrame parent = new JFrame();

						    JOptionPane.showMessageDialog(parent, "Invalid Month Selection");

				}
				}//For
				
			}//if(fininput=="2019-2020")
				Thread.sleep(2000);
		
			Thread.sleep(2000);
			driver.findElement(By.xpath("//app-reconcilation/div/div/div/div/div[3]/div/button")).click();
			wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//app-reconcilation/div[1]/div/div/div/div[5]/table/tbody/tr[7]/td[10]/button")));
			// table data in recon
			driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[5]/table/tbody/tr[7]/td[10]"))
					.click();
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[1]/div[4]/div/div/table/tbody/tr[1]/td[2]")));
			driver.findElement(By.xpath(
					"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[1]/div[3]/div[2]/button[3]"))
					.click();
			
			//Vendor Selection
			WebElement Search1 = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[2]/div[2]/div/div/input"));

			String VendorName = JOptionPane.showInputDialog("Please enter the Vendor/Suppl GSTIN NO:");
			Search1.sendKeys(VendorName);
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
					"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[3]/div/div/table/tbody/tr[1]/td[5]/button")));
			
			
			
			String TotalGSTR2A = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[3]/div/div/table/tbody/tr[1]/td[3]")).getText();
			int TotalGSTR2A1 = Integer.parseInt(TotalGSTR2A);
			
			int TotalGSTR2AQ = TotalGSTR2A1/10;
			int TotalGSTR2AR = TotalGSTR2A1%10;
			int gstr2apage;
			if (TotalGSTR2AR == 0) {
				gstr2apage=TotalGSTR2AQ;
			}//ifTotal
			else {
				 gstr2apage=TotalGSTR2AQ+1;
			}
			
			String TotalPur = driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[3]/div/div/table/tbody/tr[1]/td[4]")).getText();
			int TotalPur1 = Integer.parseInt(TotalPur);
			int LPRI = Integer.parseInt(TotalPur.substring(TotalPur.length()-1));
			
			int TotalPur1Q = TotalPur1/10;
			int TotalPur1R = TotalPur1%10;
			int PRpage;
			if (TotalPur1R == 0) {
				PRpage=TotalPur1Q;
			}//ifTotal
			else {
				PRpage=TotalPur1Q+1;
			}
			
			
			
			driver.findElement(By.xpath(
					"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[1]/div[3]/div/div/table/tbody/tr[1]/td[5]/button"))
					.click();
			Thread.sleep(3000);
			
			
			
			
			// manual match final page

			WebElement gst2a = driver.findElement(By.xpath(
					"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/h4/strong"));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", gst2a);
			
			


//			String PRpages = JOptionPane.showInputDialog("Please enter the Last Page No in Purchase Table:");
//			int PRpage = Integer.parseInt(PRpages);

			for (int k = 1; k <= gstr2apage; k++) {

				for (int i = 1; i <= 10; i++) {

					/*
					 * String date1 =driver.findElement(By.xpath(
					 * "//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["
					 * +i+"]/td[5]")).getText();
					 * 
					 * driver.findElement(By.xpath(
					 * "//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["
					 * +i+"]/td[5]")).click();
					 */
					String finyear = driver.findElement(By.xpath(
							"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+ i + "]/td[4]")).getText();
					driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+ i + "]/td[4]")).click();

					for (int u = 1; u <= PRpage; u++) {
						try {
							if (u != PRpage) {
							for (int j = 1; j <= 10; j++) {
								try {
									String finyear23 = driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+ j + "]/td[4]")).getText();
									/*
									 * String date2 = driver.findElement(By.xpath(
									 * "//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/div[2]/div/div[2]/table/tbody/tr["
									 * +j+"]/td[5]")).getText();
									 */
											
									if (finyear.equals(finyear23)) {
										try {
											driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+ j + "]/td[5]")).click();

											String invoiceValue = driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[1]/div/div/table/thead/tr[2]/td[1]")).getText();
											String invRep = invoiceValue.replace(",", "");
											System.out.println(invRep);
											double invVal = Double.parseDouble(invRep);
											System.out.println(invVal);
											String taxableValue = driver.findElement(By.xpath(
													"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[1]/div/div/table/thead/tr[2]/td[2]"))
													.getText();
											String tax = taxableValue.replace(",", "");
											System.out.println(tax);
											double taxVal = Double.parseDouble(tax);
											System.out.println(taxVal);
											String round = driver
													.findElement(
															By.xpath("//app-reconcilation/div[1]/div/div/div/div[1]/div/p[3]"))
													.getText();
											System.out.println(round);
											String splitround[] = round.split(" ");
											System.out.println(splitround[splitround.length - 1]);
											double roundoff = Double.parseDouble(splitround[splitround.length - 1]);
											double nroundoff = Double.parseDouble("-" + splitround[splitround.length - 1]);
											System.out.println(nroundoff + "   " + roundoff);
											/*WebElement lastRow = driver.findElement(By.xpath(
													"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr[10]/td[4]"));
											WebElement lastRow1 = driver.findElement(By.xpath(
													"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr[10]/td[4]"));*/

											/*
											 * if(lastRow.equals(lastRow1)) {
											 * 
											 * driver.findElement(By.xpath(
											 * "//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/p-paginator/div/a[3]/span"
											 * )).click(); if(invVal >= nroundoff && invVal <=roundoff && taxVal >=
											 * nroundoff && taxVal <= roundoff) { Base.matchMethod(); } } else
											 */ if (invVal >= nroundoff && invVal <= roundoff && taxVal >= nroundoff
													&& taxVal <= roundoff) {
												 Robot r = new Robot();
													r.keyPress(KeyEvent.VK_TAB);
													r.keyRelease(KeyEvent.VK_TAB);

													r.keyPress(KeyEvent.VK_TAB);
													r.keyRelease(KeyEvent.VK_TAB);

													r.keyPress(KeyEvent.VK_TAB);
													r.keyRelease(KeyEvent.VK_TAB);
													
													r.keyPress(KeyEvent.VK_ENTER);
													r.keyRelease(KeyEvent.VK_ENTER);
													//Submit
												driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[3]/div/div/form/div[2]/button[1]")).click();
												Thread.sleep(1000);	
												//Close
												driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[6]/div/div/div[3]/button")).click();
												
												//Selecting 2a Again
												driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+ i + "]/td[4]")).click();
												Thread.sleep(1000);
											}//if
											 else {
												System.out.println("no match for the system");

											}
										} catch (Exception e) {
											e.printStackTrace();
											// TODO: handle exception
										}

									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

							} // this for main for look int j
							}//!=if
							else {
								
								int k1 = LPRI;
								for (int j2 = 1; j2 <= k1; j2++) {
									String finyear2 = driver.findElement(By.xpath(
											"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/div[2]/div/div[2]/table/tbody/tr["
													+ j2 + "]/td[4]"))
											.getText();

									if (finyear.equals(finyear2)) {
										try {
											driver.findElement(By.xpath(
													"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/div[2]/div/div[2]/table/tbody/tr["
															+ j2 + "]/td[5]"))
													.click();

											String invoiceValue = driver.findElement(By.xpath(
													"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[1]/div/div/table/thead/tr[2]/td[1]"))
													.getText();
											String invRep = invoiceValue.replace(",", "");
											System.out.println(invRep);
											double invVal = Double.parseDouble(invRep);
											System.out.println(invVal);
											String taxableValue = driver.findElement(By.xpath(
													"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[1]/div/div/table/thead/tr[2]/td[2]"))
													.getText();
											String tax = taxableValue.replace(",", "");
											System.out.println(tax);
											double taxVal = Double.parseDouble(tax);
											System.out.println(taxVal);
											String round = driver
													.findElement(By.xpath(
															"//app-reconcilation/div[1]/div/div/div/div[1]/div/p[3]"))
													.getText();
											System.out.println(round);
											String splitround[] = round.split(" ");
											System.out.println(splitround[splitround.length - 1]);
											double roundoff = Double.parseDouble(splitround[splitround.length - 1]);
											double nroundoff = Double.parseDouble("-" + splitround[splitround.length - 1]);
											System.out.println(nroundoff + "   " + roundoff);
											if (invVal >= nroundoff && invVal <= roundoff && taxVal >= nroundoff
													&& taxVal <= roundoff) {
												Base.matchMethod();
												//Submit
												driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[3]/div/div/form/div[2]/button[1]")).click();
												Thread.sleep(1000);
													//Close
												driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[6]/div/div/div[3]/button")).click();
										
												//Selecting 2a Again
												driver.findElement(By.xpath("//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/div[2]/div/div[2]/table/tbody/tr["+ i + "]/td[4]")).click();
												Thread.sleep(1000);
											} 
											else {
												System.out.println("no match for the system");

											}
										} catch (Exception e) {
											e.printStackTrace();
											// TODO: handle exception
										}

									}

								}

							
								
							}//else Last Invoice/page

							driver.findElement(By.xpath(
									"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/p-paginator/div/a[3]/span"))
									.click();
						}//try for u
						catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}//Catch for u
					} // end of u
					driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[2]/p-table/div/p-paginator/div/a[1]/span")).click();
				} // this for main for look int i
				driver.findElement(By.xpath(
						"//app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/p-paginator/div/a[3]/span"))
						.click();
			} // this end is for k

//	driver.findElement(By.xpath("//*[@id=\"setFootertopmargin\"]/app-reconcilation/div[1]/div/div/div/div[9]/app-gstr2a-pending/div[2]/app-seller-wise/div[2]/app-manual-matching/div/div[3]/div[1]/p-table/div/p-paginator/div/span/a[2]")).click();

		} // this close is for test priorty 3
		
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	
	}
}


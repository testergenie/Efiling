package GSTR1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.Base;
import Base.ObjectRepository;

public class Upload extends Base {

	@Test(priority = 1, description = "testing the upload for purchase")
	public static void purchaseUpload() {

		try {

			// selecting template for purchase
			Thread.sleep(3000);
			driver.findElement(By.xpath(ObjectRepository.temclick)).click();
			Thread.sleep(3000);
			for (int i = 1; i <= 3; i++) {
				String year = driver.findElement(By.xpath(
						"//app-upload-data/div/div[1]/div/div/div/div[2]/div[1]/div/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				System.out.println(year);
				if (year.equals("Upload From Excel Template")) {
					driver.findElement(By.xpath(
							"//app-upload-data/div/div[1]/div/div/div/div[2]/div[1]/div/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}
			}
			Thread.sleep(3000);

			// selecting financial year
			driver.findElement(By.xpath(ObjectRepository.finyearclick)).click();
			Thread.sleep(3000);
			for (int i = 1; i <= 3; i++) {
				String finyear = driver.findElement(By.xpath(
						"//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[1]/ng-select/ng-dropdown-panel/div[1]/div[2]/div["
								+ i + "]/span"))
						.getText();
				System.out.println(finyear);
				if (finyear.equals("2017-2018")) {
					driver.findElement(By.xpath(
							"//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[1]/ng-select/ng-dropdown-panel/div[1]/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
				}

			}
			Thread.sleep(3000);

			// selecting financial month
			driver.findElement(By.xpath(ObjectRepository.MONTHCLICK)).click();
			Thread.sleep(3000);
			for (int i = 1; i < 24; i++) {
				String month = driver.findElement(By.xpath(
						"//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
								+ i + "]/span"))
						.getText();
				System.out.println(month);
				if (month.equals("Dec 2017")) {
					driver.findElement(By.xpath(
							"//app-upload-data/div/div[1]/div/div/app-datepicker/div/div[2]/ng-select/ng-dropdown-panel/div/div[2]/div["
									+ i + "]/span"))
							.click();
					break;
					
				}
			}
			Thread.sleep(3000);
			// getting the url of file to insert into portal
			String te = urlMethod();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath(ObjectRepository.chooseFile)).click();
			Thread.sleep(3000);

			Base.fileChooser(te);
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

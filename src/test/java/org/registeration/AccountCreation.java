package org.registeration;

import java.io.IOException;

import org.junit.Assert;
import org.pom.PojoClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.util.Utility;

public class AccountCreation extends PojoClass {
	
	@BeforeMethod
	private void setup() {

		toLanuchBrowser();
		lanuchUrl("https://login.yahoo.com/account/create?.intl=us&specId=yidReg&done=https%3A%2F%2Fwww.yahoo.com");
		toMaximizeWindow();
		toApplyWait(20);
	}

	@AfterMethod
	private void tearDown() {
		toQuit();
	}
	
	
	
	
	@Test(dataProvider="regData")
	private void tc001(String firstName,String lastName,String emailId,String pass,String countryCode,String phoneNo,String month,
							String day,String year,String gender) throws InterruptedException, IOException {

		PojoClass p=new PojoClass();
		toFillTextBox(p.getFirstName(),firstName);
		toFillTextBox(p.getLastName(),lastName);
		toFillTextBox(p.getEmailId(), emailId);
		toFillTextBox(p.getPass(), pass);
		toselect(p.getCountryCode(),countryCode);
		toFillTextBox(p.getPhoneNo(), phoneNo);
		toselect(p.getBirthMonth(),month);
		toFillTextBox(p.getBirthDay(), day);
		toFillTextBox(p.getBirthYear(), year);
		toFillTextBox(p.getGender(), gender);
		toClick(p.getContinueBtn());
		
		toTakeScreenShot("Register Details");
				
		
		String url=driver.getCurrentUrl();
		
		
		Thread.sleep(5000);
		
		Assert.assertTrue("Registeration moved to next page",url.contains("recaptcha") );
		
	
		
		
		
		
	}
	
	@DataProvider(name="regData")
	public String[][] data() throws IOException{
		
		String path="C:\\Users\\sankar\\eclipse-workspace1\\Yahoo\\Excel\\TEST DATA.xlsx";
		
		Utility util=new Utility(path);
		
		int totalRows = util.getRowCount("Sheet1");
		int totalcols = util.getCellCount("Sheet1", 1);
		
		
		
		
		String[][] regData = new String[totalRows][totalcols];
		
		for (int i = 1; i <=totalRows; i++) {
			
			for (int j = 0; j <totalcols ; j++) {
				
				 regData[i-1][j]=util.getCellData("Sheet1", i, j);
				
			}
		}
				
				
		
		
		return regData;
	}
	

}

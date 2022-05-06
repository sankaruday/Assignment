package org.registeration;

import java.io.IOException;


import org.openqa.selenium.support.ui.Select;
import org.pom.PojoClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class phoneNoInCorrect extends PojoClass {

	
	
	
	@Test
	private void tc002() throws InterruptedException, IOException {
		

		PojoClass p=new PojoClass();
		
		Select s=new Select(p.getCountryCode());
		s.selectByVisibleText("India ‪(+91)‬");
				
		toFillTextBox(p.getPhoneNo(), "94426226085");
		toClick(p.getContinueBtn());
		
		toScrollDown(p.getContinueBtn());
		
		Thread.sleep(5000);
		toTakeScreenShot("inCorrectMobilenumber");
	}
	
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
	

}

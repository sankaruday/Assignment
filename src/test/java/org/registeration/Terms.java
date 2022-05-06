package org.registeration;

import java.io.IOException;

import org.pom.PojoClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Terms extends PojoClass {

	@Test
	private void tc003() throws InterruptedException, IOException {

		PojoClass p = new PojoClass();
		toClick(p.getTermsBtn());

		Thread.sleep(10000);
		toTakeScreenShot("TermsPage");
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
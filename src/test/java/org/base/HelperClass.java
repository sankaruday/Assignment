package org.base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import io.github.bonigarcia.wdm.WebDriverManager;

public class HelperClass {
	
	public static WebDriver driver;
	
	
	
	
	public static void toLanuchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
	}
	
	public static void lanuchUrl(String url) {

		driver.get(url);
	}

	public static void toMaximizeWindow() {

		driver.manage().window().maximize();
	}

	public static void toApplyWait(int time) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));

	}

	public static void toGetTitle() {

		driver.getTitle();
	}

	public static void toGetUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void toQuit() {

		driver.quit();
	}

	public static void toClose() {

		driver.close();
	}

	public static void toFillTextBox(WebElement e, String value) {
		
		e.clear();

		e.sendKeys(value);

	}

	public static void toClick(WebElement e) {

		e.click();
	}

	public static void toTakeScreenShot(String filename) throws IOException {

		TakesScreenshot tk=(TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\sankar\\eclipse-workspace1\\Yahoo\\screenshots\\"+filename+".png");
		FileUtils.copyFile(src, des);
	}
	
	public static void toselect(WebElement e,String value) {

		Select s=new Select(e);
		s.selectByValue(value);
		
	}
	
	public static void toBack() {

		driver.navigate().back();
	}
	
	public static void toScrollDown(WebElement pagedown) {

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", pagedown);
	}
}

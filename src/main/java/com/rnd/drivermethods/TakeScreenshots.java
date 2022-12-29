package com.rnd.drivermethods;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeScreenshots {

	public static void main(String[] args) throws IOException, InterruptedException {
		/**
		 * Sample Code to Take Screenshot in Selenium
		 */
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launch URL
		driver.get("http://google.com");
		
		//To Take Screenshot if Entire Browser Screen
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File ("./screenshots/image1.png"));
		Thread.sleep(3000);
		
		//To take Screenshot of Particular WebElement
		WebElement element = driver.findElement(By.cssSelector(".lnXdpd"));
		
		File elementsrc = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(elementsrc,new File ("./screenshots/Element.png"));
		Thread.sleep(3000);
		driver.quit();
		
	}
  
}

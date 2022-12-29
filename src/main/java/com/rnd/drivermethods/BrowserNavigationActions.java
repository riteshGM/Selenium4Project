package com.rnd.drivermethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserNavigationActions {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Navigation Methods and Getter Methods for Driver
		 */
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launch URL
		driver.get("http://google.com");
		System.out.println(driver.getWindowHandle());
		Thread.sleep(2000);
		//Other way to load a URL in current Browser tab
		driver.navigate().to("https://automationstepbystep.com/");
		//Get Current URL
		System.out.println(driver.getCurrentUrl());
		//Get Title of Page
		System.out.println(driver.getTitle());
		//Get Window Handle
		//Even if URL changes Window Handle ID remains same
		System.out.println(driver.getWindowHandle());
		//Go Back in history
		driver.navigate().back();
		Thread.sleep(2000);
		//Go forward in history
		driver.navigate().forward();
		Thread.sleep(2000);
		//Refresh the Page
		driver.navigate().refresh();
		Thread.sleep(10000);
		//Closed Window which is in current focus
		//driver.close();
		//Closes Everything all browser windows opened by driver
		driver.quit();
	}

}

package com.rnd.drivermethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windows {

	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * Windows switch Sample
		 */
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launch URL
		driver.get("http://google.com");
		System.out.println(driver.getWindowHandle());
		Thread.sleep(2000);
		String originalWindowHandle = driver.getWindowHandle();
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(2000);
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(2000);
		//Switch Focus back to Original Window
		driver.switchTo().window(originalWindowHandle);
		//Close Currently focused browser window only
		//driver.close();
		Thread.sleep(10000);
		//Closes Everything all browser windows opened by driver
		driver.quit();
	}

}

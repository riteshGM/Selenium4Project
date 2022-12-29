package com.rnd.drivermethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		
		/**
		 * Frames Switch Sample
		 */
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Frames Sample
		driver.navigate().to("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.switchTo().frame("packageFrame");
		Thread.sleep(2000);
		driver.findElement(By.linkText("Action")).click();
		System.out.println(driver.getTitle());
		//Switch Back to Top Level Content
		driver.switchTo().defaultContent();
		Thread.sleep(10000);
		//Closes Everything all browser windows opened by driver
		driver.quit();

	}

}

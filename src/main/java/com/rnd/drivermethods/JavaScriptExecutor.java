package com.rnd.drivermethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException {
		/**
		 * Java Script Executor Sample
		 */
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launch URL
		driver.get("http://google.com");
		JavascriptExecutor js = (JavascriptExecutor)driver;

		WebElement button = driver.findElement(By.name("btnI"));

		js.executeScript("arguments[0].click();",button);
		Thread.sleep(10000);
		if(driver.getTitle().equals("Google Doodles")) {
			System.out.println("Title Matched");	
		}else {
			System.out.println("Title Not Matched");
		}

		driver.quit();


	}

}

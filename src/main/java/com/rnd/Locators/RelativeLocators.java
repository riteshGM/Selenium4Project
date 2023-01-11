package com.rnd.Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(20));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Launch URL
		driver.get("https://opensource-demo.orangehrmlive.com");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebElement element = driver.findElement(By.id("btnLogin"));
	
		//Find Element Using Relative Locator
		/**
		 * Used when you know common property of WebElements using which you can pick one WebElement and 
		 * Search other Relative WebElements 
		 * leftOf, rightOf,below, above are the methods we have
		 */
		driver.findElement(RelativeLocator.with(By.tagName("input")).above(element)).sendKeys("1234");
	}

}

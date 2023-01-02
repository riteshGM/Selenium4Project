package com.rnd.drivermethods;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {

	public static void main(String[] args) {
		/**
		 * Java Script Executor Sample
		 */
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launch URL
		driver.get("http://google.com");
		

	}

}

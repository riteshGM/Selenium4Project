package com.rnd.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Launch URL
		driver.get("https://trytestingthis.netlify.app/");

		/**
		 * Implicit Waits - Applied at driver session Level
		 * default Polling frequency = 500ms
		 */
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		/**
		 * Explicit Waits - Applied at WebElement Level
		 * default Polling Frequency = 500ms
		 * One thing to Learn here - When you want to use Explicit Wait
		 * you should locate your element there itself. It doesn't make any sense to do findElement and then try for Explicity wait on it.
		 *  Point to Note if you give Implicit Wait of 10 Seconds and Explicit Waits of 5 Seconds = 10+5 = 15 will be total time wait.
		 */
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("fname"))).sendKeys("FirstName");
		
		/**
		 *FluentWait - Applied at WebElement Level
		 * User can provide explicit Polling Frequency
		 * You Can also provide which Exception to Ignore during polling 
		 * 
		 */
		
		Wait <WebDriver> fluentWait = new FluentWait<WebDriver> (driver)
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.withTimeout(Duration.ofSeconds(5));
		
		fluentWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lname"))).sendKeys("LastName");
		
		driver.quit();



	}

}

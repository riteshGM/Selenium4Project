package com.rnd.seleniumpuzzles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Write a Program to check if WebElement is Underlined
 * @author rites
 *
 */
public class CheckWebElementUnderlined {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/?gfe_rd=ctrl&ei=bXAwU8jYN4W6iAf8zIDgDA&gws_rd=cr");
		String cssValue=driver.findElement(By.xpath("//a[contains(@href,'hl=hi')]")).getCssValue("text-decoration");
		System.out.println("value"+cssValue);
		Actions act = new Actions(driver);
		act.moveToElement (driver.findElement (By.xpath ("//a[contains(@href,'hl=hi')]"))).perform();
		String cssValue1=driver.findElement (By.xpath("//a[contains(@href,'hl=hi')]")).getCssValue("text-decoration");
		Thread.sleep(5000);
		System.out.println ("value over"+cssValue1);
		driver.close ();
	}

}

package com.rnd.seleniumpuzzles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckWebElementHighlighted {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(10));
		driver.get("https://www.google.co.in/?gfe_rd=ctrl&ei=bXAwU8jYN4W6iAf8zIDgDA&gws_rd=cr");
		
		//Check Background Color WebElement Before
		String cssValue=driver.findElement(By.xpath("//a[contains(@href,'hl=hi')]")).getCssValue("background-color");
		System.out.println("Background Color Before is "+cssValue);
		
		//Check Text Color of WebElement
		String cssValue1=driver.findElement (By.xpath("//a[contains(@href,'hl=hi')]")).getCssValue("color");
		Thread.sleep(5000);
		System.out.println ("Text Color is "+cssValue1);
		
		//Highlight WebElement
		WebElement ele = driver.findElement (By.xpath("//a[contains(@href,'hl=hi')]"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.background='yellow'", ele);
		
		//Check Again Background Color of WebElement After
		String cssValue2=driver.findElement(By.xpath("//a[contains(@href,'hl=hi')]")).getCssValue("background-color");
		System.out.println("Background Page Color After is "+cssValue2);
		
		Thread.sleep(5000);

		if(cssValue.equals(cssValue2)) {
			System.out.println("Web Element is not Highlighted");
		}else {
			System.out.println("WebElement is Highlighted");
		}
		
		//Restore back WebElement
		jse.executeScript("arguments[0].style.background='rgba(0, 0, 0, 0)'", ele);
		
		//Check Again Background Color of WebElement After
		String cssValue3=driver.findElement(By.xpath("//a[contains(@href,'hl=hi')]")).getCssValue("background-color");
		System.out.println("Background Page Color After is "+cssValue3);
		Thread.sleep(5000);
		if(cssValue.equals(cssValue3)) {
			System.out.println("Web Element is not Highlighted");
		}else {
			System.out.println("WebElement is Highlighted");
		}
		
		driver.quit ();

	}

}

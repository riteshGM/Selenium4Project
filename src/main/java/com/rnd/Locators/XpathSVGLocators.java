package com.rnd.Locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathSVGLocators {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		//Launch URL
		driver.get("https://seleniumbase.io/demo_page");
		String xpath = "//*[name()='svg']//*[local-name()='rect']";
		
		WebElement ele = driver.findElement(By.xpath(xpath));
		System.out.println("fill value found as "+ele.getAttribute("fill"));
		ele.click();
		System.out.println("Clicked");
		Thread.sleep(3000);
		
		//Here we are changing color of the element using setAttribute()
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].setAttribute('fill','#000000')", ele);
		Thread.sleep(3000);
		System.out.println("Script Executed");
	}

}

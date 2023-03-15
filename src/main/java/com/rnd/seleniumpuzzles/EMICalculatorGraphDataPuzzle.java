package com.rnd.seleniumpuzzles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * Credits : Naveen Automation Lab
 * Youtube Video https://www.youtube.com/watch?v=J-Zc02wp-6E
 * Demo Site URL: https://emicalculator.net/
 * Puzzle: Get Tooltip Value from EMI Calculator Graph points (the line on graph)
 * @author rites
 *
 */
public class EMICalculatorGraphDataPuzzle {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Launch URL
		driver.get("https://emicalculator.net/");
		Actions action = new Actions(driver);
		//Locator for Move Hover Action to Graph Line
		List<WebElement> eleList = driver.findElements(By.xpath("//*[local-name()='svg']//*[local-name()='g' and @class='highcharts-markers highcharts-series-2 highcharts-spline-series highcharts-tracker']//*[local-name()='path']"));
		for(WebElement eachElement : eleList) {
			action.moveToElement(eachElement).perform();
			Thread.sleep(500);
			//locator for Tooltip
			String toolTipLocator="//*[local-name()='svg']//*[local-name()='g' and contains(@class,'highcharts-tooltip')]//*[local-name()='text' and @data-z-index = '1']";
			try {
				String tooltip = driver.findElement(By.xpath(toolTipLocator)).getText();
				System.out.println(tooltip);
			}catch(NoSuchElementException e) {
				//This is only because first Element in List does hold any tooltip.
				//Do Nothing
				System.out.println("Exception Occured");
			}
		}

	}

}

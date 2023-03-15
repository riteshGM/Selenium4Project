package com.rnd.seleniumpuzzles;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * SVG Graph Puzzle
 * Credits Naveen Automation Lab Youtube video: https://www.youtube.com/watch?v=as9J-nqTQx8
 *
 * @author rites
 *
 */
public class CovidCasesGraghDataPuzzle {

	public static void main(String[] args) throws InterruptedException {		
		WebDriver driver = new ChromeDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Launch URL
		driver.get("https://www.google.co.in/search?q=covid+cases+in+india&sxsrf=AJOqlzUn0RXPc8pQTVoZjjHB0qg7uXystw%3A1677238775374&source=hp&ei=96H4Y7HSFLib4-EP3NSPmAo&iflsig=AK50M_UAAAAAY_iwByni0ogroo3zPuuakXcD0WsDJcQp&oq=covid+cases&gs_lcp=Cgdnd3Mtd2l6EAMYATILCAAQsQMQyQMQkQIyCAgAELEDEJECMggIABCxAxCRAjIICAAQgAQQsQMyBQgAEIAEMggIABCABBCxAzIICAAQgAQQsQMyCAgAEIAEELEDMggIABCABBCxAzIHCAAQsQMQCjoECCMQJzoKCC4QxwEQrwEQJzoLCAAQsQMQgwEQkQI6DgguELEDEMcBENEDEJECOgsIABCABBCxAxCDAToRCC4QgAQQsQMQgwEQxwEQ0QM6BQgAELEDOgoIABCABBCxAxAKUABYsA1gvBpoAHAAeAGAAegDiAHBDZIBBzAuOS40LTGYAQCgAQE&sclient=gws-wiz");
		/**
		 * We need two things here 
		 * #1 index of each day in graph
		 * #2 we need locator of tool-tip for each day or index in graph.
		 */
		
		//Rect is Rectangle Shape being used to draw graph each day
		String xpathGraphIndex = "//*[local-name()='svg' and @class='uch-psvg']//*[local-name()='g']//*[local-name()='rect']";
		List <WebElement> indexElementsList = driver.findElements(By.xpath(xpathGraphIndex));
		
		Actions action = new Actions(driver);
		for(WebElement eachIndex : indexElementsList) {
			//to mimic mouse action to each index so that Tooltip changes for each day index in graph
			action.moveToElement(eachIndex).perform();
			Thread.sleep(10);
			//Capture Tool-tip Content
			//One important learning if we do getText it will get us Text from all child tags within that tag.
			String toolTipContent = driver.findElement(By.xpath("//div[@class='ExnoTd']")).getText();
			System.out.println(toolTipContent);
		}
	}

}

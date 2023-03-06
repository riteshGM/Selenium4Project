package com.rnd.Locators;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Write a Program to Retrieve Table Content from Dynamic WebTable
 * @author rites
 *
 */
public class LocatingWebTables {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(10));
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		//Find Total Rows in Dynamic Table
		int rowsCount = driver.findElements(By.xpath("//table[@class='tsc_table_s13']//tr")).size();
		System.out.println("Total Rows Found "+rowsCount);
		for(int rowIndex=1; rowIndex<=rowsCount; rowIndex++) {
			if(rowIndex==1) {
				//Find Total Columns in Header and Loop Through Each
				List<WebElement> headerEle = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/thead//tr/*"));
				System.out.println("*******Printing Header********");
				System.out.println();
				for(WebElement each : headerEle) {
					System.out.print(each.getText()+"|");
				}
				System.out.println();
			}else if(rowIndex==rowsCount){
				//footer row (last) row in this case
				System.out.println("*******Printing Footer********");
				System.out.println();
				List<WebElement> footerEle = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tfoot//tr/*"));
				for(WebElement each : footerEle) {
					System.out.print(each.getText()+"|");
				}
				System.out.println();
			}else {
				List<WebElement> dataList = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody//tr["+(rowIndex-1)+"]/*"));
				System.out.println("*******Printing Data********");
				System.out.println();
				for(WebElement each : dataList) {
					System.out.print(each.getText()+"|");
				}
				System.out.println();
			}
		}
		driver.quit();
	}
}
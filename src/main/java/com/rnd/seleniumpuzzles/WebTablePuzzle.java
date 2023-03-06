package com.rnd.seleniumpuzzles;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Write A program to find Max of a Column from a WebTable
 * https://www.techlistic.com/p/demo-selenium-practice.html
 * Find the tallest structure in the table with Selenium
 * @author rites
 *
 */
public class WebTablePuzzle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait (Duration.ofSeconds(10));
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		driver.manage().window().maximize();
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		//Find total Rows to Iterate
		int rowsCount = driver.findElements(By.xpath("//table[@class='tsc_table_s13']/tbody/tr")).size();
		//Find Targeted Rows and Columns and Store in a Map
		for(int rowIndex =1; rowIndex<=rowsCount ; rowIndex++) {
			String key = driver.findElement(By.xpath("(//table[@class='tsc_table_s13']/tbody/tr["+rowIndex+"]/*)[1]")).getText();
			String value = driver.findElement(By.xpath("(//table[@class='tsc_table_s13']/tbody/tr["+rowIndex+"]/*)[4]")).getText();
			value = value.substring(0, value.length()-1);
			System.out.println(value);
			Integer value1 = Integer.parseInt(value);
			map.put(key, value1);
		}
		//Just Printing Map
		System.out.println(map);
		//use Collections to Find Max of Value in Map
		Integer maxValue = Collections.max(map.values());
		//Check Which Key hold Max Value
		for(Map.Entry<String, Integer> eachEntry : map.entrySet()) {
			if(eachEntry.getValue()==maxValue) {
				System.out.println("Maximum Height Found for "+eachEntry.getKey()+" that is "+eachEntry.getValue());
			}
		}
	}

}

package com.rnd.headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadlessBrowser {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		//We can also use addArguments() of OPtions Class alternatively to activate Headless mode
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		//Title Should be nopCommerce demo store
		System.out.println("Title is:"+driver.getTitle());
		
	}

}

package com.rnd.headlessbrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxHeadlessBrowser {

	public static void main(String[] args) {
		
		FirefoxOptions options = new FirefoxOptions();
		options.setHeadless(true);
		//We can also use addArguments() of OPtions Class alternatively to activate Headless mode
		//options.addArguments("--headless");
		WebDriver driver = new FirefoxDriver(options);
		driver.get("https://demo.nopcommerce.com/");
		//Title Should be nopCommerce demo store
		System.out.println("Title is:"+driver.getTitle());
		
	}

}

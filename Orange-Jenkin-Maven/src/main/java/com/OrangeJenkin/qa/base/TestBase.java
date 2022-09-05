package com.OrangeJenkin.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prope;

	public TestBase() {
		prope = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:\\Maven Project For Jenkins\\Orange-Jenkin-Maven\\src\\main\\java\\com\\OrangeJenkin\\qa\\config\\config.properties");
			prope.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initilization() {
		String browserName = prope.getProperty("Browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Maven Project For Jenkins\\Orange-Jenkin-Maven\\Binary\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Maven Project For Jenkins\\Orange-Jenkin-Maven\\Binary\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("gecko")) {
			System.setProperty("webdriver.gecko.driver",
					"C:\\Maven Project For Jenkins\\Orange-Jenkin-Maven\\Binary\\geckodriver.exe");
			driver = new FirefoxDriver();
		}


		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prope.getProperty("url"));

}
	
}

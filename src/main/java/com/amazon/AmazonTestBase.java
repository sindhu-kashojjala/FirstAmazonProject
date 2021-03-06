package com.amazon;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.Util.AmazonTestUtil;
import com.amazon.Util.WebEventListener;

public class AmazonTestBase {
	
	//Declare required variables
	public static WebDriver driver;
	public static Properties properties;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	//Read data from .properties file
	public AmazonTestBase(){
		try {
			properties = new Properties();
			FileInputStream propertiesfile = new FileInputStream(System.getProperty("user.dir")+"\\application.properties");
			properties.load(propertiesfile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	//Open Browser and load URL
	public void LaunchBrowser() {
	
		String Browsername = properties.getProperty("browser");
		if(Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", properties.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}else if(Browsername.equals("FireFox")) {
			System.setProperty("webdriver.gecko.driver", properties.getProperty("FireFoxDriverPath"));
			driver = new ChromeDriver();
		}
		
		//code to invoke event firing webdriver
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		//Maximize window and load required URL
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(AmazonTestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(AmazonTestUtil.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		
		driver.get(properties.getProperty("Amazonurl"));
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
}

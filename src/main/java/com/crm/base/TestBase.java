package com.crm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	 public TestBase()
	 {
		 prop = new Properties();
		 try {
			FileInputStream fp = new FileInputStream("C:\\Back Up\\CRMNewPractiseProject\\src\\main\\java\\com\\crm\\configurations\\config.properties");
			try {
				prop.load(fp);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	 }
	 
	 public void initialization()
	 {
		 String browser = prop.getProperty("Browser");
		   if(browser.equals("Firefox"))
		   {
			   driver = new FirefoxDriver();
		   }
		   else if(browser.equals("Chrome"))
           {
	          driver = new ChromeDriver();
           }
		   
		   
		   driver.manage().window().maximize();
		   driver.manage().deleteAllCookies();
		   driver.get(prop.getProperty("Url"));
		   driver.manage().timeouts().pageLoadTimeout(TestUtil.pageLoadTimeout,TimeUnit.SECONDS);
		   driver.manage().timeouts().implicitlyWait(TestUtil.implicitlyWait,TimeUnit.SECONDS);
	 }

}

package com.email.e2e;

import java.io.File;
import java.io.FileReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.junit.Test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import com.email.e2e.pageObjects.InboxPage;
import com.email.e2e.pageObjects.LoginPage;
import com.email.e2e.pageObjects.SentPage;

import junit.framework.TestCase;

public class GMailTest extends TestCase{
	public WebDriver driver;	
	public Properties properties = new Properties();
	
	 public void setUp() throws Exception {
	        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
	        driver = new ChromeDriver();
	        properties.load(new FileReader(new File("test.properties")));
	    }
	 
	 public void tearDown(){
		 
		 //driver.close();
	 }
	
	
	

    
    @Test
    public void testSendEmail() throws Exception {
    	//navigates to Gmail
        driver.get(properties.getProperty("url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        LoginPage login = new LoginPage(driver);
       //logs in to Gmail
        login.loginToGmail();
       

        InboxPage inbox = new InboxPage(driver);
        //sends email
        inbox.sendEmail();
        
        
        
        SentPage received = new SentPage(driver);
      //Receives email
        received.RecieveEmail();
        //waits until Verify Name, Subject and Body Results are printed to testResults.properties before closing Webdriver
        Thread.sleep(2000);
        
       
    }
}

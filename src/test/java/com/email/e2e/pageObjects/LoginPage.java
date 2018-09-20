package com.email.e2e.pageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





public class LoginPage {
	WebDriver driver;
	public Properties properties = new Properties();
	By userElement = By.id("identifierId");
	By nextButton = By.id("identifierNext");
	By Password = By.name("password");
	By PasswordNext = By.id("passwordNext");
	
	
	
	public LoginPage(WebDriver driver) throws FileNotFoundException, IOException {
		this.driver = driver;		
		properties.load(new FileReader(new File("test.properties")));
	}
	
	public void onUserName(){
		driver.findElement(userElement).click();
		driver.findElement(userElement).sendKeys((properties.getProperty("username")));
		
		
	}
	public void onUserNameNext(){
		driver.findElement(nextButton).click();
		
	}
	public void onPassword(){
		driver.findElement(Password).sendKeys((properties.getProperty("password")));
		
	}
	public void onPasswordNext(){
		driver.findElement(PasswordNext).click();
	}
	
	public void loginToGmail(){

        //Fill user name

        this.onUserName();
        //click next Button
        this.onUserNameNext();

        //Fill password

        this.onPassword();

        //Click Login button

        this.onPasswordNext();
        
	}

	
	}


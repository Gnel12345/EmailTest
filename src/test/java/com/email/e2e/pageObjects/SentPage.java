package com.email.e2e.pageObjects;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.AssertJUnit;



public class SentPage {
	WebDriver driver;
	
	public Properties properties = new Properties();
	By messageRecieved = By.id("link_vsm");
	
	public SentPage(WebDriver driver) throws FileNotFoundException, IOException{
		this.driver=driver;
		properties.load(new FileReader(new File("testResults.properties")));
	}
public void onMessageRecieved(){
		
		driver.findElement(messageRecieved).click();
	
	}
public void onVerifySubjectText(){
	WebElement subject = driver.findElement(By.className("hP"));
	String subjectExpectedText = ("Greetings");
	String subjectActualText=subject.getText();
	AssertJUnit.assertEquals(subjectActualText,subjectExpectedText);	
	try{
	properties.setProperty("subjectActualText", subjectActualText);
	File f = new File("testResults.properties");
    OutputStream out = new FileOutputStream( f );
    properties.store(out,"Verified");
	}catch(Exception e){
		e.printStackTrace();
	}

	
}
public void onVerifyBodyText() throws IOException{
	try{WebElement body = driver.findElement(By.className("a3s"));
	String bodyExpectedText = ("Hello Crossover");
	String bodyActualText=body.getText();
	AssertJUnit.assertEquals(bodyActualText,bodyExpectedText);	
	properties.setProperty("bodyActualText", bodyActualText);
	File f = new File("testResults.properties");
    OutputStream out = new FileOutputStream( f );
    properties.store(out,"Verified");
	}catch(Exception e){
		e.printStackTrace();
	}
	
}

public void onVerifyName(){
	
	
	WebElement name = driver.findElement(By.name("Glenn"));
	
	String nameExpectedText = ("Glenn");
	String nameActualText=name.getText();
	AssertJUnit.assertEquals(nameActualText,nameExpectedText);	
	try{
		properties.setProperty("nameActualText", nameActualText);
		File f = new File("testResults.properties");
	    OutputStream out = new FileOutputStream( f );
	    properties.store(out,"Verified");	    
		}catch(Exception e){
			e.printStackTrace();
		}
	
}

public void RecieveEmail() throws IOException{
	//clicks View Message
	this.onMessageRecieved();
	//verifies the subject text
	this.onVerifySubjectText();
	//verifies the body text
	this.onVerifyBodyText();
	//verifies name
	this.onVerifyName();
}

}

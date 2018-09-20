package com.email.e2e.pageObjects;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;






public class InboxPage {
	WebDriver driver;
	public Properties properties = new Properties();
	By composeElement = By.xpath("//div[@class='T-I J-J5-Ji T-I-KE L3']");
	By RecipientElement = By.name("to");
	By SubjectElement = By.name("subjectbox");
	By message = By.id(":qb");
	By attachmentButton = By.className("a1");
	By sendButton = By.xpath("//*[@role='button' and text()='Send']");
	
	
	
	 
	
	
	public InboxPage(WebDriver driver) throws FileNotFoundException, IOException{
		this.driver=driver;
		
		properties.load(new FileReader(new File("test.properties")));
	}
	
	public void onComposeButton(){
		driver.findElement(composeElement).click();
		
	}
	
	public void onRecipientClear(){
		driver.findElement(RecipientElement).clear();
		
	}
	
	public void onRecipientEnter(){
		driver.findElement(RecipientElement).sendKeys(String.format("%s@gmail.com", properties.getProperty("username")));
		
	}
	
	public void onSubjectBox(){
		driver.findElement(SubjectElement).sendKeys(properties.getProperty("subject"));
		
	}
	
	public void onMessage(){
		driver.findElement(message).sendKeys(properties.getProperty("body"));	
		
	}
	public void onAttachment() throws IOException, InterruptedException{
		driver.findElement(attachmentButton).click();
		Process p = Runtime.getRuntime().exec("C:\\Users\\Glenns\\Desktop\\cross-mail-selenium-java_GlennNelson\\Attachment.exe");
		p.waitFor();
		
		
	}
	
	public void onMessageSend(){
		driver.findElement(sendButton).click();
		
	}
	
	
	
	
	
	public void sendEmail() throws IOException, InterruptedException{
		//clicks Compose Button
		this.onComposeButton();
		//clears the Recipient Text Box
		this.onRecipientClear();
		//enters the Recipient Email address
		this.onRecipientEnter();
		//enters message in the Subject Text Box
		this.onSubjectBox();
		//enters message into the message box
		this.onMessage();
		//clicks Attachment
		this.onAttachment();
		//clicks the send button
		this.onMessageSend();
		
		
		
		
	}
	
}

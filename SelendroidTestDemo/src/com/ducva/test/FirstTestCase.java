package com.ducva.test;

import static org.junit.Assert.*;
import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstTestCase {

	@Test
	public void test() {
		//specify test capabilities
		
		SelendroidCapabilities cap = new SelendroidCapabilities("io.selendroid.testapp:0.12.0");
		cap.setEmulator(false);
		
		//start a new webdriver
		try {
			WebDriver driver = new SelendroidDriver(cap);
			
			WebElement element = driver.findElement(By.id("my_text_field"));
			Assert.assertEquals("true", element.getAttribute("enabled"));
			element.sendKeys("Selendroid");
			Assert.assertEquals("Selendroid", element.getText());
			
			Thread.sleep(5000);
			
			driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}

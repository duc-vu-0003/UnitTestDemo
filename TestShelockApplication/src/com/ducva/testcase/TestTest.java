package com.ducva.testcase;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidDriver;
import io.selendroid.device.DeviceTargetPlatform;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestTest {

	@Test
	public void test() {
		// specify test capabilities (your 'test environment')
	    SelendroidCapabilities capa = new SelendroidCapabilities("io.selendroid.testapp:0.12.0");
	         
	    // explicitly state that we want to run our test on an Android API level 10 device
	    //capa.setPlatformVersion(DeviceTargetPlatform.ANDROID10);
	         
	    // explicitly state that we use an emulator (an AVD) for test execution rather than a physical device
	    capa.setEmulator(false);
	 
	    // start a new WebDriver
	    WebDriver driver;
		try {
			driver = new SelendroidDriver(capa);
			
			// execute a very simple test
		    WebElement inputField = driver.findElement(By.id("my_text_field"));
		    Assert.assertEquals("true", inputField.getAttribute("enabled"));
		    inputField.sendKeys("Selendroid");
		    Assert.assertEquals("Selendroid", inputField.getText());
		    
		    Thread.sleep(5000);
		         
		    // quit testing
		    driver.quit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	         
	    
	}

}

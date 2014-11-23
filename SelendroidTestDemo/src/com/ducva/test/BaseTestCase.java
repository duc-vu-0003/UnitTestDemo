package com.ducva.test;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTestCase {

	private static SelendroidConfiguration serverConfig;
	private static SelendroidLauncher launcher;
	private static SelendroidCapabilities cap;
	private static SelendroidDriver driver;
	
	//private static String APK_DIR = "/Users/hex0r/Desktop/SherlockApplication.apk";
	//private static String APK_DIR = "/Users/hex0r/Desktop/LastFMLollipop.apk";
	private String appUnderTestID = "com.ducva.sherlockapplication:1.0";
	private static String APK_DIR = "resources/SherlockApplication.apk";
	//private String appUnderTestID = "com.ducva.lollipopdemo:1.0";
	
	public SelendroidDriver driver(){
		return driver;
	}
	
	@BeforeClass
	public static void startSelendroidServer(){
		initServer(APK_DIR);
		launcher.launchSelendroid();
	}
	
	@AfterClass
	public static void stopSelendroidServer(){
		launcher.stopSelendroid();
	}
	
	@Before
	public void setup(){
		initDriver(appUnderTestID, null);
	}
	
	@After
	public void teardown(){
		if(driver != null){
			driver.quit();
		}
	}
	
	//--------------
	private static void initServer(String appPath){
		serverConfig = new SelendroidConfiguration();
		serverConfig.addSupportedApp(appPath);
		serverConfig.setForceReinstall(true);
		serverConfig.setPrintHelp(true);
		launcher = new SelendroidLauncher(serverConfig);
	}
	
	private static void initDriver(String appID, String lauchActivity){
		cap = new SelendroidCapabilities();
		cap.setAut(appID);
		
		if(lauchActivity != null){
			cap.setLaunchActivity(lauchActivity);
		}
		
		cap.setEmulator(false);
		
		try {
			driver = new SelendroidDriver(cap);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

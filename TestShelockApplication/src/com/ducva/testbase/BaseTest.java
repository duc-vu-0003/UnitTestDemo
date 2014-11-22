package com.ducva.testbase;

import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class BaseTest {

	private static SelendroidConfiguration serverConfig;
	private static SelendroidLauncher launcher;
	private static SelendroidCapabilities capabilities;
	private static SelendroidDriver driver;

	//private static String APK_DIR = "/Users/hex0r/Downloads/selendroid-test-app-0.12.0.apk";
	private static String APK_DIR = "/Users/hex0r/Desktop/SherlockApplication.apk";
	//private String appUnderTestId = "io.selendroid.testapp:0.12.0";
	private String appUnderTestId = "com.ducva.sherlockapplication:1.0";
	private String serverUrl = "http://localhost:4444/wd/hub";
	//private String lauchActivity = "io.selendroid.testapp.HomeScreenActivity";
	private static boolean forceReinstall = true;
	private static boolean clearData = true;
	private boolean runOnEmulator = false;

	public SelendroidDriver driver() {
		return driver;
	}

	@BeforeClass
	public static void startSelendroidServer() {
		initServer(APK_DIR, forceReinstall, clearData);
		launcher.launchSelendroid();
	}

	@AfterClass
	public static void stopSelendroidServer() {
		launcher.stopSelendroid();
	}

	@Before
	public void setup() {
		initDriver(appUnderTestId, null, serverUrl, runOnEmulator);
	}

	@After
	public void teardown() {
		if (driver() != null) {
			driver().quit();
		}
	}

	@Rule
	public TestRule rule = new TestRule() {

		@Override
		public Statement apply(final Statement base, final Description description) {
			return new Statement() {
				@Override
				public void evaluate() throws Throwable {
					System.out.println(String.format("%s.%s", description.getTestClass().getName(),
							description.getMethodName()));
					try {
						base.evaluate();
					} catch (Exception e) {
						e.printStackTrace();
						throw e;
					}
					System.out.println("test completed.");
				}
			};
		}
	};

	// -------------
	private static void initServer(String appPath, boolean forceReinstall, boolean clearData) {
		serverConfig = new SelendroidConfiguration();
		serverConfig.addSupportedApp(appPath);
		serverConfig.setPort(4444);
		serverConfig.setSelendroidServerPort(38080);
		serverConfig.setForceReinstall(forceReinstall);
		serverConfig.setNoClearData(!clearData);
		serverConfig.setPrintHelp(true);
		launcher = new SelendroidLauncher(serverConfig);
	}

	private static void initDriver(String appUnderTestId, String launchActivity, String serverUrl, boolean runOnEmulator) {
		capabilities = new SelendroidCapabilities();
		capabilities.setAut(appUnderTestId);
		if (launchActivity != null) {
			capabilities.setLaunchActivity(launchActivity);
		}
		capabilities.setEmulator(runOnEmulator);
		try {
			driver = new SelendroidDriver(capabilities);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

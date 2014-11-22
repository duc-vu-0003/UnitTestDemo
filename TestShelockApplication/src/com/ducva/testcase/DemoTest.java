package com.ducva.testcase;

import io.selendroid.SelendroidKeys;
import io.selendroid.exceptions.NoSuchElementException;
import io.selendroid.waiter.TestWaiter;
import io.selendroid.waiter.WaitingConditions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ducva.testbase.BaseTest;
import com.ducva.testcase.model.PersonBO;

public class DemoTest extends BaseTest {

	@Test
	public void testItemOfgridView() {

		// WebElement button =
		// driver().findElement(By.id("drawer_myalbum_title"));
		//
		// WebElement button1 =
		// driver().findElement(By.id("drawer_myartist_title"));
		//
		// Assert.assertEquals(button.getAttribute("text"), "My Album");
		//
		// Assert.assertEquals(button1.getAttribute("text"), "My Artist");

		// --------

		// //put the app to the background
		// driver().backgroundApp();
		// //resume app
		// driver().resumeApp();

		// ------------
		// WebElement pages = driver().findElement(By.id("swipe_container"));
		// TouchActions flick = new TouchActions(driver()).flick(pages, 0, 30,
		// 0);
		// flick.perform();

		// new Actions(driver()).sendKeys(SelendroidKeys.MENU).perform();
		//
		// driver().backgroundApp();

		// List<WebElement> we = driver().findElements(By.id("gvContact"));
		//
		// int count = we.size();
		//
		// Assert.assertEquals(count, 2);

		// WebElement element6 =
		// driver().findElement(By.xpath("//ActionMenuItemView[@id='action_add']"));
		// element6.click();

		//Assert.assertEquals(2, 2);
		
		
	}

	@Test
	public void testAddPerson() {
		// Perform button add
		WebElement buttonAdd = driver().findElement(By.id("action_add"));
		buttonAdd.click();

		// registerUser(new PersonBO("DUCVA", false, 172, 23, "Hanoi", "Black",
		// "No Comment", ""));

		registerUser(new PersonBO("DUCVA", false, 172, 23, "Hanoi", "Black",
				"No Comment", ""));
	}

	@Test
	public void searchPersonTest() {
		WebElement buttonSearch = driver().findElement(By.id("action_search"));
		buttonSearch.click();

		WebElement textSearch = driver().findElement(By.id("search_src_text"));

		textSearch.sendKeys("ABC");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textSearch.clear();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		textSearch.sendKeys("DUC");

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver().getKeyboard().sendKeys(SelendroidKeys.ENTER);

		Assert.assertNotNull(driver().findElement(By.id("tvNoPerson")));

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test()
	public void testViewPager() {

		testAddPerson();

		WebElement element4 = driver().findElement(
				By.xpath("(//GridView/FrameLayout)[1]"));
		// WebElement element4 = driver().findElement(By.id("ivContactImage"));

		element4.click();

		WebElement pages = driver().findElement(By.id("vpPager"));
		TouchActions flick = new TouchActions(driver()).flick(pages, 0, 100, 0);
		flick.perform();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		flick = new TouchActions(driver()).flick(pages, -100, 0, 0);
		flick.perform();
	}

	@Test()
	public void shouldGoBackInNativeMode() {
		driver().findElement(By.id("action_add")).click();
		Assert.assertEquals(driver().getCurrentUrl(),
				"and-activity://AddPersonActivity");

		// TestWaiter.waitFor(WaitingConditions.driverUrlToBe(driver(),
		// "and-activity://AddPersonActivity"), 10, TimeUnit.SECONDS);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver().navigate().back();

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Assert.assertEquals(driver().getCurrentUrl(),
				"and-activity://MainActivity");

	}

	private void registerUser(PersonBO user) {

		// Find edtitext of name
		WebElement personName = driver().findElement(By.id("etPersonName"));
		personName.sendKeys(user.getPersonName());

		WebElement personAge = driver().findElement(By.id("etPersonAge"));
		personAge.sendKeys(user.getPersonAge() + "");

		WebElement personHeight = driver().findElement(By.id("etPersonHeight"));
		personHeight.sendKeys(user.getPersonHeight() + "");

		if (user.isPersonGender()) {
			WebElement personGenderMale = driver()
					.findElement(By.id("rbtMale"));
			personGenderMale.click();
		} else {
			WebElement personGenderFemale = driver().findElement(
					By.id("rbtFemale"));
			personGenderFemale.click();
		}

		WebElement personHair = driver().findElement(By.id("etPersonHair"));
		personHair.sendKeys(user.getPersonHairColor());

		WebElement personAddress = driver().findElement(
				By.id("etPersonAddress"));
		personAddress.sendKeys(user.getPersonAddress());

		WebElement personComment = driver().findElement(By.id("etAdditional"));
		personComment.sendKeys(user.getAdditionalcomment());

		WebElement buttonSave = driver().findElement(By.id("btnSave"));

		buttonSave.click();

		// Perform
		// WebElement diablogButton =
		// driver().findElement(By.xpath("//Button[@id='button3']"));
		// diablogButton.click();

		try {
			WebElement diablogButton = driver().findElementByLinkText("Create");
			Assert.assertEquals(diablogButton.getText(), "Create");
			diablogButton.click();

			Assert.assertEquals(driver().getCurrentUrl(),
					"and-activity://MainActivity");

			WebDriverWait wait = new WebDriverWait(driver(), 5);
		} catch (Exception e) {
			Assert.fail("Missing Input Field");
		}

	}

	@Test
	public void shouldRotate() throws Exception {
		Assert.assertEquals(ScreenOrientation.PORTRAIT, driver()
				.getOrientation());
		driver().rotate(ScreenOrientation.LANDSCAPE);
		Assert.assertEquals(ScreenOrientation.LANDSCAPE, driver()
				.getOrientation());
		driver().rotate(ScreenOrientation.PORTRAIT);
		Assert.assertEquals(ScreenOrientation.PORTRAIT, driver()
				.getOrientation());
	}

	@Test
	public void testBackgroundAppFunctionality() throws Exception {
		driver().backgroundApp();
		String currentActivity = adbCurrentActivity();

		System.out.print(currentActivity);

		Assert.assertTrue(currentActivity
				.contains("com.android.launcher2.Launcher"));
		driver().resumeApp();
		currentActivity = adbCurrentActivity();
		Assert.assertTrue(currentActivity
				.contains("com.ducva.sherlockapplication.MainActivity"));
	}

	private String adbCurrentActivity() throws Exception {
		return execCmd(System.getenv("ANDROID_HOME")
				+ "/platform-tools/"
				+ "adb shell dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'");
	}

	public String execCmd(String cmd) throws java.io.IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		java.io.InputStream is = proc.getInputStream();
		java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A");
		String val = "";
		if (s.hasNext()) {
			val = s.next();
		} else {
			val = "";
		}
		return val;
	}

	@Test
	public void shouldSetJapaneseTextIntoNativeTextField() {
//		String text = "ありがとう";
//		WebElement input = driver().findElement(By.id("my_text_field"));
//		input.sendKeys(text);
//		Assert.assertEquals(text, input.getText());

		WebElement btn = driver().findElement(By.id("action_demo"));
		
		btn.click();
		
		WebElement pages = driver().findElement(By.id("vpPager"));
		TouchActions flick = new TouchActions(driver()).flick(pages, -100, 0, 0);
		flick.perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		flick.perform();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

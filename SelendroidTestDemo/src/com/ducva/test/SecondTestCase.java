package com.ducva.test;

import java.util.List;

import io.selendroid.SelendroidKeys;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SecondTestCase extends BaseTestCase{

	@Test
	public void test() {
		String text = "No person in databases";
	    WebElement clickMe = driver().findElement(By.linkText("No person in database"));
	    Assert.assertEquals(clickMe.getText(), text);
	}
	
	@Test
	public void test2() {
		List<WebElement> elements = driver().findElements(By.id("action_add"));
	    Assert.assertEquals(elements.size(), 1);
	}
	
	@Test
	public void addPersonTest(){
		
		Assert.assertTrue(true);
		
		WebElement actionAdd = driver().findElement(By.id("action_add"));
		actionAdd.click();
		
		//find element
		addPerson(new Person("DUCVA", true, "Hanoi", 172, 23));
		
		//addPerson(new Person("パソコン版にする", true, "Hanoi", 172, 23));
	}
	
	private void addPerson(Person person){
		WebElement nameElement = driver().findElement(By.id("etPersonName"));
		nameElement.sendKeys(person.personName);
		
		WebElement ageElement = driver().findElement(By.id("etPersonAge"));
		ageElement.sendKeys(person.personAge + "");
		
		WebElement heightElement = driver().findElement(By.id("etPersonHeight"));
		heightElement.sendKeys(person.personHeight + "");
		
		if(person.personGender){
			WebElement maleElement = driver().findElement(By.id("rbtMale"));
			maleElement.click();
		} else {
			WebElement femaleElement = driver().findElement(By.id("rbtFemale"));
			femaleElement.click();
		}
		
		WebElement button = driver().findElement(By.id("btnSave"));
		button.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			WebElement dialogButton = driver().findElementByLinkText("Create");
			Assert.assertEquals(dialogButton.getText(), "Create");
			
			dialogButton.click();
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String text = "DUCVA";
		    WebElement clickMe = driver().findElement(By.linkText("DUCVA"));
		    Assert.assertEquals(clickMe.getText(), text);
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail("Missing input data");
		}
		
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
	
	class Person{
		public String personName;
		public boolean personGender;
		public String personAddress;
		public int personHeight;
		public int personAge;
		
		public Person(String personName, boolean personGender, String personAddress, int personHeight, int personAge) {
			// TODO Auto-generated constructor stub
			this.personName = personName;
			this.personGender = personGender;
			this.personAddress = personAddress;
			this.personHeight = personHeight;
			this.personAge = personAge;
		}
	}

}

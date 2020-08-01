package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel; 
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	
	
	//Initializing the page object
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
	}
	
	public void createNewContact(String title,String ftName,String ltName,String comp) {
		
	/*	String s="//select[@name='title']/option[@value='test']";
		
		String s1=s.replace("test",title);
		
	*/
		
		
		int i = driver.findElements(By.tagName("iframe")).size();
		
		System.out.println("COunt"+i);
		;
		driver.switchTo().frame(0);
		WebDriverWait wait= new WebDriverWait(driver, 60);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("title")));
	//	driver.switchTo().frame(arg0)
		
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
			
	}
	
	

}

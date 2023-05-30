package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BaseClass;

public class HomePage{
	@FindBy(id="logoutLink")
	private WebElement lgout;
	@FindBy(xpath = "//div[text() ='Tasks']")
	private WebElement TasksTab; 
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void setLogout() {
		lgout.click();
	}
	public void setTaskTab() {
		TasksTab.click();
	}
}

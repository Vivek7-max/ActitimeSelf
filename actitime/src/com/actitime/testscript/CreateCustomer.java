package com.actitime.testscript;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.actitime.generic.BaseClass;
import com.actitime.generic.FileLib;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;
@Listeners(com.actitime.generic.ListenerImplementation.class)
public class CreateCustomer extends BaseClass {
	@Test
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException {
		Reporter.log("createCustomer", true);
		FileLib f = new FileLib();
		String customerName = f.getExcelData("CreateCustomer", 1, 2);
		String customerDesc = f.getExcelData("CreateCustomer", 1, 3);
		HomePage h = new HomePage(driver);
		h.setTaskTab();
		TaskListPage t = new TaskListPage(driver);
		t.getAddNewBtn().click();
		t.getNewCustomerOption().click();
		t.getCustomerNameTbx().sendKeys(customerName);
		t.getCustomerDescriptionTbx().sendKeys(customerDesc);
		t.getCustomerDropdown().click();
		t.getOurCompany().click();
		t.getCreateCustomerBtn().click();
		WebElement actualCustomer = t.getActualCustomerCreated();
		explicitWait(driver).until(ExpectedConditions.visibilityOf(actualCustomer));
		String createdCustomer = t.getActualCustomerCreated().getText();
		Assert.assertEquals(createdCustomer, customerName);
	}
}

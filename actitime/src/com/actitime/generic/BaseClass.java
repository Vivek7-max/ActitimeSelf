package com.actitime.generic;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.actitime.pom.HomePage;
import com.actitime.pom.LoginPage;
public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
	@BeforeMethod
	public void login() throws IOException {
		FileLib f= new FileLib();
		String url = f.getPropertyData("url");
		String un = f.getPropertyData("username");
		String pw = f.getPropertyData("password");
		driver.get(url);
		LoginPage l = new LoginPage(driver);
		l.setLogin(un, pw);
	}
	@AfterMethod
	public void logout() {
		HomePage h = new HomePage(driver);
		h.setLogout();
	}
	public WebDriverWait explicitWait(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		return wait;
	}
}
















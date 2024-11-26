package com.medicover.hms.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.medicover.hms.generic.fileutility.ExcelUtility;
import com.medicover.hms.generic.fileutility.FileUtility;
import com.medicover.hms.generic.fileutility.WebdriverUtility;
import com.medicover.hms.objectrepository.AdminLoginPage;

public class BaseUtility {
	public WebdriverUtility wLib = new WebdriverUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public static WebDriver sdriver = null;

	public WebDriver driver;

	@BeforeSuite(groups= {"smoke","regression"})
	public void configureBS() {
		System.out.println("database connection");
		// System.out.println("configure report");
	}
	@Parameters("BROWSER")
	@BeforeClass(groups= {"smoke","regression"})
	public void configBC(@Optional("chrome") String browser) throws Throwable {
		System.out.println("launch the browser");
		String BROWSER = fLib.getDataFromPropertyFile("browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
	}

	@BeforeMethod(groups= {"smoke","regression"})
	public void configBM() throws Throwable {
		String URL = fLib.getDataFromPropertyFile("url");
		driver.get(URL);
		WebdriverUtility wu = new WebdriverUtility();
		wu.toMaximize(driver);
		wu.toWaitLoad(driver);
		
		
	}

	@AfterMethod(groups= {"smoke","regression"})
	public void configAM() {
		driver.quit();
		//System.out.println("logout");
	}

	@AfterClass(groups= {"smoke","regression"})
	public void configAC() {
		System.out.println("close the browser");
	}

	@AfterSuite(groups= {"smoke","regression"})
	public void configAS() {
		System.out.println("close the database connection");
	}

}

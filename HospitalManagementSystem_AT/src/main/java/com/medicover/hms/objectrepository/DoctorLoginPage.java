package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicover.hms.generic.fileutility.WebdriverUtility;

public class DoctorLoginPage {
	WebDriver driver;

	public DoctorLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement doctorUsername;

	@FindBy(name = "password")
	private WebElement doctorPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submitBtn;

	@FindBy(xpath = "//h3[text()='Doctors Login']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement doctorLink;

	public WebElement getDoctorLink() {
		return doctorLink;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDoctorUsername() {
		return doctorUsername;
	}

	public WebElement getDoctorPassword() {
		return doctorPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public void doctorLogin( String username, String password) throws InterruptedException {
		WebdriverUtility wu = new WebdriverUtility();
		wu.clickElementJavaExecutor(driver, doctorLink);
		doctorUsername.sendKeys(username);
		doctorPassword.sendKeys(password);
		submitBtn.click();
		Thread.sleep(3000);

	}

}

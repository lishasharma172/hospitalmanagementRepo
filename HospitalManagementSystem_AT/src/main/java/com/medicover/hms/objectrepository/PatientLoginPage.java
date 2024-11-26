package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicover.hms.generic.fileutility.WebdriverUtility;

public class PatientLoginPage {
	WebDriver driver;

	public PatientLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	private WebElement patientUsername;

	@FindBy(name = "password")
	private WebElement patientPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submitBtn;

	public WebElement getPatientUsername() {
		return patientUsername;
	}

	public WebElement getPatientPassword() {
		return patientPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	@FindBy(xpath = "//h3[text()='Patients']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement patientLink;

	public WebElement getPatientLink() {
		return patientLink;
	}

	public void patientLogin(String username, String password) throws InterruptedException {
		WebdriverUtility wu=new WebdriverUtility();
		//wu.toMaximize(driver);
	//	wu.toWaitLoad(driver);
		wu.clickElementJavaExecutor(driver, patientLink);
		patientUsername.sendKeys(username);
		patientPassword.sendKeys(password);
		submitBtn.click();

	}

}

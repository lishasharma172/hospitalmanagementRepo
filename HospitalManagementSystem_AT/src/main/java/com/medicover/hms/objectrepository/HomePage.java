package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h3[text()='Patients']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement patientLink;
	
	@FindBy(xpath="//h3[text()='Doctors Login']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement doctorLink;
	
	@FindBy(xpath="//h3[text()='Admin Login']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement adminLink;
	
	@FindBy(linkText="contact")
	private WebElement contactLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPatientLink() {
		return patientLink;
	}

	public WebElement getDoctorLink() {
		return doctorLink;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
}

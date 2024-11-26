package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Doctor_DashboardPage {
	WebDriver driver;

	public Doctor_DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()=' Patients ']")
	private WebElement patientLink;
	
	@FindBy(xpath="//span[text()=' Add Patient']")
	private WebElement addPatientLink;

	@FindBy(partialLinkText="Update Profile")
	private WebElement updateDoctorProfileLink;
	
	@FindBy(xpath = " //span[text()=' Search ']")
	private WebElement searchPatientLink;
	
	@FindBy(id="searchdata")
	private WebElement searchtextfild;
	
	@FindBy(id="submit")
	private WebElement searchBtn;
	
	
	

	public WebElement getSearchPatientLink() {
		return searchPatientLink;
	}

	public WebElement getSearchtextfild() {
		return searchtextfild;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getPatientLink() {
		return patientLink;
	}

	public WebElement getAddPatientLink() {
		return addPatientLink;
	}

	public WebElement getUpdateDoctorProfileLink() {
		return updateDoctorProfileLink;
	}
	public void addPatient() {
		patientLink.click();
		addPatientLink.click();
	}
	
	public void searchPatient(String patientname) throws InterruptedException {
		searchPatientLink.click();
		searchtextfild.sendKeys(patientname);
		Thread.sleep(2000);
		searchBtn.click();
	}
	
}

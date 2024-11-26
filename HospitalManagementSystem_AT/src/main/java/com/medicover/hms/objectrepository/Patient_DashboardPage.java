package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Patient_DashboardPage {
	WebDriver driver;

	public Patient_DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()=' Appointment History ']")
	private WebElement appointHistoryLink;

	public WebElement getAppointHistoryLink() {
		return appointHistoryLink;
	}
	public void clickAppointHistory() {
		
		appointHistoryLink.click();
}
	@FindBy(xpath="//span[@class='username']")
	private WebElement PatientLogoutLink;
	
	@FindBy(partialLinkText="Log Out")
    private WebElement PatientLogoutBtn;
	
	@FindBy(xpath="//h1[text()='User | Dashboard']")
	private WebElement userHeader;

	
	public WebElement getPatientLogoutLink() {
		return PatientLogoutLink;
	}
	public WebElement getPatientLogoutBtn() {
		return PatientLogoutBtn;
	}
	
	public void logOutPatient() throws InterruptedException {
		PatientLogoutLink.click();
		Thread.sleep(3000);
		PatientLogoutBtn.click();
	}
	
	public WebElement getUserHeader() {
		return userHeader;
	}
	
}
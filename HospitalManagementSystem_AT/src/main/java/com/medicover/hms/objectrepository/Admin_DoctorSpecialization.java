package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_DoctorSpecialization {
	WebDriver driver;

	public Admin_DoctorSpecialization(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="doctorspecilization")
	private WebElement docSpeciazationTextField;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	private WebElement submitBtn;
	
	@FindBy(partialLinkText="Admin")
	private WebElement adminDropdown;
	
	@FindBy(partialLinkText="Log Out")
	private WebElement logOutLink;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDocSpeciazationTextField() {
		return docSpeciazationTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
}

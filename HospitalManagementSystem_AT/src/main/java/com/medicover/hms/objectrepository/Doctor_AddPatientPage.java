package com.medicover.hms.objectrepository;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicover.hms.generic.fileutility.WebdriverUtility;

public class Doctor_AddPatientPage {
	WebDriver driver;

	public Doctor_AddPatientPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="patname")
	private WebElement patientNameTextField;
	
	@FindBy(name="patcontact")
	private WebElement patientContactTextField;
	
	@FindBy(id="patemail")
	private WebElement patientEmailTextField;
	
	@FindBy(name="pataddress")
	private WebElement patientAddressTextField;
	
	@FindBy(name="patage")
	private WebElement patientAgeTextField;
	
	@FindBy(name="medhis")
	private WebElement patientMedicalHistoryTextField;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement addBtn;
	
	//@FindBy(xpath="//label[@class='block']/parent::div[@class='form-group']/descendant::label[@for='rg-female']")
	//private WebElement genderRadioBtn;
	
	@FindBy(xpath ="//input[@value='female']")
	private WebElement femaleGenderRadioBtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPatientNameTextField() {
		return patientNameTextField;
	}

	public WebElement getPatientContactTextField() {
		return patientContactTextField;
	}

	public WebElement getPatientEmailTextField() {
		return patientEmailTextField;
	}

	public WebElement getPatientAddressTextField() {
		return patientAddressTextField;
	}

	public WebElement getPatientAgeTextField() {
		return patientAgeTextField;
	}

	public WebElement getPatientMedicalHistoryTextField() {
		return patientMedicalHistoryTextField;
	}

	public WebElement getAddBtn() {
		return addBtn;
	}

	public WebElement getGenderRadioBtn() {
		return femaleGenderRadioBtn;
	}
	
	
	public void addPatientDetails(String name, String contactno, String email, String address, String age, String medHistory) throws InterruptedException, AWTException {
		
		patientNameTextField.sendKeys(name);
		Thread.sleep(2000);
		patientContactTextField.sendKeys(contactno);
		patientEmailTextField.sendKeys(email,Keys.ENTER);

		Actions action=new Actions(driver);
		//action.click(femaleGenderRadioBtn).perform();;
		patientAddressTextField.sendKeys(address);
		patientAgeTextField.sendKeys(age);
		patientMedicalHistoryTextField.sendKeys(medHistory);
		
		action.click(addBtn).perform();


	}
	
}

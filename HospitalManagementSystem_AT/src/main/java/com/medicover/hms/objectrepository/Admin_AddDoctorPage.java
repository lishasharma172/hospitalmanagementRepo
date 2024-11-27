package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.medicover.hms.generic.fileutility.WebdriverUtility;

public class Admin_AddDoctorPage {
	WebDriver driver;

	public Admin_AddDoctorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Doctorspecialization")
	private WebElement docSpeciaTextField;

	@FindBy(name = "docname")
	private WebElement docNameTextField;

	@FindBy(name = "clinicaddress")
	private WebElement docClinicAddressTextField;

	@FindBy(name = "docfees")
	private WebElement docFeesTextField;

	@FindBy(name = "doccontact")
	private WebElement docContactNoTextField;

	@FindBy(id = "docemail")
	private WebElement docMailIdTextField;

	@FindBy(name = "npass")
	private WebElement passwordTextField;

	@FindBy(name = "cfpass")
	private WebElement confirmPasswordTextField;

	@FindBy(xpath = "//button[@type='submit']	")
	private WebElement submitBtn;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement updateBtn;
	
	

	public WebElement getUpdateBtn() {
		return updateBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getDocSpeciaTextField() {
		return docSpeciaTextField;
	}

	public WebElement getDocNameTextField() {
		return docNameTextField;
	}

	public WebElement getDocClinicAddressTextField() {
		return docClinicAddressTextField;
	}

	public WebElement getDocFeesTextField() {
		return docFeesTextField;
	}

	public WebElement getDocContactNoTextField() {
		return docContactNoTextField;
	}

	public WebElement getDocMailIdTextField() {
		return docMailIdTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getConfirmPasswordTextField() {
		return confirmPasswordTextField;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	
	public void selectDoctorSpecialization() {
		docSpeciaTextField.click();
		WebdriverUtility wu=new WebdriverUtility();
		wu.selectByIndex(docSpeciaTextField,2 );
	}
	
	public void addDoctorDetails(String name, String clinic,String fees, String contactno, String email, String pass, String cpass) {
		docNameTextField.sendKeys(name);
		docClinicAddressTextField.sendKeys(clinic);
		docFeesTextField.sendKeys(fees);
		docContactNoTextField.sendKeys(contactno);
		docMailIdTextField.sendKeys(email);
		passwordTextField.sendKeys(pass);
		confirmPasswordTextField.sendKeys(cpass);
		WebdriverUtility wlib=new WebdriverUtility();
		wlib.clickElementJavaExecutor(driver, submitBtn);
//		submitBtn.click();	
	}
	public void editDocDetails(String contactno, String clinic) {
		docContactNoTextField.clear();
		docContactNoTextField.sendKeys(contactno);
		docClinicAddressTextField.clear();
		docClinicAddressTextField.sendKeys(clinic);
		updateBtn.click();
	}
	
	public void updatedDocProfile() {
		Doctor_DashboardPage ddp=new Doctor_DashboardPage(driver);
		ddp.getUpdateDoctorProfileLink().click();
	}
	
	
	

}

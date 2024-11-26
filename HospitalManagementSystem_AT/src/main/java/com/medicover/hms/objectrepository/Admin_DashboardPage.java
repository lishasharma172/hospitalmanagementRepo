package com.medicover.hms.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_DashboardPage {
	WebDriver driver;

	public Admin_DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//span[text()=' Dashboard ']")
		private WebElement dashboardLink;
		
		@FindBy(xpath="//span[text()=' Add Doctor']")
		private WebElement addDoctorLink;
		
		@FindBy(xpath="//span[text()=' Doctors ']")
		private WebElement doctorsLink;	
		
		@FindBy(xpath="//span[text()=' Doctor Specialization ']")
		private WebElement docSpecializationLink;
		
		@FindBy(xpath="//span[text()=' Manage Doctors ']")
		private WebElement manageDoctorLink;
		
		


		public WebElement getDashboardLink() {
			return dashboardLink;
		}

		public WebDriver getDriver() {
			return driver;
		}

		public WebElement getAddDoctorLink() {
			return addDoctorLink;
		}

		public WebElement getDoctorsLink() {
			return doctorsLink;
		}

		public WebElement getDocSpecializationLink() {
			return docSpecializationLink;
		}

		public WebElement getManageDoctorLink() {
			return manageDoctorLink;
		}
		
		@FindBy(partialLinkText="Admin")
		private WebElement adminLogoutLink;
		
		@FindBy(partialLinkText="Log Out")
	    private WebElement adminLogoutBtn;


		public WebElement getAdminLogoutLink() {
			return adminLogoutLink;
		}

		
		public WebElement getAdminLogoutBtn() {
			return adminLogoutBtn;
		}
		
		@FindBy(xpath="//div[@class='col-sm-8']/h1[text()='Admin | Dashboard']")
		private WebElement adminHeader;
		
		@FindBy(xpath="//div[@class='col-sm-8']/h1[text()='Admin | Manage Doctors']")
		private WebElement manageDrHeader;
		
		@FindBy(xpath="//span[text()=' Doctor Specialization ']")
		private WebElement adminAddDrSpi; 
		
		@FindBy(name="Doctorspecialization")
		private WebElement DoctorsspecialLink;
		
		@FindBy(name="doctorspecilization")
		private WebElement AddDoctorSpitextfild;
		
		@FindBy(name="submit")
		private WebElement AddDoctorSpisubmitbtn;
		
		public void drSpeciAdd() throws InterruptedException {
			doctorsLink.click();
			Thread.sleep(3000);
			adminAddDrSpi.click();
			Thread.sleep(3000);
		}
		public void addDoctorSpic(String Drspicali) throws InterruptedException {
			AddDoctorSpitextfild.sendKeys(Drspicali);
			AddDoctorSpisubmitbtn.click();
			Thread.sleep(2000);
			doctorsLink.click();
			Thread.sleep(4000);
			addDoctorLink.click();
			}
		
		
		
	
		public WebElement getAdminHeader() {
			return adminHeader;
		}

		public WebElement getManageDrHeader() {
			return manageDrHeader;
		}

		public WebElement getAdminAddDrSpi() {
			return adminAddDrSpi;
		}

		public WebElement getDoctorsspecialLink() {
			return DoctorsspecialLink;
		}

		public WebElement getAddDoctorSpitextfild() {
			return AddDoctorSpitextfild;
		}

		public WebElement getAddDoctorSpisubmitbtn() {
			return AddDoctorSpisubmitbtn;
		}

		public void addDoctor() {
			doctorsLink.click();
			addDoctorLink.click();
		}
		public void logOutAdmin() throws InterruptedException {
			adminLogoutLink.click();
			Thread.sleep(3000);
			adminLogoutBtn.click();
		}
		
		public void manageDoctor() {
			doctorsLink.click();
			manageDoctorLink.click();
		}
		
		
		
}

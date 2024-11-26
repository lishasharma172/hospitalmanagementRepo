package com.medicover.hms.objectrepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.medicover.hms.generic.fileutility.WebdriverUtility;

public class AdminLoginPage {
	WebDriver driver;

	public AdminLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminUsername() {
		return adminUsername;
	}

	public WebElement getAdminPassword() {
		return adminPassword;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getAdminLink() {
		return adminLink;
	}

	@FindBy(xpath = "//h3[text()='Admin Login']/following-sibling::div/span/a[text()='Click Here']")
	private WebElement adminLink;

	@FindBy(name = "username")
	private WebElement adminUsername;

	@FindBy(name = "password")
	private WebElement adminPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	private WebElement submitBtn;

	public void adminLogin( String username, String password) throws InterruptedException {
		WebdriverUtility wu = new WebdriverUtility();

		wu.clickElementJavaExecutor(driver, adminLink);
		// adminLink.click();
		adminUsername.sendKeys(username);
		adminPassword.sendKeys(password);
		submitBtn.click();
		Thread.sleep(3000);

	}

}

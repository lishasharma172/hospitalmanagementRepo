package Admin_Module_Login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.medicover.hms.basetest.BaseUtility;
import com.medicover.hms.objectrepository.AdminLoginPage;
import com.medicover.hms.objectrepository.Admin_AddDoctorPage;
import com.medicover.hms.objectrepository.Admin_DashboardPage;
import com.medicover.hms.objectrepository.DoctorLoginPage;
@Listeners(com.medicover.hms.listenerutility.ListenerImp.class)
public class ManageDoctorTest extends BaseUtility {
	@Test(groups="regression")
	public void manageDoctor() throws Throwable {
	
	String adminUSERNAME = fLib.getDataFromPropertyFile("admin_username");
	String adminPASSWORD = fLib.getDataFromPropertyFile("admin_password");
	System.out.println("login successfully");
	AdminLoginPage alp=new AdminLoginPage(driver);
	alp.adminLogin(adminUSERNAME, adminPASSWORD);

	
	Admin_DashboardPage dp=new Admin_DashboardPage(driver);
	dp.manageDoctor();
	
	
	WebElement DocEdtIcon = driver.findElement(By.xpath("//a[@href='manage-doctors.php?id=120&del=delete']/preceding-sibling::a"));
	wLib.clickElementJavaExecutor(driver, DocEdtIcon);
	
	
//	driver.findElement(By.xpath("//a[@href='manage-doctors.php?id=120&del=delete']/preceding-sibling::a")).click();
	Admin_AddDoctorPage adp=new Admin_AddDoctorPage(driver);
	WebElement ContactTextField = adp.getDocContactNoTextField();
	//wLib.clickElementJavaExecutor(driver, ContactTextField);
	
	Thread.sleep(3000);
	String edtiContact=eLib.getDataFromExcel("Sheet2", 1, 2);
	String editAddress=eLib.getDataFromExcel("Sheet2", 1, 3);
	
	
	adp.editDocDetails(edtiContact, editAddress);
	
	
	dp.logOutAdmin();
	
	String doctorUSERNAME = fLib.getDataFromPropertyFile("doctor_username");
	String doctorPASSWORD = fLib.getDataFromPropertyFile("doctor_password");
	
	DoctorLoginPage dlp=new DoctorLoginPage(driver);
	dlp.doctorLogin( doctorUSERNAME, doctorPASSWORD);
	adp.updatedDocProfile();
	
	String updatedDRContact = adp.getDocContactNoTextField().getAttribute("value");
	String updatedDRAdd = adp.getDocClinicAddressTextField().getText();
	Assert.assertEquals(updatedDRContact, edtiContact);
	Assert.assertEquals(updatedDRAdd, editAddress);
	}
}

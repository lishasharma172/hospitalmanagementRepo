package Admin_Module_Login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.medicover.hms.basetest.BaseUtility;
import com.medicover.hms.generic.fileutility.ExcelUtility;
import com.medicover.hms.generic.fileutility.JavaUtility;
import com.medicover.hms.objectrepository.AdminLoginPage;
import com.medicover.hms.objectrepository.Admin_AddDoctorPage;
import com.medicover.hms.objectrepository.Admin_DashboardPage;
import com.medicover.hms.objectrepository.DoctorLoginPage;
@Listeners(com.medicover.hms.listenerutility.ListenerImp.class)
public class CreateDoctorAccountTest extends BaseUtility {
	@Test
	public void createDoctor() throws Throwable {
		String URL = fLib.getDataFromPropertyFile("url");
		String adminUSERNAME = fLib.getDataFromPropertyFile("admin_username");
		String adminPASSWORD = fLib.getDataFromPropertyFile("admin_password");
		System.out.println("login successfully");
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin( adminUSERNAME, adminPASSWORD);

		Admin_DashboardPage dp = new Admin_DashboardPage(driver);
		dp.addDoctor();

		Admin_AddDoctorPage adp = new Admin_AddDoctorPage(driver);
		adp.selectDoctorSpecialization();
		
		JavaUtility jLib=new JavaUtility();

		ExcelUtility eLib = new ExcelUtility();
		

		String DOCNAME = eLib.getDataFromExcel("Sheet1", 1, 2);
		String CLINICADDRESS = eLib.getDataFromExcel("Sheet1", 1, 3);
		String FEES = eLib.getDataFromExcel("Sheet1", 1, 4);
		String CONTACT = eLib.getDataFromExcel("Sheet1", 1, 5);
		String EMAIL = eLib.getDataFromExcel("Sheet1", 1, 6)+jLib.getRandomNumber();
		String PASSWORD = eLib.getDataFromExcel("Sheet1", 1, 7);
		String CPASSWORD = eLib.getDataFromExcel("Sheet1", 1, 8);

		adp.addDoctorDetails(DOCNAME, CLINICADDRESS, FEES, CONTACT, EMAIL, PASSWORD, CPASSWORD);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		dp.logOutAdmin();
		
		String doctorUSERNAME = fLib.getDataFromPropertyFile("doctor_username");
		String docotrPASSWORD = fLib.getDataFromPropertyFile("doctor_password");
		System.out.println("doctor loggedin successfully");
		DoctorLoginPage dlp=new DoctorLoginPage(driver);
		dlp.doctorLogin( doctorUSERNAME, docotrPASSWORD);
		
		
		String expectedTitle="Doctor | Dashboard";
        String actTitle =driver.getTitle();
        Assert.assertEquals(actTitle, expectedTitle);
        	
        }
	}



package Doctor_Module_;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.medicover.hms.basetest.BaseUtility;
import com.medicover.hms.generic.fileutility.ExcelUtility;
import com.medicover.hms.generic.fileutility.JavaUtility;
import com.medicover.hms.generic.fileutility.WebdriverUtility;
import com.medicover.hms.objectrepository.DoctorLoginPage;
import com.medicover.hms.objectrepository.Doctor_AddPatientPage;
import com.medicover.hms.objectrepository.Doctor_DashboardPage;
import com.medicover.hms.objectrepository.PatientLoginPage;
import com.medicover.hms.objectrepository.Patient_DashboardPage;
@Listeners(com.medicover.hms.listenerutility.ListenerImp.class)
public class AddPatientTest extends BaseUtility {

	@Test(groups="regression")
	public void addPatient() throws Throwable {
		String URL = fLib.getDataFromPropertyFile("url");
		String doctorUSERNAME = fLib.getDataFromPropertyFile("doctor_username");
		String doctorPASSWORD = fLib.getDataFromPropertyFile("doctor_password");
		System.out.println("login successfully");
		DoctorLoginPage dlp = new DoctorLoginPage(driver);
		dlp.doctorLogin(doctorUSERNAME, doctorPASSWORD);

		Doctor_DashboardPage ddp = new Doctor_DashboardPage(driver);
		ddp.addPatient();

		JavaUtility jLib = new JavaUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebdriverUtility wu = new WebdriverUtility();

		String PatientName = eLib.getDataFromExcel("Sheet1", 4, 2) + jLib.getRandomNumber();
		String PatientContact = eLib.getDataFromExcel("Sheet1", 4, 3);
		String PatientEmail = eLib.getDataFromExcel("Sheet1", 4, 4)+ jLib.getRandomNumber();
		String PatientAddress = eLib.getDataFromExcel("Sheet1", 4, 5);
		String PatientAge = eLib.getDataFromExcel("Sheet1", 4, 6);
		String PatientMedHistory = eLib.getDataFromExcel("Sheet1", 4, 7);

		Doctor_AddPatientPage dap = new Doctor_AddPatientPage(driver);
		dap.addPatientDetails(PatientName, PatientContact, PatientEmail, PatientAddress, PatientAge, PatientMedHistory);
		

		
		ddp.searchPatient(PatientName);
	 	Assert.assertTrue(driver.findElement(By.xpath("//td[text()='"+PatientName+"']")).isDisplayed());
		
		
	    
	}

}

package Paitent_Module_Login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.medicover.hms.basetest.BaseUtility;
import com.medicover.hms.objectrepository.PatientLoginPage;
import com.medicover.hms.objectrepository.Patient_DashboardPage;
@Listeners(com.medicover.hms.listenerutility.ListenerImp.class)
public class PatientLoginTest extends BaseUtility {
@Test
public void userLogin() throws Throwable {
	String URL = fLib.getDataFromPropertyFile("url");
	String patientUSERNAME = fLib.getDataFromPropertyFile("patient_username");
	String patientPASSWORD = fLib.getDataFromPropertyFile("patient_password");
	System.out.println("login successfully");
	PatientLoginPage plp=new PatientLoginPage(driver);
	plp.patientLogin(patientUSERNAME, patientPASSWORD);
	
	String expectedData="USER | DASHBOARD";
	Patient_DashboardPage pdp=new Patient_DashboardPage(driver);
	String userHeader =pdp.getUserHeader().getText();
      Assert.assertTrue(userHeader.contains(expectedData));
	
}
}

package Paitent_Module_Login;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.medicover.hms.basetest.BaseUtility;
import com.medicover.hms.generic.fileutility.WebdriverUtility;
import com.medicover.hms.objectrepository.PatientLoginPage;
import com.medicover.hms.objectrepository.Patient_DashboardPage;
@Listeners(com.medicover.hms.listenerutility.ListenerImp.class)
public class CancelAppointmentTest extends BaseUtility {
	@Test(groups="smoke")
	public void cancelAppointmentByUser() throws Throwable {
		String URL = fLib.getDataFromPropertyFile("url");
		String patientUSERNAME = fLib.getDataFromPropertyFile("patient_username");
		String patientPASSWORD = fLib.getDataFromPropertyFile("patient_password");
		System.out.println("login successfully");
		PatientLoginPage plp = new PatientLoginPage(driver);
		plp.patientLogin(patientUSERNAME, patientPASSWORD);
		
		Patient_DashboardPage pdp=new Patient_DashboardPage(driver);
		pdp.clickAppointHistory();
		
		driver.findElement(By.xpath("//table[@class='table table-hover']/tbody/tr[contains(.,'Aapti')]/td[8]")).click();
		
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
		//alert.accept();
		
		
		
		
	}
}

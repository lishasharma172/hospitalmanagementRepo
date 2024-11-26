package Admin_Module_Login;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.medicover.hms.basetest.BaseUtility;
import com.medicover.hms.objectrepository.AdminLoginPage;
import com.medicover.hms.objectrepository.Admin_DashboardPage;
@Listeners(com.medicover.hms.listenerutility.ListenerImp.class)
public class DoctorSpecialization extends BaseUtility{


		@Test
		public void doctorSpecialization() throws Throwable {
			String URL = fLib.getDataFromPropertyFile("url");
			String adminUSERNAME = fLib.getDataFromPropertyFile("admin_username");
			String adminPASSWORD = fLib.getDataFromPropertyFile("admin_password");
			System.out.println("login successfully");
			AdminLoginPage alp=new AdminLoginPage(driver);
			alp.adminLogin(adminUSERNAME, adminPASSWORD);
			
			
			System.out.println("Login to the usermodule successfully");

			Admin_DashboardPage adp = new Admin_DashboardPage(driver);
			adp.drSpeciAdd();
			String drSpicAdd = eLib.getDataFromExcel("Sheet3", 1, 1);
			adp.addDoctorSpic(drSpicAdd);
			System.out.println(drSpicAdd);
			WebElement doctorsspecialLink = adp.getDoctorsspecialLink();
			adp.getDoctorsspecialLink().click();
			
			Thread.sleep(3000);
			
			Select select = new Select(doctorsspecialLink);
			List<WebElement> allDrSpeciOptions = select.getOptions();
			
			Thread.sleep(3000);
			String expected=null;
			boolean flag=false;
			
			for(WebElement ele:allDrSpeciOptions) {
				expected=ele.getText();
				if(expected.contains(drSpicAdd)) {
					flag=true;
					break;
				}
			}
			Assert.assertTrue(flag);
}}

package Admin_Module_Login;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.medicover.hms.basetest.BaseUtility;
import com.medicover.hms.objectrepository.AdminLoginPage;
import com.medicover.hms.objectrepository.Admin_DashboardPage;

@Listeners(com.medicover.hms.listenerutility.ListenerImp.class)
public class AdminLoginTest extends BaseUtility {
	
	@Test(groups="smoke")
	public void adminLogin() throws Throwable {
		String URL = fLib.getDataFromPropertyFile("url");
		String adminUSERNAME = fLib.getDataFromPropertyFile("admin_username");
		String adminPASSWORD = fLib.getDataFromPropertyFile("admin_password");
		System.out.println("login successfully");
		AdminLoginPage alp = new AdminLoginPage(driver);
		alp.adminLogin(adminUSERNAME, adminPASSWORD);

		
		String expectedData="ADMIN | DASHBOARD";
		
	  Admin_DashboardPage adp=new Admin_DashboardPage(driver);
      String adminHeader = adp.getAdminHeader().getText();
      System.out.println(adminHeader);
      Assert.assertTrue(adminHeader.contains(expectedData));
	}

}

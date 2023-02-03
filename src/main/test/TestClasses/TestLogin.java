package TestClasses;

import POM.Login;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;

public class TestLogin extends BaseTest {



	@Test(priority = 0,enabled = false)
	public  void ValidLogin() {
		extent.startTest(" ValidLogin Extent Data");
		test.setDescription(" Verify that User is able to login successfully. ");
		Login login = new Login();
		login.validLogin();

	}

}

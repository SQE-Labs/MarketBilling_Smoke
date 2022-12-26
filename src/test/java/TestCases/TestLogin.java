package TestCases;

import ExtentReport.ExtentReportClass;
import POM.Flow1Login;
import org.testng.annotations.Test;

public class TestLogin extends ExtentReportClass {



	@Test(priority = 0)
	public static void ValidLogin() {
		extentTest = extent.startTest(" ValidLogin ");
		extentTest.setDescription(" Verify that User is able to login successfully. ");
		Flow1Login.ValidLogin();
	}
}

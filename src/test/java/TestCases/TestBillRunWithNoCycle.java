package TestCases;

import ExtentReport.ExtentReportClass;
import POM.Flow5_AddCustomer;
import POM.Flow6_7AddingServiceAndMeter;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan;

public class TestBillRunWithNoCycle extends ExtentReportClass {
	

	@Test(priority = 2)
	public static void BillRunWithNoCycle() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
		Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterR();
		POM.Flow4_BillRunWithNoCycle.Billrun.BillrunMethod_NoCycle();
		
	}
	
	
	

}
 
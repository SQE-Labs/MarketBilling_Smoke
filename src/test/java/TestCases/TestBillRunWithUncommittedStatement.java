
package TestCases;

import ExtentReport.ExtentReportClass;
import POM.Flow5_AddCustomer;
import POM.Flow6_7AddingServiceAndMeter;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan;

public class TestBillRunWithUncommittedStatement extends ExtentReportClass {
	
	

	
	@Test(priority = 1)
	public static void BillRunWithUncommittedStatement() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With Uncommitted Statement ");
		extentTest.setDescription(" Verify that User is gets the confirmation popup when user tries to run the bill WitUncommitted Statement ");
		Flow5_AddCustomer.ThirdCustomer.ThirdCommercialCustomer();
		Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();
		//Flow6_7AddingServiceAndMeter.Metering.AddMeter();
	//	Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle(CustomerID03C);
	//	Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
	///	POM.Flow10_BillRunWithUncommittedStatement.BillRunWithUncommittedStatement();
		
	}
	
	
	

}
 
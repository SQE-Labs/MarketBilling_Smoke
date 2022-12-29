package TestCases;

import ExtentReport.ExtentReportClass;
import POM.Flow5_AddCustomer;
import POM.Flow6_7AddingServiceAndMeter;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan; //TestTwoCustomerBillRun

public class TestSingleCustomerBillRun extends ExtentReportClass {
	
	
	@Test(priority = 1) 
	public static void CreateCustomerFor_BillrunCycle() throws InterruptedException {
		extentTest = extent.startTest(" Create Customer for bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
		Flow6_7AddingServiceAndMeter.X_AddService.EditService();
		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
		Thread.sleep(128000);

	}
		@Test(priority = 2) 
		public static void SmallBillRunWithSingleCustomer() throws InterruptedException { 
			extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
			extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
		//	Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle(CustomerID01R);
		//	POM.Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
		Thread.sleep(41000);
		}	
		@Test(priority = 3) 
		
			public static void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException { 
				extentTest = extent.startTest(" Rollback for single customer ");
				extentTest.setDescription(" Verify that User is able to run rollback single customer ");
		    	//POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
			Thread.sleep(18000);

		}

	@Test(priority = 4)

	public static void rebill_and_Reuse() throws InterruptedException {
		extentTest = extent.startTest(" Rebill and Reuse Statement ");
		extentTest.setDescription(" Verify that User is able to run rebill and reuse and Statement");
		//POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
     Thread.sleep(35000);
	}
	@Test(priority = 4)

	public static void rebill_New_statement() throws InterruptedException {
		extentTest = extent.startTest(" Rebill with  new  Statement ");
		extentTest.setDescription(" Verify that User is able to run rebill  with new Statement");
		//POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
		Thread.sleep(20000);
	}

}
 
package TestCases;

import ExtentReport.ExtentReportClass;
import POM.Flow5_AddCustomer;
import POM.Flow6_7AddingServiceAndMeter;
import POM.Flow8_AllBillrunCycles;
import org.testng.annotations.Test;

import static POM.Flow5_AddCustomer.CustomerID01R;

//import POM.Flow2_3AddTOUFileAndPlan; //TestTwoCustomerBillRun

public class TestSingleCustomerBillRun extends ExtentReportClass {
	
	
	@Test(priority = 1) 
	public static void CreateCustomerFor_BillrunCycle() throws InterruptedException {
		extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
		Flow6_7AddingServiceAndMeter.X_AddService.EditService();
		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
	}
		@Test(priority = 2) 
		public static void SmallBillRunWithSingleCustomer() throws InterruptedException { 
			extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
			extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
			Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle(CustomerID01R);
			POM.Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
			
		}	
		@Test(priority = 3) 
		
			public static void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException { 
				extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
				extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
		    	POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
			
	}
	
	
	

}
 
package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan; //TestTwoCustomerBillRun

public class TestSingleCustomerBillRun extends ExtentReportClass {
	
	
	@Test(priority = 1) 
	public static void X_BillrunCycle() throws InterruptedException { 
		extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
		POM.Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle(); 
		
	}
		@Test(priority = 2) 
		public static void SmallBillRunWithSingleCustomer() throws InterruptedException { 
			extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
			extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
			POM.Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer(); 
			
		}	
		@Test(priority = 3) 
		
			public static void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException { 
				extentTest = extent.startTest(" Small Cycle Bill run with 1 customer ");
				extentTest.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
				POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
			
	}
	
	
	

}
 
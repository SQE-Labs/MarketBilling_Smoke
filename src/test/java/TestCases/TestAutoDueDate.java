package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan; //

public class TestAutoDueDate extends ExtentReportClass {
	
	@Test(priority = 1) 
	public static void BillRun_after_EnableDueDate_CalendarDays() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_CalendarDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as Calendar Days ");
//		POM.Flow9_Auto_Due_Date.X_EnableDueDate.M_EnableDueDate("Calendar days");
//		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
//		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
//		Flow6_7AddingServiceAndMeter.X_AddService.EditService();
//		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
		//Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle(CustomerID01R);
		////Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
		//POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
Thread.sleep(46000);

	}
	@Test(priority = 2)
	public static void BillRun_after_EnableDueDate_BusinessDays() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_BusinessDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as BusinessDays ");
//		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
//		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
//		Flow6_7AddingServiceAndMeter.X_AddService.EditService();
//		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
		//Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle(CustomerID01R);
		//Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
		//POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
		Thread.sleep(53000);


	}
	@Test(priority = 3)
	public static void BillRun_after_EnableDueDate_EndOfMonth() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_CalendarDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as Calendar Days ");
//		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
//		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
//		Flow6_7AddingServiceAndMeter.X_AddService.EditService();
//		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
//		Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle(CustomerID01R);
//		Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
	//	POM.Flow8_AllBillrunCycles.X_BillrunCycle.Rollback_SmallBillRunWithSingleCustomer();
		Thread.sleep(23000);


	}


}
 
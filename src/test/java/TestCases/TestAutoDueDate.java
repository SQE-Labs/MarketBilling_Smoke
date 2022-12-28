package TestCases;

import POM.Flow6_7AddingServiceAndMeter;
import POM.Flow8_AllBillrunCycles;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan; //

public class TestAutoDueDate extends TestLogin {
	
	@Test(priority = 1) 
	public static void BillRun_after_EnableDueDate_CalendarDays() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_CalendarDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as Calendar Days ");
		POM.Flow9_Auto_Due_Date.X_EnableDueDate.M_EnableDueDate("Calendar days");
		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterC();
		Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();



	}
	@Test(priority = 2)
	public static void BillRun_after_EnableDueDate_BusinessDays() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_BusinessDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as BusinessDays ");
		POM.Flow9_Auto_Due_Date.X_EnableDueDate.M_EnableDueDate("Business days");
		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterC();
		Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();



	}
	@Test(priority = 3)
	public static void BillRun_after_EnableDueDate_EndOfMonth() throws InterruptedException {
		extentTest = extent.startTest("BillRun_after_EnableDueDate_CalendarDays");
		extentTest.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as Calendar Days ");
		POM.Flow9_Auto_Due_Date.X_EnableDueDate.M_EnableDueDate("End of month");
		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterC();
		Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();



	}


}
 
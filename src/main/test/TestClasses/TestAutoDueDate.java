package TestClasses;

import POM.*;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestAutoDueDate extends BaseTest {

	@Test(priority = 1,enabled = true)
	public  void BillRun_after_EnableDueDate_CalendarDays() throws InterruptedException {
		extent.startTest("BillRun_after_EnableDueDate_CalendarDays");
		test.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as Calendar Days ");
		AdminGroup.M_EnableDueDate("Calendar days");
		String customerId = Customer.createCustomer("Tenant", "Residential", "business123@yopmail.com");
		String serviceId=Services.M_AddService(customerId);
		Services.EditService();
		String 	meterId =Metering.AddMeter();
		String 	registerId =Metering.createRegister();
		Metering.addMeterReads("Initial","150","200","300");
		Metering.addMeterReads("Actual Read","200","400","650");
		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		String billRunCycle=BillRun.createBillCycle(customerList);
		BillRun.runBillCycle(billRunCycle);
	}
	@Test(priority = 2,enabled = true)
	public  void BillRun_after_EnableDueDate_BusinessDays() throws InterruptedException {
		extent.startTest("BillRun_after_EnableDueDate_BusinessDays");
		test.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as BusinessDays ");
		AdminGroup.M_EnableDueDate("Business days");
		String customerId = Customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
		String serviceId=Services.M_AddService(customerId);
		Services.EditService();
	    String 	meterId =Metering.AddMeter();
      	String 	registerId =Metering.createRegister();
		Metering.addMeterReads("Initial","150","200","300");
		Metering.addMeterReads("Actual Read","200","400","650");

		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		String billRunCycle=BillRun.createBillCycle(customerList);
		BillRun.runBillCycle(billRunCycle);

	}
	@Test(priority = 3)
	public  void BillRun_after_EnableDueDate_EndOfMonth() throws InterruptedException {
		extent.startTest("BillRun_after_EnableDueDate_EndOfMonth");
		test.setDescription(" Verify that User is able to Run Bill after enabling  due date by Payment term method as End of Month");
		AdminGroup.M_EnableDueDate("End of month");
		String customerId = Customer.createCustomer("Tenant", "Commercial", "residential123@yopmail.com");
		String serviceId=Services.M_AddService(customerId);
		Services.EditService();
		String 	meterId =Metering.AddMeter();
		String 	registerId =Metering.createRegister();
		Metering.addMeterReads("Initial","150","200","300");
		Metering.addMeterReads("Actual Read","200","400","650");
		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		String billRunCycle=BillRun.createBillCycle(customerList);
		BillRun.runBillCycle(billRunCycle);	}


}

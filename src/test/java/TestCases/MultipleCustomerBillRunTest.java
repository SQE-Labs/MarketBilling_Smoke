package TestCases;

import CommonMethods.BaseTest;
import POM.BillRun;
import POM.Customer;
import POM.Metering;
import POM.Services;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static POM.Flow5_AddCustomer.*;

public class MultipleCustomerBillRunTest extends BaseTest {
	public String customerId;
	public String customerId2;
	public String billRunCycle;

	@Test(priority = 1,enabled = true)
	public  void TestLargeBillRun() throws InterruptedException {
		extentTest = extent.startTest(" Large Cycle Bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the large bill run with 1 customer ");
		List<String> customerList = new ArrayList<String>();
		customerList.add(CustomerID01R);
		customerList.add(CustomerID02B);
		customerList.add(CustomerID03C);
		String billRunCycleName=BillRun.createBillCycle(customerList);
		BillRun.runBillCycle(billRunCycleName);
	}
	@Test(priority = 2,enabled = true)
	public  void BillRunWithUncommittedStatement() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With Uncommitted Statement ");
		extentTest.setDescription(" Verify that User is gets the confirmation popup when user tries to run the bill WitUncommitted Statement ");
		String customerId = Customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
		String serviceId=Services.M_AddService(customerId);
		Services.EditService();
		String 	meterId =Metering.AddMeter();
		String 	registerId =Metering.createRegister();
		Metering.addMeterReads("Initial","150","200","300");
		Metering.addMeterReads("Actual Read","200","400","650");
		String billRunCycle=BillRun.BillRunCycle(customerId);
		BillRun.SmallBillRunWithSingleCustomer(billRunCycle);
		BillRun.BillRunWithUncommittedStatement(billRunCycle,customerId);

	}
	@Test(priority = 3,enabled = true)
	public  void TwoCustomerBillRun() throws InterruptedException {
		extentTest = extent.startTest(" Small Cycle Bill run with 2 customer ");
		extentTest.setDescription(" Verify that User is able to run the small bill run with 2 customer ");
		 customerId = Customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
		String serviceId=Services.M_AddService(customerId);
		Services.EditService();
		String 	meterId =Metering.AddMeter();
		String 	registerId =Metering.createRegister();
		Metering.addMeterReads("Initial","150","200","300");
		Metering.addMeterReads("Actual Read","200","400","650");

		customerId2 = Customer.createCustomer("Tenant", "Business", "business124@yopmail.com");
		String serviceId2=Services.M_AddService(customerId2);
		Services.EditService();
		String 	meterId2 =Metering.AddMeter();
		String 	registerId2 =Metering.createRegister();
		Metering.addMeterReads("Initial","150","200","300");
		Metering.addMeterReads("Actual Read","200","400","650");
		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		customerList.add(customerId2);
		billRunCycle=BillRun.createBillCycle(customerList);
		BillRun.runBillCycleForRollBack(billRunCycle);

	}
	@Test(priority = 4,enabled = true)
	public  void TwoCustomer_RollBack() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		BillRun.rollback();
	}
	@Test(priority = 5,enabled = true)
	public  void TwoCustomer_ReBill() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		List<String> customerList = new ArrayList<String>();
		customerList.add(customerId);
		customerList.add(customerId2);
		BillRun.runBillCycle(billRunCycle);

	}
	@Test(priority = 6,enabled = true)
	public  void TwoCustomer_FullStatementRollBack() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rollback ");
		extentTest.setDescription(" Verify that User is able to run full statement rollback with 2 customer ");
		BillRun.rollback_in_statementTab(customerId2);
	}
	@Test(priority = 7,enabled = true)
	public  void TwoCustomer_RebillStatement() throws InterruptedException {
		extentTest = extent.startTest(" Full Statement Rebill ");
		extentTest.setDescription(" Verify that User is able to run full statement rebill ");
		String customerId2="40975";
		BillRun.statementRebill(customerId2);
	}
	@Test(priority = 8,enabled = true)
	public  void BillRunWithNoCycle() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		String customerId = Customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
		String serviceId=Services.M_AddService(customerId);
		Services.EditService();
		String 	meterId =Metering.AddMeter();
		String 	registerId =Metering.createRegister();
		Metering.addMeterReads("Initial","150","200","300");
		Metering.addMeterReads("Actual Read","200","400","650");
		BillRun.BillrunMethod_NoCycle();
	}
}

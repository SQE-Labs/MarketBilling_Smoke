package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.Metering;
import POM.Services;
import org.testng.annotations.Test;

public class TestAddMeter extends BaseTest {
	String 	registerId;
	@Test(priority = 1)
	public  void Metering() throws InterruptedException {
		extentTest = extent.startTest("Add  Meter  for Residential Customer ");
		extentTest.setDescription(" Verify that User is able to add Meter. ");
		Customer.searchAndNavigateToRecentCustomer();
		Services.navigateToEditServices();
		Metering.AddMeter();
	}
	@Test(priority = 2)
	public  void MeterRegister() throws InterruptedException {
		extentTest = extent.startTest(" Meter Register ");
		extentTest.setDescription(" Verify that User is able to register meter ");
		registerId =	Metering.createRegister();

	}
	@Test(priority = 3)
	public  void MeterReadsInitial() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Initial ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads ");
		Metering.addMeterReads("Initial","150","200","300");
	}
	@Test(priority = 4)
	public  void MeterReadsConsumption() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Consumption Data  ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads consumption data ");
		Metering.addMeterReads("Actual Read","200","400","650");

	}
}

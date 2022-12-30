package TestCases;

import CommonMethods.BaseTest;
import POM.Metering;
import org.testng.annotations.Test;

public class TestAddMeter extends BaseTest {
	@Test(priority = 1)
	public static void Metering() throws InterruptedException {
		extentTest = extent.startTest("Add  Meter  ");
		extentTest.setDescription(" Verify that User is able to add Meter. ");
		Metering.AddMeter();
	}
	@Test(priority = 2)
	public static void MeterRegister() throws InterruptedException {
		extentTest = extent.startTest(" Meter Register ");
		extentTest.setDescription(" Verify that User is able to register meter ");
		Metering.createRegister();

	}
	@Test(priority = 3)
	public static void MeterReadsInitial() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Initial ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads ");
		Metering.addMeterReads("Initial","150","200","300");
	}
	@Test(priority = 3)
	public static void MeterReadsConsumption() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads Consumption Data  ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads consumption data ");
		Metering.addMeterReads("Actual Read","200","400","650");

	}
}

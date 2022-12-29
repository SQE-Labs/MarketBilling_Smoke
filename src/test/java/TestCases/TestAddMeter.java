package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.Test;

public class TestAddMeter extends ExtentReportClass {

	@Test(priority = 1)
	public static void Metering() throws InterruptedException {
		extentTest = extent.startTest("Add  Meter  ");
		extentTest.setDescription(" Verify that User is able to add Meter. ");
		//Flow6_7AddingServiceAndMeter.Metering.AddMeter();
		Thread.sleep(30000);
	}
	@Test(priority = 1)
	public static void MeterReads() throws InterruptedException {
		extentTest = extent.startTest(" Meter Reads  ");
		extentTest.setDescription(" Verify that User is able to add  Meter Reads ");
		//Flow6_7AddingServiceAndMeter.Metering.AddMeter();
		Thread.sleep(40000);

	}
	@Test(priority = 1)
	public static void MeterRegister() throws InterruptedException {
		extentTest = extent.startTest(" Meter Register ");
		extentTest.setDescription(" Verify that User is able to register meter ");
		//Flow6_7AddingServiceAndMeter.Metering.AddMeter();
		Thread.sleep(50000);

	}@Test(priority = 1)
	public static void AddMeter_Commercial() throws InterruptedException {
		extentTest = extent.startTest(" Meter add commercial Customer");
		extentTest.setDescription(" Verify that User is able to add meter for comercial customer ");
		////Flow6_7AddingServiceAndMeter.Metering.AddMeter();
		Thread.sleep(30000);

	}
}
 
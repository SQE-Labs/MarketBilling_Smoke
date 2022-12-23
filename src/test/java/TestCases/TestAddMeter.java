package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.Test;
import POM.Flow6_7AddingServiceAndMeter;

public class TestAddMeter extends ExtentReportClass {

	@Test(priority = 1)
	public static void Metering() throws InterruptedException {
		extentTest = extent.startTest(" Meter ");
		extentTest.setDescription(" Verify that User is able to add Meter. ");
		Flow6_7AddingServiceAndMeter.Metering.AddMeter();
	}
	
}
 
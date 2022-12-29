package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.Test;
import POM.Flow5_AddCustomer;

public class TestCustomers extends ExtentReportClass {

	@Test(priority = 1)
	public static void ResidentialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" Customer ");
		extentTest.setDescription(" Verify that User is able to add Residential customer. ");
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
	}
	
	@Test(priority = 2)
	public static void BusinessCustomer() throws InterruptedException {
		extentTest = extent.startTest(" SecondCustomer ");
		extentTest.setDescription(" Verify that User is able to add Business SecondCustomer. ");
	   Flow5_AddCustomer.SecondCustomer.SecondBusinessCustomer();
	}
	
	@Test(priority = 3)
	public static void CommercialCustomer() throws InterruptedException {
		extentTest = extent.startTest(" ThirdCustomer ");
		extentTest.setDescription(" Verify that User is able to add  Commercial ThirdCustomer. ");
	   Flow5_AddCustomer.ThirdCustomer.ThirdCommercialCustomer();
	}
}
 
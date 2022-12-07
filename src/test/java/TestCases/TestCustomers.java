package TestCases;

import org.testng.annotations.Test;
import POM.Flow5_AddCustomer;

public class TestCustomers extends TestLogin{

	@Test(priority = 1)
	public static void Customer() throws InterruptedException {
		extentTest = extent.startTest(" Customer ");
		extentTest.setDescription(" Verify that User is able to add customer. ");
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
	}
	
	@Test(priority = 2)
	public static void SecondCustomer() throws InterruptedException {
		extentTest = extent.startTest(" SecondCustomer ");
		extentTest.setDescription(" Verify that User is able to add SecondCustomer. ");
	   Flow5_AddCustomer.SecondCustomer.SecondBusinessCustomer();
	}
	
	@Test(priority = 3)
	public static void ThirdCustomer() throws InterruptedException {
		extentTest = extent.startTest(" ThirdCustomer ");
		extentTest.setDescription(" Verify that User is able to add ThirdCustomer. ");
	   Flow5_AddCustomer.ThirdCustomer.ThirdCommercialCustomer();
	}
}
 
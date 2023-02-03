package TestClasses;

import POM.Flow5_AddCustomer;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;

public class TestCustomers extends BaseTest {

	@Test(priority = 1)
	public  void ResidentialCustomer() throws InterruptedException {
		extent.startTest(" Add Residential Customer ");
		test.setDescription(" Verify that User is able to add Residential customer. ");
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
	}

	@Test(priority = 2)
	public  void BusinessCustomer() throws InterruptedException {
		extent.startTest(" Add Business Customer ");
		test.setDescription(" Verify that User is able to add Business SecondCustomer. ");
	   Flow5_AddCustomer.SecondCustomer.SecondBusinessCustomer();
	}

	@Test(priority = 3)
	public  void CommercialCustomer() throws InterruptedException {
		extent.startTest(" Add Commercial Customer ");
		test.setDescription(" Verify that User is able to add  Commercial ThirdCustomer. ");
	   Flow5_AddCustomer.ThirdCustomer.ThirdCommercialCustomer();
	}
}

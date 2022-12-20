package TestCases;

import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan;

public class TestBillRunWithNoCycle extends TestLogin{
	
	
	@Test(priority = 1) 
	public static void BillRunWithNoCycle() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		POM.Flow4_BillRunWithNoCycle.BillRunWithNoCycle();
		
	}
	
	@Test(priority = 2)
	public static void BillrunMethod_NoCycle() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		POM.Flow4_BillRunWithNoCycle.Billrun.BillrunMethod_NoCycle();
		
	}
	
	
	

}
 
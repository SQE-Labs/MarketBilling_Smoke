package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan; //

public class TestLargeBillRun extends ExtentReportClass {
//	@BeforeClass
//	public void login() throws InterruptedException, IOException {
//		try{
//			Flow1Login.ValidLogin();
//		}catch(Exception e){
//        System.out.println(e);
//		}
//	}

	
	@Test(priority = 1) 
	public static void TestLargeBillRun() throws InterruptedException {
		extentTest = extent.startTest(" Large Cycle Bill run with 1 customer ");
		extentTest.setDescription(" Verify that User is able to run the large bill run with 1 customer ");
		POM.Flow8_AllBillrunCycles.X_BillrunCycle.LargeBillRun(); 
		
	}





}
 
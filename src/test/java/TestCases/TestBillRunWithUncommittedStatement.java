
package TestCases;

import ExtentReport.ExtentReportClass;
import org.testng.annotations.Test;

//import POM.Flow2_3AddTOUFileAndPlan;

public class TestBillRunWithUncommittedStatement extends ExtentReportClass {
	
	

	
	@Test(priority = 1)
	public static void BillRunWithUncommittedStatement() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With Uncommitted Statement ");
		extentTest.setDescription(" Verify that User is gets the confirmation popup when user tries to run the bill WitUncommitted Statement ");
		POM.Flow10_BillRunWithUncommittedStatement.BillRunPrerequiste();
		POM.Flow10_BillRunWithUncommittedStatement.BillRunWithUncommittedStatement();
		
	}
	
	
	

}
 
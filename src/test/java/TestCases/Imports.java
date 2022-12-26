package TestCases;

import ExtentReport.ExtentReportClass;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.Test;

import java.io.IOException;

//import POM.Flow2_3AddTOUFileAndPlan;

public class Imports extends ExtentReportClass {
	
	
	@Test(priority = 1) 
	public static void CustomerPrerequiste() throws InterruptedException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.CustomerPrerequiste();
		
	}
	
	@Test(priority = 2)
	public static void MeterNumberImport() throws InterruptedException, IOException, CsvException {
		extentTest = extent.startTest(" Bill Run With No Cycle ");
		extentTest.setDescription(" Verify that User is able to run the bill without any cycle ");
		POM.Flow11Import_Transactions_Update_Download_And_EmailStatement.MeterNumberImport.MeterNumberImportFile();
		
	}
	
	
	

}
 
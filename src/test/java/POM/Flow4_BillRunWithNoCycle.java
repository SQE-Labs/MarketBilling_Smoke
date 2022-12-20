package POM;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.testng.asserts.SoftAssert;

import CommonMethods.WebDriverWaits;

//import org.openqa.selenium.By;

import TestCases.TestLogin;

public class Flow4_BillRunWithNoCycle extends TestLogin {

	public static JavascriptExecutor jse = (JavascriptExecutor) driver;

	public static void BillRunWithNoCycle() throws InterruptedException {
		Thread.sleep(2000);
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
		Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();

		Flow6_7AddingServiceAndMeter.X_AddService.AddMeter_MeterRegisterR();

		
	}

	public static class Billrun {

		public static By BillRun_Tab = By.xpath("//*[@class='icon-tasks']");
		public static By RunTheBills_Button = By.xpath("//*[@class='btn btn-success']");
		public static By BillRun_StartDate_Datepicker = By.xpath("//*[@id='cycleDate']");
		public static By Select_BillRun_StartDate_Datepicker = By.xpath("//*[@class='active day']");
		public static By BillRun_EndDate_Datepicker = By.xpath("//*[@id='cycleEnd']");
		public static By Select_BillRun_EndDate_Datepicker = By.xpath("//*[@class='active day']");
		public static By BillRun_IssueDate_Datepicker = By.xpath("//*[@id='issueDate']"); 
		public static By Select_BillRun_IssueDate_Datepicker = By.xpath("//*[@class='active day']"); 
		public static By BillRun_DueDate_Datepicker = By.xpath("//*[@id='dueDate']"); 
		public static By Select_BillRun_DueDate_Datepicker = By.xpath("//*[@class='active day']");
		
		public static By BillRun_Button = By.xpath("//button[contains(text(),'Run Bill')]");
		public static By Continue_Button = By.xpath("//button[contains(text(),'Continue')]");
		public static By OK_Button = By.xpath("//button[contains(text(),'OK')]");
		public static By Spinner_Icon = By.xpath("//div[@class='spinner']");
		public static By View_Button = By.xpath("//button[contains(text(),'View')]");
		public static By Cancel_Button = By.xpath("//*[@class='close']");
		public static By Yes_Button = By.xpath("//button[contains(text(),'Yes')]");
		
		public static void BillrunMethod_NoCycle() throws InterruptedException {
			// SoftAssert softAssert = new SoftAssert();

			jse.executeScript("window.scrollBy(0,-400)", "");
			WebDriverWaits.ClickOn(BillRun_Tab);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

			WebDriverWaits.ClickOn(RunTheBills_Button);
			WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
			WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
			WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
			WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
			WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
			WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
			WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
			WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(BillRun_Button);
			WebDriverWaits.ClickOn(Continue_Button);
			Thread.sleep(2000);
		    WebDriverWaits.ClickOn(OK_Button);
//			Thread.sleep(500000);
//			WebDriverWaits.WaitUntilInvisible(Spinner_Icon);
			WebDriverWaits.ClickAfter5mins(View_Button);
//			WebDriverWaits.ClickOn(View_Button);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(Cancel_Button);
			Thread.sleep(2000);

			WebDriverWaits.ClickOn(Yes_Button);
			Thread.sleep(2000);


			
		}

	}

}

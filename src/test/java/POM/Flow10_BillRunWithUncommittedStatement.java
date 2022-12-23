package POM;

import CommonMethods.WebDriverWaits;
import POM.Flow4_BillRunWithNoCycle.Billrun;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Flow10_BillRunWithUncommittedStatement extends TestLogin {
    public static By OK_Button =By.xpath("//*[contains(text(),'OK')]");
    public static By ConfirmationAssertion = By.xpath("//*[@class='bootstrap-dialog-message']");
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	public static void BillRunPrerequiste() throws InterruptedException {
//		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterR();
		driver.navigate().refresh();
		Thread.sleep(2000);
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
		Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterC();
		
		Flow8_AllBillrunCycles.X_BillrunCycle.M_BillRunCycle();
		Flow8_AllBillrunCycles.X_BillrunCycle.SmallBillRunWithSingleCustomer();
		
	}

	public static void BillRunWithUncommittedStatement() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();

		Thread.sleep(5000);
//		WebDriverWaits.ClickOn(X_BillrunCycle.Bill_Run_Complete_CloseButton);
		WebDriverWaits.ClickOn(Billrun.Cancel_Button);
		WebDriverWaits.ClickOn(Billrun.Yes_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Billrun.BillRun_Tab);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.RunTheBills_Button);
		WebDriverWaits.ClickOn(Billrun.BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_IssueDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_IssueDate_Datepicker);
		//WebDriverWaits.ClickOn(Billrun.BillRun_DueDate_Datepicker);
		//WebDriverWaits.ClickOn(Billrun.Select_BillRun_DueDate_Datepicker);
		WebDriverWaits.ClickOn(Flow8_AllBillrunCycles.X_BillrunCycle.BillRunCycle_Dropdown);
		//WebDriverWaits.ClickOn(BillRunCycle_DropdownOpn);
		Thread.sleep(2000);
		WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(Flow8_AllBillrunCycles.X_BillrunCycle.BillRunCycleOption);
		Select select = new Select(BillRunCycOption);
		Thread.sleep(2000);
		select.selectByVisibleText(Flow8_AllBillrunCycles.X_BillrunCycle.RandomCycleName1);
		//BillRunCycleOption
		//driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.BillRun_Button);
		// Assert Warning: Customer 40113 previously billed on uncommitted statement. Do you want to proceed?
		Thread.sleep(2000);
		String ActualMsg = WebDriverWaits.GetText(ConfirmationAssertion);
		String ExpectedMsg1 = "Customer 40113 previously billed on uncommitted statement. Do you want to proceed?";
		softAssert.assertEquals(ExpectedMsg1, ActualMsg);
		System.out.println("Successfully asserted the popup text while bill run with uncomitted statement.");
		Thread.sleep(4000);
		
	}
	
	}


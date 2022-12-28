package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import POM.Flow4_BillRunWithNoCycle.Billrun;

import POM.Flow6_7AddingServiceAndMeter.X_AddService;

public class Flow8_AllBillrunCycles extends Flow5_AddCustomer {
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	
	public static class X_BillrunCycle {
		public static String RandomCycleName1;
		public static String RandomCycleName2;
		public static String RandomCycleName3;

	public static By Admin_Tab = By.xpath("//a[@title='Administration']/i");
	public static By BillRunCycles_Subtab = By.xpath("//*[contains(text(),'Bill Run Cycles')]");
	public static By AddBillRunCycleButton_CreateNew = By.xpath("//*[@id='addBtn']");
	public static By CycleName_Field = By.xpath("//*[@id='cyclename']");
	public static By CustomerListFilter = By.xpath("//*[@placeholder='Customer List Filter']");
	public static By CustomerListFilterOpn = By.xpath("(//select[@multiple='multiple'])[1]");
	public static By ArrowRight = By.xpath("(//*[@class='glyphicon glyphicon-arrow-right'])[3]");
	public static By SaveButton = By.xpath("//button[contains(text(),'Save')]");
	public static By BillRunCycleSuccessMsg = By.xpath("//div[@class='alert alert-success']/center");
	public static By BillRunCycle_Dropdown = By.xpath("//*[@id='cycleno']");
	public static By BillRunCycle_DropdownOpn = By.xpath("//*[@id='cycleno']/option[2]");
	public static By Rollback_and_Fix_Tab = By.xpath("//*[@id='rollback-and-fix']");
	public static By Continue_rollback_Button = By.xpath("(//*[contains(text(),'Continue rollback')])[2]");
	public static By RollbackCompleteSuccessMsg = By.xpath("(//div[contains(text(),'Rollback complete.')])");
	public static By Cancel_Button = By.xpath("//*[@class='bootstrap-dialog-close-button']");
	public static By Statement_Subtab = By.xpath("//*[@class='icon-columns']");
    public static By ViewDetails_Icon =By.xpath("//*[@title='View Details']");
    public static By Rollback_Button =By.xpath("//*[@class='btn btn-mini btn-danger']");
	public static By RollbackReason_Field =By.xpath("//*[@id='rollbackReason']");
	public static By Ok_Button =By.xpath("//*[contains(text(),'OK')]");
	public static By Successrollback_assertion =By.xpath("//*[@Class='bootstrap-dialog-body']");
	public static By BillRunCycleOption =By.xpath("//select[@id='cycleno']");
	public static By RollbackCross_Icon =By.xpath("//*[@class='bootstrap-dialog-close-button']");
	public static By Bill_Run_Complete_CloseButton =By.xpath("(//*[@class='btn btn-primary'])[3]");
	
	
	public static void M_BillRunCycle() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		WebDriverWaits.ClickOn(Admin_Tab);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(BillRunCycles_Subtab);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(CycleName_Field);
		RandomCycleName1 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(CycleName_Field, RandomCycleName1);
		System.out.println("Bill Cycle name --------- "+RandomCycleName1);
		WebDriverWaits.ClickOn(CustomerListFilter);
		WebDriverWaits.SendKeys(CustomerListFilter, CustomerID01R);
		Thread.sleep(2000);
		WebElement CustomerListOption = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
		Select CustomerList = new Select(CustomerListOption);
		Thread.sleep(2000);
		CustomerList.selectByIndex(0);
		Thread.sleep(2000);
		WebElement CustomerListFirstOp = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
		WebDriverWaits.ClickOnWE(CustomerListFirstOp);

		WebDriverWaits.ClickOn(ArrowRight);
		Thread.sleep(2000);

		WebDriverWaits.ClickOn(SaveButton);
		// Assertion: Successfully added new bill run cycle.
		Thread.sleep(2000);
		String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
		String ExpectedMsg1 = "Successfully added new bill run cycle.";
		softAssert.assertEquals(ExpectedMsg1, ActualMsg);
		System.out.println("Successfully added new bill run cycle for single customer.");
		Thread.sleep(4000);
		
	}
	
	public static void SmallBillRunWithSingleCustomer() throws InterruptedException {
	//	SoftAssert softAssert = new SoftAssert();
		
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
		WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
		//WebDriverWaits.ClickOn(BillRunCycle_DropdownOpn);
		Thread.sleep(2000);
		WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
		Select select = new Select(BillRunCycOption);
		Thread.sleep(4000);
		select.selectByVisibleText(X_BillrunCycle.RandomCycleName1);
		//BillRunCycleOption
		//driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.BillRun_Button);
	//	WebDriverWaits.ClickOn(Billrun.Continue_Button);
	//	WebDriverWaits.ClickOn(Billrun.OK_Button);
		//Thread.sleep(300000);
//		WebDriverWaits.WaitUntilInvisible(Spinner_Icon);
		//WebDriverWaits.ClickOn(Billrun.View_Button);
		WebDriverWaits.ClickAfter5mins(Billrun.View_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Billrun.Cancel_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Billrun.Yes_Button);
		
	}
	
	public static void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		WebDriverWaits.ClickOn(X_AddService.SearchIcon);
		WebDriverWaits.ClickOn(X_AddService.SearchField);
		WebDriverWaits.SendKeys(X_AddService.SearchField,CustomerID01R);
		WebDriverWaits.ClickOn(X_AddService.SearchIcon);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Statement_Subtab);
		WebDriverWaits.ClickOn(ViewDetails_Icon);
		WebDriverWaits.ClickOn(Rollback_Button);
		WebDriverWaits.ClickOn(RollbackReason_Field);
		WebDriverWaits.SendKeys(RollbackReason_Field,"Kindly rollback the statement.");
		WebDriverWaits.ClickOn(Ok_Button);
       
        //Assert 	Rollback for customer 40037 and statement 7899 has been successful.
        Thread.sleep(10000);
        WebDriverWaits.ClickOn(RollbackCross_Icon);
        Thread.sleep(3000);


//		WebDriverWaits.ClickOn(Rollback_and_Fix_Tab);
//		WebDriverWaits.ClickOn(Continue_rollback_Button);
//		Thread.sleep(5000);
//		String ActualMsg1 = WebDriverWaits.GetText(RollbackCompleteSuccessMsg);
//		String ExpectedMsg2 = "Rollback complete.";
//		softAssert.assertEquals(ExpectedMsg2, ActualMsg1);
//		System.out.println("Successfully Rollback completed for single customer.");
//		WebDriverWaits.ClickOn(Cancel_Button);
		Thread.sleep(2000);
		//Run bill again
		WebDriverWaits.ClickOn(Billrun.BillRun_Tab);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.RunTheBills_Button);
		WebDriverWaits.ClickOn(Billrun.BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_IssueDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_IssueDate_Datepicker);
		//*Auto due date is enabled for the following customer category(Commercial,Residential,Business)
		//WebDriverWaits.ClickOn(Billrun.BillRun_DueDate_Datepicker);
		//WebDriverWaits.ClickOn(Billrun.Select_BillRun_DueDate_Datepicker);
		//WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
		//Thread.sleep(2000);
		Thread.sleep(2000);
		WebElement BillRunCycOption2 = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
		Select select2 = new Select(BillRunCycOption2);
		Thread.sleep(2000);
		select2.selectByVisibleText(RandomCycleName1);
		//driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.BillRun_Button);
		//	WebDriverWaits.ClickOn(Billrun.Continue_Button);
		//	WebDriverWaits.ClickOn(Billrun.OK_Button);
		//	Thread.sleep(200000);
		//	WebDriverWaits.ClickOn(Billrun.View_Button);
		WebDriverWaits.ClickAfter5mins(Billrun.View_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Billrun.Cancel_Button);
		WebDriverWaits.ClickOn(Billrun.Yes_Button);
		Thread.sleep(2000);

		
		

//		WebDriverWaits.ClickOn(Billrun.Yes_Button);
//		Thread.sleep(2000); 
		
		
		
	}

	public static void SmallBillRunWithTwoCustomer() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		try{
			driver.navigate().refresh();
			System.out.println(driver.getCurrentUrl());
		}
		catch(Exception e){
			driver.navigate().refresh();
		}


		jse.executeScript("window.scrollBy(0,-500)", "");

		WebDriverWaits.ClickOn(Admin_Tab);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(BillRunCycles_Subtab);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(CycleName_Field);
		RandomCycleName2 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(CycleName_Field, RandomCycleName2);
		WebDriverWaits.ClickOn(CustomerListFilter);
		WebDriverWaits.SendKeys(CustomerListFilter, CustomerID02B);
		Thread.sleep(2000);
		WebElement CustomerListOption = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
		Select CustomerList = new Select(CustomerListOption);
		Thread.sleep(2000);
		CustomerList.selectByIndex(0);
		Thread.sleep(2000);
		WebElement CustomerListFirstOp = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
		WebDriverWaits.ClickOnWE(CustomerListFirstOp);

		WebDriverWaits.ClickOn(CustomerListFilter);
		WebDriverWaits.SendKeys(CustomerListFilter, CustomerID03C);
		Thread.sleep(2000);
		WebElement CustomerListOption1 = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
		Select CustomerList1 = new Select(CustomerListOption1);
		Thread.sleep(2000);
		CustomerList1.selectByIndex(0);
		Thread.sleep(2000);
		WebElement CustomerListFirstOp1 = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
		WebDriverWaits.ClickOnWE(CustomerListFirstOp1);
		
		
		WebDriverWaits.ClickOn(ArrowRight);
		Thread.sleep(2000);

		WebDriverWaits.ClickOn(SaveButton);
		// Assertion: Successfully added new bill run cycle.
		Thread.sleep(2000);
		String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
		String ExpectedMsg1 = "Successfully added new bill run cycle.";
		softAssert.assertEquals(ExpectedMsg1, ActualMsg);
		System.out.println("Successfully added new bill run cycle for Two customers.");
		Thread.sleep(4000);
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
		WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
		//WebDriverWaits.ClickOn(BillRunCycle_DropdownOpn);
		Thread.sleep(2000);
		WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
		Select select = new Select(BillRunCycOption);
		Thread.sleep(2000);
		select.selectByVisibleText(X_BillrunCycle.RandomCycleName2);
		//BillRunCycleOption
		//driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.BillRun_Button);
	//	WebDriverWaits.ClickOn(Billrun.Continue_Button);
	//	WebDriverWaits.ClickOn(Billrun.OK_Button);
	//	Thread.sleep(300000);
		WebDriverWaits.ClickAfter5mins(Billrun.View_Button);
		Thread.sleep(2000);
//		WebDriverWaits.WaitUntilInvisible(Spinner_Icon);
	//	WebDriverWaits.ClickOn(Billrun.View_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Rollback_and_Fix_Tab);
		WebDriverWaits.ClickOn(Continue_rollback_Button);
		Thread.sleep(5000);
		String ActualMsg1 = WebDriverWaits.GetText(RollbackCompleteSuccessMsg);
		String ExpectedMsg2 = "Rollback complete.";
		softAssert.assertEquals(ExpectedMsg2, ActualMsg1);
		System.out.println("Successfully Rollback completed for two customers.");
		WebDriverWaits.ClickOn(Cancel_Button);
		Thread.sleep(2000);
		
		
		//Run bill again
		
		
		WebDriverWaits.ClickOn(Billrun.BillRun_Tab);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.RunTheBills_Button);
		WebDriverWaits.ClickOn(Billrun.BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_IssueDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_IssueDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_DueDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_DueDate_Datepicker);
		//WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
		//Thread.sleep(2000);
		Thread.sleep(2000);
		WebElement BillRunCycOption2 = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
		Select select2 = new Select(BillRunCycOption2);
		Thread.sleep(2000);
		select2.selectByVisibleText(RandomCycleName1);
		//driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.BillRun_Button);
	//	WebDriverWaits.ClickOn(Billrun.Continue_Button);
	//	WebDriverWaits.ClickOn(Billrun.OK_Button);
//		Thread.sleep(200000);
//		WebDriverWaits.ClickOn(Billrun.View_Button);
		WebDriverWaits.ClickAfter5mins(Billrun.View_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Billrun.Cancel_Button);
		WebDriverWaits.ClickOn(Billrun.Yes_Button);
		Thread.sleep(2000);
		
		WebDriverWaits.ClickOn(X_AddService.SearchIcon);
		WebDriverWaits.ClickOn(X_AddService.SearchField);
		WebDriverWaits.SendKeys(X_AddService.SearchField,CustomerID01R);
		WebDriverWaits.ClickOn(X_AddService.SearchIcon);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Statement_Subtab);
		WebDriverWaits.ClickOn(ViewDetails_Icon);
		WebDriverWaits.ClickOn(Rollback_Button);
		WebDriverWaits.ClickOn(RollbackReason_Field);
		WebDriverWaits.SendKeys(RollbackReason_Field,"Kindly rollback the statement.");
		WebDriverWaits.ClickOn(Ok_Button);
		//Assert Rollback for customer 40027 and statement 7892 has been successful.
		Thread.sleep(100000);
		WebDriverWaits.ClickOn(RollbackCross_Icon);
		Thread.sleep(4000);

	}

	
	public static void BillRunWithLargeCycle() throws InterruptedException {
		Thread.sleep(2000);
		Flow5_AddCustomer.FirstCustomer.FirstResidentialCustomer();
		Flow5_AddCustomer.SecondCustomer.SecondBusinessCustomer();

		Flow5_AddCustomer.ThirdCustomer.ThirdCommercialCustomer();

		Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.AddSecondService();
		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
	}
	
	public static void LargeBillRun_RollBack(){


	}
		public static void createBillCycle(){


		}
	public static void LargeBillRun() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		driver.navigate().refresh();
		jse.executeScript("window.scrollBy(0,-500)", "");
		
	
		WebDriverWaits.ClickOn(Admin_Tab);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(BillRunCycles_Subtab);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(CycleName_Field);
		RandomCycleName3 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(CycleName_Field, RandomCycleName3);
		WebDriverWaits.ClickOn(CustomerListFilter);
		WebDriverWaits.SendKeys(CustomerListFilter, CustomerID01R);
		Thread.sleep(2000);
		WebElement CustomerListOption = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
		Select CustomerList = new Select(CustomerListOption);
		Thread.sleep(2000);
		CustomerList.selectByIndex(0);
		Thread.sleep(2000);
		WebElement CustomerListFirstOp = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
		WebDriverWaits.ClickOnWE(CustomerListFirstOp);
        WebDriverWaits.ClickOn(ArrowRight);
		Thread.sleep(2000);

		WebDriverWaits.ClickOn(CustomerListFilter);
		WebDriverWaits.SendKeys(CustomerListFilter, CustomerID02B);
		Thread.sleep(2000);
//		WebElement CustomerListOption = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
//		Select CustomerList = new Select(CustomerListOption);
		Thread.sleep(2000);
		CustomerList.selectByIndex(0);
		Thread.sleep(2000);
		//WebElement CustomerListFirstOp = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
		WebDriverWaits.ClickOnWE(CustomerListFirstOp);
		WebDriverWaits.ClickOn(ArrowRight);
		Thread.sleep(2000);

		WebDriverWaits.ClickOn(CustomerListFilter);
		WebDriverWaits.SendKeys(CustomerListFilter, CustomerID03C);
		Thread.sleep(2000);
		//WebElement CustomerListOption = WebDriverWaits.WaitUntilVisibleWE(CustomerListFilterOpn);
		//Select CustomerList = new Select(CustomerListOption);
		Thread.sleep(2000);
		CustomerList.selectByIndex(0);
		Thread.sleep(2000);
		//WebElement CustomerListFirstOp = (WebElement) jse.executeScript("return document.querySelector('#bootstrap-duallistbox-nonselected-list_custnos > option')");
		WebDriverWaits.ClickOnWE(CustomerListFirstOp);
		WebDriverWaits.ClickOn(ArrowRight);
		Thread.sleep(2000);

        WebDriverWaits.ClickOn(SaveButton);
		// Assertion: Successfully added new bill run cycle.
        Thread.sleep(2000);
		String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
		String ExpectedMsg1 = "Successfully added new bill run cycle.";
		softAssert.assertEquals(ExpectedMsg1, ActualMsg);
		System.out.println("Successfully added new bill run cycle for More than three customers.");
		Thread.sleep(4000);
		
		
		//First Time Bill run 
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
		WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
		//WebDriverWaits.ClickOn(BillRunCycle_DropdownOpn);
		Thread.sleep(2000);
		WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
		Select select = new Select(BillRunCycOption);
		Thread.sleep(2000);
		select.selectByVisibleText(X_BillrunCycle.RandomCycleName3);
		//BillRunCycleOption
		//driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.BillRun_Button);
	//	WebDriverWaits.ClickOn(Billrun.Continue_Button);
	//	WebDriverWaits.ClickOn(Billrun.OK_Button);
	//	Thread.sleep(300000);
		WebDriverWaits.ClickAfter5mins(Billrun.View_Button);
		Thread.sleep(2000);
//		WebDriverWaits.WaitUntilInvisible(Spinner_Icon);
	//	WebDriverWaits.ClickOn(Billrun.View_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Rollback_and_Fix_Tab);
		WebDriverWaits.ClickOn(Continue_rollback_Button);
		Thread.sleep(5000);
		//Assertion: Rollback 
		String ActualMsg1 = WebDriverWaits.GetText(RollbackCompleteSuccessMsg);
		String ExpectedMsg2 = "Rollback complete.";
		softAssert.assertEquals(ExpectedMsg2, ActualMsg1);
		System.out.println("Successfully Rollback completed for more than three customers.");
		WebDriverWaits.ClickOn(Cancel_Button);
		Thread.sleep(2000);
		//Run bill again
		WebDriverWaits.ClickOn(Billrun.BillRun_Tab);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.RunTheBills_Button);
		WebDriverWaits.ClickOn(Billrun.BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_StartDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_EndDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.BillRun_IssueDate_Datepicker);
		WebDriverWaits.ClickOn(Billrun.Select_BillRun_IssueDate_Datepicker);
	//	WebDriverWaits.ClickOn(Billrun.BillRun_DueDate_Datepicker);
//		WebDriverWaits.ClickOn(Billrun.Select_BillRun_DueDate_Datepicker);
		//WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
		//Thread.sleep(2000);
		Thread.sleep(2000);
		WebElement BillRunCycOption2 = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
		Select select2 = new Select(BillRunCycOption2);
		Thread.sleep(2000);
		select2.selectByVisibleText(RandomCycleName1);
		//driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
		Thread.sleep(2000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(Billrun.BillRun_Button);
	//	WebDriverWaits.ClickOn(Billrun.Continue_Button);
	//	WebDriverWaits.ClickOn(Billrun.OK_Button);
//		Thread.sleep(200000);
//		WebDriverWaits.ClickOn(Billrun.View_Button);
		WebDriverWaits.ClickAfter5mins(Billrun.View_Button);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Billrun.Cancel_Button);
		WebDriverWaits.ClickOn(Billrun.Yes_Button);
		Thread.sleep(2000);
		
		WebDriverWaits.ClickOn(X_AddService.SearchIcon);
		WebDriverWaits.ClickOn(X_AddService.SearchField);
		WebDriverWaits.SendKeys(X_AddService.SearchField,CustomerID01R);
		WebDriverWaits.ClickOn(X_AddService.SearchIcon);
		Thread.sleep(2000);
		WebDriverWaits.ClickOn(Statement_Subtab);
		WebDriverWaits.ClickOn(ViewDetails_Icon);
		WebDriverWaits.ClickOn(Rollback_Button);
		WebDriverWaits.ClickOn(RollbackReason_Field);
		WebDriverWaits.SendKeys(RollbackReason_Field,"Kindly rollback the statement.");
		WebDriverWaits.ClickOn(Ok_Button);
		Thread.sleep(100000);
        //Assert Rollback for customer 40027 and statement 7892 has been successful.

		WebDriverWaits.ClickOn(RollbackCross_Icon);
		
	}
	
	}
}

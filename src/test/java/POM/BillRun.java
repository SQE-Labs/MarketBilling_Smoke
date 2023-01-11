package POM;

import BrowsersBase.DataInterface;
import CommonMethods.DateAndTime;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static POM.Flow5_AddCustomer.*;

public class BillRun extends TestLogin {
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static By ConfirmationAssertion = By.xpath("//*[@class='bootstrap-dialog-message']");
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
    public static By rollbackCancel = By.className("bootstrap-dialog-close-button");

    public static By Yes_Button = By.xpath("//button[contains(text(),'Yes')]");
    public static By Admin_Tab = By.xpath("//a[@title='Administration']/i");
    public static By BillRunCycles_Subtab = By.xpath("//*[contains(text(),'Bill Run Cycles')]");
    public static By AddBillRunCycleButton_CreateNew = By.xpath("//*[@id='addBtn']");
    public static By billSearch = By.xpath("//input[@type='search']");
    public static By editActionBtn = By.xpath("//a[@title='Edit']");

    public static By billRunSearch = By.cssSelector(".box-icon a");

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
    // public static By Cancel_Button = By.xpath("//*[@class='bootstrap-dialog-close-button']");
    public static By Statement_Subtab = By.xpath("//*[@class='icon-columns']");
    public static By ViewDetails_Icon = By.xpath("//*[@title='View Details']");
    public static By EditDetails_Icon = By.xpath("//i[@class='icon-edit']");
    public static By newIssueDate = By.cssSelector("input#custIssueDate");
    public static By updateBtn = By.xpath("//button[contains(text(),'Update')]");
    public static By textIssueDate = By.xpath("//tr/td[3]");

    public static By Rollback_Button = By.xpath("//*[@class='btn btn-mini btn-danger']");
    public static By RollbackReason_Field = By.xpath("//*[@id='rollbackReason']");
    public static By Ok_Button = By.xpath("//*[contains(text(),'OK')]");
    public static By Successrollback_assertion = By.xpath("//*[@Class='bootstrap-dialog-body']");
    public static By BillRunCycleOption = By.xpath("//select[@id='cycleno']");
    public static By RollbackCross_Icon = By.xpath("//*[@class='bootstrap-dialog-close-button']");
    public static By Bill_Run_Complete_CloseButton = By.xpath("(//*[@class='btn btn-primary'])[3]");

    public static By viewRollBackHistoryBtn = By.xpath("//*[contains(text(),' View Rollback History')]");
    public static By editActionIcon = By.xpath("//*[@class='btn btn-mini btn-success']");
    public static By runBillS = By.cssSelector(".form-group #runBill");
    public static By customer_checkBox = By.id("chkDelete_0");

    public static By downloadPdf = By.xpath("//button[contains(text(),'Download')]");
    public static By emailBills = By.xpath("//button[contains(text(),'Email')]");
    public static By selectedCustomer = By.xpath("//a[contains(text(),'Selected')]");
    public static By selectedCustomers = By.xpath("(//a[contains(text(),'Selected customers')])[2]");

    public static By continueEmail = By.xpath("//button[contains(text(),'Continue')]");
    public static By status = By.cssSelector("#emailResultData  td:nth-child(5)");
    public static By dateSend = By.cssSelector("#emailResultData  td:nth-child(4)");

    public static By close = By.id("sendEmailResultClose");
    public static By download = By.id("submitSelected");
    static SoftAssert softAssert = new SoftAssert();
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
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
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

    public static void BillRunWithUncommittedStatement(String billCycleName, String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        driver.navigate().refresh();

////		WebDriverWaits.ClickOn(X_BillrunCycle.Bill_Run_Complete_CloseButton);
//		WebDriverWaits.ClickOn(Cancel_Button);
//		WebDriverWaits.ClickOn(Yes_Button);
        Thread.sleep(2000);
        //WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(2000);
        select.selectByVisibleText(billCycleName);
        //BillRunCycleOption
        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        // Assert Warning: Customer 40113 previously billed on uncommitted statement. Do you want to proceed?
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(ConfirmationAssertion);
        String ExpectedMsg1 = "Customer " + customerId + "previously billed on uncommitted statement. Do you want to proceed?";
        softAssert.assertEquals(ExpectedMsg1, ActualMsg);
        System.out.println("Successfully asserted the popup text while bill run with uncomitted statement.");
        Thread.sleep(4000);
        WebDriverWaits.ClickOn(OK_Button);
        Thread.sleep(10000);

    }

    public static String BillRunCycle(String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWaits.ClickOn(Admin_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(CycleName_Field);
        String BillCycleName = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeys(CycleName_Field, BillCycleName);
        WebDriverWaits.ClickOn(CustomerListFilter);
        WebDriverWaits.SendKeys(CustomerListFilter, customerId);
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
        System.out.println("Bill Cycle name --------- " + BillCycleName);
        return BillCycleName;
    }

    public static void SmallBillRunWithSingleCustomer(String billCycleName) throws InterruptedException {
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);
        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(4000);
        select.selectByVisibleText(billCycleName);
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Cancel_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Yes_Button);
    }

    public static void Rollback_SmallBillRunWithSingleCustomer(String customerId) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon);
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchField);
        WebDriverWaits.SendKeys(Flow6_7AddingServiceAndMeter.X_AddService.SearchField, customerId);
        WebDriverWaits.ClickOn(Flow6_7AddingServiceAndMeter.X_AddService.SearchIcon);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Statement_Subtab);
        WebDriverWaits.ClickOn(ViewDetails_Icon);
        WebDriverWaits.ClickOn(Rollback_Button);
        WebDriverWaits.ClickOn(RollbackReason_Field);
        WebDriverWaits.SendKeys(RollbackReason_Field, "Kindly rollback the statement.");
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


    }

    public static void rebillSingleCustomer(String billCycleName) throws InterruptedException {
        //Run bill again
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        //*Auto due date is enabled for the following customer category(Commercial,Residential,Business)
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        Thread.sleep(2000);
        WebElement BillRunCycOption2 = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select2 = new Select(BillRunCycOption2);
        Thread.sleep(2000);
        select2.selectByVisibleText(billCycleName);
        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        //	WebDriverWaits.ClickOn(Continue_Button);
        //	WebDriverWaits.ClickOn(OK_Button);
        //	Thread.sleep(200000);
        //	WebDriverWaits.ClickOn(View_Button);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Cancel_Button);
        WebDriverWaits.ClickOn(Yes_Button);
        Thread.sleep(2000);

    }


    public static void filterCustomerId(String customerId) throws InterruptedException {
        WebDriverWaits.ClickOn(CustomerListFilter);
        System.out.println("Customer 1R -- " + CustomerID01R);
        System.out.println("Customer 2B -- " + CustomerID02B);
        System.out.println("Customer 3C -- " + CustomerID03C);
        WebDriverWaits.SendKeysWithClear(CustomerListFilter, customerId);
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
    }

    public static void rollback_in_statementTab(String customerId) throws InterruptedException {
        Customer.searchCustomer(customerId);
        WebDriverWaits.ClickOn(Statement_Subtab);
        WebDriverWaits.ClickOn(ViewDetails_Icon);
        WebDriverWaits.ClickOn(Rollback_Button);
        WebDriverWaits.ClickOn(RollbackReason_Field);
        WebDriverWaits.SendKeys(RollbackReason_Field, "Kindly rollback the statement.");
        WebDriverWaits.ClickOn(Ok_Button);
        Thread.sleep(5000);
        //Assert Rollback for customer 40027 and statement 7892 has been successful.

        WebDriverWaits.ClickOn(RollbackCross_Icon);
    }

    public static void statementRebill(String customerId) throws InterruptedException {
        Customer.searchCustomer(customerId);
        WebDriverWaits.ClickOn(Statement_Subtab);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(viewRollBackHistoryBtn);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(editActionIcon);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(runBillS);
        Thread.sleep(3000);
        WebDriverWaits.ClickOn(Ok_Button);
        Thread.sleep(5000);

    }

    public static void rollback() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Rollback_and_Fix_Tab);
        WebDriverWaits.ClickOn(Continue_rollback_Button);
        Thread.sleep(5000);
        String ActualMsg1 = WebDriverWaits.GetText(RollbackCompleteSuccessMsg);
        String ExpectedMsg2 = "Rollback complete.";
        softAssert.assertEquals(ExpectedMsg2, ActualMsg1);
        System.out.println("Successfully Rollback completed for two customers.");
        WebDriverWaits.ClickOn(rollbackCancel);
        Thread.sleep(2000);

    }

    public static String createBillCycle(List<String> customerIdList) throws InterruptedException {
        driver.navigate().refresh();
        jse.executeScript("window.scrollBy(0,-500)", "");
        WebDriverWaits.ClickOn(Admin_Tab);
        WebDriverWaits.scrollIntoView(BillRunCycles_Subtab);
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(AddBillRunCycleButton_CreateNew);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(CycleName_Field);
        String billRunCycleName = RandomStrings.RequiredCharacters(6);
        WebDriverWaits.SendKeysWithClear(CycleName_Field, billRunCycleName);
        System.out.println("Bill run cyccle create with name ---" + billRunCycleName);
        for (String customerId : customerIdList) {
            BillRun.filterCustomerId(customerId);
        }
        WebDriverWaits.ClickOn(SaveButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Successfully added new bill run cycle.", ActualMsg);
        System.out.println("Successfully added new bill run cycle for  customers. " + billRunCycleName);
        Thread.sleep(4000);
        return billRunCycleName;
    }

    public static String editBillCycle(String oldBillCycleName) throws InterruptedException {
        driver.navigate().refresh();
        jse.executeScript("window.scrollBy(0,-500)", "");
        WebDriverWaits.ClickOn(Admin_Tab);
        WebDriverWaits.scrollIntoView(BillRunCycles_Subtab);
        WebDriverWaits.ClickOn(BillRunCycles_Subtab);
        Thread.sleep(2000);
        WebDriverWaits.SendKeysWithClear(billSearch, oldBillCycleName);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(editActionBtn);
        String billRunCycleNewName = oldBillCycleName + RandomStrings.RequiredCharacters(3);
        WebDriverWaits.SendKeysWithClear(CycleName_Field, billRunCycleNewName);
        System.out.println("Bill run cycle renamed with name ---" + billRunCycleNewName);

        WebDriverWaits.ClickOn(SaveButton);
        Thread.sleep(2000);
        String ActualMsg = WebDriverWaits.GetText(BillRunCycleSuccessMsg);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("Successfully updated " + oldBillCycleName + "cycle.", ActualMsg);
        System.out.println("Successfully added new bill run cycle for  customers. " + billRunCycleNewName);
        Thread.sleep(4000);
        return billRunCycleNewName;
    }

    public static void runBillCycle(String billRunCycleName) throws InterruptedException {
        LandingPage.navigateToHomePage();
        //First Time Bill run
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(2000);
        select.selectByVisibleText(billRunCycleName);
        Thread.sleep(2000);
        WebDriverWaits.scrollIntoView(BillRun_Button);
        WebDriverWaits.ClickOn(BillRun_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Cancel_Button);
        WebDriverWaits.ClickOn(Yes_Button);
        Thread.sleep(2000);
    }

    public static void runBillCycleForRollBack(String billRunCycleName) throws InterruptedException {

        //First Time Bill run
        WebDriverWaits.ClickOn(BillRun_Tab);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(RunTheBills_Button);
        WebDriverWaits.ClickOn(BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_StartDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_EndDate_Datepicker);
        WebDriverWaits.ClickOn(BillRun_IssueDate_Datepicker);
        WebDriverWaits.ClickOn(Select_BillRun_IssueDate_Datepicker);
        if (!(DataInterface.autoDueDateEnabled)) {
            WebDriverWaits.ClickOn(BillRun_DueDate_Datepicker);
            WebDriverWaits.ClickOn(Select_BillRun_DueDate_Datepicker);

        }
        WebDriverWaits.ClickOn(BillRunCycle_Dropdown);
        //WebDriverWaits.ClickOn(BillRunCycle_DropdownOpn);
        Thread.sleep(2000);
        WebElement BillRunCycOption = WebDriverWaits.WaitUntilVisibleWE(BillRunCycleOption);
        Select select = new Select(BillRunCycOption);
        Thread.sleep(2000);
        select.selectByVisibleText(billRunCycleName);
        //BillRunCycleOption
        //driver.findElement(By.xpath("//option[text()='" + RandomCycleName1+ "']"));
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(BillRun_Button);
        Thread.sleep(2000);
        WebDriverWaits.ClickAfter5mins(View_Button);
        Thread.sleep(2000);

    }

    public static void updateStatementDate(String customerId) throws InterruptedException {
        WebDriverWaits.ClickOn(Statement_Subtab);
        WebDriverWaits.ClickOn(EditDetails_Icon);
        String issueDate = DateAndTime.getDateWithDays("dd/MM/yyyy", 2);
        WebDriverWaits.SendKeys(newIssueDate, issueDate);
        WebDriverWaits.ClickOn(updateBtn);
        Thread.sleep(4000);
        SoftAssert softAssert = new SoftAssert();
        String issued = WebDriverWaits.GetText(textIssueDate);
        softAssert.assertEquals(issueDate, issued);
        Thread.sleep(2000);


    }

    public static void billRunCycleSearch(String billCycle) throws InterruptedException {
        Admin.navigateToBillRun();
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(billRunSearch);
        WebDriverWaits.SendKeysWithClear(billSearch, billCycle);

    }
    public static void viewBillDetails() throws InterruptedException {
        WebDriverWaits.ClickOn(ViewDetails_Icon);

    }
    public static void selectCustCheckBox() throws InterruptedException {
        WebDriverWaits.selectCheckBox(customer_checkBox);

    }
    public static void clickDownloadPdf() throws InterruptedException {
        WebDriverWaits.ClickOn(downloadPdf);

    }
    public static void clickEmailBills() throws InterruptedException {
        WebDriverWaits.ClickOn(emailBills);

    }
    public static void clickSelectedCustomer() throws InterruptedException {
        WebDriverWaits.ClickOn(selectedCustomer);

    }
    public static void clickSelectedCustomers() throws InterruptedException {
        WebDriverWaits.ClickOn(selectedCustomers);

    }
    public static void clickDownload_Popup() throws InterruptedException {
      WebDriverWaits.WaitUntilVisible(download);
        WebDriverWaits.ClickOn(download);

    }
    public static void clickContinueEmail() throws InterruptedException {
        WebDriverWaits.WaitUntilVisible(continueEmail);
        WebDriverWaits.ClickOn(continueEmail);
    }
    public static void verifyEmailResults() throws InterruptedException {
        WebDriverWaits.WaitUntilVisible(status);
        softAssert.assertEquals(WebDriverWaits.GetText(status),"Success");
        softAssert.assertEquals(WebDriverWaits.GetText(dateSend),DateAndTime.DateTimeGenerator("dd/MM/yyyy"));

    }
    public static void clickClose() throws InterruptedException {
        WebDriverWaits.ClickOn(close);
    }
}

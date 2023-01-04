package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.asserts.SoftAssert;

import static BrowsersBase.BrowsersInvoked.driver;

public class Metering {
    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static By AddMeterIcon = By.xpath("//a[@id='addMeter']/i");
    public static By MeterSerialNumber_Field = By.xpath("//*[@id='meterNo']");
    public static By ConfigurationType_Dropdown = By.xpath("//*[@id='configurationType']");
    public static By ConfigurationType_Opn = By.xpath("//option[text()='POS']");
    public static By LastTestdate_Datepiker = By.xpath("//*[@id='maintenanceDate']");
    public static By Select_LastTestdate_Datepiker = By.xpath("//td[@class='active day']");
    public static By DateConnected_Datepicker = By.xpath("//*[@id='datecon']");
    public static By Select_DateConnected_Datepicker = By.xpath("//*[@class='active day']");
    public static By CreateMeter_Button = By.xpath("//*[@id='createMeter']");
    public static By MeterEdit_icon = By.xpath("//*[@class='icon-edit']");
    public static By AddMeterRegister_Icon = By.xpath("//*[@id='addRegister']");
    public static By RegisterID_Field = By.xpath("//*[@id='registerNo']");
    public static By NetworkTariffCode_Field = By.xpath("//*[@id='networkTariffCode']");
    public static By UnitOfMeasure_Field = By.xpath("//*[@id='unitOfMeasure']");
    public static By TimeofDay_Field = By.xpath("//*[@id='timeOfDay']");
    public static By DialFormat_Field = By.xpath("//*[@id='dialFormat']");
    public static By Demand1_Field = By.xpath("//*[@id='demand1']");
    public static By Demand2_Field = By.xpath("//*[@id='demand2']");
    public static By NMISuffix_Field = By.xpath("//*[@id='nmiSuffix']");
    public static By DateConnectedDatepicker = By.xpath("//*[@id='datecon']");
    public static By SelectTodayDateConnected_Datepicker = By.xpath("//*[@class='active day']");
    public static By CreateRegister_Button = By.xpath("//*[@id='createRegister']");
    public static By MeterReads_Tab = By.xpath("//*[@class='icon-bar-chart']");
    public static By ServiceName_Dropdown = By.xpath("//*[@id='nmis']");
    public static By ServiceName_DropdownOpn = By.xpath("//*[@id='nmis']/option[2]");
    public static By MeterNumber_Dropdown = By.xpath("//*[@id='meterNo']");
    public static By MeterNumber_DropdownOpn = By.xpath("//*[@id='meterNo']/option[2]");
    public static By ViewMeterReads = By.xpath("//*[@id='viewMeterReads']");
    public static By AddMeterReads = By.xpath("//*[@title='Add Read']");
    public static By MeterNo_Dropdown = By.xpath("//*[@id='rmeterno']");
    public static By MeterNo_DropdownOpn = By.xpath("//*[@id='rmeterno']/option[2]");
    public static By RegisterNo_Dropdown = By.xpath("//*[@id='rregno']");
    public static By RegisterNo_DropdownOpn = By.xpath("//*[@id='rregno']/option[2]");
    public static By ReadType_Dropdown = By.id("rreadType");
    public static By ReadType_DropdownOpn1 = By.xpath("//*[@id='rreadType']/option[2]");
    public static By ReadType_DropdownOpn2 = By.xpath("//*[@id='rreadType']/option[4]");
    public static By ReadDate_Datepicker = By.xpath("//*[@id='rreadDate']");
    public static By Select_ReadDate_Datepicker = By.xpath("//*[@class='active day']");
    public static By MeterReadPeak_Field = By.xpath("//*[@id='modalReadingP']");
    public static By MeterReadOffPeak_Field = By.xpath("//*[@id='modalReadingO']");
    public static By MeterReadShoulder_Field = By.xpath("//*[@id='modalReadingS']");
    public static By Save_Button = By.xpath("(//button[contains(text(),'Save')])[2]");
    public static By CustomerSuccessMeterRegister = By.xpath("//div[@class='alert alert-success']/center");
    public static SoftAssert softAssert = new SoftAssert();

    public static String AddMeter() throws InterruptedException {

//			Thread.sleep(2000);
//			WebDriverWaits.ClickOn(AddService.SearchIcon);
//			//WebDriverWaits.ClickOn(AddService.SearchField);
//			WebDriverWaits.SendKeys(AddService.SearchField, Flow5_AddCustomer.CustomerID01R);
//			Thread.sleep(2000);

        //	jse.executeScript("window.scrollBy(0,-1000)", "");

        Thread.sleep(3000);
        jse.executeScript("window.scrollBy(0,1000)", "");
        System.out.println("I am clicking add meter button");
        WebDriverWaits.ClickOn(AddMeterIcon);
        System.out.println("I am on add meter page");
        WebDriverWaits.ClickOn(MeterSerialNumber_Field);
        String RandomNumber1 = "Meter" + RandomStrings.RequiredDigits(5);
        WebDriverWaits.SendKeys(MeterSerialNumber_Field, RandomNumber1);
        WebDriverWaits.ClickOn(ConfigurationType_Dropdown);
        WebDriverWaits.ClickOn(ConfigurationType_Opn);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(LastTestdate_Datepiker);
        WebDriverWaits.ClickOn(Select_LastTestdate_Datepiker);
        WebDriverWaits.ClickOn(DateConnected_Datepicker);
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(Select_DateConnected_Datepicker);
        WebDriverWaits.ClickOn(CreateMeter_Button);
        Thread.sleep(4000);
        String ExpectedMsg = "Successfully registered meter";
        softAssert.assertEquals(ExpectedMsg, "Successfully registered meter");
        Thread.sleep(4000);
        // Assertion
        // Successfully registered meter.
        return RandomNumber1;
    }

    public static String createRegister() throws InterruptedException {
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(MeterEdit_icon);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        WebDriverWaits.ClickOn(AddMeterRegister_Icon);

        //Create register
        WebDriverWaits.ClickOn(RegisterID_Field);
        Thread.sleep(2000);
        String registerId = "99345" + RandomStrings.RequiredDigits(5);
        WebDriverWaits.SendKeys(RegisterID_Field, registerId);
        WebDriverWaits.ClickOn(NetworkTariffCode_Field);
        WebDriverWaits.SendKeys(NetworkTariffCode_Field, "Na");
        WebDriverWaits.ClickOn(UnitOfMeasure_Field);
        WebDriverWaits.SendKeys(UnitOfMeasure_Field, "KWH");
        WebDriverWaits.ClickOn(TimeofDay_Field);
        WebDriverWaits.SendKeys(TimeofDay_Field, "ALLDAY");
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(DialFormat_Field);
        WebDriverWaits.SendKeys(DialFormat_Field, "5");
        WebDriverWaits.ClickOn(Demand1_Field);
        WebDriverWaits.SendKeys(Demand1_Field, "0");
        WebDriverWaits.ClickOn(Demand2_Field);
        WebDriverWaits.SendKeys(Demand2_Field, "0");
        WebDriverWaits.ClickOn(NMISuffix_Field);
        WebDriverWaits.SendKeys(NMISuffix_Field, "17");
        WebDriverWaits.ClickOn(DateConnectedDatepicker);
        WebDriverWaits.ClickOn(SelectTodayDateConnected_Datepicker);
        WebDriverWaits.ClickOn(CreateRegister_Button);
        // Validate Successfully created meter register.
        String ActualSucessMsg = WebDriverWaits.GetText(CustomerSuccessMeterRegister);
        String ExpectedSucessMsg1 = "Successfully created meter register.";
        softAssert.assertEquals(ExpectedSucessMsg1, ActualSucessMsg);
        Thread.sleep(3000);
        System.out.println("register Id created ----- "+registerId);
        return registerId;
    }

    public static void  addMeterReads(String readType,String peakValue, String offPeakValue, String shoulderValue) throws InterruptedException {
        WebDriverWaits.ClickOn(MeterReads_Tab);
        WebDriverWaits.ClickOn(ServiceName_Dropdown);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(ServiceName_DropdownOpn);
        WebDriverWaits.ClickOn(MeterNumber_Dropdown);
        Thread.sleep(1000);
        WebDriverWaits.ClickOn(MeterNumber_DropdownOpn);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(ViewMeterReads);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebDriverWaits.ClickOn(AddMeterReads);
        Thread.sleep(1000);

        WebDriverWaits.ClickOn(MeterNo_Dropdown);
        WebDriverWaits.ClickOn(MeterNo_DropdownOpn);
        WebDriverWaits.ClickOn(RegisterNo_Dropdown);
        WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);
        WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);

        WebDriverWaits.selectByVisibleText(ReadType_Dropdown,readType);
        // WebElement ReadTypeOption2 = WebDriverWaits.WaitUntilVisibleWE(ReadType_Dropdown);
        // select = new Select(ReadTypeOption2);
        // select.selectByVisibleText("Actual Read");
        WebDriverWaits.ClickOn(ReadDate_Datepicker);
        WebDriverWaits.ClickOn(Select_ReadDate_Datepicker);
        WebDriverWaits.ClickOn(MeterReadPeak_Field);
        WebDriverWaits.SendKeys(MeterReadPeak_Field, peakValue);
        WebDriverWaits.ClickOn(MeterReadOffPeak_Field);
        WebDriverWaits.SendKeys(MeterReadOffPeak_Field, offPeakValue);
        WebDriverWaits.ClickOn(MeterReadShoulder_Field);
        WebDriverWaits.SendKeys(MeterReadShoulder_Field, shoulderValue);
        WebDriverWaits.ClickOn(Save_Button);
        Thread.sleep(2000);
        jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

}

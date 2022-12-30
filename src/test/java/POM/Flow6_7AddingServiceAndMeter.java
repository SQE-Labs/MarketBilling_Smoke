package POM;


import CommonMethods.DateAndTime;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import CommonMethods.WebDriverWaits;
//import POM.Flow6_7AddingServiceAndMeter.AddService;
//import POM.Flow5_AddCustomer.FirstCustomer;
//import POM.Flow5_AddCustomer.SecondCustomer;
//import POM.Flow5_AddCustomer.ThirdCustomer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import CommonMethods.InternalMethods;
import CommonMethods.RandomStrings;
//import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;

public class Flow6_7AddingServiceAndMeter extends TestLogin {

    public static JavascriptExecutor jse = (JavascriptExecutor) driver;
    public static Select select;
    public static String ServiceIDLater1;
    public static String ServiceIDLater2;
    public static String ServiceIDLater3;
    public static String RandomNumber1;
    public static String RandomNumber2;
    public static String RandomNumber3;

    public static class X_AddService {
        // Search Field
        public static By SearchField = By.xpath("//*[@id=\"search_input\"]");
        public static By SearchIcon = By.xpath("//*[@class=\"glyphicon glyphicon-search\"]");

        // Select the Residential/Business/Commercial customer created in add customer
        public static By TwosearchResults = By.xpath("//*[@class='icon-edit ']");
        public static By selectResidentialCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[1]");
        public static By selectBusinessCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[2]");
        public static By selectBusinessCustomer_Record1 = By.xpath("(//td[@class='sorting_1']/a)[1]"); // Just temporary
        // due to issue
        public static By selectCommercialCustomer_Record = By.xpath("(//td[@class='sorting_1']/a)[1]");
        public static By OverviewTab = By.xpath("//*[@class=\"icon-eye-open\"]"); // //*[contains(text(),'Overview')]

        // Add Service for Residential/Business/Commercial customer
        public static By RetailElectricity_Plus_Subtab = By.xpath("(//*[@class='icon-minus'])[2]");
        public static By Market_Type_Field = By.xpath("//*[@id='marketTypeSel']");
        public static By NMI_Field = By.xpath("//*[@id=\"NMI\"]");
        public static By Service_Plan_Dropdown = By.xpath("//*[@id=\"planNo\"]");
        public static By Move_In_Date_Datepicker = By.xpath("//*[@id=\"proposedDate\"]");
        public static By SelectCurrentDate = By.xpath("//*[@class=\"active day\"]");
        public static By Select_Use_Structured_Address_Togglebutton = By.xpath("//*[@class=\"switch-label\"]");
        public static By Building_Name_Field = By.xpath("//*[@id=\"buildingName\"]");
        public static By UnitType_Dropdown = By.xpath("//*[@id=\"flatType\"]");
        public static By Street_Number_Suffix_Dropdown = By.xpath("//*[@id=\"houseNBRSuffix\"]");
        public static By Suburb_Field = By.xpath("//*[@id=\"locality\"]");
        public static By Postal_Code_field = By.xpath("//*[@id=\"postCode\"]");
        public static By StateDropdown = By.xpath("//*[@id=\"state\"]");
        public static By AddButton = By.xpath("//*[@id=\"submitBttn\"]");

        // Edit Residential/Business/Commercial customer service
        public static By ServiceTab = By.xpath("//*[@class=\"icon-power-off\"]");
        public static By Search_FieldOnPage = By.xpath("//*[@class=\"dataTables_filter\"]");
        public static By Edit_icon = By.xpath("//*[@class=\"btn btn-primary toolt\"]");
        public static By Service_Status_Dropdown = By.xpath("//*[@id=\"serviceStatus\"]");
        public static By Netting_Config_Dropdown = By.xpath("//*[@id=\"nettingConfig\"]");
        public static By Sub_Channel_Aggregation_Dropdown = By.xpath("//*[@id=\"subChannelAggregation\"]");
        public static By SaveChanges_Button = By.xpath("//*[@class=\"btn btn-primary iseditable\"]");
        public static By OkButton = By.xpath("//*[contains(text(),'OK')]");
        public static By CustomerSuccessEditMsg = By.xpath("//div[@class='alert alert-success']/center");

        // Methods to add Residential Service

        public static void M_AddService() throws InterruptedException {

            //		 SoftAssert softAssert = new SoftAssert();

            WebDriverWaits.ClickOn(SearchIcon);
            Thread.sleep(1000);
            WebDriverWaits.ClickOn(SearchField);

            Thread.sleep(4000);

            String ThirdRecID = WebDriverWaits.GetText(selectResidentialCustomer_Record);
            //		WebDriverWaits.SendKeys(SearchField, CustomerID01R);
            WebDriverWaits.SendKeys(SearchField, ThirdRecID);


            WebDriverWaits.ClickOn(SearchIcon);
            WebDriverWaits.ClickOn(OverviewTab);
            WebDriverWaits.ClickOn(RetailElectricity_Plus_Subtab);
            Thread.sleep(2000);

            WebDriverWaits.ClickOn(Market_Type_Field);
            WebElement Option = WebDriverWaits.WaitUntilVisibleWE(Market_Type_Field);
            select = new Select(Option);
            select.selectByVisibleText("Off Market");

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,300)", "");
            Thread.sleep(2000);

            WebDriverWaits.ClickOn(NMI_Field);
            ServiceIDLater1 = RandomStrings.RequiredDigits(10);
            WebDriverWaits.SendKeys(NMI_Field, ServiceIDLater1);
            System.out.println("SERVICE ID -------- " + ServiceIDLater1);

            Thread.sleep(1000);

            WebDriverWaits.ClickOn(Service_Plan_Dropdown);
            WebElement Option2 = WebDriverWaits.WaitUntilVisibleWE(Service_Plan_Dropdown);
            select = new Select(Option2);
            select.selectByVisibleText("Electricity Template Plan");
            Thread.sleep(1000);

            WebDriverWaits.ClickOn(Move_In_Date_Datepicker);
            WebDriverWaits.SendKeys(Move_In_Date_Datepicker, DateAndTime.DateTimeGenerator("dd/mm/yyyy"));

            WebDriverWaits.ClickOn(SelectCurrentDate);

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(Select_Use_Structured_Address_Togglebutton);
            WebDriverWaits.ClickOn(Building_Name_Field);
            WebDriverWaits.SendKeys(Building_Name_Field, "Los angels");
            WebDriverWaits.ClickOn(UnitType_Dropdown);
            WebElement BlockOption = WebDriverWaits.WaitUntilVisibleWE(UnitType_Dropdown);
            select = new Select(BlockOption);
            select.selectByVisibleText("Block");
            WebDriverWaits.ClickOn(Street_Number_Suffix_Dropdown);
            WebElement VOption = WebDriverWaits.WaitUntilVisibleWE(Street_Number_Suffix_Dropdown);
            select = new Select(VOption);
            select.selectByVisibleText("V");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebDriverWaits.ClickOn(Suburb_Field);
            WebDriverWaits.SendKeys(Suburb_Field, "Almor Distt 324");
            WebDriverWaits.ClickOn(Postal_Code_field);
            String RandomNumber2 = RandomStrings.RequiredDigits(15);
            WebDriverWaits.SendKeys(Postal_Code_field, RandomNumber2);
            WebDriverWaits.ClickOn(StateDropdown);
            WebElement StateOption = WebDriverWaits.WaitUntilVisibleWE(StateDropdown);
            select = new Select(StateOption);
            select.selectByVisibleText("New South Wales");
            WebDriverWaits.ClickOn(AddButton);
            jse.executeScript("window.scrollBy(0,-300)", "");

        }

        public static void EditService() throws InterruptedException {
            SoftAssert softAssert = new SoftAssert();


            // Methods to Edit Residential Service

            WebDriverWaits.ClickOn(ServiceTab);

            // Search service id ("N" + random+"11"); which is created above
            WebDriverWaits.ClickOn(Edit_icon);
            jse.executeScript("window.scrollBy(0,300)", "");
            WebDriverWaits.ClickOn(Service_Status_Dropdown);
            WebElement StatusOption = WebDriverWaits.WaitUntilVisibleWE(Service_Status_Dropdown);
            select = new Select(StatusOption);
            select.selectByVisibleText("Connected");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebDriverWaits.ClickOn(SaveChanges_Button);
            WebDriverWaits.ClickOn(OkButton);
            //Assert:  Successfully saved service details.
//			String ActualMsg = WebDriverWaits.GetText(CustomerSuccessEditMsg);
//			String ExpectedMsg1 = "Successfully saved service details.";
//			softAssert.assertEquals(ExpectedMsg1, ActualMsg);
            System.out.println("Successfully edited customer");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            //Metering.AddMeter();
//			Thread.sleep(2000);
        }

        public static void Service_MeterR() throws InterruptedException {
            X_AddService.M_AddService();
            //X_AddService.EditService();
            //Metering.AddMeter();
            Thread.sleep(2000);
        }

        // Methods to add Business Service
        public static void AddSecondService() throws InterruptedException {
//		 SoftAssert softAssert = new SoftAssert();

            WebDriverWaits.ClickOn(SearchIcon);
            Thread.sleep(1000);
            WebDriverWaits.ClickOn(SearchField);

            String SecondRecID = WebDriverWaits.GetText(selectBusinessCustomer_Record);
            WebDriverWaits.SendKeys(SearchField, SecondRecID);

            WebDriverWaits.ClickOn(SearchIcon);
            Thread.sleep(2000);
            InternalMethods.SwitchToCustomerpage();
            // WebDriverWaits.ClickOn(OverviewTab);
            Thread.sleep(2000);

            WebDriverWaits.ClickOn(RetailElectricity_Plus_Subtab);
            Thread.sleep(2000);

            WebDriverWaits.ClickOn(Market_Type_Field);
            WebElement Option = WebDriverWaits.WaitUntilVisibleWE(Market_Type_Field);
            select = new Select(Option);
            select.selectByVisibleText("Off Market");

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,300)", "");
            Thread.sleep(2000);

            WebDriverWaits.ClickOn(NMI_Field);
            ServiceIDLater2 = RandomStrings.RequiredDigits(10);
            WebDriverWaits.SendKeys(NMI_Field, ServiceIDLater2);

            Thread.sleep(1000);

            WebDriverWaits.ClickOn(Service_Plan_Dropdown);
            WebElement Option2 = WebDriverWaits.WaitUntilVisibleWE(Service_Plan_Dropdown);
            select = new Select(Option2);
            select.selectByVisibleText("Electricity Template Plan");
            Thread.sleep(1000);

            WebDriverWaits.ClickOn(Move_In_Date_Datepicker);
            WebDriverWaits.SendKeys(Move_In_Date_Datepicker, "01/12/2022");
//			WebDriverWaits.ClickOn(SelectCurrentDate);

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(Select_Use_Structured_Address_Togglebutton);
            WebDriverWaits.ClickOn(Building_Name_Field);
            WebDriverWaits.SendKeys(Building_Name_Field, "Los angels");
            WebDriverWaits.ClickOn(UnitType_Dropdown);
            WebElement BlockOption = WebDriverWaits.WaitUntilVisibleWE(UnitType_Dropdown);
            select = new Select(BlockOption);
            select.selectByVisibleText("Block");
            WebDriverWaits.ClickOn(Street_Number_Suffix_Dropdown);
            WebElement VOption = WebDriverWaits.WaitUntilVisibleWE(Street_Number_Suffix_Dropdown);
            select = new Select(VOption);
            select.selectByVisibleText("V");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebDriverWaits.ClickOn(Suburb_Field);
            WebDriverWaits.SendKeys(Suburb_Field, "Almor Distt 324");
            WebDriverWaits.ClickOn(Postal_Code_field);
            String RandomNumber2 = RandomStrings.RequiredDigits(15);
            WebDriverWaits.SendKeys(Postal_Code_field, RandomNumber2);
            WebDriverWaits.ClickOn(StateDropdown);
            WebElement StateOption = WebDriverWaits.WaitUntilVisibleWE(StateDropdown);
            select = new Select(StateOption);
            select.selectByVisibleText("New South Wales");
            WebDriverWaits.ClickOn(AddButton);
        }

        // Methods to Edit Business Service
        public static void EditSecondService() throws InterruptedException {
            SoftAssert softAssert = new SoftAssert();
            WebDriverWaits.ClickOn(ServiceTab);
            // Search service id ("N" + random+"11"); which is created above
            WebDriverWaits.ClickOn(Edit_icon);
            jse.executeScript("window.scrollBy(0,300)", "");
            WebDriverWaits.ClickOn(Service_Status_Dropdown);
            WebElement StatusOption = WebDriverWaits.WaitUntilVisibleWE(Service_Status_Dropdown);
            select = new Select(StatusOption);
            select.selectByVisibleText("Connected");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebDriverWaits.ClickOn(SaveChanges_Button);
            WebDriverWaits.ClickOn(OkButton);
            //Assert:  Successfully saved service details.
//			String ActualMsg = WebDriverWaits.GetText(CustomerSuccessEditMsg);
//			String ExpectedMsg1 = "Successfully saved service details.";
//			softAssert.assertEquals(ExpectedMsg1, ActualMsg);
            System.out.println("Successfully edited customer");

        }

//		public static void BAddMeter_MeterRegister() throws InterruptedException {
//
//			Metering.AddMeter();
//			Thread.sleep(2000);
//
//		}

        public static void Service_MeterB() throws InterruptedException {
            X_AddService.AddSecondService();
            //X_AddService.EditSecondService();
            //  Metering.AddMeter();
            Thread.sleep(2000);
        }

        // Methods to add Commercial Service
        public static void AddThirdService() throws InterruptedException {
//			SoftAssert softAssert = new SoftAssert();

            WebDriverWaits.ClickOn(SearchIcon);
            Thread.sleep(1000);
            WebDriverWaits.ClickOn(SearchField);
            //WebDriverWaits.ClickOn(TwosearchResults);
            String FirstRecID = WebDriverWaits.GetText(selectCommercialCustomer_Record);
            WebDriverWaits.SendKeys(SearchField, FirstRecID);

            // WebDriverWaits.ClickOn(selectCommercialCustomer_Record);
            WebDriverWaits.ClickOn(SearchIcon);
            //Thread.sleep(5000);
            // issue fix for now is click on the record
//			ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
//			Thread.sleep(3000);
//			driver.switchTo().window((String) tabs.get(1));

            // WebDriverWaits.ClickOn(selectCommercialCustomer_Record);
            Thread.sleep(2000);
            WebDriverWaits.ClickOn(RetailElectricity_Plus_Subtab);
            Thread.sleep(2000);

            WebDriverWaits.ClickOn(Market_Type_Field);
            WebElement Option = WebDriverWaits.WaitUntilVisibleWE(Market_Type_Field);
            select = new Select(Option);
            select.selectByVisibleText("Off Market");

            Thread.sleep(4000);
            jse.executeScript("window.scrollBy(0,300)", "");
            Thread.sleep(2000);

            WebDriverWaits.ClickOn(NMI_Field);
            ServiceIDLater3 = RandomStrings.RequiredDigits(10);
            WebDriverWaits.SendKeys(NMI_Field, ServiceIDLater3);

            Thread.sleep(1000);

            WebDriverWaits.ClickOn(Service_Plan_Dropdown);
            WebElement Option2 = WebDriverWaits.WaitUntilVisibleWE(Service_Plan_Dropdown);
            select = new Select(Option2);
            select.selectByVisibleText("Electricity Template Plan");
            Thread.sleep(1000);

            WebDriverWaits.ClickOn(Move_In_Date_Datepicker);
            //	WebDriverWaits.ClickOn(SelectCurrentDate);
            WebDriverWaits.SendKeys(Move_In_Date_Datepicker, "01/12/2022");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(Select_Use_Structured_Address_Togglebutton);
            WebDriverWaits.ClickOn(Building_Name_Field);
            WebDriverWaits.SendKeys(Building_Name_Field, "Los angels");
            WebDriverWaits.ClickOn(UnitType_Dropdown);
            WebElement BlockOption = WebDriverWaits.WaitUntilVisibleWE(UnitType_Dropdown);
            select = new Select(BlockOption);
            select.selectByVisibleText("Block");
            WebDriverWaits.ClickOn(Street_Number_Suffix_Dropdown);
            WebElement VOption = WebDriverWaits.WaitUntilVisibleWE(Street_Number_Suffix_Dropdown);
            select = new Select(VOption);
            select.selectByVisibleText("V");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebDriverWaits.ClickOn(Suburb_Field);
            WebDriverWaits.SendKeys(Suburb_Field, "Almor Distt 324");
            WebDriverWaits.ClickOn(Postal_Code_field);
            String RandomNumber2 = RandomStrings.RequiredDigits(15);
            WebDriverWaits.SendKeys(Postal_Code_field, RandomNumber2);
            WebDriverWaits.ClickOn(StateDropdown);
            WebElement StateOption = WebDriverWaits.WaitUntilVisibleWE(StateDropdown);
            select = new Select(StateOption);
            select.selectByVisibleText("New South Wales");
            WebDriverWaits.ClickOn(AddButton);
            jse.executeScript("window.scrollBy(0,-1000)", "");

        }

        // Methods to Edit Commercial Service
        public static void EditThirdService() throws InterruptedException {
            SoftAssert softAssert = new SoftAssert();


            WebDriverWaits.ClickOn(ServiceTab);
            // Search service id ("N" + random+"11"); which is created above
            WebDriverWaits.ClickOn(Edit_icon);
            jse.executeScript("window.scrollBy(0,300)", "");
            WebDriverWaits.ClickOn(Service_Status_Dropdown);
            WebElement StatusOption = WebDriverWaits.WaitUntilVisibleWE(Service_Status_Dropdown);
            select = new Select(StatusOption);
            select.selectByVisibleText("Connected");
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            WebDriverWaits.ClickOn(SaveChanges_Button);
            WebDriverWaits.ClickOn(OkButton);
            //Assert:  Successfully saved service details.
//			String ActualMsg = WebDriverWaits.GetText(CustomerSuccessEditMsg);
//			String ExpectedMsg1 = "Successfully saved service details.";
//			softAssert.assertEquals(ExpectedMsg1, ActualMsg);
            System.out.println("Successfully ediited customer");
            Thread.sleep(4000);
            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        }

        public static void addSiteParameters() {


        }

        //		public static void AddMeter_MeterRegisterC() throws InterruptedException {
//			
//			Metering.AddMeter();
//			Thread.sleep(2000);
//			
//}
        public static void Service_MeterC() throws InterruptedException {
            X_AddService.AddThirdService();
            //X_AddService.EditThirdService();
            // Metering.AddMeter();
            Thread.sleep(2000);
        }


    }



}

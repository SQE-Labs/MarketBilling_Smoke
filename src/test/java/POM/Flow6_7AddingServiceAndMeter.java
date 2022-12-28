package POM;

//import java.util.ArrayList;

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
		public static By TwosearchResults= By.xpath("//*[@class='icon-edit ']");
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
		public static By CustomerSuccessEditMsg =By.xpath("//div[@class='alert alert-success']/center");
		
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
			System.out.println("SERVICE ID -------- "+ServiceIDLater1);

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
			WebDriverWaits.SendKeys(Move_In_Date_Datepicker, "01/12/2022" );
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
			WebDriverWaits.SendKeys(Move_In_Date_Datepicker, "01/12/2022" );
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
		public static void addSiteParameters()  {


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

	public static class Metering {
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
		public static By ReadType_Dropdown = By.xpath("//*[@id='rreadType']");
		public static By ReadType_DropdownOpn1 = By.xpath("//*[@id='rreadType']/option[2]");
		public static By ReadType_DropdownOpn2 = By.xpath("//*[@id='rreadType']/option[4]");

		public static By ReadDate_Datepicker = By.xpath("//*[@id='rreadDate']");
		public static By Select_ReadDate_Datepicker = By.xpath("//*[@class='active day']");
		public static By MeterReadPeak_Field= By.xpath("//*[@id='modalReadingP']");
		public static By MeterReadOffPeak_Field =By.xpath("//*[@id='modalReadingO']");
		public static By MeterReadShoulder_Field =By.xpath("//*[@id='modalReadingS']");
		public static By Save_Button =By.xpath("(//button[contains(text(),'Save')])[2]");
		public static By CustomerSuccessMeterRegister =By.xpath("//div[@class='alert alert-success']/center");
		
		public static void AddMeter() throws InterruptedException {
			
			SoftAssert softAssert = new SoftAssert();
//			Thread.sleep(2000);
//			WebDriverWaits.ClickOn(AddService.SearchIcon);
//			//WebDriverWaits.ClickOn(AddService.SearchField);
//			WebDriverWaits.SendKeys(AddService.SearchField, Flow5_AddCustomer.CustomerID01R);
//			Thread.sleep(2000);

		//	jse.executeScript("window.scrollBy(0,-1000)", "");
			
            Thread.sleep(3000);
			jse.executeScript("window.scrollBy(0,1000)", "");
//			JavascriptExecutor jser = (JavascriptExecutor) driver;
//            Thread.sleep(3000);
//            WebElement AddMeterIconJS = (WebElement) jser.executeScript("return document.querySelector('#serviceEditPage > div.col-lg-9 > div.box > div.box-content > div:nth-child(6) > div.col-lg-12.table-responsive > div > div > div')");
//            Thread.sleep(6000);
////            AddMeterIconJS.click();
//			WebDriverWaits.ClickOnWE(AddMeterIconJS);

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
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(MeterEdit_icon);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(AddMeterRegister_Icon);

			//Create register
			WebDriverWaits.ClickOn(RegisterID_Field);
			Thread.sleep(2000);
			String RandomNumber2 = "12345"+RandomStrings.RequiredDigits(5);
			WebDriverWaits.SendKeys(RegisterID_Field, RandomNumber2);
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
			WebDriverWaits.ClickOn(AddMeterReads);
			Thread.sleep(1000);

			WebDriverWaits.ClickOn(MeterNo_Dropdown);
			WebDriverWaits.ClickOn(MeterNo_DropdownOpn);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(RegisterNo_Dropdown);
			WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);
			Thread.sleep(2000);

		//	WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);
			WebDriverWaits.ClickOn(ReadType_Dropdown);
			WebDriverWaits.ClickOn(ReadType_DropdownOpn1);
			// WebElement ReadTypeOption1 = WebDriverWaits.WaitUntilVisibleWE(ReadType_Dropdown);
			// select = new Select(ReadTypeOption1);
			// select.selectByVisibleText("Initial");
			WebDriverWaits.ClickOn(ReadDate_Datepicker);
			WebDriverWaits.ClickOn(Select_ReadDate_Datepicker);
			WebDriverWaits.ClickOn(MeterReadPeak_Field);
			WebDriverWaits.SendKeys(MeterReadPeak_Field, "150");
			WebDriverWaits.ClickOn(MeterReadOffPeak_Field);
			WebDriverWaits.SendKeys(MeterReadOffPeak_Field, "200");
			WebDriverWaits.ClickOn(MeterReadShoulder_Field);
			WebDriverWaits.SendKeys(MeterReadShoulder_Field, "300");
			WebDriverWaits.ClickOn(Save_Button);
			Thread.sleep(2000);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(AddMeterReads);
			Thread.sleep(1000);

			WebDriverWaits.ClickOn(MeterNo_Dropdown);
			WebDriverWaits.ClickOn(MeterNo_DropdownOpn);
			WebDriverWaits.ClickOn(RegisterNo_Dropdown);
			WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);
			WebDriverWaits.ClickOn(RegisterNo_DropdownOpn);
			WebDriverWaits.ClickOn(ReadType_Dropdown);
			WebDriverWaits.ClickOn(ReadType_DropdownOpn2);
			// WebElement ReadTypeOption2 = WebDriverWaits.WaitUntilVisibleWE(ReadType_Dropdown);
			// select = new Select(ReadTypeOption2);
			// select.selectByVisibleText("Actual Read");
			WebDriverWaits.ClickOn(ReadDate_Datepicker);
			WebDriverWaits.ClickOn(Select_ReadDate_Datepicker);
			WebDriverWaits.ClickOn(MeterReadPeak_Field);
			WebDriverWaits.SendKeys(MeterReadPeak_Field, "200");
			WebDriverWaits.ClickOn(MeterReadOffPeak_Field);
			WebDriverWaits.SendKeys(MeterReadOffPeak_Field, "400");
			WebDriverWaits.ClickOn(MeterReadShoulder_Field);
			WebDriverWaits.SendKeys(MeterReadShoulder_Field, "650");
			WebDriverWaits.ClickOn(Save_Button);
			Thread.sleep(2000);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			
			
			
		}
		
		
	}

}

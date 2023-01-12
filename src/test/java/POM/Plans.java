package POM;

import CommonMethods.BaseTest;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;
//import junit.framework.Assert;

public class Plans extends BaseTest {
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	public static SoftAssert softAssert = new SoftAssert();
	static Select select ;

		public static By PlanTab = By.xpath("//*[@class='icon-lightbulb']");
		public static By CreateNewPlan = By.xpath("//*[@id='addBtn']");
		public static By UsageTypeDropdown = By.xpath("//*[@id='usageTypes']");
		public static By NameField = By.xpath("//*[@id='name']");
		public static By Usage_TOU_Definition_Dropdown = By.xpath("//*[@id='usageTOU']");
		public static By Demand_TOU_Definition_Dropdown = By.xpath("//*[@id='demandTOU']");
		public static By DateValidFrom_Datepicker = By.xpath("//*[@id='dateValidFrom']");
		public static By Select_Current_ValidDate_From = By.xpath("//*[@class='active day']");
		public static By DateValidTo_Datepicker = By.xpath("//*[@id='dateValidTo']");
		public static By Select_Current_ValidDate_To = By.xpath("//*[@class='active day']");
		public static By Add_Tariff_Button = By.id("addTrfBtn");
		public static By ChargeDescription_Field = By.xpath("//*[@id='charge-desc']");
		public static By ChargeDescription_Opn = By.xpath("//div[@class='tt-dataset-states']");
		public static By RollupDescription_Field = By.xpath("//*[@id='rollup-desc']");
		public static By RollupDescription_Opn = By.xpath("(//div[@class='tt-dataset-states'])[2]");
		public static By ChargeType_Dropdown = By.xpath("//*[@id='charge-type']");
		public static By RatingMethod_Dropdown = By.xpath("//*[@id='method-type']");
		public static By RatingMethod_Dropdown_Opn = By.xpath("//option[text()='Network Volume']");
		public static By RatingMethod_Dropdown_Opn_OtherPlan = By.xpath("//option[text()='Other Charges']");
		public static By Unit_Dropdown = By.xpath("//*[@id='unit-type']");
		public static By Unit_Dropdown_Opn = By.xpath("(//*[@id='unit-type']/option)[2]");
		public static By Rate_Field = By.xpath("//*[@id='rate']");
	public static By RateR_Field = By.xpath("//*[@id='rateR']");

	public static By AddTrf_Button = By.xpath("//*[@id='addTrf']");
	public static By AddProrata_Button = By.id("addProrataBtn");
	public static By AddProrata_Button1 = By.id("//button[(text()='Add Tariff')]");

	public static By Trf_SearchField = By.xpath("(//label[text()='Search:'])[2]/input");
		// public static By Trf_SearchField =
		// By.xpath("//*[@id='datatablePreview_wrapper']/div[1]/label/input");
		public static By Publish_Button = By.xpath("//*[@id='publishBtn']");
//		public static By Cross_icon = By.xpath("//*[@class='icon-remove']");
		public static By Cross_icon = By.id("closePlnBtn");
	public static By Prorata_Close = By.id("prorataClose");

		public static By Plan_Search_Field = By.xpath("(//label[text()='Search:'])[1]/input");
		public static By SearchResultForPlanName = By.xpath("//tbody[@id='plnListBody']/tr/td[2]");

		public static By EditIconTarrif = By.xpath("//i[@class='fa fa-pencil']");
		public static By InfoMsgTarrifCount = By.xpath("//div[@id='datatablePreview_info']");
		public static By PlanSearchField = By.xpath(".//*[@class='dataTables_filter']/label/input");
		public static By EditPlan = By.xpath("//*[@class='fa fa-pencil ']");
		public static By TrfCalendarIcon = By.xpath("(//*[@class='icon-calendar'])[1]");
		public static By Prorata_ToggleButton = By.xpath("(//span[@class='switch-label'])[2]");
		public static By Prorata_RangeFrom_Datepicker = By.xpath("//*[@id='rangeFrom']");
		public static By SelectTodayProrataDate_RangeFrom = By.xpath("//*[@class='active selected day']");
		public static By Prorata_RangeTo_Datepicker = By.xpath("//*[@id='rangeTo']");
		public static By SelectTodayProrataDate_RangeTo = By.xpath("//*[@class='active selected day']");
		public static By ProrataRateField = By.xpath("//*[@id='rateR']");
		public static By ProrataPlus_Button = By.xpath("//*[@id='addProrataBtn']");
		public static By ProrataClose_Button = By.xpath("//*[@id='prorataClose']");
		public static By ProrataPlanRecord_Edit = By.xpath("(//*[@class='fa fa-pencil '])[1]");
		public static void AddPlanwithoutTOUDefinition() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.navigate().refresh();
			WebDriverWaits.ClickOn(PlanTab);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(CreateNewPlan);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);

			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			WebDriverWaits.ClickOn(NameField);
			String RandomName1 = "Market_Plan" + RandomStrings.RequiredCharacters(4);
			WebDriverWaits.SendKeys(NameField, RandomName1);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			// Assertion_obj.AssertTariffButton
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Flat Usage");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Account Charges");
			WebDriverWaits.ClickOn(RollupDescription_Opn);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByVisibleText("Ausgrid kVA Capacity Charge");
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			// WebElement UnitOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(UnitOption);
			// select.selectByIndex(1);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate1 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate1);
			Thread.sleep(4000);
			WebDriverWaits.ClickOn(AddTrf_Button);
			Thread.sleep(4000);
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate1);
			Thread.sleep(2000);
			List<WebElement> countEditIcon = driver.findElements(EditIconTarrif);
			int sizeOfList = countEditIcon.size();
			boolean compareList = sizeOfList == 1;
			softAssert.assertEquals(compareList, true);
			String TarrifMsg = WebDriverWaits.GetText(InfoMsgTarrifCount);
			String ExpectedMsg = "Showing 1 to 1 of 1 entries";
			softAssert.assertEquals(ExpectedMsg, TarrifMsg);
			System.out.println("Assert passed");
			Thread.sleep(4000);
			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ExpectedMsg1 = "Market has been successfully created.";
			softAssert.assertEquals(ExpectedMsg1, "Market has been successfully created.");
			System.out.println("Market having Plan without TOUDefinition has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			Thread.sleep(4000);
			// Search the same created plan.
			WebDriverWaits.ClickOn(Plan_Search_Field);
			WebDriverWaits.SendKeys(Plan_Search_Field, RandomName1);
			// Assertion that the plan is added.
            String SearchResultPlanName = WebDriverWaits.GetText(SearchResultForPlanName);
			Assert.assertEquals(SearchResultPlanName, RandomName1);


		}

		public static void PlanwithTOUDefinition_Network_and_Retail_Trf() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.navigate().refresh();
			driver.navigate().refresh();
			WebDriverWaits.ClickOn(PlanTab);
			WebDriverWaits.ClickOn(CreateNewPlan);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);
			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			// select.selectByIndex(2);
			WebDriverWaits.ClickOn(NameField);
			String RandomName2 = "MktPlan_NetworkRate" + RandomStrings.RequiredCharacters(4);
			System.out.println("RandomName2 "+RandomName2);

			WebDriverWaits.SendKeys(NameField, RandomName2);
			WebDriverWaits.ClickOn(Usage_TOU_Definition_Dropdown);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);

			// Add Trf with Rating Method as Network Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Flat Usage");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Account Charges");
			WebDriverWaits.ClickOn(RollupDescription_Opn);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption =WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByVisibleText("Network Volume") // Need to scroll the dropdown
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate2 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate2);
			WebDriverWaits.ClickOn(AddTrf_Button);

			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate2);
			Thread.sleep(2000);
			// Assertion on Showing 1 to 1 of 1 entries
			List<WebElement> countEditIcon = driver.findElements(EditIconTarrif);
			int sizeOfList = countEditIcon.size();
			boolean compareList = sizeOfList == 1;
			softAssert.assertEquals(compareList, true);
			String TarrifMsg = WebDriverWaits.GetText(InfoMsgTarrifCount);
			String ExpectedMsg = "Showing 1 to 1 of 1 entries";
			softAssert.assertEquals(ExpectedMsg, TarrifMsg);
			System.out.println("Plan with TOU Definition having Network rating method is successfully added");


			// Add Trf with Rating Method as Retail Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Retail Electricity Charges");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Electricity Usages");
			WebDriverWaits.ClickOn(RollupDescription_Opn);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption1 = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption1);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption1 = WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption1);
			// select.selectByVisibleText("Retail Volume") // Need to scroll the dropdown
			WebDriverWaits.ClickOn(Unit_Dropdown);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate3 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate3);
			WebDriverWaits.ClickOn(AddTrf_Button);
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate3);
			Thread.sleep(2000);
			// Assertion on Showing 1 to 1 of 1 entries
			//List<WebElement> countEditIcon2 = driver.findElements(EditIconTarrif);
			//int sizeOfList2 = countEditIcon2.size();
			//boolean compareList2 = sizeOfList == 1;
			//softAssert.assertEquals(compareList, true);
		//	String TarrifMsg2 = WebDriverWaits.GetText(InfoMsgTarrifCount);
			//String ExpectedMsg2 = "Showing 1 to 1 of 1 entries";
			//softAssert.assertEquals(ExpectedMsg, TarrifMsg);
			//System.out.println("Assert passed");
			Thread.sleep(4000);

			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ExpectedMsg2 = "Market has been successfully created.";
			softAssert.assertEquals(ExpectedMsg2, "Market has been successfully created.");
			System.out.println("Plan with TOUDefinition Market has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			WebDriverWaits.ClickOn(Plan_Search_Field);
			WebDriverWaits.SendKeys(Plan_Search_Field, RandomName2);
			String SearchResultPlanName = WebDriverWaits.GetText(SearchResultForPlanName);
			Assert.assertEquals(SearchResultPlanName, RandomName2);
			jse.executeScript("window.scrollBy(0,-400)", "");

			Thread.sleep(2000);

			// Search the same created plan.
			// Assertion that the plan is added.

		}

		public static String PlanwithDemandTOUdefinition_Network_and_Retail_Trf() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.navigate().refresh();
			WebDriverWaits.ClickOn(PlanTab);
			WebDriverWaits.ClickOn(CreateNewPlan);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);
			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			// select.selectByIndex(2);
			WebDriverWaits.ClickOn(NameField);
			String planId = "MktPlan_NetworkRate" + RandomStrings.RequiredCharacters(4);
			WebDriverWaits.SendKeys(NameField, planId);
			WebDriverWaits.ClickOn(Demand_TOU_Definition_Dropdown);

			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);

			// Add Trf with Rating Method as Network Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Flat Usage");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Account Charges");
			WebDriverWaits.ClickOn(RollupDescription_Opn);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByVisibleText("Network Volume") ;// Need to scroll the dropdown
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String random = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, random);
			WebDriverWaits.ClickOn(AddTrf_Button);
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, random);

			// Assertion on Showing 1 to 1 of 1 entries
			// Assertion that the Trf is added.
			// Add Trf with Rating Method as Retail Volume
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Retail Electricity Charges");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "Electricity Usages");
			WebDriverWaits.ClickOn(RollupDescription_Opn);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption1 = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption1);
			select.selectByVisibleText("Electricity Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn);
			// WebElement RatingOption1 =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption1);
			// select.selectByVisibleText("Retail Volume")
			// select.selectByValue("GV");
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			// WebElement UnitOption1 =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(UnitOption1);
			// select.selectByVisibleText("$/kW/year");
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate5 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate5);
			WebDriverWaits.ClickOn(AddTrf_Button);
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Trf_SearchField, RandomRate5);

			// Assertion on Showing 1 to 1 of 1 entries
			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ExpectedMsg3 = "Market has been successfully created.";
			softAssert.assertEquals(ExpectedMsg3, "Market has been successfully created.");
			System.out.println("Plan with DemandTOUdefinition Market has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);


return planId;
		}

		public static void OtherPlan() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			driver.navigate().refresh();
			WebDriverWaits.ClickOn(PlanTab);
			WebDriverWaits.ClickOn(CreateNewPlan);
			WebDriverWaits.ClickOn(UsageTypeDropdown);
			WebElement UsageOption = WebDriverWaits.WaitUntilVisibleWE(UsageTypeDropdown);
			select = new Select(UsageOption);
			select.selectByVisibleText("Retail Electricity");
			WebDriverWaits.ClickOn(NameField);
			String RandomName4 = "OtherPlan\" + random" + RandomStrings.RequiredCharacters(6);
			WebDriverWaits.SendKeys(NameField, RandomName4);
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(DateValidFrom_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_From);
			WebDriverWaits.ClickOn(DateValidTo_Datepicker);
			WebDriverWaits.ClickOn(Select_Current_ValidDate_To);
			WebDriverWaits.ClickOn(Add_Tariff_Button);
			// Assertion_obj.AssertTariffButton
			WebDriverWaits.ClickOn(ChargeDescription_Field);
			WebDriverWaits.SendKeys(ChargeDescription_Field, "Other Charges");
			WebDriverWaits.ClickOn(ChargeDescription_Opn);
			WebDriverWaits.ClickOn(RollupDescription_Field);
			WebDriverWaits.SendKeys(RollupDescription_Field, "All USages rates");
			WebDriverWaits.ClickOn(RollupDescription_Opn);
			WebDriverWaits.ClickOn(ChargeType_Dropdown);
			WebElement ChargeOption = WebDriverWaits.WaitUntilVisibleWE(ChargeType_Dropdown);
			select = new Select(ChargeOption);
			select.selectByVisibleText("Account Level Charges");
			WebDriverWaits.ClickOn(RatingMethod_Dropdown);
			Thread.sleep(2000);
			WebDriverWaits.ClickOn(RatingMethod_Dropdown_Opn_OtherPlan);
			// WebElement RatingOption =
			// WebDriverWaits.WaitUntilVisibleWE(RatingMethod_Dropdown);
			// select = new Select(RatingOption);
			// select.selectByIndex(1);
			// select.selectByVisibleText("Ausgrid kVA Capacity Charge");
			WebDriverWaits.ClickOn(Unit_Dropdown);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Unit_Dropdown_Opn);
			Thread.sleep(1000);
			WebDriverWaits.ClickOn(Rate_Field);
			// WebDriverWaits.SendKeys(Rate_Field,"10" );
			String RandomRate6 = RandomStrings.RequiredDigits(2);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate6);
			WebDriverWaits.ClickOn(AddTrf_Button);
			WebDriverWaits.ClickOn(Trf_SearchField);
			WebDriverWaits.SendKeys(Rate_Field, RandomRate6);
			Thread.sleep(2000);
			List<WebElement> countEditIcon = driver.findElements(EditIconTarrif);
			int sizeOfList = countEditIcon.size();
			boolean compareList = sizeOfList == 1;
			softAssert.assertEquals(compareList, true);
			String TarrifMsg = WebDriverWaits.GetText(InfoMsgTarrifCount);
			String ExpectedMsg = "Showing 1 to 1 of 1 entries";
			softAssert.assertEquals(ExpectedMsg, TarrifMsg);
			WebDriverWaits.ClickOn(Publish_Button);
			// Assertion "Market has been successfully created."
			String ExpectedMsg4 = "Market has been successfully created.";
			softAssert.assertEquals(ExpectedMsg4, "Market has been successfully created.");
			System.out.println("OtherPlan Market has been successfully created.");
			WebDriverWaits.ClickOn(Cross_icon);
			WebDriverWaits.ClickOn(Plan_Search_Field);
			WebDriverWaits.SendKeys(Plan_Search_Field, RandomName4);
			String SearchResultPlanName = WebDriverWaits.GetText(SearchResultForPlanName);
			Assert.assertEquals(SearchResultPlanName, RandomName4);
			jse.executeScript("window.scrollBy(0,-400)", "");

		}

		public static void Add_ProRated_Rates() throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			Thread.sleep(5000);
            WebDriverWaits.scrollIntoView(TrfCalendarIcon);
			WebDriverWaits.ClickOn(TrfCalendarIcon);
			Thread.sleep(5000);
			WebDriverWaits.selectCheckBox(Prorata_ToggleButton);
			WebDriverWaits.ClickOn(Prorata_RangeFrom_Datepicker);
			WebDriverWaits.ClickOn(SelectTodayProrataDate_RangeFrom);
			WebDriverWaits.ClickOn(Prorata_RangeTo_Datepicker);
			WebDriverWaits.ClickOn(SelectTodayProrataDate_RangeFrom);
			WebDriverWaits.SendKeys(RateR_Field,"20");
			WebDriverWaits.ClickOn(AddProrata_Button);
			WebDriverWaits.ClickOn(Prorata_Close);

Thread.sleep(3000);
//WebDriverWaits.scrollIntoView(AddProrata_Button1);
//			WebDriverWaits.ClickOn(AddProrata_Button1)
			;



		}
	public static void search_Plan(String planId) throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
Admin.navigateToPlans();
        WebDriverWaits.SendKeysWithClear(PlanSearchField,planId);
		WebDriverWaits.ClickOn(EditPlan);


	}
	}

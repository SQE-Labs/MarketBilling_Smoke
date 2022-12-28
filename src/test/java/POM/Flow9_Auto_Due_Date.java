package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

//import BrowsersBase.DataInterface;
//import CommonMethods.InternalMethods;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import POM.Flow5_AddCustomer.FirstCustomer;
import POM.Flow5_AddCustomer.SecondCustomer;
import POM.Flow5_AddCustomer.ThirdCustomer;

import POM.Flow6_7AddingServiceAndMeter.X_AddService;
//import POM.Flow6_7AddingServiceAndMeter.Metering;
import TestCases.TestLogin;

public class Flow9_Auto_Due_Date extends TestLogin {
	public static String RandomCycleName4;
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	
	
	public static void AutoDueDate() throws InterruptedException {
		Thread.sleep(2000);
		Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterR();

		Flow6_7AddingServiceAndMeter.X_AddService.AddSecondService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterB();

		Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
		Flow6_7AddingServiceAndMeter.X_AddService.Service_MeterC();

	}

	public static class X_EnableDueDate {
		public static By Admin_Tab = By.xpath("//a[@title='Administration']/i");
		public static By EditGroup_SubTab = By.xpath("//*[contains(text(),'Edit Group')]");
		public static By MinimumDaystoBill = By.xpath("//*[@id='minDaysToBill']");
		public static By DueDatebyPaymentTerms_ToggleButton = By.xpath("(//label[text()='Due Date by Payment Terms']/following::span)[1]");
		public static By ToggleButton_opn1_Commercial = By.xpath("(//*[@name='ptCategory'])[1]");
		public static By ToggleButton_opn2_Residential = By.xpath("(//*[@name='ptCategory'])[2]");
		public static By ToggleButton_opn3_Business = By.xpath("(//*[@name='ptCategory'])[3]");

		public static By g_payment_term_method = By.id("g_payment_term_method");

		public static By PaymentTermNumberofDays_Field = By.xpath("//*[@name='g_term_days']");
		public static By SaveChanges_Button = By.xpath("//*[@id='saveChangesBtn']");
		public static By Save_Button = By.xpath("//button[contains(text(),'Save')]");
		public static By EditGroupSuccessMsg = By.xpath("//div[@class='alert alert-success']");

		public static void M_EnableDueDate(String paymentMethod) throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			WebDriverWaits.ClickOn(Admin_Tab);
			WebDriverWaits.ClickOn(EditGroup_SubTab);
			// jse.executeScript("arguments[0].scrollIntoView(true);", MinimumDaystoBill);
			jse.executeScript("window.scrollBy(0,2400)", "");
			// jse.executeScript("window.scrollIntoView(MinimumDaystoBill)");
			if ( driver.findElement(By.id("payTermOption")).getAttribute("style").contains("none")){
				WebDriverWaits.ClickOn(DueDatebyPaymentTerms_ToggleButton);

			}
			WebDriverWaits.selectCheckBox(ToggleButton_opn1_Commercial);
			WebDriverWaits.selectCheckBox(ToggleButton_opn2_Residential);
			WebDriverWaits.selectCheckBox(ToggleButton_opn3_Business);
			jse.executeScript("window.scrollBy(0,100)", "");
			WebDriverWaits.selectByVisibleText(g_payment_term_method,paymentMethod);
			if(paymentMethod!="End of month"){
				WebElement Field = WebDriverWaits.WaitUntilVisibleWE(PaymentTermNumberofDays_Field);
				Field.clear();
				WebDriverWaits.SendKeys(PaymentTermNumberofDays_Field, "10");
			}

			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(SaveChanges_Button);
			WebDriverWaits.ClickOn(Save_Button);
			Thread.sleep(2000);
			// Assert Success! Changes have been updated successfully.
			String ActualMsg = WebDriverWaits.GetText(EditGroupSuccessMsg);
			String ExpectedMsg1 = "Success! Changes have been updated successfully.";
			softAssert.assertEquals(ExpectedMsg1, ActualMsg);
			System.out.println("Changes have been updated successfully as user is able to Enable due date by Payment terms.");
			Thread.sleep(2000);
		}
	}

	public static void FirstResidentialCustomer1st() throws InterruptedException {
		driver.navigate().refresh();
		Thread.sleep(3000);
		WebDriverWaits.ClickOn(FirstCustomer.CustomerIcontab);
		WebDriverWaits.ClickOn(FirstCustomer.CustomerTypedropdown);
		WebElement TenantOption = WebDriverWaits.WaitUntilVisibleWE(FirstCustomer.CustomerTypedropdown);
		Select select = new Select(TenantOption);
		select.selectByVisibleText("Tenant");
		WebDriverWaits.ClickOn(FirstCustomer.Categorydropdown);
		WebElement ResidentialOption = WebDriverWaits.WaitUntilVisibleWE(FirstCustomer.Categorydropdown);
		select = new Select(ResidentialOption);
		select.selectByVisibleText("Residential");
		WebDriverWaits.ClickOn(FirstCustomer.Address1field);
		WebDriverWaits.SendKeys(FirstCustomer.Address1field, "Madirma R-Town");
		WebDriverWaits.ClickOn(FirstCustomer.Cityfield);
		WebDriverWaits.SendKeys(FirstCustomer.Cityfield, "Mills NY");
		WebDriverWaits.ClickOn(FirstCustomer.Statedropdown);
		WebElement WAOption = WebDriverWaits.WaitUntilVisibleWE(FirstCustomer.Statedropdown);
		select = new Select(WAOption);
		select.selectByVisibleText("WA");
		WebDriverWaits.ClickOn(FirstCustomer.PostalCodefield);
		WebDriverWaits.SendKeys(FirstCustomer.PostalCodefield, "1265");
		jse.executeScript("window.scrollBy(0,500)", "");
		WebDriverWaits.ClickOn(FirstCustomer.TitleDropdown);
		WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(FirstCustomer.TitleDropdown);
		select = new Select(DrOption);
		select.selectByVisibleText("Dr.");
		WebDriverWaits.ClickOn(FirstCustomer.GivenNameField);
		Flow5_AddCustomer.RandomName1 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(FirstCustomer.GivenNameField, Flow5_AddCustomer.RandomName1);
		WebDriverWaits.ClickOn(FirstCustomer.SurnameField);
		Flow5_AddCustomer.RandomName2 = RandomStrings.RequiredCharacters(6);
		Thread.sleep(2000);
		WebDriverWaits.SendKeys(FirstCustomer.SurnameField, Flow5_AddCustomer.RandomName2);
		WebDriverWaits.ClickOn(FirstCustomer.PhoneBHField);
		String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
		WebDriverWaits.SendKeys(FirstCustomer.PhoneBHField, RandomNumber);
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(1000);
		WebDriverWaits.ClickOn(FirstCustomer.EmailField);
		WebDriverWaits.SendKeys(FirstCustomer.EmailField, "test_Resdnt2@yopmail.com");
		jse.executeScript("window.scrollBy(0,400)", "");
		Thread.sleep(1000);
		WebDriverWaits.ClickOn(FirstCustomer.AccountManagementSection);
		Thread.sleep(1000);
		jse.executeScript("window.scrollBy(0,300)", "");
		WebDriverWaits.ClickOn(FirstCustomer.ContractStartDate_Datepicker);
		WebDriverWaits.ClickOn(FirstCustomer.CurrentDate);
		WebDriverWaits.ClickOn(FirstCustomer.ContractTerm_Field);
		WebDriverWaits.SendKeys(FirstCustomer.ContractTerm_Field, "10");
	}
//			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_Dropdown);
//			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_DropdownOpn);

	public static void FirstResidentialCustomer2nd() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		WebDriverWaits.ClickOn(FirstCustomer.SaveCustomerButton);
		WebDriverWaits.ClickOn(FirstCustomer.SaveOnlyButton);
		Thread.sleep(2000);
		String ActualMsg = WebDriverWaits.GetText(FirstCustomer.CustomerSuccessMsg);
		String ExpectedMsg1 = "Successfully saved customer.";
		softAssert.assertEquals(ExpectedMsg1, ActualMsg);
		System.out.println("Successfully saved customer");
		Thread.sleep(4000);
		Flow5_AddCustomer.CustomerID01R = WebDriverWaits.GetText(X_AddService.selectBusinessCustomer_Record1);
	}

	public static void SecondBusinessCustomer1st() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		WebDriverWaits.ClickOn(SecondCustomer.CustomerIcontab);
		WebDriverWaits.ClickOn(SecondCustomer.CustomerTypedropdown);
		WebElement OtherOption = WebDriverWaits.WaitUntilVisibleWE(SecondCustomer.CustomerTypedropdown);
		Select select = new Select(OtherOption);
		select.selectByVisibleText("Others");
//				softAssert.assertTrue(TenantText.equals("Tenant"));
		softAssert.assertAll();
		WebDriverWaits.ClickOn(SecondCustomer.Categorydropdown);
		WebElement BusinessOption = WebDriverWaits.WaitUntilVisibleWE(SecondCustomer.Categorydropdown);
		select = new Select(BusinessOption);
		select.selectByVisibleText("Business");
		WebDriverWaits.ClickOn(SecondCustomer.Address1field);
		WebDriverWaits.SendKeys(SecondCustomer.Address1field, "Madirma B-Town");
		WebDriverWaits.ClickOn(SecondCustomer.Cityfield);
		WebDriverWaits.SendKeys(SecondCustomer.Cityfield, "Saint Augustine");
		WebDriverWaits.ClickOn(SecondCustomer.Statedropdown);
		WebElement TASOption = WebDriverWaits.WaitUntilVisibleWE(SecondCustomer.Statedropdown);
		select = new Select(TASOption);
		select.selectByVisibleText("TAS");
		WebDriverWaits.ClickOn(SecondCustomer.PostalCodefield);
		WebDriverWaits.SendKeys(SecondCustomer.PostalCodefield, "6541");
		jse.executeScript("window.scrollBy(0,400)", "");
		WebDriverWaits.ClickOn(FirstCustomer.CompanyNameField);
		WebDriverWaits.SendKeys(FirstCustomer.CompanyNameField, "FranklinCovey");

		WebDriverWaits.ClickOn(SecondCustomer.ABNField);
		WebDriverWaits.SendKeys(SecondCustomer.ABNField, "32165485216");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,650)", "");

		WebDriverWaits.ClickOn(SecondCustomer.TitleDropdown);
		WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(SecondCustomer.TitleDropdown);
		select = new Select(DrOption);
		select.selectByVisibleText("Dr.");

		WebDriverWaits.ClickOn(SecondCustomer.GivenNameField);
		Flow5_AddCustomer.RandomName3 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(SecondCustomer.GivenNameField, Flow5_AddCustomer.RandomName3);
		// WebDriverWaits.SendKeys(GivenNameField, "Moien");

		WebDriverWaits.ClickOn(SecondCustomer.SurnameField);
		Flow5_AddCustomer.RandomName4 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(SecondCustomer.SurnameField, Flow5_AddCustomer.RandomName4);
		// WebDriverWaits.SendKeys(SurnameField, "Alli");

		WebDriverWaits.ClickOn(SecondCustomer.PhoneBHField);
		String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
		WebDriverWaits.SendKeys(SecondCustomer.PhoneBHField, RandomNumber);

		jse.executeScript("window.scrollBy(0,300)", "");

		WebDriverWaits.ClickOn(SecondCustomer.EmailField);
		WebDriverWaits.SendKeys(SecondCustomer.EmailField, "testBusiness@yopmail.com");

		jse.executeScript("window.scrollBy(0,400)", "");

		WebDriverWaits.ClickOn(SecondCustomer.AccountManagementSection);

		jse.executeScript("window.scrollBy(0,300)", "");

		WebDriverWaits.ClickOn(SecondCustomer.ContractStartDate_Datepicker);
		WebDriverWaits.ClickOn(SecondCustomer.CurrentDate);

		WebDriverWaits.ClickOn(SecondCustomer.ContractTerm_Field);
		WebDriverWaits.SendKeys(SecondCustomer.ContractTerm_Field, "10");

	}

//			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_Dropdown);
//			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_DropdownOpn);
	public static void SecondBusinessCustomer2nd() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebDriverWaits.ClickOn(SecondCustomer.SaveCustomerButton);
		WebDriverWaits.ClickOn(SecondCustomer.SaveOnlyButton);

		String ExpectedMsg2 = "Successfully saved customer";
		softAssert.assertEquals(ExpectedMsg2, "Successfully saved customer");
		System.out.println("Successfully saved customer");

		Thread.sleep(4000);

		Flow5_AddCustomer.CustomerID02B = WebDriverWaits.GetText(X_AddService.selectBusinessCustomer_Record1);
		Thread.sleep(2000);

	}

	public static void ThirdCommercialCustomer1st() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

		WebDriverWaits.ClickOn(ThirdCustomer.CustomerIcontab);

		WebDriverWaits.ClickOn(ThirdCustomer.CustomerTypedropdown);
		WebElement OtherOption = WebDriverWaits.WaitUntilVisibleWE(ThirdCustomer.CustomerTypedropdown);
		Select select = new Select(OtherOption);
		select.selectByVisibleText("Others");

		softAssert.assertAll();

		WebDriverWaits.ClickOn(ThirdCustomer.Categorydropdown);
		WebElement CommercialOption = WebDriverWaits.WaitUntilVisibleWE(ThirdCustomer.Categorydropdown);
		select = new Select(CommercialOption);
		select.selectByVisibleText("Commercial");

		WebDriverWaits.ClickOn(ThirdCustomer.Address1field);
		WebDriverWaits.SendKeys(ThirdCustomer.Address1field, "Madirma B-Town");

		WebDriverWaits.ClickOn(ThirdCustomer.Cityfield);
		WebDriverWaits.SendKeys(ThirdCustomer.Cityfield, "Saint Augustine");

		WebDriverWaits.ClickOn(ThirdCustomer.Statedropdown);
		WebElement TASOption = WebDriverWaits.WaitUntilVisibleWE(ThirdCustomer.Statedropdown);
		select = new Select(TASOption);
		select.selectByVisibleText("QLD");

		WebDriverWaits.ClickOn(ThirdCustomer.PostalCodefield);
		WebDriverWaits.SendKeys(ThirdCustomer.PostalCodefield, "3546");

		jse.executeScript("window.scrollBy(0,400)", "");

		WebDriverWaits.ClickOn(FirstCustomer.CompanyNameField);
		WebDriverWaits.SendKeys(FirstCustomer.CompanyNameField, "Testing Company SQE");

		WebDriverWaits.ClickOn(ThirdCustomer.ABNField);
		WebDriverWaits.SendKeys(ThirdCustomer.ABNField, "95623111254");
		Thread.sleep(2000);
		jse.executeScript("window.scrollBy(0,650)", "");

		WebDriverWaits.ClickOn(ThirdCustomer.TitleDropdown);
		WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(ThirdCustomer.TitleDropdown);
		select = new Select(DrOption);
		select.selectByVisibleText("Dr.");

		WebDriverWaits.ClickOn(ThirdCustomer.GivenNameField);
		Flow5_AddCustomer.RandomName5 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(ThirdCustomer.GivenNameField, Flow5_AddCustomer.RandomName5);
		// WebDriverWaits.SendKeys(GivenNameField, "Siyon");

		WebDriverWaits.ClickOn(ThirdCustomer.SurnameField);
		Flow5_AddCustomer.RandomName6 = RandomStrings.RequiredCharacters(6);
		WebDriverWaits.SendKeys(ThirdCustomer.SurnameField, Flow5_AddCustomer.RandomName6);
		// WebDriverWaits.SendKeys(SurnameField, "mandis");

		WebDriverWaits.ClickOn(ThirdCustomer.PhoneBHField);
		String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
		WebDriverWaits.SendKeys(ThirdCustomer.PhoneBHField, RandomNumber);

		jse.executeScript("window.scrollBy(0,300)", "");

		WebDriverWaits.ClickOn(ThirdCustomer.EmailField);
		WebDriverWaits.SendKeys(ThirdCustomer.EmailField, "testcommercial@yopmail.com");

		jse.executeScript("window.scrollBy(0,400)", "");

		// WebDriverWaits.ClickOn(AccountManagementSection);

		jse.executeScript("window.scrollBy(0,400)", "");

		Thread.sleep(1000);

		WebDriverWaits.ClickOn(ThirdCustomer.ContractStartDate_Datepicker);
		WebDriverWaits.ClickOn(ThirdCustomer.CurrentDate);

		WebDriverWaits.ClickOn(ThirdCustomer.ContractTerm_Field);
		WebDriverWaits.SendKeys(ThirdCustomer.ContractTerm_Field, "10");
	}

	public static void ThirdCommercialCustomer2nd() throws InterruptedException {
		SoftAssert softAssert = new SoftAssert();

	//	WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_Dropdown);
	//	WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_DropdownOpn);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		WebDriverWaits.ClickOn(ThirdCustomer.SaveCustomerButton);
		WebDriverWaits.ClickOn(ThirdCustomer.SaveOnlyButton);

		String ExpectedMsg5 = "Successfully saved customer";
		softAssert.assertEquals(ExpectedMsg5, "Successfully saved customer");
		System.out.println("Successfully saved customer");
		Thread.sleep(4000);

		Flow5_AddCustomer.CustomerID03C = WebDriverWaits.GetText(X_AddService.selectBusinessCustomer_Record1);
		Thread.sleep(2000);

	}
	
	public static class EnableDueDate{
		
		public static int FirstOption(){
			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_Dropdown);
			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_DropdownOpnE1);	
			return 0;	
			}
		
		public static int SecondOption(){
			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_Dropdown);
			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_DropdownOpnC2);
			return 0;	
			}
		
		public static int ThirdOption(){
			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_Dropdown);
			WebDriverWaits.ClickOn(FirstCustomer.PaymentTermMethod_DropdownOpn_B3);	
			return 0;	
			}

		public static void Enable_Due_Date() throws InterruptedException {
			Thread.sleep(2000);
					
			FirstResidentialCustomer1st();
			FirstOption();
			FirstResidentialCustomer2nd();
			SecondBusinessCustomer1st();
			FirstOption();
			SecondBusinessCustomer2nd();
			ThirdCommercialCustomer1st();
			FirstOption();
			ThirdCommercialCustomer2nd();
			
			FirstResidentialCustomer1st();
			SecondOption();
			FirstResidentialCustomer2nd();
			SecondBusinessCustomer1st();
			SecondOption();
			SecondBusinessCustomer2nd();
			ThirdCommercialCustomer1st();
			SecondOption();
			ThirdCommercialCustomer2nd();

			FirstResidentialCustomer1st();
			ThirdOption();
			FirstResidentialCustomer2nd();
			SecondBusinessCustomer1st();
			ThirdOption();
			SecondBusinessCustomer2nd();
			ThirdCommercialCustomer1st();
			ThirdOption();
			ThirdCommercialCustomer2nd();
			
		
			}

	}
}

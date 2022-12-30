package POM;
//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import BrowsersBase.DataInterface;
import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;

import POM.Flow6_7AddingServiceAndMeter.X_AddService;
import TestCases.TestLogin;
//import junit.framework.Assert;

public class Flow5_AddCustomer extends TestLogin {
    public static String RandomName1;
    public static String RandomName2;
    public static String RandomName3;
    public static String RandomName4;
    public static String RandomName5;
    public static String RandomName6;
    public static String CustomerID01R;
    public static String CustomerID02B;
    public static String CustomerID03C;


    public static JavascriptExecutor jse = (JavascriptExecutor) driver;

    public static class FirstCustomer {

        // First Residential Customer
        public static By CustomerIcontab = By.xpath("//span[text()='Customers']");
        public static By CustomerTypedropdown = By.xpath("//select[@id='custTypeEl']");
        public static By Categorydropdown = By.xpath("//*[@id='category']");
        public static By Address1field = By.xpath("//*[@id='hAddress']");
        public static By Cityfield = By.xpath("//*[@id='hSuburb']");
        public static By Statedropdown = By.xpath("//*[@id='hState']");
        public static By PostalCodefield = By.xpath("//*[@name='pcode']");

        // Company/Business Details
        public static By CompanyNameField = By.xpath("//*[@id=\"company\"]");
        public static By ABNField = By.xpath("//*[@id=\"abn\"]");
        // Contact Details
        public static By TitleDropdown = By.xpath("//*[@name='sal']");
        public static By GivenNameField = By.xpath("//*[@name='firstName']");
        public static By SurnameField = By.xpath("//*[@name='surname']");
        public static By PhoneBHField = By.xpath("//*[@name='contact_phone']");
        public static By EmailField = By.xpath("//*[@name='contact_email']");
        public static By AccountManagementSection = By.xpath("//*[@id='accountManagementPlus']");
        public static By ContractStartDate_Datepicker = By.xpath("//*[@id='contract_start_date']");
        public static By PaymentTermMethod_Dropdown = By.xpath("//*[@id='payment_term']");
        public static By PaymentTermMethod_DropdownOpnC2 = By.xpath("//*[@id='payment_term']/option[2]");
        public static By PaymentTermMethod_DropdownOpn_B3 = By.xpath("//*[@id='payment_term']/option[3]");
        public static By PaymentTermMethod_DropdownOpnE1 = By.xpath("//*[@id='payment_term']/option[1]");
        public static By CurrentDate = By.xpath("//*[@class=\"active day\"]");
        public static By ContractTerm_Field = By.xpath("//*[@id='contract_term']");
        // Scroll to last of the page
        public static By SaveCustomerButton = By.xpath("//*[@value='Save Customer']");
        // public static By SaveandAddProvisioning= By.xpath("//*[contains(text(),'Save
        // and Add Provisioning')])[2]");

        public static By SaveOnlyButton = By.xpath("//button[contains(text(),'Save Only')]");
        public static By CustomerSuccessMsg = By.xpath("//div[@class='alert alert-success']/center");

        // Scroll the page to last again
        // Change Status button appears
        public static By ChangeStatusButton = By.xpath("//*[@class=\"btn btn-danger\"]");
        public static By NewStatusDropdown = By.xpath("//select[@id='acctStatus']");
        public static By ReasonforchangeField = By.xpath("//*[@id='statusReason']");
        public static By Save_button_on_popup = By.xpath("//*[@id='save']");
        public static By Closepopup_icon = By.xpath("//*[@class='close']");


        // Methods
        public static void FirstResidentialCustomer() throws InterruptedException {
            SoftAssert softAssert = new SoftAssert();
            driver.navigate().refresh();
            Thread.sleep(3000);
            WebDriverWaits.ClickOn(CustomerIcontab);
            WebDriverWaits.ClickOn(CustomerTypedropdown);
            WebElement TenantOption = WebDriverWaits.WaitUntilVisibleWE(CustomerTypedropdown);
//					driver.findElement(CustomerTypedropdown);
            Select select = new Select(TenantOption);
            select.selectByVisibleText("Tenant");
            WebDriverWaits.ClickOn(Categorydropdown);
            WebElement ResidentialOption = WebDriverWaits.WaitUntilVisibleWE(Categorydropdown);
            select = new Select(ResidentialOption);
            select.selectByVisibleText("Residential");
            WebDriverWaits.ClickOn(Address1field);
            WebDriverWaits.SendKeys(Address1field, "Madirma R-Town");
            WebDriverWaits.ClickOn(Cityfield);
            WebDriverWaits.SendKeys(Cityfield, "Mills NY");
            WebDriverWaits.ClickOn(Statedropdown);
            WebElement WAOption = WebDriverWaits.WaitUntilVisibleWE(Statedropdown);
            select = new Select(WAOption);
            select.selectByVisibleText("WA");
            WebDriverWaits.ClickOn(PostalCodefield);
            WebDriverWaits.SendKeys(PostalCodefield, "1265");
            jse.executeScript("window.scrollBy(0,500)", "");
            WebDriverWaits.ClickOn(TitleDropdown);
            WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(TitleDropdown);
            select = new Select(DrOption);
            select.selectByVisibleText("Dr.");

            WebDriverWaits.ClickOn(GivenNameField);
            RandomName1 = RandomStrings.RequiredCharacters(6);
            WebDriverWaits.SendKeys(GivenNameField, RandomName1);
            //WebDriverWaits.SendKeys(GivenNameField, "Babar");

            WebDriverWaits.ClickOn(SurnameField);
            RandomName2 = RandomStrings.RequiredCharacters(6);
            Thread.sleep(2000);
            WebDriverWaits.SendKeys(SurnameField, RandomName2);
            //WebDriverWaits.SendKeys(SurnameField, "Asam");

            WebDriverWaits.ClickOn(PhoneBHField);
            String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
            WebDriverWaits.SendKeys(PhoneBHField, RandomNumber);

            Thread.sleep(2000);

            jse.executeScript("window.scrollBy(0,200)", "");

            Thread.sleep(1000);

            WebDriverWaits.ClickOn(EmailField);
            WebDriverWaits.SendKeys(EmailField, "test_Resdnt2@yopmail.com");

            jse.executeScript("window.scrollBy(0,400)", "");

            Thread.sleep(1000);

            WebDriverWaits.ClickOn(AccountManagementSection);

            Thread.sleep(1000);

            jse.executeScript("window.scrollBy(0,300)", "");

            WebDriverWaits.ClickOn(ContractStartDate_Datepicker);
            WebDriverWaits.ClickOn(CurrentDate);

            WebDriverWaits.ClickOn(ContractTerm_Field);
            WebDriverWaits.SendKeys(ContractTerm_Field, "10");


            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(SaveCustomerButton);
            WebDriverWaits.ClickOn(SaveOnlyButton);
            Thread.sleep(2000);
            String ActualMsg = WebDriverWaits.GetText(CustomerSuccessMsg);
            String ExpectedMsg1 = "Successfully saved customer.";
            softAssert.assertEquals(ExpectedMsg1, ActualMsg);
            System.out.println("Successfully saved customer");

            Thread.sleep(4000);

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(ChangeStatusButton);
            WebDriverWaits.ClickOn(NewStatusDropdown);
            WebElement ActiveOption = WebDriverWaits.WaitUntilVisibleWE(NewStatusDropdown);
            select = new Select(ActiveOption);
            select.selectByVisibleText("Active");

            WebDriverWaits.ClickOn(ReasonforchangeField);
            WebDriverWaits.SendKeys(ReasonforchangeField, "Only For testing Residential Type of Category");

            WebDriverWaits.ClickOn(Save_button_on_popup);

            String ExpectedMsg2 = "Status change successful.";
            softAssert.assertEquals(ExpectedMsg2, "Status change successful.");
            System.out.println("Status change successful.");

            Thread.sleep(4000);

            WebDriverWaits.ClickOn(Closepopup_icon);
            driver.navigate().to(DataInterface.AdminURL);
            Thread.sleep(8000);
            WebDriverWaits.ClickOn(X_AddService.SearchIcon);
            Thread.sleep(4000);
            CustomerID01R = WebDriverWaits.GetText(X_AddService.selectBusinessCustomer_Record1);

        }

    }

    // Second Business customer
    public static class SecondCustomer {

        public static By CustomerIcontab = By.xpath("//span[text()='Customers']");

        public static By CustomerTypedropdown = By.xpath("//select[@id='custTypeEl']");
        public static By Categorydropdown = By.xpath("//*[@id='category']");
        public static By Address1field = By.xpath("//*[@id='hAddress']");
        public static By Cityfield = By.xpath("//*[@id='hSuburb']");
        public static By Statedropdown = By.xpath("//*[@id='hState']");
        public static By PostalCodefield = By.xpath("//*[@name='pcode']");

        // Scroll little jse.executeScript("window.scrollBy(0,2500)", "");
        // Company/Business Details

        public static By Company_Name_Field = By.xpath("//*[@id=\"company\"]");
        public static By ABNField = By.xpath("//*[@id=\"abn\"]");

        // Scroll little
        // Contact Details

        public static By TitleDropdown = By.xpath("//*[@name='sal']");
        public static By GivenNameField = By.xpath("//*[@name='firstName']");
        public static By SurnameField = By.xpath("//*[@name='surname']");
        public static By PhoneBHField = By.xpath("//*[@name='contact_phone']");
        public static By EmailField = By.xpath("//*[@name='contact_email']");

        // Account Management section
        public static By AccountManagementSection = By.xpath("//*[@id='accountManagementPlus']");
        public static By ContractStartDate_Datepicker = By.xpath("//*[@id='contract_start_date']");
        public static By CurrentDate = By.xpath("//*[@class=\"active day\"]");
        public static By ContractTerm_Field = By.xpath("//*[@id='contract_term']");

        // Scroll to last of the page

        public static By SaveCustomerButton = By.xpath("//*[@value='Save Customer']");
        // public static By SaveandAddProvisioning= By.xpath("//*[contains(text(),'Save
        // and Add Provisioning')])[2]");

        public static By SaveOnlyButton = By.xpath("//button[contains(text(),'Save Only')]");

        // Scroll the page to last again
        // Change Status button appears
        public static By ChangeStatusButton = By.xpath("//*[@class=\"btn btn-danger\"]");
        public static By NewStatusDropdown = By.xpath("//select[@id='acctStatus']");
        public static By ReasonforchangeField = By.xpath("//*[@id='statusReason']");
        public static By Save_button_on_popup = By.xpath("//*[@id='save']");
        public static By Closepopup_icon = By.xpath("//*[@class='close']");

        // Second Customer Methods

        public static void SecondBusinessCustomer() throws InterruptedException {
            SoftAssert softAssert = new SoftAssert();

            WebDriverWaits.ClickOn(CustomerIcontab);

            WebDriverWaits.ClickOn(CustomerTypedropdown);
            WebElement OtherOption = WebDriverWaits.WaitUntilVisibleWE(CustomerTypedropdown);
            Select select = new Select(OtherOption);
            select.selectByVisibleText("Others");

//				softAssert.assertTrue(TenantText.equals("Tenant"));
            softAssert.assertAll();

            WebDriverWaits.ClickOn(Categorydropdown);
            WebElement BusinessOption = WebDriverWaits.WaitUntilVisibleWE(Categorydropdown);
            select = new Select(BusinessOption);
            select.selectByVisibleText("Business");

            WebDriverWaits.ClickOn(Address1field);
            WebDriverWaits.SendKeys(Address1field, "Madirma B-Town");

            WebDriverWaits.ClickOn(Cityfield);
            WebDriverWaits.SendKeys(Cityfield, "Saint Augustine");

            WebDriverWaits.ClickOn(Statedropdown);
            WebElement TASOption = WebDriverWaits.WaitUntilVisibleWE(Statedropdown);
            select = new Select(TASOption);
            select.selectByVisibleText("TAS");

            WebDriverWaits.ClickOn(PostalCodefield);
            WebDriverWaits.SendKeys(PostalCodefield, "6541");

            jse.executeScript("window.scrollBy(0,400)", "");

            WebDriverWaits.ClickOn(FirstCustomer.CompanyNameField);
            WebDriverWaits.SendKeys(FirstCustomer.CompanyNameField, "FranklinCovey");

            WebDriverWaits.ClickOn(ABNField);
            WebDriverWaits.SendKeys(ABNField, "32165485216");
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,650)", "");

            WebDriverWaits.ClickOn(TitleDropdown);
            WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(TitleDropdown);
            select = new Select(DrOption);
            select.selectByVisibleText("Dr.");

            WebDriverWaits.ClickOn(GivenNameField);
            RandomName3 = RandomStrings.RequiredCharacters(6);
            WebDriverWaits.SendKeys(GivenNameField, RandomName3);
            //WebDriverWaits.SendKeys(GivenNameField, "Moien");

            WebDriverWaits.ClickOn(SurnameField);
            RandomName4 = RandomStrings.RequiredCharacters(6);
            WebDriverWaits.SendKeys(SurnameField, RandomName4);
            //WebDriverWaits.SendKeys(SurnameField, "Alli");

            WebDriverWaits.ClickOn(PhoneBHField);
            String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
            WebDriverWaits.SendKeys(PhoneBHField, RandomNumber);

            jse.executeScript("window.scrollBy(0,300)", "");

            WebDriverWaits.ClickOn(EmailField);
            WebDriverWaits.SendKeys(EmailField, "testBusiness@yopmail.com");

            jse.executeScript("window.scrollBy(0,400)", "");

            WebDriverWaits.ClickOn(AccountManagementSection);

            jse.executeScript("window.scrollBy(0,300)", "");

            WebDriverWaits.ClickOn(ContractStartDate_Datepicker);
            WebDriverWaits.ClickOn(CurrentDate);

            WebDriverWaits.ClickOn(ContractTerm_Field);
            WebDriverWaits.SendKeys(ContractTerm_Field, "10");

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(SaveCustomerButton);
            WebDriverWaits.ClickOn(SaveOnlyButton);

            String ExpectedMsg2 = "Successfully saved customer";
            softAssert.assertEquals(ExpectedMsg2, "Successfully saved customer");
            System.out.println("Successfully saved customer");

            Thread.sleep(4000);

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(ChangeStatusButton);

            // popup assertion

            WebDriverWaits.ClickOn(NewStatusDropdown);
            WebElement ActiveOption = WebDriverWaits.WaitUntilVisibleWE(NewStatusDropdown);
            select = new Select(ActiveOption);
            select.selectByVisibleText("Active");

            WebDriverWaits.ClickOn(ReasonforchangeField);
            WebDriverWaits.SendKeys(ReasonforchangeField, "Only For testing Residential Type of Category");

            WebDriverWaits.ClickOn(Save_button_on_popup);

            String ExpectedMsg4 = "Status change successful.";
            softAssert.assertEquals(ExpectedMsg4, "SStatus change successful.");
            System.out.println("Status change successful.");

            Thread.sleep(4000);

            WebDriverWaits.ClickOn(Closepopup_icon);
            driver.navigate().to(DataInterface.AdminURL);
            Thread.sleep(8000);
            WebDriverWaits.ClickOn(X_AddService.SearchIcon);
            Thread.sleep(3000);
            CustomerID02B = WebDriverWaits.GetText(X_AddService.selectBusinessCustomer_Record1);

        }
    }

    // Third Commercial customer
    public static class ThirdCustomer {

        public static By CustomerIcontab = By.xpath("//span[text()='Customers']");

        public static By CustomerTypedropdown = By.xpath("//select[@id='custTypeEl']");
        public static By Categorydropdown = By.xpath("//*[@id='category']");
        public static By Address1field = By.xpath("//*[@id='hAddress']");
        public static By Cityfield = By.xpath("//*[@id='hSuburb']");
        public static By Statedropdown = By.xpath("//*[@id='hState']");
        public static By PostalCodefield = By.xpath("//*[@name='pcode']");

        // Company/Business Details

        public static By Company_Name_Field = By.xpath("//*[@id=\"company\"]");
        public static By ABNField = By.xpath("//*[@id=\"abn\"]");

        // Contact Details

        public static By TitleDropdown = By.xpath("//*[@name='sal']");
        public static By GivenNameField = By.xpath("//*[@name='firstName']");
        public static By SurnameField = By.xpath("//*[@name='surname']");
        public static By PhoneBHField = By.xpath("//*[@name='contact_phone']");
        public static By EmailField = By.xpath("//*[@name='contact_email']");

        // Account Management section
        public static By AccountManagementSection = By.xpath("//*[@id='accountManagementPlus']");
        public static By ContractStartDate_Datepicker = By.xpath("//*[@id='contract_start_date']");
        public static By CurrentDate = By.xpath("//*[@class=\"active day\"]");
        public static By ContractTerm_Field = By.xpath("//*[@id='contract_term']");

        public static By SaveCustomerButton = By.xpath("//*[@value='Save Customer']");

        public static By SaveOnlyButton = By.xpath("//button[contains(text(),'Save Only')]");

        // Change Status button appears
        public static By ChangeStatusButton = By.xpath("//*[@class=\"btn btn-danger\"]");
        public static By NewStatusDropdown = By.xpath("//select[@id='acctStatus']");
        public static By ReasonforchangeField = By.xpath("//*[@id='statusReason']");
        public static By Save_button_on_popup = By.xpath("//*[@id='save']");
        public static By Closepopup_icon = By.xpath("//*[@class='close']");

        // Methods
        public static void ThirdCommercialCustomer() throws InterruptedException {
            SoftAssert softAssert = new SoftAssert();

            WebDriverWaits.ClickOn(CustomerIcontab);

            WebDriverWaits.ClickOn(CustomerTypedropdown);
            WebElement OtherOption = WebDriverWaits.WaitUntilVisibleWE(CustomerTypedropdown);
            Select select = new Select(OtherOption);
            select.selectByVisibleText("Others");

//						softAssert.assertTrue(TenantText.equals("Tenant"));
            softAssert.assertAll();

            WebDriverWaits.ClickOn(Categorydropdown);
            WebElement CommercialOption = WebDriverWaits.WaitUntilVisibleWE(Categorydropdown);
            select = new Select(CommercialOption);
            select.selectByVisibleText("Commercial");

            WebDriverWaits.ClickOn(Address1field);
            WebDriverWaits.SendKeys(Address1field, "Madirma B-Town");

            WebDriverWaits.ClickOn(Cityfield);
            WebDriverWaits.SendKeys(Cityfield, "Saint Augustine");

            WebDriverWaits.ClickOn(Statedropdown);
            WebElement TASOption = WebDriverWaits.WaitUntilVisibleWE(Statedropdown);
            select = new Select(TASOption);
            select.selectByVisibleText("QLD");

            WebDriverWaits.ClickOn(PostalCodefield);
            WebDriverWaits.SendKeys(PostalCodefield, "3546");

            jse.executeScript("window.scrollBy(0,400)", "");

            WebDriverWaits.ClickOn(FirstCustomer.CompanyNameField);
            WebDriverWaits.SendKeys(FirstCustomer.CompanyNameField, "Testing Company SQE");

            WebDriverWaits.ClickOn(ABNField);
            WebDriverWaits.SendKeys(ABNField, "95623111254");
            Thread.sleep(2000);
            jse.executeScript("window.scrollBy(0,650)", "");

            WebDriverWaits.ClickOn(TitleDropdown);
            WebElement DrOption = WebDriverWaits.WaitUntilVisibleWE(TitleDropdown);
            select = new Select(DrOption);
            select.selectByVisibleText("Dr.");

            WebDriverWaits.ClickOn(GivenNameField);
            RandomName5 = RandomStrings.RequiredCharacters(6);
            WebDriverWaits.SendKeys(GivenNameField, RandomName5);
            //	WebDriverWaits.SendKeys(GivenNameField, "Siyon");

            WebDriverWaits.ClickOn(SurnameField);
            RandomName6 = RandomStrings.RequiredCharacters(6);
            WebDriverWaits.SendKeys(SurnameField, RandomName6);
            //WebDriverWaits.SendKeys(SurnameField, "mandis");

            WebDriverWaits.ClickOn(PhoneBHField);
            String RandomNumber = "4" + RandomStrings.RequiredDigits(8);
            WebDriverWaits.SendKeys(PhoneBHField, RandomNumber);

            jse.executeScript("window.scrollBy(0,300)", "");

            WebDriverWaits.ClickOn(EmailField);
            WebDriverWaits.SendKeys(EmailField, "testcommercial@yopmail.com");

            jse.executeScript("window.scrollBy(0,400)", "");

            // WebDriverWaits.ClickOn(AccountManagementSection);

            jse.executeScript("window.scrollBy(0,400)", "");

            Thread.sleep(1000);

            WebDriverWaits.ClickOn(ContractStartDate_Datepicker);
            WebDriverWaits.ClickOn(CurrentDate);

            WebDriverWaits.ClickOn(ContractTerm_Field);
            WebDriverWaits.SendKeys(ContractTerm_Field, "10");

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(SaveCustomerButton);
            WebDriverWaits.ClickOn(SaveOnlyButton);

            String ExpectedMsg5 = "Successfully saved customer";
            softAssert.assertEquals(ExpectedMsg5, "Successfully saved customer");
            System.out.println("Successfully saved customer");
            Thread.sleep(4000);

            jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            WebDriverWaits.ClickOn(ChangeStatusButton);


            WebDriverWaits.ClickOn(NewStatusDropdown);
            WebElement ActiveOption = WebDriverWaits.WaitUntilVisibleWE(NewStatusDropdown);
            select = new Select(ActiveOption);
            select.selectByVisibleText("Active");

            WebDriverWaits.ClickOn(ReasonforchangeField);
            WebDriverWaits.SendKeys(ReasonforchangeField, "Only For testing Residential Type of Category");

            WebDriverWaits.ClickOn(Save_button_on_popup);

            String ExpectedMsg6 = "Status change successful.";
            softAssert.assertEquals(ExpectedMsg6, "SStatus change successful.");
            System.out.println("Status change successful.");

            Thread.sleep(4000);

            WebDriverWaits.ClickOn(Closepopup_icon);

            driver.navigate().to(DataInterface.AdminURL);
            Thread.sleep(8000);
            WebDriverWaits.ClickOn(X_AddService.SearchIcon);
            Thread.sleep(3000);
            CustomerID03C = WebDriverWaits.GetText(X_AddService.selectBusinessCustomer_Record1);

        }
    }
}

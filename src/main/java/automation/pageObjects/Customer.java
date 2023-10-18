package automation.pageObjects;

import automation.utilities.ActionEngine;
import automation.utilities.Assertions;
import automation.utilities.RandomGenerator;
import automation.utilities.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Customer extends ActionEngine {
    public By customerTab = By.xpath("//a[@title='Customer']");
    public By detailsTab = By.xpath("//a[contains(text(),'Details')]");
    public By nmiTab = By.xpath("//a[contains(text(),'NMI')]");
    public By market = By.xpath("(//a[contains(text(),' Market')])[1]");
    public By service = By.xpath("//a[contains(text(),'Services')]");

    public By SearchField = By.xpath("//*[@id=\"search_input\"]");
    public By SearchIcon = By.xpath("//*[@class=\"glyphicon glyphicon-search\"]");
    public By categoryDropdownField = By.xpath("//select[@name='category']");
    public By firstNameField = By.xpath("//input[@name='firstName']");
    public By lastNameField = By.xpath("//input[@name='surname']");
    public By phoneNumberField = By.xpath("//input[@name='contact_mobile']");
    public By emailField = By.xpath("//input[@name='contact_email']");
    public By billingEmailField = By.xpath("//input[@name='billingEmail']");
    public By addressOneField = By.xpath("//input[@name='hAddress']");
    public By addressTwoField = By.xpath("//input[@name='hAddress2']");
    public By cityField = By.xpath("//input[@name='hSuburb']");
    public By stateField = By.xpath("//input[@name='hState']");
    public By zipCodeField = By.xpath("//input[@name='pcode']");
    public By countryField = By.xpath("//input[@name='hCountry']");
    public By planDropdownField = By.xpath("//select[@name='planNo']");
    public By physicalAddressTogglebutton = By.xpath("(//span[@class='switch-handle'])[1]");
    public By saveCustomerbutton = By.xpath("//div[@class='col-lg-12 text-left']/a/i");
    public By okbutton = By.xpath("//button[contains(text(),'OK')]");
    public By companyNameField = By.xpath("(//input[@name='company'])[1]");
    public By successMessageForCustomerCreation = By.xpath("//div[@id='notification']//center");
    public By customerID = By.xpath("(//label[@class='col-sm-12 control-label'])[1]");
    public By groupTag = By.xpath("(//label[@class=\"col-sm-12 control-label\"]/b)[1]");
    public By error = By.xpath("//p[@class='error']");
    public String RandomName1;
    public String RandomName2;
    public Select select;
    public By CustomerIcontab = By.xpath("//span[text()='Customers']");
    public By detailsIcon = By.className("icon-reorder");
    public By CustomerTypedropdown = By.xpath("//select[@id='custTypeEl']");
    public By Categorydropdown = By.xpath("//*[@id='category']");
    public By Address1field = By.xpath("//*[@id='hAddress']");
    public By Cityfield = By.xpath("//*[@id='hSuburb']");
    public By Statedropdown = By.xpath("//*[@id='hState']");
    public By PostalCodefield = By.xpath("//*[@name='pcode']");
    // Company/Business Details
    public By CompanyNameField = By.xpath("//*[@id=\"company\"]");
    public By ABNField = By.xpath("//*[@id=\"abn\"]");
    // Contact Details
    public By TitleDropdown = By.xpath("//*[@name='sal']");
    public By GivenNameField = By.xpath("//*[@name='firstName']");
    public By SurnameField = By.xpath("//*[@name='surname']");
    public By PhoneBHField = By.xpath("//*[@name='contact_phone']");
    public By EmailField = By.xpath("//*[@name='contact_email']");
    public By AccountManagementSection = By.xpath("//*[@id='accountManagementPlus']");
    public By ContractStartDate_Datepicker = By.id("contract_start_date");
    public By PaymentTermMethod_Dropdown = By.xpath("//*[@id='payment_term']");
    public By PaymentTermMethod_DropdownOpnC2 = By.xpath("//*[@id='payment_term']/option[2]");
    public By PaymentTermMethod_DropdownOpn_B3 = By.xpath("//*[@id='payment_term']/option[3]");
    public By PaymentTermMethod_DropdownOpnE1 = By.xpath("//*[@id='payment_term']/option[1]");
    public By CurrentDate = By.xpath("//*[@class=\"active day\"]");
    public By ContractTerm_Field = By.xpath("//*[@id='contract_term']");
    // Scroll to last of the page
    public By SaveCustomerButton = By.xpath("//*[@value='Save Customer']");
    public By SaveOnlyButton = By.xpath("//button[contains(text(),'Save Only')]");
    public By CustomerSuccessMsg = By.xpath("//div[@class='alert alert-success']/center");
    // public  By SaveandAddProvisioning= By.xpath("//*[contains(text(),'Save
    // and Add Provisioning')])[2]");
    // Scroll the page to last again
    // Change Status button appears
    public By ChangeStatusButton = By.xpath("//*[@class=\"btn btn-danger\"]");
    public By NewStatusDropdown = By.xpath("//select[@id='acctStatus']");
    public By ReasonforchangeField = By.xpath("//*[@id='statusReason']");
    public By Save_button_on_popup = By.xpath("//*[@id='save']");
    public By Closepopup_icon = By.xpath("//*[@class='close']");
    public By Company_Name_Field = By.xpath("//*[@id=\"company\"]");
    public By settingsTab = By.xpath("//a[text()=' Settings']");
    public By recentCustomerId = By.xpath("(//td[@class=\"sorting_1\"]/a)[1]");
    Assertions as;
    String SUCCESS_MESG = "Successfully saved customer.";


    //Metering

    public  By MeterReads_Tab = By.xpath("//*[@class='icon-bar-chart']");
    public  By ServiceName_Dropdown = By.xpath("//*[@id='nmis']");
    public  By ServiceName_DropdownOpn = By.xpath("//*[@id='nmis']/option[2]");
    public  By MeterNumber_Dropdown = By.xpath("//*[@id='meterNo']");
    public  By MeterNumber_DropdownOpn = By.xpath("//*[@id='meterNo']/option[2]");
    public  By ViewMeterReads = By.xpath("//*[@id='viewMeterReads']");
    public  By viewDemandReads = By.xpath("//*[@id='viewDemandReads']");
   // public  By viewKvarhReads = By.xpath("//*[@id='viewKvarhReads']");
    public  By viewTOUReads = By.xpath("//*[@id='viewTOUReads']");
    public  By viewTOUDailyReads = By.xpath("//*[@id='viewTOUDailyReads']");
    public  By viewNEM13Reads = By.xpath("//*[@id='viewNEM13Reads']");
    public  By retrieveTOUDailyReads = By.id("viewNEM13Reads");
    public  By retrieveTOUReads = By.id("retrieveTOUReads");
    public  By exportNEM13Reads = By.id("exportNEM13Reads");
    public  By retrieveNEM13Reads = By.id("retrieveNEM13Reads");


    //Market Page
    public  By b2bNotAndRequest = By.id("b2bNotAndRequest");
    public  By SORD = By.id("SORD");
    public  By CATS = By.xpath("//a[@id='CATS']");
    public  By NMID = By.id("NMID");
    public  By newNMIDButton = By.id("newNMIDButton");
    public  By CATSCategory = By.id("CATSCategory");
    public  By newSOButton = By.id("newSOButton");
    public  By B2BCategory = By.id("B2BCategory");

//Services

    public  By editService = By.xpath("//button[@title='View']");
    public  By backToServices = By.xpath("//a[@value='Back']");

    public By contracts=By.xpath("//a[text()=' Contracts']");



    public String getGroupName() {
        String groupName = getText_custom(groupTag);
        System.out.println("GroupName of customer is " + groupName);
        return groupName;
    }

    public String clickRecentCustomerId() {
        String customerId = getText_custom(recentCustomerId);
        click_custom(recentCustomerId);
        return customerId;

    }

    public void clickCustomerTab() {
        clickBtn_custom(customerTab, "Customers Tab");
    }

    public void clickDetailsTab() {
        clickBtn_custom(detailsTab, "Details Tab");
    }
//    public void clickNMITab() throws InterruptedException {
//        clickBtn_custom(nmiTab, "NMI Tab");
//    }
    public void clickMarketTab() {
        clickBtn_custom(market, "Market Tab");
    }

    public void clickServiceTab() {
        clickBtn_custom(service, "Servcie Tab");
    }


    public void clickCustomerTab(String tabName) throws InterruptedException {
        Thread.sleep(4000);
 
    	WebDriverWaits.waitForElementUntilVisible((By.xpath("//a[contains(text(),'" + tabName + "')]")), Duration.ofSeconds(10));

        clickBtn_custom(By.xpath("//a[contains(text(),'" + tabName + "')]"), tabName);
    }

    public boolean isErrorDisplayed() {
        return isElementPresent_custom(error,"error");
    }

    public void selectCategoryDropdownField(String categoryText) {
        //clickBtn_custom(categoryDropdownField, "Category");
        selectDropDownByVisibleText_custom(categoryDropdownField, categoryText, "Category");
    }

    public void enterCompanyNameField(String companyNameText) {
        sendKeys_custom(companyNameField, companyNameText, "Company Name");
    }

    public void enterFirstNameField(String firstNameText) {
        sendKeys_custom(firstNameField, firstNameText, "First Name");
    }

    public void enterLastNameField(String lastnameText) {
        sendKeys_custom(lastNameField, lastnameText, "Last Name");
    }

    public void enterPhoneNumber(String phoneNumberText) {
        sendKeys_custom(phoneNumberField, phoneNumberText, "Phone");
    }

    public void enterEmailField(String emailText) {
        scrollIntoView(emailField);
        sendKeys_custom(emailField, emailText, "Email");
    }

    public void enterBillingEmailField(String billingEmailText) {
        sendKeys_custom(billingEmailField, billingEmailText, "Billing Email");
    }

    public void enterAddressOneField(String addressOneText) {
        sendKeys_custom(addressOneField, addressOneText, "Address1");
    }

    public void enterAddressTwoField(String addressTwoText) {
        sendKeys_custom(addressTwoField, addressTwoText, "Address2");
    }

    public void enterCityField(String cityText) {
        sendKeys_custom(cityField, cityText, "City");
    }

    public void enterStateField(String stateText) {
        sendKeys_custom(stateField, stateText, "State");
    }

    public void enterZipCodeField(String zipCodeText) {
        sendKeys_custom(zipCodeField, zipCodeText, "State");
    }

    public void enterCountryField(String countryText) {
        sendKeys_custom(countryField, countryText, "Country");
    }

    public void selectPlanDropdownField(String PlanText) {
        clickBtn_custom(planDropdownField, "Plan");
        selectDropDownByVisibleText_custom(planDropdownField, PlanText, "Plan ");
    }

    public void clickPhysicalAddressToggleBtn() {
        clickBtn_custom(physicalAddressTogglebutton, "Use Physical Address ?");
    }

    public void clickSaveCustomerBtn() {
        scrollIntoView(saveCustomerbutton);
        clickBtn_custom(saveCustomerbutton, "Save Customer");
    }

    public void clickOkBtn() {
        clickBtn_custom(okbutton, "Ok");
    }

    public String getCustomerId() {
        return getText_custom(customerID);


    }

    public String getSuccessMsgText() {
        WebDriverWaits.waitForElementVisible(successMessageForCustomerCreation, Duration.ofSeconds(5));
        return getText_custom(successMessageForCustomerCreation);
    }

    public String createCustomer(String category, String companyName, String firstName, String lastName, String phoneNumber, String email, String billingEmail, String addressOne, String addressTwo, String city, String zipCode, String country, String plan) throws InterruptedException {
        as = new Assertions();
        clickCustomerTab();
        selectCategoryDropdownField(category);
        enterCompanyNameField(companyName);
        Thread.sleep(1000);
        enterFirstNameField(firstName);
        enterLastNameField(lastName);
        enterPhoneNumber(phoneNumber);
        enterEmailField(email);
        enterBillingEmailField(billingEmail);
        enterAddressOneField(addressOne);
        enterAddressTwoField(addressTwo);
        enterCityField(city);
        enterZipCodeField(zipCode);
        enterCountryField(country);
        selectPlanDropdownField(plan);
        clickPhysicalAddressToggleBtn();
        clickSaveCustomerBtn();
        clickOkBtn();
        as.assertStrings(getSuccessMsgText(), SUCCESS_MESG);
        return getCustomerId();
    }

    public void clickDetails() {
        clickBtn_custom(CustomerIcontab);
    }


    public void createCustomer(String type, String category, String email) throws InterruptedException {
        //Account Type
        clickBtn_custom(CustomerIcontab,"CustomerIcontab");
        clickBtn_custom(CustomerTypedropdown,"CustomerTypedropdown");
        Select select = new Select(getDriver().findElement(CustomerTypedropdown));
        select.selectByVisibleText(type);
        clickBtn_custom(Categorydropdown);
        WebElement ResidentialOption = getDriver().findElement(Categorydropdown);
        select = new Select(ResidentialOption);
        select.selectByVisibleText(category);
        //Contact Details
        if (category.equals("Business") || category.equals("Commercial")) {
            addBusinessDetails();
        }
        addContactDetails(email);
        addAccountManagement(category);
        scrollIntoView(SaveCustomerButton);
        clickBtn_custom(SaveCustomerButton,"SaveCustomerButton");
        clickBtn_custom(SaveOnlyButton,"SaveOnlyButton");
        Thread.sleep(2000);
    }

    public void addContactDetails(String email) throws InterruptedException {
        clickBtn_custom(Address1field,"Address1field");
        sendKeys_custom(Address1field, "Madirma R-Town");
        clickBtn_custom(Cityfield,"Cityfield");
        sendKeys_custom(Cityfield, "Mills NY");
        clickBtn_custom(Statedropdown);
        select = new Select(getDriver().findElement(Statedropdown));
        select.selectByVisibleText("WA");
        clickBtn_custom(PostalCodefield);
        sendKeys_custom(PostalCodefield, "1265");
        scrollIntoView(TitleDropdown);

        clickBtn_custom(TitleDropdown);
        select = new Select(getDriver().findElement(TitleDropdown));
        select.selectByVisibleText("Dr.");
        clickBtn_custom(GivenNameField);
        RandomName1 = RandomGenerator.requiredCharacters(6);
        sendKeys_custom(GivenNameField, RandomName1);
        clickBtn_custom(SurnameField);
        RandomName2 = RandomGenerator.requiredCharacters(6);
        Thread.sleep(2000);
        sendKeys_custom(SurnameField, RandomName2);
        scrollIntoView(PhoneBHField);

        clickBtn_custom(PhoneBHField);
        String RandomNumber = "4" + RandomGenerator.requiredDigits(8);
        sendKeys_custom(PhoneBHField, RandomNumber);
        Thread.sleep(2000);
        scrollIntoView(EmailField);

        Thread.sleep(1000);
        clickBtn_custom(EmailField);
        sendKeys_custom(EmailField, email);
    }

    public void addBusinessDetails() throws InterruptedException {
        clickBtn_custom(CompanyNameField);
        sendKeys_custom(CompanyNameField, "FranklinCovey");
        scrollIntoView(ABNField);

        clickBtn_custom(ABNField);
        sendKeys_custom(ABNField, "32165485216");
        Thread.sleep(2000);
    }

    public void addAccountManagement(String category) throws InterruptedException {
        scrollIntoView(AccountManagementSection);
        if (category != "Commercial")
            clickBtn_custom(AccountManagementSection);
        scrollIntoView(ContractStartDate_Datepicker);
        Thread.sleep(3000);
        clickBtn_custom(ContractStartDate_Datepicker);
        clickBtn_custom(CurrentDate);
        clickBtn_custom(ContractTerm_Field);
        sendKeys_custom(ContractTerm_Field, "10");
    }

    public void addMeterInformation(String serviceName , String meterNumber){
        click_custom(ServiceName_Dropdown,"ServiceName");
        click_custom(ServiceName_DropdownOpn);
        click_custom(MeterNumber_Dropdown,"Meter Number");
        click_custom(MeterNumber_DropdownOpn);
    }
    public void addMeterInformation(){
        click_custom(ServiceName_Dropdown,"ServiceName");
        click_custom(ServiceName_DropdownOpn);
        click_custom(MeterNumber_Dropdown,"Meter Number");
      //  click_custom(MeterNumber_DropdownOpn);
    }
    public void verifyMeterReadsTabs(){
        click_custom(ViewMeterReads,"Meter Reads Tab");
        attachScreenShot("Meter Reads Tab");
        click_custom(viewDemandReads," Demand Reads Tab");
        attachScreenShot("Demand Reads Tab");

        //isElementPresent_custom();
        SoftAssert softAssert = new SoftAssert();
        click_custom(viewNEM13Reads,"NEM 13 Raw Reads Tab");
        attachScreenShot("NEM 13 Raw Reads Tab");

        softAssert.assertTrue(isElementPresent_custom(retrieveNEM13Reads,"Retrieve Button"));
        softAssert.assertFalse(isExceptionOrErrorPresent());
        click_custom(viewTOUDailyReads,"Tou Aggregated Reads Tab");
        attachScreenShot("Tou Aggregated  Reads Tab");

        softAssert.assertTrue(isElementPresent_custom(retrieveTOUDailyReads,"Retrieve Button"));
        softAssert.assertFalse(isExceptionOrErrorPresent());

        click_custom(viewTOUReads,"Tou Raw Reads Tab ");
        attachScreenShot("Tou Raw Reads Tab");

        softAssert.assertTrue(isElementPresent_custom(retrieveTOUReads, "Retrieve Button"));
        softAssert.assertFalse(isExceptionOrErrorPresent());

        softAssert.assertAll();

    }
    public void verifyMarketTabs(){
        SoftAssert softAssert = new SoftAssert();
        click_custom(NMID,"CATS NMI Discovery Tab");
        attachScreenShot("CATS NMI Discovery Tab");
        softAssert.assertTrue(isElementPresent_custom(newNMIDButton,"Retrieve Button"));
        softAssert.assertFalse(isExceptionOrErrorPresent());

        click_custom(CATS,"Change request Tab");
        attachScreenShot("Change Request Tab");
        softAssert.assertTrue(isElementPresent_custom(CATSCategory,"CATSCategory Box"));
        softAssert.assertFalse(isExceptionOrErrorPresent());

        click_custom(SORD,"Service Order Tab ");
        attachScreenShot("Service Order Tab");
        softAssert.assertTrue(isElementPresent_custom(newSOButton, "newSOButton Button"));

        click_custom(b2bNotAndRequest,"Notifications/request Tab");
        attachScreenShot("Notifications/Request Tab");
        softAssert.assertTrue(isElementPresent_custom(B2BCategory, "Category selection box "));
        softAssert.assertFalse(isExceptionOrErrorPresent());

        softAssert.assertAll();

    }
    public void verifyServiceEdit(){

        click_custom(editService,"Edit Service Button");
        attachScreenShot("Services Edit Page");

        scrollIntoView(backToServices);
        click_custom(backToServices,"Back To Services Button");
    }
    public void verifyContractsTab(){
        SoftAssert softAssert = new SoftAssert();
        click_custom(contracts ,"Contracts Tab");
    }
}

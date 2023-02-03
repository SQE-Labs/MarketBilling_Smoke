package org.automation.pageObjects.customers;

import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.DateGenerator;
import org.automation.utilities.RandomGenerator;
import org.openqa.selenium.By;


public class Services  extends ActionEngine {
    // Search Field
    public  By SearchField = By.xpath("//*[@id=\"search_input\"]");
    public  By SearchIcon = By.xpath("//*[@class=\"glyphicon glyphicon-search\"]");
    public  By OverviewTab = By.xpath("//*[@class=\"icon-eye-open\"]"); // //*[contains(text(),'Overview')]

    // Add Service for Residential/Business/Commercial customer
    public  By RetailElectricity_Plus_Subtab = By.xpath("(//*[@class='icon-minus'])[2]");
    public  By Market_Type_Field = By.xpath("//*[@id='marketTypeSel']");
    public  By NMI_Field = By.xpath("//*[@id=\"NMI\"]");
    public  By Service_Plan_Dropdown = By.xpath("//*[@id=\"planNo\"]");
    public  By Move_In_Date_Datepicker = By.xpath("//*[@id=\"proposedDate\"]");
    public  By SelectCurrentDate = By.xpath("//*[@class=\"active day\"]");
    public  By Select_Use_Structured_Address_Togglebutton = By.xpath("//*[@class=\"switch-label\"]");
    public  By Building_Name_Field = By.xpath("//*[@id=\"buildingName\"]");
    public  By UnitType_Dropdown = By.xpath("//*[@id=\"flatType\"]");
    public  By Street_Number_Suffix_Dropdown = By.xpath("//*[@id=\"houseNBRSuffix\"]");
    public  By Suburb_Field = By.xpath("//*[@id=\"locality\"]");
    public  By Postal_Code_field = By.xpath("//*[@id=\"postCode\"]");
    public  By StateDropdown = By.xpath("//*[@id=\"state\"]");
    public  By AddButton = By.xpath("//*[@id=\"submitBttn\"]");

    // Edit Residential/Business/Commercial customer service
    public  By ServiceTab = By.xpath("//*[@class=\"icon-power-off\"]");
    public  By Search_FieldOnPage = By.xpath("//*[@class=\"dataTables_filter\"]");
    public  By Edit_icon = By.xpath("//*[@class=\"btn btn-primary toolt\"]");
    public  By Service_Status_Dropdown = By.xpath("//*[@id=\"serviceStatus\"]");
    public  By Netting_Config_Dropdown = By.xpath("//*[@id=\"nettingConfig\"]");
    public  By Sub_Channel_Aggregation_Dropdown = By.xpath("//*[@id=\"subChannelAggregation\"]");
    public  By SaveChanges_Button = By.xpath("//*[@class=\"btn btn-primary iseditable\"]");
    public  By OkButton = By.xpath("//*[contains(text(),'OK')]");
    public  By CustomerSuccessEditMsg = By.xpath("//div[@class='alert alert-success']/center");

    public DateGenerator dateGenerator = new DateGenerator();
    public RandomGenerator random = new RandomGenerator();

    public  String addService(String customerId ) throws InterruptedException {
        clickBtn_custom(SearchIcon);
        clickBtn_custom(SearchField);
        sendKeys_custom(SearchField, customerId);
        clickBtn_custom(SearchIcon);
        clickBtn_custom(OverviewTab);
        clickBtn_custom(RetailElectricity_Plus_Subtab);
        clickBtn_custom(Market_Type_Field);
        selectDropDownByVisibleText_custom(Market_Type_Field,"Off Market");
        scrollIntoView(NMI_Field);
        clickBtn_custom(NMI_Field);
        String serviceId = random.requiredDigits(10);
        sendKeys_custom(NMI_Field, serviceId);
        clickBtn_custom(Service_Plan_Dropdown);
        selectDropDownByVisibleText_custom(Service_Plan_Dropdown,"Electricity Template Plan");
        sendKeys_custom(Move_In_Date_Datepicker, dateGenerator.DateTimeGenerator("dd/MM/yyyy"));
        scrollIntoView(Select_Use_Structured_Address_Togglebutton);
        clickBtn_custom(Select_Use_Structured_Address_Togglebutton);
        clickBtn_custom(Building_Name_Field);
        sendKeys_custom(Building_Name_Field, "Los angels");
        clickBtn_custom(UnitType_Dropdown);
        selectDropDownByVisibleText_custom(UnitType_Dropdown,"Block");
        clickBtn_custom(Street_Number_Suffix_Dropdown);
        selectDropDownByVisibleText_custom(Street_Number_Suffix_Dropdown,"V");
        scrollIntoView( Suburb_Field);
        clickBtn_custom(Suburb_Field);
        sendKeys_custom(Suburb_Field, "Almor Distt 324");
        clickBtn_custom(Postal_Code_field);
        String RandomNumber2 = random.requiredDigits(15);
        sendKeys_custom(Postal_Code_field, RandomNumber2);
        clickBtn_custom(StateDropdown);
        selectDropDownByVisibleText_custom(StateDropdown,"New South Wales");
        clickBtn_custom(AddButton);
        return serviceId;
    }
    public  void editServiceStatus() throws InterruptedException {
        clickBtn_custom(ServiceTab);
        clickBtn_custom(Edit_icon);
        scrollIntoView(Service_Status_Dropdown);
        clickBtn_custom(Service_Status_Dropdown);
        selectDropDownByVisibleText_custom(Service_Status_Dropdown,"Connected");
        scrollIntoView(SaveChanges_Button);
        clickBtn_custom(SaveChanges_Button);
        clickBtn_custom(OkButton);

    }
    public  void navigateToEditServices() throws InterruptedException {
        clickBtn_custom(ServiceTab);
        clickBtn_custom(Edit_icon);
    }
    public  void validateSuccessMessage() throws InterruptedException {
			String ActualMsg = getText_custom(CustomerSuccessEditMsg);
			String ExpectedMsg1 = "Successfully saved service details.";
            Assertions assertions = new Assertions();
            assertions.assertStrings(ExpectedMsg1, ActualMsg);

    }
}

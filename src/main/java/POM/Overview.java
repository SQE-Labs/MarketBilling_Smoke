package POM;

import CommonMethods.RandomStrings;
import CommonMethods.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static POM.Flow5_AddCustomer.jse;

public class Overview {

    public static Select select;
    public static String ServiceIDLater1;
    public static String ServiceIDLater2;
    public static String ServiceIDLater3;
    public static String RandomNumber1;
    public static String RandomNumber2;
    public static String RandomNumber3;
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




    public void  addProvisioning(String serviceType, String marketType, String transferType) throws InterruptedException {
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



}

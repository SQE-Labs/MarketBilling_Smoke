package TestClasses;

import automation.pageObjects.*;
import automation.utilities.ActionEngine;
import automation.utilities.PropertiesUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SmokeTest extends ActionEngine {
    IndexPage indexPage;
    CustomerSearchPage searchPage = new CustomerSearchPage();
    String BASE_URL=PropertiesUtil.getPropertyValue("baseUrl");

    String customerId;

    @Test(priority = 0, enabled = true, description = "verify build version at  Login Page")
    public void version_Check_at_LoginPage() {
        Login login = new Login();
        Assert.assertEquals(login.getBuildVersionText(), PropertiesUtil.getPropertyValue("copyRightText"));
    }

    @Test(priority = 1, enabled = true, description = "verify successful Login with valid username password")
    public void valid_Login() {
        Login login = new Login();
        indexPage = login.validLogin();
        Assert.assertEquals(indexPage.getPageUrl(),BASE_URL+ PropertiesUtil.getPropertyValue("indexPage"));
    }

    @Test(priority = 2, enabled = true, description = "verify index page reload")
    public void reload_IndexPage() {
        indexPage.refreshPage();
        Assert.assertEquals(indexPage.getPageUrl(),BASE_URL+ PropertiesUtil.getPropertyValue("indexPage"));
    }

    @Test(priority = 3, enabled = true, description = "verify build version at index page")
    public void version_Check_at_Indexpage() {

        Assert.assertEquals(indexPage.getTextVersion().trim(), PropertiesUtil.getPropertyValue("buildVersion"));
    }


    @Test(priority = 4, enabled =false , description = "verify create new customer")
    public void create_new_Customer() throws InterruptedException {
        Customer customer = new Customer();
        customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
    }
    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All() {
        indexPage.searchAll();
        Assert.assertTrue(searchPage.getHeaderText().contains("Customers Found"));
        Assert.assertTrue(searchPage.getHeader2Text().contains("Market Services Found"));


    }
    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All_Market_ServiceID() {

        indexPage.searchAllServiceId();
        Assert.assertTrue(searchPage.getHeaderText().contains("Market Services Found"));
    }
    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All_Customer_Address() {

        indexPage.searchAllCustomerAddress();
        Assert.assertTrue(searchPage.getHeaderText().contains("Customers Found"));


    }
    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All_Service_Address() {

        indexPage.searchAllServiceAddress();
        Assert.assertTrue(searchPage.getHeaderText().contains("Market Services Found"));

    }
    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All_Meter_Number() {
        indexPage.searchAllMeterNumber();
        Assert.assertTrue(searchPage.getHeaderText().contains("Market Services Found"));

    }
    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All_Customers() {

        indexPage.searchAllCustomer();
        Assert.assertTrue(searchPage.getHeaderText().contains("Customers Found"));

    }

    @Test(priority = 6, enabled = true, description = "verify Customer group Name ")
    public void search_Recent_Customers_groupName() {
        Admin admin = new Admin();
        GroupEdit groupEdit= admin.navigateToGroupEdit();
        String groupName =groupEdit.getGroupNameText();

        Customer customer = new Customer();
        SoftAssert softAssert = new SoftAssert();
        indexPage.searchAllCustomer();
        String customerIdRecent = customer.clickRecentCustomerId();
       // softAssert.assertEquals(customerIdRecent, customerId);
        customer.switchToWindow("CustomerPage");
        customer.clickDetailsTab();
       String custGroupName= customer.getGroupName();
        Assert.assertEquals(custGroupName, groupName);
         softAssert.assertAll();
    }

    @Test(priority = 7, enabled = true, description = "verify all Customer Tabs ")
    public void verify_CustomerTabs() {
        Customer customer = new Customer();
        SoftAssert softAssert = new SoftAssert();
        String[] tabs = PropertiesUtil.getPropertyValue("customerTabs").split(",");
        for (String tab : tabs) {
            customer.clickCustomerTab(tab);
            getScreenshot(getDriver(), tab);
            softAssert.assertFalse(customer.isErrorDisplayed());

        }
        softAssert.assertAll();

    }

    @Test(priority = 8, enabled = true, description = "verify Fast NMI discovery")
    public void Fast_NMIDiscovery() {
        Customer customer = new Customer();
        customer.clickNMITab();
        FastNMI nmipage = new FastNMI();
        nmipage.enterNmi("EMB8573590");
        nmipage.clickDiscoveryBtn();
        Assert.assertEquals(nmipage.getResultText(), "Error in Fast NMI Discovery Request - I/O Exception: java.net.ConnectException: Connection timed out: connect");

    }


}

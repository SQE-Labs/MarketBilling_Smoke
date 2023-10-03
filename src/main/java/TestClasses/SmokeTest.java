package TestClasses;

import automation.pageObjects.*;
import automation.utilities.ActionEngine;
import automation.utilities.DateTime;
import automation.utilities.PropertiesUtil;
import automation.utilities.WebDriverWaits;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class SmokeTest extends ActionEngine {
    IndexPage indexPage;
    CustomerSearchPage searchPage = new CustomerSearchPage();

    String BASE_URL = PropertiesUtil.getPropertyValue("baseUrl");
    String INDEX = PropertiesUtil.getPropertyValue("indexPage");

    String serviceID;
    String customerId;

    @Test(priority = 0, enabled = true, description = "verify build version at  Login Page")
    public void version_Check_at_LoginPage() {
        Login login = new Login();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(login.getBuildVersionText(), PropertiesUtil.getPropertyValue("copyRightText"));
        softAssert.assertAll();

    }

    @Test(priority = 1, enabled = true, description = "verify successful Login with valid username password")
    public void valid_Login() {
        Login login = new Login();
        if (PropertiesUtil.getPropertyValue("group").contains("multi")) {
            indexPage = login.loginWithGroupName(PropertiesUtil.getPropertyValue("groupName"));
            Assert.assertEquals(indexPage.getPageUrl(), BASE_URL + "/");

        } else {
            indexPage = login.validLogin();

            Assert.assertEquals(indexPage.getPageUrl(), BASE_URL + PropertiesUtil.getPropertyValue("indexPage"));
        }
    }


    @Test(priority = 2, enabled = true, description = "verify build version at index page")
    public void version_Check_at_Indexpage() {

        Assert.assertEquals(indexPage.getTextVersion().trim(), PropertiesUtil.getPropertyValue("buildVersion"));
    }

    @Test(priority = 3, enabled = true, description = "verify  page reload")
    public void reload_Page() {
        indexPage.refreshPage();
        if (PropertiesUtil.getPropertyValue("group").contains("single")) {
            Assert.assertEquals(indexPage.getPageUrl(), BASE_URL + INDEX);
        } else {
            Assert.assertEquals(indexPage.getPageUrl(), BASE_URL + "/");
        }

    }

    //  Not requires for Production //
    @Test(priority = 4, enabled = false, description = "verify create new customer")
    public void create_new_Customer() throws InterruptedException {
        Customer customer = new Customer();
        customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
    }

    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All() {
        SoftAssert softAssert = new SoftAssert();

        indexPage.searchAll();
        softAssert.assertTrue(searchPage.getHeaderText().contains("Customers Found"));
        attachScreenShot("SearchAllPage1");
        indexPage.ScrollDownThePageMax();
        softAssert.assertTrue(searchPage.getHeader2Text().contains("Market Services Found"));
        softAssert.assertAll();
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
    public void search_Recent_Customers_groupName() throws InterruptedException {
        Admin admin = new Admin();
        GroupEdit groupEdit = admin.navigateToGroupEdit();
        String groupName = groupEdit.getGroupNameText();
        attachScreenShot("groupNameAdmin");
        Customer customer = new Customer();
        SoftAssert softAssert = new SoftAssert();
        indexPage.searchAllCustomer();
        String customerIdRecent = customer.clickRecentCustomerId();
        // softAssert.assertEquals(customerIdRecent, customerId);
        customer.switchToWindow("CustomerPage");
        customer.clickDetailsTab();
        String custGroupName = customer.getGroupName();
        attachScreenShot("groupName");
        softAssert.assertEquals(custGroupName, groupName);
        softAssert.assertEquals(custGroupName, PropertiesUtil.getPropertyValue("groupName"));
        Thread.sleep(5000);
        softAssert.assertFalse(isExceptionOrErrorPresent());
        softAssert.assertAll();

    }

    @DataProvider(name = "getCustomerTabs")
    public Object[][] getCustomerTabs() {
        String[] strList = PropertiesUtil.getPropertyValue("customerTabs").split(",");
        String data[][] = new String[strList.length][1];

        for (int i = 0; i < strList.length; i++) {
            data[i][0] = strList[i];
        }

        return data;
    }

    @Test(priority = 7, enabled = true, description = "verify  Customer Tab")
    public void Click_CustomerTabs() throws InterruptedException {
  Login login =new Login();
  login.validLogin();

        String tabs[] = PropertiesUtil.getPropertyValue("customerTabs").split(",");
        SoftAssert softAssert = new SoftAssert();

        for (String tab : tabs) {

            Customer customer = new Customer();
            customer.clickCustomerTab(tab);
            Thread.sleep(4000);
            attachScreenShot(tab);
//                if (!(tab.contains("Settings")||tab.contains("Contact"))) {
//                    softAssert.assertFalse(customer.isExceptionOrErrorPresent(), "Exception in  " + tab + " Tab.\n");
//                } else {
//                    softAssert.assertFalse(customer.isExceptionOrErrorPresent(3), "Exception found in  " + tab + " Tab.\n");
//                }
            softAssert.assertFalse(customer.isExceptionOrErrorPresent(), "Exception in  " + tab + " Tab.\n");
        }
        softAssert.assertAll();

    }


    @Test(priority = 8, enabled = true, description = "verify Fast NMI discovery tab")
    public void verify_Fast_NMIDiscovery() throws InterruptedException {
        Customer customer = new Customer();

        SrvCustSearchResults srvCustSearchResults = indexPage.searchAllMeterNumber();
        serviceID = srvCustSearchResults.getFirstServiceId();

        if (srvCustSearchResults.getHeaderCount() > 1) {
            customer.clickRecentCustomerId();
            customer.switchToWindow("customer");
        }

        //customer.clickNMITab();
        FastNMI nmipage = new FastNMI();
        nmipage.enterNmi(serviceID);
        nmipage.clickDiscoveryBtn();
        SoftAssert softAssert = new SoftAssert();
        if (PropertiesUtil.getPropertyValue("env").equalsIgnoreCase("qa")) {
            softAssert.assertEquals(nmipage.getResultText(), "Error in Fast NMI Discovery Request - I/O Exception: 403 - Bad User Credentials (NB: check that the MSATS password hasn't expired -- AEMO enforces password rotation)");
            softAssert.assertEquals(nmipage.getDlfValue(), "");

        } else {
            softAssert.assertTrue(nmipage.getResultText().contains("<Header>"));
            softAssert.assertNotEquals(nmipage.getDlfValue(), "");
            softAssert.assertNotEquals(nmipage.getTnivalue(), "");

        }
        softAssert.assertAll();

    }

    @Test(priority = 9, enabled = true, description = "verify market Tab sub Tabs")
    public void verify_marketTab_subTabs() {
        Customer customer = new Customer();
        SrvCustSearchResults srvCustSearchResults = indexPage.searchAllMeterNumber();
        // serviceID = srvCustSearchResults.getFirstServiceId();
        if (srvCustSearchResults.getHeaderCount() > 1) {
            customer.clickRecentCustomerId();
            customer.switchToWindow("customer");
        }

        customer.clickMarketTab();
        customer.verifyMarketTabs();

    }

    @Test(priority = 10, enabled = true, description = "verify  Servic sub Tabs")
    public void verify_serviceTab_SubTabs() {
        // indexPage.searchAll(serviceID);
        Customer customer = new Customer();
        SrvCustSearchResults srvCustSearchResults = indexPage.searchAllMeterNumber();
        if (srvCustSearchResults.getHeaderCount() > 1) {
            customer.clickRecentCustomerId();
            customer.switchToWindow("customer");
        }
        //serviceID = srvCustSearchResults.getFirstServiceId();

        customer.clickServiceTab();
        customer.verifyServiceEdit();

    }

    @Test(priority = 10, enabled = true, description = "verify meter reads  Sub Tabs")
    public void verify_MeterReads_Sub_Tabs() throws InterruptedException {
        Customer customer = new Customer();
        SrvCustSearchResults srvCustSearchResults = indexPage.searchAllMeterNumber();
        //  serviceID = srvCustSearchResults.getFirstServiceId();
        if (srvCustSearchResults.getHeaderCount() > 1) {
            customer.clickRecentCustomerId();
            customer.switchToWindow("customer");
        }

        customer.clickCustomerTab("Meter Reads");
        customer.addMeterInformation();
        customer.verifyMeterReadsTabs();
        Assert.assertFalse(isExceptionOrErrorPresent());

    }

    @Test(priority = 14, enabled = true, description = "verify EDI Type 2 Reports")
    public void validate_EDI_Type_2_Reports() throws InterruptedException {
        Admin admin = new Admin();
        Reports report = new Reports();
        Login login = new Login();
        BillRun billRun = new BillRun();
        //login.validLogin();
        admin.navigateToBasePage();
        report.navigateToReports();
        report.goTo_EdiReport_Type_2();
        report.select_Latest_StatementNumber();
        report.downloadReport();
        report.goToNotification();
        String downloadedFile = billRun.validateDownloadedFile();
        Assert.assertTrue(billRun.isFileDownloaded(downloadedFile));

    }


    @Test(priority = 12, enabled = true, description = "Download Zip file from Statement Summary")
    public void statementSummary_downloadZip() throws InterruptedException, IOException {
        Admin admin = new Admin();
        Login login = new Login();
        BillRun billRun = new BillRun();
        //  login.validLogin();
        admin.navigateToBasePage();
        admin.navigateToBillRun();
        billRun.billRunFilter();
        String statement = billRun.downloadZip();
        String fileName = billRun.getcustomerNumber() + "_" + statement + "_" + DateTime.getEpocTime() + ".7z";
        String home = System.getProperty("user.home");
        billRun.unzip(home + "/Downloads/", fileName);
        String downloadedFile = billRun.validateDownloadedFile();
        Assert.assertTrue(billRun.isFileDownloaded(downloadedFile));

    }

    @Test(priority = 13, enabled = true, description = "Download Pdf file from Statement Summary")
    public void statementSummary_downloadPdf() throws InterruptedException {
        Admin admin = new Admin();
        Login login = new Login();
        BillRun billRun = new BillRun();
        admin.navigateToBasePage();
        admin.navigateToBillRun();
        billRun.billRunFilter();
        String statement = billRun.downloadPdf();
        String downloadedFile = billRun.validateDownloadedFile();
        Assert.assertTrue(billRun.isFileDownloaded(downloadedFile));
    }

    @Test(priority = 15, enabled = true, description = "verify build version at index page")
    public void version_Check_Jsp() {
        Version version = new Version();
        getDriver().get(PropertiesUtil.getPropertyValue("baseUrl") + PropertiesUtil.getPropertyValue("versionJsp"));
        Assert.assertEquals(version.getHeaderText().trim(), PropertiesUtil.getPropertyValue("jspVersion"));

    }
}

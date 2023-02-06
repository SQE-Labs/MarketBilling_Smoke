package test.TestClasses;

import org.automation.pageObjects.*;
import org.automation.utilities.ActionEngine;
import org.automation.utilities.Assertions;
import org.automation.utilities.PropertiesUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class SmokeTest extends ActionEngine {
    IndexPage indexPage;
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
        Assert.assertEquals(indexPage.getPageUrl(), PropertiesUtil.getPropertyValue("indexPage"));
    }

    @Test(priority = 2, enabled = true, description = "verify index page reload")
    public void reload_IndexPage() {
        indexPage.refreshPage();
        Assert.assertEquals(indexPage.getPageUrl(), PropertiesUtil.getPropertyValue("indexPage"));
    }

    @Test(priority = 3, enabled = true, description = "verify build version at index page")
    public void version_Check_at_Indexpage() {

        Assert.assertEquals(indexPage.getTextVersion().trim(), PropertiesUtil.getPropertyValue("buildVersion"));
    }


    @Test(priority = 4, enabled = true, description = "verify create new customer")
    public void create_new_Customer() throws InterruptedException {
        Customer customer = new Customer();
        customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
    }

    @Test(priority = 5, enabled = true, description = "verify all customer Search box")
    public void search_All_Customers() {
        indexPage.searchAllCustomer();
    }

    @Test(priority = 6, enabled = true, description = "verify Customer group Name ")
    public void search_Recent_Customers_groupName() {
        Customer customer = new Customer();
        SoftAssert softAssert = new SoftAssert();
        String customerIdRecent = customer.clickRecentCustomerId();
        softAssert.assertEquals(customerIdRecent, customerId);

        customer.switchToWindow("CustomerPage");
        customer.clickDetailsTab();
        softAssert.assertEquals(customer.getGroupName(), PropertiesUtil.getPropertyValue("groupName"));
    }

    @Test(priority = 7, enabled = true, description = "verify all Customer Tabs ")
    public void verify_CustomerTabs() {
        Customer customer = new Customer();
        String[] tabs = PropertiesUtil.getPropertyValue("customerTabs").split(",");
        for (String tab : tabs) {
            customer.clickCustomerTab(tab);
            getScreenshot(getDriver(), tab);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertFalse(customer.isErrorDisplayed());
        }

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

    @Test(priority = 9, enabled = true, description = "Load Webservices page and open each WSDL file link")
    public void load_WebServices() {
        Webservice webservice = new Webservice();
        getDriver().get(PropertiesUtil.getPropertyValue("webservices"));
        List<WebElement> wsdlLinks = webservice.getWSDLLinks();
        for (WebElement link : wsdlLinks) {
            String hyperLink = getText_custom(link);
            String[] text = hyperLink.split("/");
            click_custom(link);
            String fileName = "";
            for (String s : text) {
                if (s.contains("?")) {
                    fileName = Arrays.asList(s.split("\\?")).get(0);
                    break;
                }
            }
            Assertions softAssert = new Assertions();
            webservice.switchToWindow("new Tab");

            softAssert.assertStrings(webservice.getPageUrl(), hyperLink);
            softAssert.assertTrue(webservice.isXMLTextPresent("definitions"));

            getScreenshot(getDriver(), fileName);
            webservice.navigateBack();

        }
    }
}

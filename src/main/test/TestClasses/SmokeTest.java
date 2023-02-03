package TestClasses;

import POM.Login;
import org.automation.pageObjects.IndexPage;
import org.automation.pageObjects.Webservice;
import org.automation.pageObjects.customers.Customer;
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

    @Test(priority = 0, enabled = true, description = "verify version at  Login Page")
    public void versionCheck_LoginPage() {
        Login login = new Login();
        Assert.assertEquals(login.getBuildVersionText(), PropertiesUtil.getPropertyValue("copyRightText"));
    }

    @Test(priority = 1, enabled = true, description = "verify successful Login")
    public void validLogin() {
        Login login = new Login();
        indexPage = login.validLogin();
        Assert.assertEquals(indexPage.getPageUrl(), PropertiesUtil.getPropertyValue("indexPage"));
    }

    @Test(priority = 2, enabled = true, description = "verify index page reload")
    public void reloadIndexPage() {
        indexPage.refreshPage();
        Assert.assertEquals(indexPage.getPageUrl(), PropertiesUtil.getPropertyValue("indexPage"));
    }

    @Test(priority = 3, enabled = true, description = "verify build version")
    public void versionCheck() {

        Assert.assertEquals(indexPage.getTextVersion().trim(), PropertiesUtil.getPropertyValue("buildVersion"));
    }

    @Test(priority = 4, enabled = true, description = "verify all customer Search")
    public void searchAllCustomers() {
        indexPage.searchAllCustomer();
    }

    @Test(priority = 5, enabled = false, description = "verify create new customer")
    public void createCustomer() throws InterruptedException {
        customerId = POM.Customer.createCustomer("Tenant", "Business", "business123@yopmail.com");
    }

    @Test(priority = 6, enabled = true, description = "verify Customer group Name")
    public void searchRecentCustomers() {
        Customer customer = new Customer();
        SoftAssert softAssert = new SoftAssert();
        String customerIdRecent = customer.clickRecentCustomerId();
        softAssert.assertEquals(customerIdRecent, customerId);

        customer.switchToWindow("CustomerPage");
        customer.clickDetailsTab();
        softAssert.assertEquals(customer.getGroupName(), PropertiesUtil.getPropertyValue("groupName"));
    }

    @Test(priority = 7, enabled = true, description = "verify Customer Tabs")
    public void verifyCustomerTabs() {
        Customer customer = new Customer();
        String tabs[] = PropertiesUtil.getPropertyValue("customerTabs").split(",");
        for (int i = 0; i < tabs.length; i++) {
            // accessing each tab of array
            customer.clickCustomerTab(tabs[i]);
            customer.verifyConsoleLogs();
            // Screenshot.takeScreenShot("Success_" + result.getName())
            getScreenshot(getDriver(), tabs[i]);
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertFalse(customer.isErrorDisplayed());
        }

    }

    @Test(priority = 8, enabled = false, description = "load Webservices page")
    public void loadWebServices() throws InterruptedException {
        Webservice webservice = new Webservice();
      //  getDriver().close();
        getDriver().get(PropertiesUtil.getPropertyValue("webservices"));
        List<WebElement> wsdlLinks = webservice.getWSDLLinks();
        for (WebElement link : wsdlLinks) {
            String hyperLink=getText_custom(link);
            System.out.println(hyperLink);
            String text[] = hyperLink.split("/");
            click_custom(link);
            String fileName = "";
            for (int i = 0; i < text.length; i++) {
                if (text[i].contains("?")) {
                    fileName = Arrays.asList(text[i].split("\\?")).get(0);
                    break;
                }
            }
            Assertions softAssert = new Assertions();
            webservice.switchToWindow("");

            softAssert.assertStrings(webservice.getPageUrl(),hyperLink);
            softAssert.assertStrings(webservice.getPageUrl(),hyperLink);

            //webservice.verifyConsoleLogs();
            getScreenshot(getDriver(), fileName);
            webservice.navigateBack();

        }
    }
}

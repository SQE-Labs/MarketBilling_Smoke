package TestClasses;

import automation.pageObjects.Webservice;
import automation.utilities.ActionEngine;
import automation.utilities.PropertiesUtil;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class WebserviceTest extends ActionEngine {
    String BASE_URL=PropertiesUtil.getPropertyValue("baseUrl");

    @Test(priority = 20, enabled = true, description = "Load Webservices page and open each WSDL file link")
    public void load_WebServices() {
        SoftAssert softAssert = new SoftAssert();
        Webservice webservice = new Webservice();
        getDriver().get(BASE_URL+PropertiesUtil.getPropertyValue("webservices"));
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
            webservice.switchToWindow("new Tab");
            softAssert.assertEquals(webservice.getPageUrl(), BASE_URL+"/"+fileName+"?wsdl");
            softAssert.assertTrue(webservice.isXMLTextPresent("definitions"));
            getScreenshot(getDriver(), fileName);
            webservice.navigateBack();

        }
        softAssert.assertAll();

    }
}

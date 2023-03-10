package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Webservice extends ActionEngine {
    By address = By.xpath("//tbody/tr/td[contains(text(),'Address')]/../td[2]");
    By links = By.tagName("a");

    public List<WebElement> getWSDLLinks() {
        List<WebElement> wsdlLinks = getWebElements(links);
        return wsdlLinks;

    }

    public boolean isXMLTextPresent(String text) {
        return isElementPresent_custom(By.xpath("//*[contains(text(),'The document tree is shown below.')]"), text);

    }
}

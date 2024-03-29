package automation.pageObjects;

import automation.utilities.ActionEngine;

import automation.utilities.WebDriverWaits;

import java.time.Duration;


import org.openqa.selenium.By;

public class FastNMI extends ActionEngine {
    public By nmi = By.id("thenmi");
    public By dlf = By.xpath("(//label[@class='col-sm-2 control-label']/../div/input)[2]");
    public By tni = By.xpath("(//label[@class='col-sm-2 control-label']/../div/input)[3]");
    public By fastNMiBtn =By.xpath("//a[text()=' Fast NMI']");
    public By goToSelectedNMI = By.xpath("//button[contains(text(),'Discovery')]");
    public By result = By.id("result");

    public String getResultText() {
        return getText_custom(result);
    }
    public String getDlfValue() {
        return getAttributevalue(dlf,"value");
    }
    public String getTnivalue() {
        return getAttributevalue(tni,"value");
    }

 
    public void enterNmi(String serviceID) {
        click_custom(fastNMiBtn,"FastNMiBtn");
        WebDriverWaits.waitForElementUntilVisible(nmi, Duration.ofSeconds(10));
        sendKeys_custom(nmi,serviceID);

    }
 
    public void clickDiscoveryBtn() {
        clickBtn_custom(goToSelectedNMI);

    }
}

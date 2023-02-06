package org.automation.pageObjects;

import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class FastNMI extends ActionEngine {
    public By nmi = By.id("thenmi");
    public By goToSelectedNMI = By.className("btn btn-large btn-primary btn-round ");

    public By result = By.id("result");

    public String getResultText() {
        return getText_custom(result);
    }

    public void enterNmi(String text) {
        sendKeys_custom(nmi,text);

    }
    public void clickDiscoveryBtn() {
        click_custom(goToSelectedNMI);

    }
}

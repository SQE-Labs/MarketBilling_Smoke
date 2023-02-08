package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class FastNMI extends ActionEngine {
    public By nmi = By.id("thenmi");
    public By goToSelectedNMI = By.xpath("//button[contains(text(),'Discovery')]");

    public By result = By.id("result");

    public String getResultText() {
        return getText_custom(result);
    }

    public void enterNmi(String text) {
        sendKeys_custom(nmi,text);

    }
    public void clickDiscoveryBtn() {
        clickBtn_custom(goToSelectedNMI);

    }
}

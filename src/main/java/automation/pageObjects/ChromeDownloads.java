package automation.pageObjects;

import automation.utilities.ActionEngine;
import automation.utilities.WebDriverWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ChromeDownloads extends ActionEngine {
    public By fileLink = By.cssSelector("a[id='file-link']");
    public By shadowRoot = By.cssSelector("#shadow-root");


    public String getFileName(){
        WebDriverWaits.waitForElementVisible(By.cssSelector("downloads-manager"), Duration.ofSeconds(15));
        WebElement shadowHost1 = getDriver().findElement(By.cssSelector("downloads-manager"));
        SearchContext shadowRoot1 = shadowHost1.getShadowRoot();
        WebElement shadowHost3 = shadowRoot1.findElement(By.cssSelector("downloads-item"));
        SearchContext shadowRoot3 = shadowHost3.getShadowRoot();
        WebElement element = shadowRoot3.findElement(By.cssSelector("#title-area"));
   return  element.getText();
    }

}

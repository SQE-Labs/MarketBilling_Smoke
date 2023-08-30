package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class Version extends ActionEngine {
    By header = By.xpath("//h4");

    public String getHeaderText() {


        return getText_custom(header);
    }

}

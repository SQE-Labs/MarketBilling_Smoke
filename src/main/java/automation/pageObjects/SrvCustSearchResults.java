package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class SrvCustSearchResults extends ActionEngine
{
    By firstServiceId = By.xpath("(//tr/td[2])[1]");

    public String getFirstServiceId() {


        return getText_custom(firstServiceId);
    }


}

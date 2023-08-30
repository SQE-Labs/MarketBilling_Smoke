package automation.pageObjects;

import automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class SrvCustSearchResults extends ActionEngine
{
    By firstServiceId = By.xpath("(//tr/td[2])[1]");
    By header = By.xpath("//h2");

    public String getFirstServiceId() {


        return getText_custom(firstServiceId);
    }

    public String getHeaderText() {


        return getText_custom(header);
    }
    public int getHeaderCount() {

        int count = Integer.parseInt(getHeaderText().replaceAll("[^0-9]", ""));
        return  count ;
    }
}

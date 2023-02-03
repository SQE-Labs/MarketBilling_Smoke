package org.automation.pageObjects;

import org.automation.utilities.ActionEngine;
import org.openqa.selenium.By;

public class IndexPage  extends ActionEngine {
    public By footerVersion = By.cssSelector(".footerLinks div:nth-child(2)");
    public  By searchIcon = By.xpath("//*[@class=\"glyphicon glyphicon-search\"]");


    public  String getTextVersion(){
       return getText_custom(footerVersion)    ;
    }
    public  void searchAllCustomer(){
        click_custom(searchIcon);

    }

}

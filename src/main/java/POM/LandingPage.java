package POM;

import BrowsersBase.DataInterface;

import static BrowsersBase.BrowsersInvoked.driver;

public class LandingPage {


    public  static void navigateToHomePage(){
       driver.get(DataInterface.URL);
    }

}

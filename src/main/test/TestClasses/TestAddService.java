package TestClasses;

import BrowsersBase.BrowsersInvoked;
import POM.*;
import org.automation.base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestAddService extends BaseTest {

    @AfterMethod
    public void pageRefresh() {
        BrowsersInvoked.driver.navigate().refresh();
    }

    @Test(priority = 1)
    public void AddResidentialService() throws InterruptedException {
        extent.startTest("Retail Electricity Service for  Residential Customer ");
        test.setDescription(" Verify that User is able to add Residential Service. ");
        Customer.searchCustomer(Flow5_AddCustomer.CustomerID01R);
        Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
    }

    @Test(priority = 2)
    public void EditResidentialService() throws InterruptedException {
        extent.startTest(" Edit Retail Electricity Service for  Residential Customer ");
        test.setDescription(" Verify that User is able to edit Retail Electricity Service for  Residential Customer. ");
        Flow6_7AddingServiceAndMeter.X_AddService.EditService();
    }

    @Test(priority = 3)
    public void AddMeter_MeterRegisterR() throws InterruptedException {
        extent.startTest(" AddMeter and MRegister  for  service ");
        test.setDescription(" Verify that User is able to add Service. ");
        Metering metering = new Metering();
        metering.AddMeter();
        metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");


    }

    @Test(priority = 4)
    public void AddBusinessService() throws InterruptedException {
        extent.startTest(" Add and edit Retail Electricity Service for  Business Customer  ");
        test.setDescription(" Verify that User is able to add SecondService. ");
        Customer.searchCustomer(Flow5_AddCustomer.CustomerID02B);
        Flow6_7AddingServiceAndMeter.X_AddService.AddSecondService();
        Flow6_7AddingServiceAndMeter.X_AddService.EditSecondService();
        Metering metering = new Metering();
        metering.AddMeter();
        metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");

    }


    @Test(priority = 5)
    public void AddCommercialService() throws InterruptedException {
        extent.startTest(" Add and edit Retail Electricity Service for  Commercial Customer  ");
        test.setDescription(" Verify that User is able to add ThirdService ");
        Customer.searchCustomer(Flow5_AddCustomer.CustomerID03C);
        Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
        Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();
       // Metering metering = new Metering();
     //   metering.AddMeter();
     //   metering.createRegister();

    }
    @Test(priority = 6)
    public void addSitePlans() throws InterruptedException {
        extent.startTest(" Add Site Plans ");
        test.setDescription(" Verify that User is able to add  site plans ");
        AddSitePlans.addSitePlan();

    }

    @Test(priority = 7)
    public void addSiteParameters() throws InterruptedException {
        extent.startTest(" Add Site Parameters ");
        test.setDescription(" Verify that User is able to add  site Paramaters ");
        AddSitePlans.addSiteParameters();

    }

}

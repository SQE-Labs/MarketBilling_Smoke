package TestCases;

import CommonMethods.BaseTest;
import POM.AddSitePlans;
import POM.Customer;
import POM.Flow6_7AddingServiceAndMeter;
import POM.Metering;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import static POM.Flow5_AddCustomer.*;

public class TestAddService extends BaseTest {

    @AfterMethod
    public void pageRefresh() {
        driver.navigate().refresh();
    }

    @Test(priority = 1)
    public void AddResidentialService() throws InterruptedException {
        extentTest = extent.startTest("Retail Electricity Service for  Residential Customer ");
        extentTest.setDescription(" Verify that User is able to add Residential Service. ");
        Customer.searchCustomer(CustomerID01R);
        Flow6_7AddingServiceAndMeter.X_AddService.M_AddService();
    }

    @Test(priority = 2)
    public void EditResidentialService() throws InterruptedException {
        extentTest = extent.startTest(" Edit Retail Electricity Service for  Residential Customer ");
        extentTest.setDescription(" Verify that User is able to edit Retail Electricity Service for  Residential Customer. ");
        Flow6_7AddingServiceAndMeter.X_AddService.EditService();
    }

    @Test(priority = 3)
    public void AddMeter_MeterRegisterR() throws InterruptedException {
        extentTest = extent.startTest(" AddMeter and MRegister  for  service ");
        extentTest.setDescription(" Verify that User is able to add Service. ");
        Metering metering = new Metering();
        metering.AddMeter();
        metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");


    }

    @Test(priority = 4)
    public void AddBusinessService() throws InterruptedException {
        extentTest = extent.startTest(" Add and edit Retail Electricity Service for  Business Customer  ");
        extentTest.setDescription(" Verify that User is able to add SecondService. ");
        Customer.searchCustomer(CustomerID02B);
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
        extentTest = extent.startTest(" Add and edit Retail Electricity Service for  Commercial Customer  ");
        extentTest.setDescription(" Verify that User is able to add ThirdService ");
        Customer.searchCustomer(CustomerID03C);
        Flow6_7AddingServiceAndMeter.X_AddService.AddThirdService();
        Flow6_7AddingServiceAndMeter.X_AddService.EditThirdService();
       // Metering metering = new Metering();
     //   metering.AddMeter();
     //   metering.createRegister();

    }
    @Test(priority = 6)
    public void addSitePlans() throws InterruptedException {
        extentTest = extent.startTest(" Add Site Plans ");
        extentTest.setDescription(" Verify that User is able to add  site plans ");
        AddSitePlans.addSitePlan();

    }

    @Test(priority = 7)
    public void addSiteParameters() throws InterruptedException {
        extentTest = extent.startTest(" Add Site Parameters ");
        extentTest.setDescription(" Verify that User is able to add  site Paramaters ");
        AddSitePlans.addSiteParameters();

    }

}

package TestClasses;

import CommonMethods.RandomStrings;
import POM.*;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSingleCustomerBillRun extends BaseTest {
    String customerId;
    String serviceId;
    String meterId;
    String registerId;
    String billCycleName;
    String invoiceTemplate;

    @Test(priority = 1,enabled = true)
    public  void CreateCustomer_For_BillrunCycle() throws InterruptedException {
        extent.startTest(" Create Customer for bill run with 1 customer ");
        test.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        customerId =Customer.createCustomer("Tenant", "Residential", "residential123@yopmail.com");
         serviceId=Services.M_AddService(customerId);
         Services.EditService();
         meterId =Metering.AddMeter();
         registerId =Metering.createRegister();
        Metering.addMeterReads("Initial","150","200","300");
        Metering.addMeterReads("Actual Read","200","400","650");


    }
    @Test(priority = 2)

    public  void create_Customer_invoiceTemplate() throws InterruptedException {
        extent.startTest("Customer Invoice Template");
        test.setDescription(" Verify that User is able to create Customer Invoice template");
        Login login = new Login();
        login.validLogin();
        Admin.navigateToInvoiceSetup();
        invoiceTemplate="Customer_Invoice_"+ RandomStrings.RequiredCharacters(4);
        Invoice.createNewInvoice(invoiceTemplate);
    }
    @Test(priority = 3)

    public  void customer_InvoiceSettings() throws InterruptedException {
        extent.startTest("Customer Invoice Settings");
        test.setDescription(" Verify that User is able to update Customer Invoice Settings");
        customerId="41130";
        Settings settings=Customer.navigateTo_CustomerSettings(  customerId);
        settings.invoiceSettings_Customer(invoiceTemplate);
        settings.clickSave();
    }
    @Test(priority = 4,enabled = true)
    public  void createAndEditBillCycleName() throws InterruptedException {
        extent.startTest(" Small Cycle Bill run with 1 customer ");
        test.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        //String customerId="40893";
        List<String > customer= new ArrayList<String>();
        customer.add(customerId);
        String billCycleOldName =BillRun.createBillCycle(customer);
        billCycleName =BillRun.editBillCycle(billCycleOldName);

    }
    @Test(priority = 5,enabled = true)
    public  void SmallBillRunWithSingleCustomer() throws InterruptedException {
        extent.startTest(" Small Cycle Bill run with 1 customer ");
        test.setDescription(" Verify that User is able to run the small bill run with 1 customer ");
        BillRun.runBillCycle(billCycleName);
    }

    @Test(priority = 6)

    public  void Rollback_SmallBillRunWithSingleCustomer() throws InterruptedException {
        extent.startTest(" Rollback for single customer ");
        test.setDescription(" Verify that User is able to run rollback single customer ");
        BillRun.Rollback_SmallBillRunWithSingleCustomer(customerId);
    }
    @Test(priority = 7)

    public  void rebill_and_Reuse() throws InterruptedException {
        extent.startTest(" Rebill and Reuse Statement ");
        test.setDescription(" Verify that User is able to run rebill and reuse and Statement");
        BillRun.rebillSingleCustomer(  billCycleName);
    }
    @Test(priority = 8)

    public  void emailBills() throws InterruptedException {
        extent.startTest(" Send Email ");
        test.setDescription(" Verify that User is able to send emails");

         BillRun.billRunCycleSearch(billCycleName);
        BillRun.viewBillDetails( );
        BillRun.selectCustCheckBox();
        BillRun.clickEmailBills();
        BillRun.clickSelectedCustomers();
        BillRun.clickContinueEmail();
        BillRun.verifyEmailResults();
        BillRun.clickClose();
    }
    @Test(priority = 8)

    public  void downloadPdf() throws InterruptedException {
        extent.startTest(" Download Pdf ");
        test.setDescription(" Verify that User is able to download pdf");
        BillRun.billRunCycleSearch(billCycleName);
        BillRun.viewBillDetails( );
        BillRun.selectCustCheckBox();
        BillRun.clickDownloadPdf();
        BillRun.clickSelectedCustomer();
        BillRun.clickDownload_Popup();

    }

}

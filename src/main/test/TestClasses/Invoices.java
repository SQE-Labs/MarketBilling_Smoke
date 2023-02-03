package TestClasses;

import CommonMethods.RandomStrings;
import POM.Admin;
import POM.GroupEdit;
import POM.Invoice;
import org.automation.base.BaseTest;
import org.testng.annotations.Test;

public class Invoices extends BaseTest {
    String invoiceName;
    @Test(priority = 1)
    public  void createInvoice_template() throws InterruptedException {
        extent.startTest("create Invoice Template ");
        test.setDescription(" Verify that User is able to create Invoice Template. ");
        Admin.navigateToInvoiceSetup();
        Invoice.clickCreateNewInvoice();
        invoiceName="Invoice"+ RandomStrings.RequiredDigits(3);
        Invoice.enterNewInvoice(invoiceName);
        Invoice.selectInvoiceCheckBox("TRANSACTION-SUMMARY");
        Invoice.selectInvoiceCheckBox("TRANSACTION-SUMMARY-LIST");
        Invoice.clickSave();
        Invoice.selectCategory("TRANSACTION-SUMMARY-LIST");
        Invoice.enterTemplateText("Sample template text");
        Invoice.clickSaveTemplate();

    }
    @Test(priority = 1)
    public  void editInvoice_template() throws InterruptedException {
        extent.startTest("edit Invoice Template ");
        test.setDescription(" Verify that User is able to edit Invoice Template. ");
        Admin.navigateToInvoiceSetup();
        Invoice.searchInvoice(invoiceName);
        Invoice.editInvoice();
        Invoice.selectInvoiceCheckBox("TRANSACTION-SUMMARY");
        Invoice.selectInvoiceCheckBox("TRANSACTION-SUMMARY-LIST");
        Invoice.selectInvoiceCheckBox("BILLPAY");
        Invoice.clickSave();
        Invoice.selectCategory("TRANSACTION-SUMMARY-LIST");
        Invoice.enterTemplateText("Sample  edited template text");
        Invoice.clickSaveTemplate();

    }
    @Test(priority = 3)
    public void invoice_Settings() throws Exception {
        extent.startTest("Invoice Settings ");
        test.setDescription(" Verify that User is able to edit Invoice settings in Group Edit ");

        invoiceName="Invoice041";
        Admin.navigateToGroupEdit();
        GroupEdit.selectPrimaryInvoiceTemplate(invoiceName);
        GroupEdit.selectSecondaryInvoiceTemplate(invoiceName);
        GroupEdit.clickSave();
        GroupEdit.validateSuccessTxt();
    }

}

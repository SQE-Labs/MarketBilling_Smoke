package TestCases;

import CommonMethods.BaseTest;
import POM.Customer;
import POM.ManageServiceNumber;
import POM.Transactions;
import org.testng.annotations.Test;

public class TransactionsTest  extends BaseTest {
    @Test(priority = 1)
    public  void cashPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Cash ");
        extentTest.setDescription(" Verify that User is able to pay usinhg Card pay method");
        Customer.searchAndNavigateToRecentCustomer();
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Cash","1201");
    }
    @Test(priority = 2)
    public  void creditCardPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Credit card ");
        extentTest.setDescription(" Verify that User is able to pay usinhg credit pay method");
        Customer.searchAndNavigateToRecentCustomer();
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Credit Card","12199.06");

    }

}

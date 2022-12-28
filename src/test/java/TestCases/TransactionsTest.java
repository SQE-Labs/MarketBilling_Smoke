package TestCases;

import POM.ManageServiceNumber;
import POM.Transactions;
import org.testng.annotations.Test;

public class TransactionsTest  extends  TestLogin{
    @Test(priority = 1)
    public static void cashPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Cash ");
        extentTest.setDescription(" Verify that User is able to pay usinhg Card pay method");
        ManageServiceNumber.clickTxnTab();
        Transactions.addPaymentDetails("Payment","Cash","1201");
    }
    @Test(priority = 2)
    public static void creditCardPayment() throws InterruptedException {
        extentTest = extent.startTest(" Transaction for payment type Cash ");
        extentTest.setDescription(" Verify that User is able to pay usinhg Card pay method");
        ManageServiceNumber.clickTxnTab();

        Transactions.addPaymentDetails("Payment","Credit Card","12199.06");

    }

}

package POM;

import CommonMethods.WebDriverWaits;
import TestCases.TestLogin;
import org.openqa.selenium.By;

public class Transactions  extends TestLogin {

    public static By transactionType = By.id("tranType");
    public static By paymentMethod = By.id("tranSubType");

    public static By amount = By.id("amount");
    public static By activeDate = By.cssSelector(".active.day");

    public static By transactionDate = By.id("tranDate");
    public static By comments = By.id("comment");
    public static By makePayment = By.id("submitBtn");
    public static By viewHistory = By.id("historyRow");
    public static By ok = By.xpath("//*[contains(text(),'OK')]");
    public static By cancel = By.xpath("//*[contains(text(),'Cancel')]");
    public static By allowDupes = By.name("allowDupes");


    public static void addPaymentDetails(String trxnType, String payMethod, String amt) throws InterruptedException {
        WebDriverWaits.selectByVisibleText(transactionType, trxnType);
        WebDriverWaits.selectByVisibleText(paymentMethod, payMethod);
        WebDriverWaits.SendKeys(amount, amt);
        WebDriverWaits.ClickOn(transactionDate);
        WebDriverWaits.ClickOn(activeDate);
        WebDriverWaits.ClickOn(allowDupes);
        WebDriverWaits.SendKeys(comments, trxnType + " " + payMethod);
        WebDriverWaits.ClickOn(makePayment);
        try {
            WebDriverWaits.ClickOn(ok);

        } catch (Exception e) {

        }
    }
}

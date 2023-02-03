package POM;

import BrowsersBase.DataInterface;
import CommonMethods.WebDriverWaits;
import org.automation.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class AdminGroup extends BasePage {
	public static JavascriptExecutor jse = (JavascriptExecutor) driver;
	public static By Admin_Tab = By.xpath("//a[@title='Administration']/i");
		public static By EditGroup_SubTab = By.xpath("//*[contains(text(),'Edit Group')]");
		public static By MinimumDaystoBill = By.xpath("//*[@id='minDaysToBill']");
		public static By DueDatebyPaymentTerms_ToggleButton = By.xpath("(//label[text()='Due Date by Payment Terms']/following::span)[1]");
		public static By ToggleButton_opn1_Commercial = By.xpath("(//*[@name='ptCategory'])[1]");
		public static By ToggleButton_opn2_Residential = By.xpath("(//*[@name='ptCategory'])[2]");
		public static By ToggleButton_opn3_Business = By.xpath("(//*[@name='ptCategory'])[3]");
		public static By g_payment_term_method = By.id("g_payment_term_method");

		public static By PaymentTermNumberofDays_Field = By.xpath("//*[@name='g_term_days']");
		public static By SaveChanges_Button = By.xpath("//*[@id='saveChangesBtn']");
		public static By Save_Button = By.xpath("//button[contains(text(),'Save')]");
		public static By EditGroupSuccessMsg = By.xpath("//div[@class='alert alert-success']");

		public static void M_EnableDueDate(String paymentMethod) throws InterruptedException {
			SoftAssert softAssert = new SoftAssert();
			getDriver().get(DataInterface.URL);
			WebDriverWaits.ClickOn(Admin_Tab);
			WebDriverWaits.ClickOn(EditGroup_SubTab);
			jse.executeScript("window.scrollBy(0,2400)", "");
			if ( getDriver().findElement(By.id("payTermOption")).getAttribute("style").contains("none")){
				WebDriverWaits.ClickOn(DueDatebyPaymentTerms_ToggleButton);

			}
			WebDriverWaits.selectCheckBox(ToggleButton_opn1_Commercial);
			WebDriverWaits.selectCheckBox(ToggleButton_opn2_Residential);
			WebDriverWaits.selectCheckBox(ToggleButton_opn3_Business);
			jse.executeScript("window.scrollBy(0,100)", "");
			WebDriverWaits.selectByVisibleText(g_payment_term_method,paymentMethod);
			if(paymentMethod!="End of month"){
				WebElement Field = WebDriverWaits.WaitUntilVisibleWE(PaymentTermNumberofDays_Field);
				Field.clear();
				WebDriverWaits.SendKeys(PaymentTermNumberofDays_Field, "10");
			}

			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebDriverWaits.ClickOn(SaveChanges_Button);
			WebDriverWaits.ClickOn(Save_Button);
			Thread.sleep(2000);
			// Assert Success! Changes have been updated successfully.
			String ActualMsg = WebDriverWaits.GetText(EditGroupSuccessMsg);
			String ExpectedMsg1 = "Success! Changes have been updated successfully.";
			softAssert.assertEquals(ExpectedMsg1, ActualMsg);
			System.out.println("Changes have been updated successfully as user is able to Enable due date by Payment terms.");
			Thread.sleep(2000);
		}
	}

package CommonMethods;

import BrowsersBase.BrowsersInvoked;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class WebDriverWaits extends BrowsersInvoked{
	   static WebDriverWait wait = new WebDriverWait(driver,10);
       static WebDriverWait wait20 = new WebDriverWait(driver,20);
       static WebDriverWait wait5mins = new WebDriverWait(driver,300);

	   		public static void WaitUntilPresent(By element) {
		    wait.until(ExpectedConditions.presenceOfElementLocated (element)); }
		    
	   		public static void WaitUntilVisible(By element) {
	   	        wait.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	   		
	   		public static void WaitUntilVisible5mins(By element) {
	   			wait5mins.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	
	   		
	   		public static void WaitUntilInvisible(By element) {
	   	        wait.until(ExpectedConditions.invisibilityOf((WebElement) element)); }
	   		
	   		public static WebElement WaitUntilVisibleWE(By element) {
	   	        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	   		   		
	   		public static WebElement WaitUntilVisibleWE20(By element) {
	   	        return wait20.until(ExpectedConditions.visibilityOfElementLocated(element)); }
	   		
	   		public static List <WebElement> WaitUntilVisibleList(By element) {
	   	        return (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element)); }
	   		
		    public static void ClickOn(By element) {
				   try{
					   wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		               wait.until(ExpectedConditions.elementToBeClickable(element));
				   }
				catch(Exception e){

				}
		        WebElement ele = driver.findElement(element);
		        ele.click();
				System.out.println("Clicked On "+element);
			}
		    
		    public static void SendKeys(By element, String value) {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		        WebElement ele = driver.findElement(element);
		        ele.sendKeys(value);}
		    
		    public static void ClickOnWE(WebElement element) {
		        wait.until(ExpectedConditions.elementToBeClickable(element));
		        element.click();}
		    
		    public static void ClickOnWE20(WebElement element) {
		        wait20.until(ExpectedConditions.elementToBeClickable(element));
		        element.click();}
		    
		    public static void ClickAfter5mins(By element) {
		    	wait5mins.until(ExpectedConditions.elementToBeClickable(element));
		        WebElement ele = driver.findElement(element);
		        ele.click();}
			    
		    public static String GetText(By element) {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		        WebElement ele = driver.findElement(element);
		        String text = ele.getText();
		        return text;}
}

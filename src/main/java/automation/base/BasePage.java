package automation.base;


import automation.helpers.ExtentReportClass;
import automation.elements.Element;
import automation.logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class BasePage extends ExtentReportClass {

    private String parentWindow;


    /**
     * Open the specified URL.
     *
     * @param url URL to open
     */
    public void openUrl(String url) {
        Log.info("Open the URL [" + url + "]");
        BaseTest.getDriver().get(url);
    }

    /**
     * Get the URL of the current page.
     *
     * @return page URL
     */
    public String getPageUrl() {
        String currentUrl = BaseTest.getDriver().getCurrentUrl();
        Log.info("Get the Current URL " + currentUrl);

        return currentUrl;
    }

    public boolean verifyConsoleLogs() {
        LogEntries logs = BaseTest.getDriver().manage().logs().get(LogType.BROWSER);
        boolean errors = false;
        for (LogEntry entry : logs) {
            if (entry.getLevel().equals("SEVERE")) {
                System.out.println(entry.getMessage());
                System.out.println(entry.getLevel());

                errors = true;
            }

        }
        return errors;
    }

    /**
     * Get the Title of the current page.
     *
     * @return page title
     */
    public String getPageTitle() {
        Log.info("Get the Current Page Title");
        return BaseTest.getDriver().getTitle();
    }

    /**
     * Refresh the current page.
     */
    public void refreshPage() {
        Log.info("Refresh the browser");
        BaseTest.getDriver().navigate().refresh();
    }

    public void navigateBack() {
        Log.info("Navigate Back the browser");
        BaseTest.getDriver().navigate().back();
    }

    public void navigateForward() {
        Log.info("Navigate Forward the browser");
        BaseTest.getDriver().navigate().forward();
    }
    /**
     * Get the Hash String of the specified file.
     *
     * @param file     file whose hash is needed
     * @param hashType The hash type of the file
     * @return The hash of the specified file
     */

    /**
     * Switch to the newly opened window.
     *
     * @param description description of the new window
     */
    public void switchToWindow(String description) {
        Log.info("Switch to window [" + description + "]");
        parentWindow = BaseTest.getDriver().getWindowHandle();
        for (String windowHandle : BaseTest.getDriver().getWindowHandles())
            if (!windowHandle.equals(parentWindow))
                BaseTest.getDriver().switchTo().window(windowHandle);
    }

    /**
     * Switch to the window containing the specified URL text.
     *
     * @param description description of the new window
     * @param urlText     URL text that the window contains
     */
    public void switchToWindowContainingUrlText(String description, String urlText) {
        Log.info("Switch to window [" + description + "] which contains URL text [" + urlText + "]");
        parentWindow = BaseTest.getDriver().getWindowHandle();
        BaseTest.getDriver().getWindowHandles().stream().map(BaseTest.getDriver().switchTo()::window)
                .filter(driver -> BaseTest.getDriver().getCurrentUrl().contains(urlText)).findFirst()
                .orElseThrow(() -> new NoSuchWindowException(
                        "Unable to find window [" + description + "] which contains URL text [" + urlText + "]"));
    }

    /**
     * Switch to the window containing the specified title.
     *
     * @param description description of the new window
     * @param title       title that the window contains
     */
    public void switchToWindowContainingTitle(String description, String title) {
        Log.info("Switch to window [" + description + "] which contains title [" + title + "]");
        parentWindow = BaseTest.getDriver().getWindowHandle();
        BaseTest.getDriver().getWindowHandles().stream().map(BaseTest.getDriver().switchTo()::window)
                .filter(driver -> BaseTest.getDriver().getTitle().contains(title)).findFirst()
                .orElseThrow(() -> new NoSuchWindowException(
                        "Unable to find window [" + description + "] which contains title [" + title + "]"));
    }

    /**
     * Switch to the Main window.
     *
     * @param description description of the main window
     */
    public void switchToParentWindow(String description) {
        Log.info("Switch to parent window [" + description + "]");
        BaseTest.getDriver().switchTo().window(parentWindow);
    }

    /**
     * Switch to the frame containing the specified element.
     *
     * @param description description of the frame
     * @param element     element of the frame
     */
    public void switchToFrame(Element element) {
        Log.info("Switch to frame [" + element.getDescription() + "]");
        BaseTest.getDriver().switchTo().frame(element.getWebElement());
    }

    /**
     * Switch to the frame containing the specified name or ID.
     *
     * @param description description of the frame
     * @param nameOrId    name or ID of the frame
     */
    public void switchToFrame(String description, String nameOrId) {
        Log.info("Switch to frame [" + description + "]");
        BaseTest.getDriver().switchTo().frame(nameOrId);
    }

    /**
     * Switch to the frame containing the specified index number.
     *
     * @param description description of the frame
     * @param index       index number of the frame
     */
    public void switchToFrame(String description, int index) {
        Log.info("Switch to frame [" + description + "]");
        BaseTest.getDriver().switchTo().frame(index);
    }

    /**
     * Switch to the default window.
     *
     * @param description description of the window
     */
    public void switchToDefaultContent(String description) {
        Log.info("Switch to main window [" + description + "]");
        BaseTest.getDriver().switchTo().defaultContent();
    }

    public void ScrollDownThePage(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
        js.executeScript("window.scrollBy(x, y)", "");
    }

    public void ScrollDownThePageMax(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
        js.executeScript("window.scrollBy(x,y)", "");
    }

    public void ScrollUpThePage(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) BaseTest.getDriver();
        js.executeScript("window.scrollBy(x, y)", "");
    }

    public void scrollIntoView(By element) {
        JavascriptExecutor jse = (JavascriptExecutor) BaseTest.getDriver();
        WebElement ele = BaseTest.getDriver().findElement(element);
        jse.executeScript("arguments[0].scrollIntoView(true);", ele);

    }
}

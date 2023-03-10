package automation.utilities;


import automation.base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Function;


public final class ExplicitWait extends BaseTest {

    private final Wait<WebDriver> wait;
    private long timeout, polling;

    /**
     * Create wait object with default timeout and polling interval.
     */
    public ExplicitWait() {
        timeout = 6;
        polling = 200;
        wait = new WebDriverWait(getDriver(), timeout, polling);
    }

    /**
     * Create wait object with specified timeout and polling interval.
     *
     * @param timeout time to wait
     * @param polling poll interval
     */
    public ExplicitWait(long timeout, long polling) {
        wait = new WebDriverWait(getDriver(), timeout, polling);
    }

    /**
     * Wait until the specified expected condition is met.
     *
     * @param <R>               the output to return
     * @param expectedCondition condition to wait
     * @return output
     */
    public <R> R until(Function<WebDriver, R> expectedCondition) {
        return wait.until(expectedCondition);
    }
}

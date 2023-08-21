package lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresentById(By id, String error_message, long timeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(id)
        );
    }

    public WebElement waitForElementAndClick(By id, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(id, error_message, timeOut);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(By id, String value, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(id, error_message, timeOut);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(By id, String error_message, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(id)
        );
    }

    public WebElement waitForElementAndClear(By by, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(by, error_message, timeOut);
        element.clear();
        return element;
    }

    public void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    public void swipeUpQuick(By by, String error_message, int maxSwiped) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > maxSwiped) {
                return;
            }
            ++already_swiped;
            swipeUp(2000);
        }
    }

    public void swipeElementToLeft(By by, String error_message) {
        TouchAction action = new TouchAction(driver);
        WebElement element = waitForElementPresentById(by, error_message, 15);

        int start_x = element.getLocation().getX();
        int end_x = start_x + element.getSize().width;
        int start_y = element.getLocation().getY();
        int end_y = element.getSize().height + start_y;


        int middle_y = (start_y + end_y) / 2;
        action
                .press(end_x, middle_y)
                .waitAction(200)
                .moveTo(start_x, middle_y)
                .release()
                .perform();
    }

    public int getAmountOfElements(By by) {
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementsNotPresent(By by, String error_message) {
        int amount_of_elements = getAmountOfElements(by);
        if (amount_of_elements > 0) {
            String default_message = "An element " + by.toString() + "supposed to be not present";
            throw new AssertionError(default_message + error_message);
        }
    }

    public String waitForElementAndGetAttribute(By by, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresentById(by, error_message, timeoutInSeconds);
        return element.getText();
    }
}

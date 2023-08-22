package lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.regex.Pattern;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import lib.MyPlatform;

public class MainPageObject {
    protected AppiumDriver driver;

    public MainPageObject(AppiumDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementPresentById(String locator, String error_message, long timeOutSeconds) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClick(String locator, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(locator, error_message, timeOut);
        element.click();
        return element;
    }

    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(locator, error_message, timeOut);
        element.sendKeys(value);
        return element;
    }

    public boolean waitForElementNotPresent(String locator, String error_message, long timeOut) {
        By by = this.getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(by)
        );
    }

    public WebElement waitForElementAndClear(String locator, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(locator, error_message, timeOut);
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

    public void swipeUpTillElementAppear(String locator, String error_message, int max_size) {
        int already_swiped = 0;

        while (!this.isElementLocatedOnTheScreen(locator)) {
            if (already_swiped > max_size) {
                return;
            }
            swipeUp(2000);
            ++already_swiped;
        }
    }

    // есть ли элемент на странице или нет
    public boolean isElementLocatedOnTheScreen(String locator) {
        int element_location_by_y = waitForElementPresentById(locator, "cannot find element by locator", 15).getLocation().getY();
        // длина всего экрана
        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return screen_size_by_y < screen_size_by_y;
    }


    public void swipeUpQuick(String locator, String error_message, int maxSwiped) {
        By by = this.getLocatorByString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > maxSwiped) {
                return;
            }
            ++already_swiped;
            swipeUp(2000);
        }
    }

    public void swipeElementToLeft(String locator, String error_message) {
        TouchAction action = new TouchAction(driver);
        WebElement element = waitForElementPresentById(locator, error_message, 15);

        int start_x = element.getLocation().getX();
        int end_x = start_x + element.getSize().width;
        int start_y = element.getLocation().getY();
        int end_y = element.getSize().height + start_y;


        int middle_y = (start_y + end_y) / 2;
        action.press(end_x, middle_y);
        action.waitAction(200);
        action.moveTo(start_x, middle_y);


        if (MyPlatform.getInstance().isAndroid()) {
            action.moveTo(start_x, middle_y);
            // в айфонах когда делаем свайп не до какой то определенной точки нужно делать смещение, на опр ширину от этой точки
        } else {
            int offset_x = -(element.getSize().getWidth());
            action.moveTo(offset_x, 0);
        }
        action.release();
        action.perform();
    }

    public int getAmountOfElements(String locator) {
        By by = this.getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    public void assertElementsNotPresent(String locator, String error_message) {
        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0) {
            String default_message = "An element " + locator.toString() + "supposed to be not present";
            throw new AssertionError(default_message + error_message);
        }
    }

    public String waitForElementAndGetAttribute(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresentById(locator, error_message, timeoutInSeconds);
        return element.getText();
    }

    private By getLocatorByString(String locator_with_type) {
        String[] exploded_locator = locator_with_type.split(Pattern.quote(":"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];

        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator" + locator_with_type);
        }
    }
}

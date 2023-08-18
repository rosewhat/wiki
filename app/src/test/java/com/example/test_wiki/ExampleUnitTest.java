package com.example.test_wiki;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    private AppiumDriver driver;
    private static String AppiumURL = "http://127.0.0.1:4723/wd/hub";
    private String XPATH_ONBOARDING_CLICK_BUTTON = "//*[@resource-id='android:id/button1']";
    private String XPATH_FIND_SEARCH_WIKIPEDIA = "//*[contains(@text, 'Search Wikipedia')]";
    private String BY_FIND_IN_TEXT_EDIT_SEARCH = "org.wikipedia:id/search_src_text";
    private String BY_FIND_AND_CLOSE = "org.wikipedia:id/search_close_btn";
    private String BY_FIND_TITLE_AND_CLICK = "org.wikipedia:id/view_featured_article_card_article_title";
    private String XPATH_FIND_TO_SWIPE_TITLE = "//*[@resource-id='org.wikipedia:id/view_featured_article_card_article_title'][contains(@text, 'Doc Savage (magazine)')]";
    private String BY_CLICK_IMAGE_SAVE = "org.wikipedia:id/view_card_action_footer_button_icon";
    private String BY_CLICK_BUTTON_GOT_IT = "org.wikipedia:id/onboarding_button";
    private String BY_FIND_AND_WRITE_NAME_LIST = "org.wikipedia:id/text_input";
    private String BY_FIND_AND_CLICK_SAVE_LIST_OK = "android:id/button1";
    private String XPATH_FIND_NAVIGATION_LIST = "//android.widget.FrameLayout[@content-desc='My lists']";
    private String BY_FIND_CONTAINER_LIST = "org.wikipedia:id/item_container";
    private String BY_FIND_LIST_ITEM_CONTAINER = "org.wikipedia:id/page_list_item_title";
    private String XPATH_FIND_LIST_ITEM_CONTAINER_TITLE = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";


    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "14");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "/home/moskovsky/AndroidStudioProjects/test_wiki/app/apks/org.wikipedia.apk");
        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testDrive() {
        // Пропускаем первый диалог на кнопку OK
        WebElement dialog_ok = waitForElementAndClick(
                By.xpath(XPATH_ONBOARDING_CLICK_BUTTON),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );
        // Находим строчку Search Wikipedia
        WebElement element_to_init_search = waitForElementAndClick(
                By.xpath(XPATH_FIND_SEARCH_WIKIPEDIA),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );

        // Вписываем в editText
        WebElement element_to_enter_search_line = waitForElementAndSendKeys(
                By.id(BY_FIND_IN_TEXT_EDIT_SEARCH),
                "Java",
                "Не нашел кнопку ОК в диалоговом окне",
                15
        );

        // очищаем editText
        waitForElementAndClear(
                By.id(BY_FIND_IN_TEXT_EDIT_SEARCH),
                "Не смог очистить нашу строку из Search",
                15
        );
    }

    @Test
    public void testCanselSearch() {
        // Пропускаем первый диалог на кнопку OK
        WebElement dialog_ok = waitForElementAndClick(
                By.xpath(XPATH_ONBOARDING_CLICK_BUTTON),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );

        // Находим строчку Search Wikipedia
        WebElement element_to_init_search = waitForElementAndClick(
                By.xpath(XPATH_FIND_SEARCH_WIKIPEDIA),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );

        // Закрываем search по кнопке крестик
        WebElement element_to_close_search = waitForElementAndClick(
                By.id(BY_FIND_AND_CLOSE),
                "Не смог нажать на кнопку закрыть search",
                15
        );

        // Проверяем, что кнопка крестик пропала, при возвращении на главный экран
        waitForElementNotPresent(
                By.id(BY_FIND_AND_CLOSE),
                "Наша кнопка не исчезла",
                15
        );
    }

    @Test
    public void testSwipeArticle() {
        // Пропускаем первый диалог на кнопку OK
        WebElement dialog_ok = waitForElementAndClick(
                By.xpath(XPATH_ONBOARDING_CLICK_BUTTON),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );
        swipeUpQuick(By.xpath(XPATH_FIND_TO_SWIPE_TITLE),
                "На свайпе недокрутил до title",
                15);
    }

    @Test
    public void saveNewElementInList() {
        // Пропускаем первый диалог на кнопку OK
        WebElement dialog_ok = waitForElementAndClick(
                By.xpath(XPATH_ONBOARDING_CLICK_BUTTON),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );
        swipeUpQuick(By.id(BY_CLICK_IMAGE_SAVE),
                "На свайпе недокрутил до кнопки Save",
                15);

        // кнопка на главном экране save под статьей
        waitForElementAndClick(
                By.id(BY_CLICK_IMAGE_SAVE),
                "Не нашел картинку сохранить на главном экране",
                15
        );

        waitForElementAndClick(
                By.id(BY_CLICK_BUTTON_GOT_IT),
                "Не нашел кнопку GOT IT",
                15
        );
        // Записать имя для нового списка
        waitForElementAndSendKeys(
                By.id(BY_FIND_AND_WRITE_NAME_LIST),
                "Test",
                "Не смог найти поле для ввода для создания нового листа",
                15
        );

        // Найти кнопку OK
        waitForElementAndClick(
                By.id(BY_FIND_AND_CLICK_SAVE_LIST_OK),
                "Не нашел кнопку OK для сохранения списка",
                15
        );

        // Перейти по 2 вкладке в navigationBar

        waitForElementAndClick(
                By.xpath(XPATH_FIND_NAVIGATION_LIST),
                "Не нашел в Navigation 2 вкладку",
                15
        );
        // кликает по созданному списку с понрав статьями
        waitForElementAndClick(
                By.id(BY_FIND_CONTAINER_LIST),
                "Не кликнул на контейнер со списками",
                15
        );
        // Свайп для удаления от элемента
        swipeElementToLeft(By.id(BY_FIND_LIST_ITEM_CONTAINER),
                "Не смог свайпнуть для удаления");

        // Проверка на то, что элемент удалился
        waitForElementNotPresent(By.xpath(XPATH_FIND_LIST_ITEM_CONTAINER_TITLE),
                "Элемент не удалился",
                2000);
    }

    @Test
    public void testCompareArticleTitle() {
        // Пропускаем первый диалог на кнопку OK
        WebElement dialog_ok = waitForElementAndClick(
                By.xpath(XPATH_ONBOARDING_CLICK_BUTTON),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );

        // Находим строчку Search Wikipedia
        WebElement element_to_init_search = waitForElementAndClick(
                By.xpath(XPATH_FIND_SEARCH_WIKIPEDIA),
                "Не нашел кнопку ОК в диалоговом окне",
                15

        );

        // Закрываем search по кнопке крестик
        WebElement element_to_close_search = waitForElementAndClick(
                By.id(BY_FIND_AND_CLOSE),
                "Не смог нажать на кнопку закрыть search",
                15
        );

        // Проверяем, что кнопка крестик пропала, при возвращении на главный экран
        waitForElementNotPresent(
                By.id(BY_FIND_AND_CLOSE),
                "Наша кнопка не исчезла",
                15
        );

        // Находим статью из главного экрана
        WebElement titleElement = waitForElementPresentById(
                By.id(BY_FIND_TITLE_AND_CLICK),
                "Заголовок не найден",
                15
        );
        String titleAtribute = titleElement.getAttribute("clickable");
        Assert.assertEquals("Не получилось сравнить",
                "false",
                titleAtribute
        );
    }

    private WebElement waitForElementPresentById(By id, String error_message, long timeOutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutSeconds);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.presenceOfElementLocated(id)
        );
    }


    private WebElement waitForElementAndClick(By id, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(id, error_message, timeOut);
        element.click();
        return element;
    }

    private WebElement waitForElementAndSendKeys(By id, String value, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(id, error_message, timeOut);
        element.sendKeys(value);
        return element;
    }

    private boolean waitForElementNotPresent(By id, String error_message, long timeOut) {
        WebDriverWait wait = new WebDriverWait(driver, timeOut);
        wait.withMessage(error_message + "\n");
        return wait.until(
                ExpectedConditions.invisibilityOfElementLocated(id)
        );
    }

    private WebElement waitForElementAndClear(By by, String error_message, long timeOut) {
        WebElement element = waitForElementPresentById(by, error_message, timeOut);
        element.clear();
        return element;
    }

    private void swipeUp(int timeOfSwipe) {
        TouchAction action = new TouchAction(driver);
        Dimension size = driver.manage().window().getSize();
        int x = size.width / 2;
        int start_y = (int) (size.height * 0.8);
        int end_y = (int) (size.height * 0.2);
        action.press(x, start_y).waitAction(timeOfSwipe).moveTo(x, end_y).release().perform();
    }

    private void swipeUpQuick(By by, String error_message, int maxSwiped) {
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {
            if (already_swiped > maxSwiped) {
                return;
            }
            ++already_swiped;
            swipeUp(2000);
        }
    }

    protected void swipeElementToLeft(By by, String error_message) {
        TouchAction action = new TouchAction(driver);
        WebElement element = waitForElementPresentById(by, error_message, 15);

        int start_x = element.getLocation().getX();
        int end_x = start_x + element.getSize().width;
        int start_y = element.getLocation().getY();
        int end_y = element.getSize().height + start_y;


        int middle_y = (start_y + end_y) / 2;
        action
                .press(end_x, middle_y)
                .waitAction(2000)
                .moveTo(start_x, middle_y)
                .release()
                .perform();
    }
}
package lib.ui;


import static lib.ui.DefaultParams.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class SearchPageObject extends MainPageObject {
    private static final String XPATH_FIND_SEARCH_WIKIPEDIA = "//*[contains(@text, 'Search Wikipedia')]";
    private static final String BY_FIND_IN_TEXT_EDIT_SEARCH = "org.wikipedia:id/search_src_text";
    private static final String BY_FIND_AND_CLOSE = "org.wikipedia:id/search_close_btn";
    // template
    private static final String XPATH_FIND_SEARCH_RESULT_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_description'][contains(@text, '{SUBSTRING}')]";
    private String XPATH_FIND_RESULT_SEARCH_LIST = "//*[@resource-id='org.wikipedia:id/fragment_search_results']/*[@resource-id='org.wikipedia:id/search_results_container']";


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    private static String getResultSearchElement(String substring) {
        return XPATH_FIND_SEARCH_RESULT_TPL.replace("{SUBSTRING}", substring);
    }

    /**
     * Находим строчку Search Line
     */
    public void initSearchInput() {
        waitForElementAndClick(
                By.xpath(XPATH_FIND_SEARCH_WIKIPEDIA),
                getDefaultErrorMessageFindElements("Search Line"),
                getDefaultWaitForElement
        );
    }

    /**
     * Вписываем в Search текст
     */
    public void typeSearchLine(String search_line) {
        waitForElementAndSendKeys(
                By.id(BY_FIND_IN_TEXT_EDIT_SEARCH),
                search_line,
                getDefaultErrorMessageSendKeys(search_line),
                getDefaultWaitForElement
        );
    }

    /**
     * Тут будем получать результат, есть ли что - то после получение списка с результатми от Search
     */
    public void waitForSearchResult(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        waitForElementPresentById(
                By.xpath(search_result_xpath),
                getDefaultErrorMessageFindElements("результат строки" + substring),
                getDefaultWaitForElement
        );
    }

    /**
     * Находим кнопку закрыть Close btn
     */
    public void waitForCanselButtonToAppear() {
        waitForElementAndClick(
                By.id(BY_FIND_AND_CLOSE),
                getDefaultErrorMessageFindElements("Кнопку закрыть в Toolbar"),
                15
        );
    }

    /**
     * Проверяем, что такое кнопка закрыть пропала
     */
    public void waitForCanselButtonToDisappear() {
        waitForElementNotPresent(
                By.id(BY_FIND_AND_CLOSE),
                "Наша кнопка не исчезла",
                15
        );
    }

    public int getAmountGetArticles() {
        return getAmountOfElements(
                By.xpath(XPATH_FIND_RESULT_SEARCH_LIST)
        );
    }

    public void simpleSwipeUp() {
        swipeUp(2000);
    }

}

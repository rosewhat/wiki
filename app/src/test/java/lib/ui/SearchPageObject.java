package lib.ui;


import static lib.ui.DefaultParams.*;


import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;

abstract public class SearchPageObject extends MainPageObject {
    protected static String
            XPATH_FIND_SEARCH_WIKIPEDIA,
            BY_FIND_IN_TEXT_EDIT_SEARCH,
            BY_FIND_AND_CLOSE,
            // template
            XPATH_FIND_SEARCH_RESULT_TPL,
            XPATH_FIND_RESULT_SEARCH_LIST;


    public SearchPageObject(RemoteWebDriver driver) {
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
                XPATH_FIND_SEARCH_WIKIPEDIA,
                getDefaultErrorMessageFindElements("Search Line"),
                getDefaultWaitForElement
        );
    }

    /**
     * Вписываем в Search текст
     */
    public void typeSearchLine(String search_line) {
        waitForElementAndSendKeys(
                BY_FIND_IN_TEXT_EDIT_SEARCH,
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
                search_result_xpath,
                getDefaultErrorMessageFindElements("результат строки" + substring),
                getDefaultWaitForElement
        );
    }

    /**
     * Находим кнопку закрыть Close btn
     */
    public void waitForCanselButtonToAppear() {
        waitForElementAndClick(
                BY_FIND_AND_CLOSE,
                getDefaultErrorMessageFindElements("Кнопку закрыть в Toolbar"),
                15
        );
    }

    /**
     * Проверяем, что такое кнопка закрыть пропала
     */
    public void waitForCanselButtonToDisappear() {
        waitForElementNotPresent(
                BY_FIND_AND_CLOSE,
                "Наша кнопка не исчезла",
                15
        );
    }

    public int getAmountGetArticles() {
        return getAmountOfElements(
                XPATH_FIND_RESULT_SEARCH_LIST
        );
    }

    public void simpleSwipeUp() {
        swipeUp(2000);
    }

}

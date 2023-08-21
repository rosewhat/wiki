package lib.ui;

import org.openqa.selenium.By;

import static lib.ui.DefaultParams.*;


import io.appium.java_client.AppiumDriver;

public class MyLists extends MainPageObject {
    private static String BY_FIND_CONTAINER_LIST = "org.wikipedia:id/item_container";
    private static String BY_FIND_LIST_ITEM_CONTAINER = "org.wikipedia:id/page_list_item_title";
    private static String XPATH_FIND_LIST_ITEM_CONTAINER_TITLE = "//*[@resource-id='org.wikipedia:id/page_list_item_title']";

    public MyLists(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName() {
        waitForElementAndClick(
                By.id(BY_FIND_CONTAINER_LIST),
                getDefaultErrorMessageFindElements("контейнер со списками"),
                getDefaultWaitForElement
        );
    }

    public void swipeByArticleToDelete() {
        swipeElementToLeft(By.id(BY_FIND_LIST_ITEM_CONTAINER),
                getDefaultErrorMessageSwipeToElement("для удаления"));
    }

    public void assertDeleteElementInList() {
        waitForElementNotPresent(By.xpath(XPATH_FIND_LIST_ITEM_CONTAINER_TITLE),
                "Элемент не удалился",
                2000);
    }

}

package lib.ui;

import static lib.ui.DefaultParams.*;


import io.appium.java_client.AppiumDriver;

abstract public class MyListsPageObject extends MainPageObject {
    protected static String
            BY_FIND_CONTAINER_LIST = "id:org.wikipedia:id/item_container",
            BY_FIND_LIST_ITEM_CONTAINER = "id:org.wikipedia:id/page_list_item_title",
            XPATH_FIND_LIST_ITEM_CONTAINER_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName() {
        waitForElementAndClick(
                BY_FIND_CONTAINER_LIST,
                getDefaultErrorMessageFindElements("контейнер со списками"),
                getDefaultWaitForElement
        );
    }

    public void swipeByArticleToDelete() {
        swipeElementToLeft(
                BY_FIND_LIST_ITEM_CONTAINER,
                getDefaultErrorMessageSwipeToElement("для удаления"));
    }

    public void assertDeleteElementInList() {
        waitForElementNotPresent(
                XPATH_FIND_LIST_ITEM_CONTAINER_TITLE,
                "Элемент не удалился",
                2000);
    }
}

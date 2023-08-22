package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IosMyListsPageObject extends MyListsPageObject {
    static {
        BY_FIND_CONTAINER_LIST = "id:org.wikipedia:id/item_container";
        BY_FIND_LIST_ITEM_CONTAINER = "id:org.wikipedia:id/page_list_item_title";
        XPATH_FIND_LIST_ITEM_CONTAINER_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";
    }

    public IosMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}

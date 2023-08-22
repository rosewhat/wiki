package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObjectPageObject extends MyListsPageObject {
    static {
        BY_FIND_CONTAINER_LIST = "id:org.wikipedia:id/item_container";
        BY_FIND_LIST_ITEM_CONTAINER = "id:org.wikipedia:id/page_list_item_title";
        XPATH_FIND_LIST_ITEM_CONTAINER_TITLE = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_title']";
    }

    public AndroidMyListsPageObjectPageObject(AppiumDriver driver) {
        super(driver);
    }
}

package lib.ui.ios;

import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import lib.ui.SearchPageObject;

public class IOSSearchPageObject extends SearchPageObject {
    static {
        XPATH_FIND_SEARCH_WIKIPEDIA = "xpath://*[contains(@text, 'Search Wikipedia')]";
        BY_FIND_IN_TEXT_EDIT_SEARCH = "id:org.wikipedia:id/search_src_text";
        BY_FIND_AND_CLOSE = "id:org.wikipedia:id/search_close_btn";
        // template
        XPATH_FIND_SEARCH_RESULT_TPL = "xpath://*[@resource-id='org.wikipedia:id/page_list_item_description'][contains(@text, '{SUBSTRING}')]";
        XPATH_FIND_RESULT_SEARCH_LIST = "xpath://*[@resource-id='org.wikipedia:id/fragment_search_results']/*[@resource-id='org.wikipedia:id/search_results_container']";
    }
    public IOSSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

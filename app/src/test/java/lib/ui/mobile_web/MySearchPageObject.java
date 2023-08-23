package lib.ui.mobile_web;

import org.openqa.selenium.remote.RemoteWebDriver;

import lib.ui.SearchPageObject;

public class MySearchPageObject extends SearchPageObject {
    static {
        XPATH_FIND_SEARCH_WIKIPEDIA = "css://*[contains(@text, 'Search Wikipedia')]";
        BY_FIND_IN_TEXT_EDIT_SEARCH = "css:form>input[type='search']";
        BY_FIND_AND_CLOSE = "css:org.wikipedia:id/search_close_btn";
        // template
        XPATH_FIND_SEARCH_RESULT_TPL = "css://*[@resource-id='org.wikipedia:id/page_list_item_description'][contains(@text, '{SUBSTRING}')]";
        XPATH_FIND_RESULT_SEARCH_LIST = "css://*[@resource-id='org.wikipedia:id/fragment_search_results']/*[@resource-id='org.wikipedia:id/search_results_container']";
    }
    public MySearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}

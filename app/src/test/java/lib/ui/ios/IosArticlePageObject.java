package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.ArticlePageObject;

public class IosArticlePageObject extends ArticlePageObject {

    static {
          XPATH_SWIPE_TO_FIND_TITLE = "xpath://*[@resource-id='org.wikipedia:id/view_featured_article_card_article_title'][contains(@text, 'Xá Lợi Pagoda raids')]";
          BY_SWIPE_TO_CLICK_BUTTON_SAVE = "id:org.wikipedia:id/view_card_action_footer_button_icon";
          BY_CLICK_BUTTON_GOT_IT = "id:org.wikipedia:id/onboarding_button";
          BY_FIND_AND_WRITE_NAME_LIST = "id:org.wikipedia:id/text_input";
          BY_FIND_AND_CLICK_SAVE_LIST_OK = "id:android:id/button1";
    }

    public IosArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}

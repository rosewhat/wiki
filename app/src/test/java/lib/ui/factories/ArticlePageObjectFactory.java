package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.ArticlePageObject;
import lib.ui.android.AndroidArticlePageObject;
import lib.ui.ios.IosArticlePageObject;

public class ArticlePageObjectFactory {
    public static ArticlePageObject get(AppiumDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(appiumDriver);
        } else {
            return new IosArticlePageObject(appiumDriver);
        }
    }
}

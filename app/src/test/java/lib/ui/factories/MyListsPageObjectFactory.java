package lib.ui.factories;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;
import lib.ui.MyListsPageObject;
import lib.ui.android.AndroidMyListsPageObjectPageObject;
import lib.ui.ios.IosMyListsPageObject;

public class MyListsPageObjectFactory {
    public static MyListsPageObject get(AppiumDriver appiumDriver) {
        if (MyPlatform.getInstance().isAndroid()) {
            return new AndroidMyListsPageObjectPageObject(appiumDriver);
        } else {
            return new IosMyListsPageObject(appiumDriver);
        }
    }
}

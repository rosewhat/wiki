package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.WaitOnboardingPageObject;

public class IosWaitOnBoardingPageObject extends WaitOnboardingPageObject {
    static {
        XPATH_SKIP_WIKIPEDIA_ONBOARDING = "xpath://*[@resource-id='android:id/button1'][contains(@text, 'OK')]";
        XPATH_SKIP_NOTIFICATION_SEND = "xpath://*[@resource-id='com.android.permissioncontroller:id/permission_deny_button'][contains(@text, 'Don’t allow')]";
    }
    public IosWaitOnBoardingPageObject(AppiumDriver driver) {
        super(driver);
    }
}

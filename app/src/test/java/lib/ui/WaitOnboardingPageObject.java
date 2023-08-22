package lib.ui;

import static lib.ui.DefaultParams.getDefaultErrorMessageFindElements;
import static lib.ui.DefaultParams.getDefaultWaitForElement;

import io.appium.java_client.AppiumDriver;

abstract public class WaitOnboardingPageObject extends MainPageObject {
    protected static String
            XPATH_SKIP_WIKIPEDIA_ONBOARDING,
            XPATH_SKIP_NOTIFICATION_SEND;

    public WaitOnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void skipWaitOnboarding() {
        // Пропускаем первый диалог на кнопку OK
        waitForElementAndClick(
                XPATH_SKIP_WIKIPEDIA_ONBOARDING,
                getDefaultErrorMessageFindElements("ОК в диалоговом окне"),
                getDefaultWaitForElement
        );

        // Нажимаем на кнопку Don't show для второго диалога с уведомлениями
        waitForElementAndClick(
                XPATH_SKIP_NOTIFICATION_SEND,
                getDefaultErrorMessageFindElements("Don't allow в диалоговом окне"),
                getDefaultWaitForElement
        );
    }

}


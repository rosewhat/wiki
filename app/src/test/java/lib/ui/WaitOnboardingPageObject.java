package lib.ui;

import org.openqa.selenium.By;

import static lib.ui.DefaultParams.*;

import io.appium.java_client.AppiumDriver;

public class WaitOnboardingPageObject extends MainPageObject {
    private static String XPATH_SKIP_WIKIPEDIA_ONBOARDING = "//*[@resource-id='android:id/button1'][contains(@text, 'OK')]";
    private static String XPATH_SKIP_NOTIFICATION_SEND = "//*[@resource-id='com.android.permissioncontroller:id/permission_deny_button'][contains(@text, 'Don’t allow')]";

    public WaitOnboardingPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void skipWaitOnboarding() {
        // Пропускаем первый диалог на кнопку OK
        waitForElementAndClick(
                By.xpath(XPATH_SKIP_WIKIPEDIA_ONBOARDING),
                getDefaultErrorMessageFindElements("ОК в диалоговом окне"),
                getDefaultWaitForElement
        );

        // Нажимаем на кнопку Don't show для второго диалога с уведомлениями
        waitForElementAndClick(
                //123
                By.xpath(XPATH_SKIP_NOTIFICATION_SEND),
                getDefaultErrorMessageFindElements("Don't allow в диалоговом окне"),
                getDefaultWaitForElement
        );
    }

}


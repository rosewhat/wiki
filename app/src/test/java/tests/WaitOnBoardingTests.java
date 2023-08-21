package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.ui.WaitOnboardingPageObject;

public class WaitOnBoardingTests extends CoreTestCase {
    private WaitOnboardingPageObject waitOnboardingPageObject;

    @Test
    public void skipOnBoarding() {
        waitOnboardingPageObject = new WaitOnboardingPageObject(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
    }
}

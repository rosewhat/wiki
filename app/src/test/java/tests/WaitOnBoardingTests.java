package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.MyPlatform;
import lib.ui.WaitOnboardingPageObject;
import lib.ui.factories.WaitOnBoardingObjectFactory;

public class WaitOnBoardingTests extends CoreTestCase {
    private WaitOnboardingPageObject waitOnboardingPageObject;

    @Test
    public void testSkipOnBoarding() {
        if (MyPlatform.getInstance().isMW()) {
            return;
        }
        waitOnboardingPageObject = WaitOnBoardingObjectFactory.get(driver);
        waitOnboardingPageObject.skipWaitOnboarding();
    }

    @Test
    public void testExample() {

    }
}

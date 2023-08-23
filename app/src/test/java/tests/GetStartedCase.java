package tests;

import org.junit.Test;

import lib.CoreTestCase;
import lib.MyPlatform;
import lib.ui.WelcomeObject;

public class GetStartedCase  extends CoreTestCase {

    @Test
    public void testPassThroughWelcome() {

        if (MyPlatform.getInstance().isAndroid() || MyPlatform.getInstance().isMW()) {
            return;
        }

        WelcomeObject welcomeObject = new WelcomeObject(driver);
        welcomeObject.waitForLearnMoreLink();
        welcomeObject.clickNextButton();

        welcomeObject.waitForNewWayToExploreText();
        welcomeObject.clickNextButton();

        welcomeObject.waitForAddOrEditPreferredLangText();
        welcomeObject.clickNextButton();

        welcomeObject.waitForLearnMoreAboutDataCollectedText();
        welcomeObject.clickGetStartedButton();
    }
}

package suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import tests.ArticleTests;
import tests.WaitOnBoardingTests;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        ArticleTests.class,
        WaitOnBoardingTests.class
})
public class TestSuite {}

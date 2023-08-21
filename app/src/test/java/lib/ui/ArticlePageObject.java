package lib.ui;

import static lib.ui.DefaultParams.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class ArticlePageObject extends MainPageObject {
    private static String XPATH_SWIPE_TO_FIND_TITLE = "//*[@resource-id='org.wikipedia:id/view_featured_article_card_article_title'][contains(@text, 'Xá Lợi Pagoda raids')]";
    private static String BY_SWIPE_TO_CLICK_BUTTON_SAVE = "org.wikipedia:id/view_card_action_footer_button_icon";
    private static String BY_CLICK_BUTTON_GOT_IT = "org.wikipedia:id/onboarding_button";
    private static String BY_FIND_AND_WRITE_NAME_LIST = "org.wikipedia:id/text_input";
    private static String BY_FIND_AND_CLICK_SAVE_LIST_OK = "android:id/button1";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }


    public WebElement waitForTitleElement() {
        return waitForElementPresentById(
                By.xpath(XPATH_SWIPE_TO_FIND_TITLE),
                getDefaultErrorMessageFindElements("найти заголовок у статьи на главном экране"),
                getDefaultWaitForElement
        );
    }

    public String getArticleTitle() {
        WebElement element = waitForTitleElement();
        return element.getText();
    }

    public void swipeDownToFindElement() {
        swipeUpQuick(By.xpath(XPATH_SWIPE_TO_FIND_TITLE),
                getDefaultErrorMessageSwipeToElement("title"),
                getDefaultWaitForElement);
    }

    public void swipeToButtonSave() {
        swipeUpQuick(By.id(BY_SWIPE_TO_CLICK_BUTTON_SAVE),
                getDefaultErrorMessageSwipeToElement("кнопки Save"),
                getDefaultWaitForElement);

    }

    public void addArticleToMyList() {
        // кнопка на главном экране save под статьей
        waitForElementAndClick(
                By.id(BY_SWIPE_TO_CLICK_BUTTON_SAVE),
                getDefaultErrorMessageFindElements("картинку сохранить на главном экране"),
                getDefaultWaitForElement
        );

        //123
        waitForElementAndClick(
                By.id(BY_CLICK_BUTTON_GOT_IT),
                getDefaultErrorMessageFindElements("кпопку GOT IT"),
                getDefaultWaitForElement
        );
        String name_of_folder = "Test";
        // Записать имя для нового списка
        waitForElementAndSendKeys(
                By.id(BY_FIND_AND_WRITE_NAME_LIST),
                name_of_folder,
                getDefaultErrorMessageFindElements("поле для ввода для создания нового листа"),
                getDefaultWaitForElement
        );
        // Найти кнопку OK
        waitForElementAndClick(
                By.id(BY_FIND_AND_CLICK_SAVE_LIST_OK),
                getDefaultErrorMessageFindElements("OK для сохранения списка"),
                getDefaultWaitForElement
        );
    }
}

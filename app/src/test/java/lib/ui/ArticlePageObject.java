package lib.ui;

import static lib.ui.DefaultParams.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import lib.MyPlatform;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            XPATH_SWIPE_TO_FIND_TITLE,
            BY_SWIPE_TO_CLICK_BUTTON_SAVE,
            BY_CLICK_BUTTON_GOT_IT,
            BY_FIND_AND_WRITE_NAME_LIST,
            BY_FIND_AND_CLICK_SAVE_LIST_OK;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }


    public WebElement waitForTitleElement() {
        return waitForElementPresentById(
                XPATH_SWIPE_TO_FIND_TITLE,
                getDefaultErrorMessageFindElements("найти заголовок у статьи на главном экране"),
                getDefaultWaitForElement
        );
    }

    public String getArticleTitle() {
        WebElement element = waitForTitleElement();
        // тут должна быть разница для android & ios
        if (MyPlatform.getInstance().isAndroid()) {
            return element.getText();
        } else {
            return element.getText();
        }
    }

    public void swipeDownToFindElement() {
        swipeUpQuick(
                XPATH_SWIPE_TO_FIND_TITLE,
                getDefaultErrorMessageSwipeToElement("title"),
                getDefaultWaitForElement);
    }

    public void swipeToButtonSave() {
        swipeUpQuick(
                BY_SWIPE_TO_CLICK_BUTTON_SAVE,
                getDefaultErrorMessageSwipeToElement("кнопки Save"),
                getDefaultWaitForElement);

    }

    public void addArticleToMyList() {
        // кнопка на главном экране save под статьей
        waitForElementAndClick(
                BY_SWIPE_TO_CLICK_BUTTON_SAVE,
                getDefaultErrorMessageFindElements("картинку сохранить на главном экране"),
                getDefaultWaitForElement
        );

        //123
        waitForElementAndClick(
                BY_CLICK_BUTTON_GOT_IT,
                getDefaultErrorMessageFindElements("кпопку GOT IT"),
                getDefaultWaitForElement
        );
        String name_of_folder = "Test";
        // Записать имя для нового списка
        waitForElementAndSendKeys(
                BY_FIND_AND_WRITE_NAME_LIST,
                name_of_folder,
                getDefaultErrorMessageFindElements("поле для ввода для создания нового листа"),
                getDefaultWaitForElement
        );
        // Найти кнопку OK
        waitForElementAndClick(
                BY_FIND_AND_CLICK_SAVE_LIST_OK,
                getDefaultErrorMessageFindElements("OK для сохранения списка"),
                getDefaultWaitForElement
        );
    }
}

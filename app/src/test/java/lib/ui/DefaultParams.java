package lib.ui;

public class DefaultParams {

    public static int getDefaultWaitForElement = 15;

    public static String getDefaultErrorMessageFindElements(String error_message) {
        return String.format("Не смог найти %s", error_message);
    }

    public static String getDefaultErrorMessageSendKeys(String send_value) {
        return String.format("Не смог написать строку %s", send_value);
    }

    public static String getDefaultErrorMessageSwipeToElement(String error_message) {
        return String.format("Не смог докрутить до элемента %s", error_message);
    }
}

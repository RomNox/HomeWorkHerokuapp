package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;

public class FrameHelper extends BasePage {

    public FrameHelper(WebDriver driver) {
        super(driver);
    }

    // Метод для переключения на фрейм по имени или id
    public void switchToFrame(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    // Метод для переключения на фрейм по индексу
    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    // Метод для переключения на родительский фрейм
    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    // Метод для возврата к основному содержимому
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}

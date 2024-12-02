package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class MultipleWindowsPage extends BasePage {
    public MultipleWindowsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

public void clickHere () {
        clickLinkByText("Click here");
}

public void switchToNewWindow() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

    for (String handle : allWindows) {
        if (!handle.equals(mainWindowHandle)) { // Ищем дескриптор, который не равен основному окну
            driver.switchTo().window(handle); // Переключаемся на новое окно
        }
    }
}


}

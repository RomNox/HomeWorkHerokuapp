package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrameHelper extends BasePage {

    public FrameHelper(WebDriver driver) {
        super(driver);
    }

    public void switchToFrame(String frameNameOrId) {
        driver.switchTo().frame(frameNameOrId);
    }

    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
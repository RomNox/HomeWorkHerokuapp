package com.herokuapp.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class AlertHelper extends BasePage{
    private WebDriver driver;

    public AlertHelper(WebDriver driver) {
        super(driver);
    }

    // Метод для принятия Alert
    public String acceptAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    // Метод для отмены Alert
    public String dismissAlert() {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.dismiss();
        return alertText;
    }

    // Метод для отправки текста в Alert и принятия
    public String sendTextToAlertAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
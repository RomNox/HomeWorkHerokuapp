package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Метод для клика по элементу
    public void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Метод для ввода текста в элемент
    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear(); // Очистка поля перед вводом
        element.sendKeys(text);
    }

    // Метод для получения текста элемента
    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Метод для проверки наличия элемента на странице
    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    // Метод для клика по ссылке на странице, используя её текст
    public void clickLinkByText(String linkText) {
        By linkLocator = By.linkText(linkText);
        click(linkLocator);
    }

}

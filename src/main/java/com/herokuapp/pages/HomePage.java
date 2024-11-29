package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage extends BasePage {
    // Локатор для всех ссылок на главной странице
    private By allLinks = By.tagName("a");

    // Локатор для конкретной ссылки по тексту
    private By addRemoveLink = By.linkText("Add/Remove Elements");

    // Конструктор, который инициализирует страницу с использованием экземпляра WebDriver
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Метод для получения всех ссылок на главной странице
    public List<WebElement> getAllLinks() {
        return driver.findElements(allLinks);
    }

    // Метод для проверки наличия конкретной ссылки по тексту
    public boolean isLinkPresent(String linkText) {
        return isElementPresent(By.linkText(linkText));
    }

    // Метод для клика на ссылку "Add/Remove Elements"
    public void clickAddRemoveElements() {
        click(addRemoveLink);
    }
}

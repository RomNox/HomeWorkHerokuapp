package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    // Локатор для всех ссылок на главной странице
    @FindBy(tagName = "a")
    private List<WebElement> allLinks;

    // Локатор для конкретной ссылки по тексту
    @FindBy(linkText = "Add/Remove Elements")
    private WebElement addRemoveLink;

    // Конструктор, который инициализирует страницу с использованием экземпляра WebDriver
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Метод для получения всех ссылок на главной странице
    public List<WebElement> getAllLinks() {
        return allLinks;
    }

    // Метод для проверки наличия конкретной ссылки по тексту
    public boolean isLinkPresent(String linkText) {
        return allLinks.stream().anyMatch(link -> link.getText().equals(linkText));
    }

    // Метод для клика на ссылку "Add/Remove Elements"
    public void clickAddRemoveElements() {
        addRemoveLink.click();
    }

    // Метод для клика на ссылку по тексту
    public void clickLink(String linkText) {
        allLinks.stream()
                .filter(link -> link.getText().equals(linkText))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    // Метод для получения ссылки по тексту
    public WebElement getLinkByText(String linkText) {
        return allLinks.stream()
                .filter(link -> link.getText().equals(linkText))
                .findFirst()
                .orElse(null);
    }
}

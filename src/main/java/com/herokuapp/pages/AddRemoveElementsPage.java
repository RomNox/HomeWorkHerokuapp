package com.herokuapp.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddRemoveElementsPage extends BasePage {

    // Локатор для кнопки "Add Element"
    @FindBy(xpath = "//button[text()='Add Element']")
    private WebElement addElementButton;

    // Локатор для всех кнопок "Delete"
    @FindBy(css = ".added-manually")
    private List<WebElement> deleteButtons;

    // Конструктор, который инициализирует страницу
    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this); // Инициализация всех элементов
    }

    // Метод для клика на кнопку "Add Element"
    public void clickAddElementButton() {
        addElementButton.click();
    }

    // Метод для клика на кнопку "Delete" по индексу
    public void clickDeleteButton(int index) {
        if (index >= 0 && index < deleteButtons.size()) {
            deleteButtons.get(index).click();
        }
    }

    // Метод для получения количества кнопок "Delete"
    public int getDeleteButtonCount() {
        return deleteButtons.size();
    }
}

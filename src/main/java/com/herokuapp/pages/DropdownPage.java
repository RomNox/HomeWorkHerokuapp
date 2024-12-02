package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    public DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // Локатор для раскрывающегося списка
    private By dropdown = By.id("dropdown");

    // Метод для выбора значения из раскрывающегося списка по видимому тексту
    public void selectOptionByVisibleText(String option) {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        select.selectByVisibleText(option);
    }

    // Метод для получения текущего выбранного значения
    public String getSelectedOption() {
        WebElement dropdownElement = driver.findElement(dropdown);
        Select select = new Select(dropdownElement);
        return select.getFirstSelectedOption().getText();
    }
}

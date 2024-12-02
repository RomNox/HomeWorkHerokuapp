package tests;

import com.herokuapp.pages.BasePage;
import com.herokuapp.pages.HomePage;
import com.herokuapp.pages.MultipleWindowsPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowsTest extends TestBase {

    private static final Logger logger = LoggerFactory.getLogger(MultipleWindowsTest.class);
    private BasePage basePage;

    @BeforeMethod
    public void preCondition() {
        logger.info("Переход на страницу 'Multiple Windows'");
        HomePage homePage = new HomePage(driver);
        homePage.clickLinkByText("Multiple Windows");

        // Наследование нам не подходит, поэтому используем композицию для работы с BasePage
        basePage = new BasePage(driver);
    }

    @Test
    public void testNewWindow() {
        logger.info("Начинаем тест на открытие нового окна");
        MultipleWindowsPage multipleWindowsPage = new MultipleWindowsPage(driver);

        // Клик на ссылку "Click Here" через метод basePage
        logger.debug("Клик по ссылке 'Click Here'");
        basePage.clickLinkByText("Click Here");

        // Переключаемся на новое окно
        logger.info("Переключаемся на новое окно");
        multipleWindowsPage.switchToNewWindow();

        // Проверяем наличие текста "New Window"
        logger.info("Проверяем наличие текста 'New Window' на новой странице");
        String pageSource = driver.getPageSource();
        Assert.assertTrue(pageSource.contains("New Window"), "Текст 'New Window' не найден на новой странице");

        logger.info("Тест на открытие нового окна успешно завершён");
    }
}

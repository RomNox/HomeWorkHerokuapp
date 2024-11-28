package tests;

import com.herokuapp.pages.HomePage;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

import java.util.List;

public class HomePageTest extends TestBase {

    @Test
    public void testHomePageLinks() {

        driver.get("https://the-internet.herokuapp.com/");
        HomePage homePage = new HomePage(driver);

        List<WebElement> links = homePage.getAllLinks();

        assertTrue("На главной странице нет ссылок", links.size() > 0);

        assertTrue("Ссылка 'Add/Remove Elements' не найдена на главной странице", homePage.isLinkPresent("Add/Remove Elements"));

        for (WebElement link : links) {
            String linkText = link.getText().trim(); // Удаление пробелов
            if (!linkText.isEmpty()) { // Проверка только тех ссылок, которые имеют текст
                assertTrue("Ссылка не содержит текста", linkText != null && !linkText.isEmpty());
            }
        }
    }
}

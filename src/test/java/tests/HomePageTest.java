package tests;

import com.herokuapp.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

import java.util.List;

public class HomePageTest extends TestBase {

    @Test
    public void testHomePageHasLinks() {
        HomePage homePage = new HomePage(driver);

        List<WebElement> links = homePage.getAllLinks();
        assertTrue(links.size() > 0, "На главной странице нет ссылок");
    }

    @Test
    public void testSpecificLinkIsPresent() {
        HomePage homePage = new HomePage(driver);

        assertTrue(homePage.isLinkPresent("Add/Remove Elements"), "Ссылка 'Add/Remove Elements' не найдена на главной странице");
    }
}

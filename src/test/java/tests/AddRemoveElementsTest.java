package tests;

import com.herokuapp.pages.AddRemoveElementsPage;
import com.herokuapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddRemoveElementsTest extends TestBase{

     @BeforeMethod
             public void preconditions(){
         HomePage homePage = new HomePage(driver);
         homePage.clickLink("Add/Remove Elements");
     }

    @Test
    public void testAddElement() {
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(driver);

        // Клик на кнопку "Add Element" и проверка, что кнопка "Delete" появилась
        addRemoveElementsPage.clickAddElementButton();
        int deleteButtonCount = addRemoveElementsPage.getDeleteButtonCount();

        Assert.assertEquals(deleteButtonCount, 1, "Количество кнопок 'Delete' должно быть 1 после добавления");
    }

    @Test
    public void testAddMultipleElements() {
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(driver);

        // Добавляем три элемента и проверяем количество кнопок "Delete"
        addRemoveElementsPage.clickAddElementButton();
        addRemoveElementsPage.clickAddElementButton();
        addRemoveElementsPage.clickAddElementButton();

        int deleteButtonCount = addRemoveElementsPage.getDeleteButtonCount();
        Assert.assertEquals(deleteButtonCount, 3, "Количество кнопок 'Delete' должно быть 3 после добавления трёх элементов");
    }

    @Test
    public void testDeleteElement() {
        AddRemoveElementsPage addRemoveElementsPage = new AddRemoveElementsPage(driver);

        // Добавляем два элемента и удаляем один
        addRemoveElementsPage.clickAddElementButton();
        addRemoveElementsPage.clickAddElementButton();
        Assert.assertEquals(addRemoveElementsPage.getDeleteButtonCount(), 2, "Должно быть 2 кнопки 'Delete' перед удалением");

        addRemoveElementsPage.clickDeleteButton(0);
        int deleteButtonCountAfterDeletion = addRemoveElementsPage.getDeleteButtonCount();
        Assert.assertEquals(deleteButtonCountAfterDeletion, 1, "Количество кнопок 'Delete' должно быть 1 после удаления");
    }
}



package tests;

import com.herokuapp.pages.FrameHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends TestBase {

    @Test
    public void testIFrame() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("iFrame")).click();

        FrameHelper frameHelper = new FrameHelper(driver);
        frameHelper.switchToFrame("mce_0_ifr");

        WebElement editor = driver.findElement(By.id("tinymce"));
        Assert.assertTrue(editor.isDisplayed(), "Редактор в iframe не найден");

        frameHelper.switchToDefaultContent();
    }

    @Test
    public void testNestedFrames() {
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("Nested Frames")).click();

        FrameHelper frameHelper = new FrameHelper(driver);

        // Переход в верхний фрейм (top) и затем в левый фрейм (left)
        frameHelper.switchToFrame("frame-top");
        frameHelper.switchToFrame("frame-left");

        String leftText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(leftText.contains("LEFT"), "Текст в левом фрейме не совпадает");

        // Возврат в родительский фрейм и затем переход в центральный фрейм (middle)
        frameHelper.switchToParentFrame();
        frameHelper.switchToFrame("frame-middle");

        String middleText = driver.findElement(By.id("content")).getText();
        Assert.assertTrue(middleText.contains("MIDDLE"), "Текст в центральном фрейме не совпадает");

        // Возврат в родительский фрейм и затем переход в правый фрейм (right)
        frameHelper.switchToParentFrame();
        frameHelper.switchToFrame("frame-right");

        String rightText = driver.findElement(By.tagName("body")).getText();
        Assert.assertTrue(rightText.contains("RIGHT"), "Текст в правом фрейме не совпадает");

        frameHelper.switchToDefaultContent();
    }
}

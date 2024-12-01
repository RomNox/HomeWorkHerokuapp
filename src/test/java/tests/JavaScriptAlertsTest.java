package tests;

import com.herokuapp.pages.AlertHelper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertsTest extends TestBase {

    @Test
    public void testJsAlert() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();

        AlertHelper alertHelper = new AlertHelper(driver);
        String alertText = alertHelper.acceptAlert();

        Assert.assertEquals(alertText, "I am a JS Alert", "Текст JS Alert не совпадает");
    }

    @Test
    public void testJsConfirm() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();

        AlertHelper alertHelper = new AlertHelper(driver);
        String alertText = alertHelper.dismissAlert();

        Assert.assertEquals(alertText, "I am a JS Confirm", "Текст JS Confirm не совпадает");
    }

    @Test
    public void testJsPrompt() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();

        AlertHelper alertHelper = new AlertHelper(driver);
        alertHelper.sendTextToAlertAndAccept("Test Prompt");

        String resultText = driver.findElement(By.id("result")).getText();
        Assert.assertTrue(resultText.contains("Test Prompt"), "Результат не содержит введённый текст");
    }
}

package Ders05;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class C06_ActionsPractice extends TestBaseBeforeAfter {
    @Test
    public void actionsTest() throws InterruptedException {
        //https://the-internet.herokuapp.com.context_menu adresine gedin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Ciziqli bolum uzerinde sag click edin
        WebElement ciziqliBolum= driver.findElement(By.xpath("//*[@id='hot-spot']"));
        Actions actions=new Actions(driver);
        actions.contextClick(ciziqliBolum).perform();
        //Alert'de cixan yazinin "You selected a context menu" oldugunu test edin
        String actualText=driver.switchTo().alert().getText();
        String expectedText="You selected a context menu";
        Assert.assertEquals(actualText,expectedText);
        //OK deyerek alerti baglayin
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        //Elemental Selenium linkine basin
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //Acilan sehifede h1 tag'inda "Elemental Selenium" yazildigini test edin
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(windowList.get(1));
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
    }
}

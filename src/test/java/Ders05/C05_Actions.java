package Ders05;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C05_Actions extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        //https://demoqa.com/droppable adresine gedin
        driver.get("https://demoqa.com/droppable");
        //"Drag me" duymesine basili tutub "Drop here" qutusunun ustune buraxin
        WebElement dragMe=driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere= driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        Thread.sleep(1000);
        actions.dragAndDrop(dragMe,dropHere).perform();
        //"Drop here" yazisi yerine "Dropped" oldugunu test edin
        Assert.assertEquals("Dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());
    }
}

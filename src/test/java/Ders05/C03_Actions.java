package Ders05;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C03_Actions extends TestBaseBeforeAfter {
    @Test
    public void actionTest() {
        //amazon.com.tr sehifesine gedin
        driver.get("https://www.amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        //Hesablar menusundan list yaradin linkine basin
        WebElement hesabList= driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));
        WebElement listYarat= driver.findElement(By.xpath("(//*[@class='nav-text'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hesabList).click(listYarat).perform();

        //Axtarma qutusuna actions metodlarindan istifade ederek Iphone 15 Plus yazdirin, entere basin
        WebElement searchBox= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        actions.click(searchBox).keyDown(Keys.SHIFT).sendKeys("i").keyUp(Keys.SHIFT).sendKeys("phone").sendKeys(" ").sendKeys("15")
                .sendKeys(" ").keyDown(Keys.SHIFT).sendKeys("p").keyUp(Keys.SHIFT).sendKeys("lus").sendKeys(Keys.ENTER).perform();
        //Axtarisin heyata kecdiyini test edin
        Assert.assertTrue(driver.getTitle().contains("Iphone 15 Plus"));
    }
}

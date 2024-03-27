package Ders05;

import Utilities.TestBaseBeforeAfter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class C04_ActionsPractice extends TestBaseBeforeAfter {
    @Test
    public void test() throws InterruptedException {
        //facebook sehifesine gedin
        driver.get("https://facebook.com");
        //yeni hesab yaradin buttonuna basin
        WebElement accountCreate= driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']"));
        Actions actions=new Actions(driver);
        actions.click(accountCreate).perform();
        Thread.sleep(1000);
        //ad soyad mail ve sifre qutularina deyerler yazib qeyd ol duymesine basin
        actions.sendKeys("Roma").sendKeys(Keys.TAB).sendKeys("Secure").sendKeys(Keys.TAB).sendKeys("+994553151907").sendKeys(Keys.TAB)
                .sendKeys("12345678ABC").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("1").sendKeys(Keys.TAB).sendKeys("янв")
                .sendKeys(Keys.TAB).sendKeys("1984").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }
}

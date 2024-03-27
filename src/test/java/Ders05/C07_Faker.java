package Ders05;

import Utilities.TestBaseBeforeAfter;
import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class C07_Faker extends TestBaseBeforeAfter {
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
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(email).sendKeys(Keys.TAB).sendKeys(email).sendKeys(Keys.TAB).sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.number().digit()).sendKeys(Keys.TAB).sendKeys("янв")
                .sendKeys(Keys.TAB).sendKeys("1999").sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.RIGHT).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
    }

}

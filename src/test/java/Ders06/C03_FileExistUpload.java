package Ders06;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class C03_FileExistUpload extends TestBaseBeforeAfter {
    @Test
    public void test() {
        //https://the-internet.herokuapp.com/upload adresine gedin
        driver.get("https://the-internet.herokuapp.com/upload");
        //Dosya sec duymsine basin
        WebElement dosyaSec=driver.findElement(By.xpath("//*[@id='file-upload']"));
        //Yuklemek istediyiniz dosyani secin
        String yuklenecekDosya="C:/Users/Roma/Downloads/some-file.txt";
        dosyaSec.sendKeys(yuklenecekDosya);
        //Upload duymesine basin
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();
        //"File Uploaded!" textinin gorunduyunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='File Uploaded!']")).isDisplayed());
    }
  }

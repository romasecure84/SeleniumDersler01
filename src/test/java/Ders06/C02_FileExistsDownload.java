package Ders06;

import Utilities.TestBaseBeforeAfter;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileExistsDownload extends TestBaseBeforeAfter {
    @Test
    public void fileExistsTest() throws InterruptedException {
        //https://the-internet.herokuapp.com/download adresine gedin
        driver.get("https://the-internet.herokuapp.com/download");
        //some-file.txt dosyasini endirin
        driver.findElement(By.xpath("//*[text()='some-file.txt']")).click();
        Thread.sleep(1000);
        //Sonra isExist() metodunda dosyanin endirildiyini test edin
        String samlePath="C:/Users/Roma/Downloads/some-file.txt";
        Assert.assertTrue(Files.exists(Paths.get(samlePath)));
        //Endirildiyini konsolda gosterin
        System.out.println(Paths.get(samlePath));
    }
}

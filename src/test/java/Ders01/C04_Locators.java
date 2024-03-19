package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Locators {
    public static void main(String[] args) throws InterruptedException {
        //Chromedriveri setup edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //amacon.com saytina gedin
        driver.get("https://amazon.com.tr/");
        //amazonda notebook axtarin
        WebElement cerezler= driver.findElement(By.id("sp-cc-rejectall-link"));
        cerezler.click();
        Thread.sleep(2000);
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("notebook", Keys.ENTER);
        //amazon sehifesindeki taglarin a olanklarinin sayisini yazdirin

        //sehifeni baglayin
    }
}

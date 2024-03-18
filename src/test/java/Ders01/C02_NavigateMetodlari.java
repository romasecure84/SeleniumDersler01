package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_NavigateMetodlari {
    public static void main(String[] args) throws InterruptedException {
        //ChromeDriveri setup edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //'amazon.com.tr' adresine gedin
        driver.navigate().to("https://amazon.com");
        //google ana sehifesine gedin
        driver.navigate().to("https://google.az");
        //tekrar amazon sehifesine gedin
        Thread.sleep(1000);
        driver.navigate().back();
        //tekrara google sehifesine gedin
        Thread.sleep(1000);
        driver.navigate().forward();
        //sehifeni yenileyin
        Thread.sleep(1000);
        driver.navigate().refresh();
        //sehifeni baglayin
        driver.quit();
    }
}

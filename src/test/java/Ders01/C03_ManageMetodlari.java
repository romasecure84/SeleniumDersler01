package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_ManageMetodlari {
    public static void main(String[] args) throws InterruptedException {
        //chromedriveri setup edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        //amazon sehifesine gedin
        driver.get("https://amazon.com");
        //sehifenin yerini ve olculerini yazdirin
        System.out.println("Sehifenin kordinatlari : " + driver.manage().window().getPosition());
        System.out.println("Sehifenin olcusu : " + driver.manage().window().getSize());
        //sehifeni simge veziyyetine getirin
        driver.manage().window().minimize();
        //simge veziyyetinde 2 saniye gozledib sehifeni maximize edin
        Thread.sleep(2000);
        driver.manage().window().maximize();
        //sehifeni fullscreen edin
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        //sehifenin yerini ve olculerini fullscreen veziyyetinde yazdirin
        System.out.println("Sehifenin kordinatlari : " + driver.manage().window().getPosition());
        System.out.println("Sehifenin olcusu : " + driver.manage().window().getSize());
        // '  '  '                       istediyiniz sekilde duzeldin
        driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().setSize(new Dimension(1300,900));
        // sehifenin istenilen yer ve olcude qurasdirildigini test edin
        System.out.println("Sehifenin kordinatlari : " + driver.manage().window().getPosition());
        System.out.println("Sehifenin olcusu : " + driver.manage().window().getSize());
        //sehifeni baglayin
        driver.close();
    }
}

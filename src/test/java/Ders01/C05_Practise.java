package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.sun.tools.doclint.Entity.or;

public class C05_Practise {
    public static void main(String[] args) throws InterruptedException {
        //Facebook sehifesine gedin ve sehife baslangicinin(title) facebook oldugunu dogrulayin
        //Sehife basligi dogru deyilse basligi dogru yazdirin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com");
        if (driver.getTitle().contains("facebook")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Aktual URL : " + driver.getCurrentUrl());
        }
        //Sehife URLinin "facebook" kelmesini icerdiyini dogrulayin, deyilse "actual" URL-ni yazdirin

        if (driver.getCurrentUrl().contains("facebook")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Aktual Basliq : " + driver.getCurrentUrl());
        }
        //"https://www.walmart.com/ sehifesine gedin
        driver.navigate().to("https://walmart.com");
        //Sehifenin basliginin "walmart.com" icerdiyini dogrulayin
        if (driver.getTitle().contains("Walmart.com")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Aktual Basliq : " + driver.getTitle());
        }
        //tekrar facebook sehifesine donun
        driver.navigate().back();
        //sehifeni yenileyin
        Thread.sleep(1000);
        driver.navigate().refresh();
        //sehifeni maximize edin
        Thread.sleep(1000);
        driver.manage().window().maximize();
        //browseri baglayin
        driver.close();
    }
}

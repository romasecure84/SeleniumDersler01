package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverMetodlari {
    public static void main(String[] args) {
        //Chromdriveri setup edin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        //"www.amazon.com.tr" adresine gedin
        driver.get("https://www.amazon.com.tr");
        //Sehifeni maximum olcuye getirin
        driver.manage().window().maximize();
        //sehifenin basligini yazdirin
        System.out.println("Saytin Basligi: " + driver.getTitle());
        //sehofenin url adresinin yazdirin
        System.out.println("Saytin URL Adresi : " + driver.getCurrentUrl());
        //sehifenin qaynaq kodlarini yazdirin
        //System.out.println("Sehifenin qaynaq kodlari : " + driver.getPageSource() );
        //Qaynaq kodlarinin icerisinde "Gateway" kelimesinin oldugunu test edin
        String actualData= driver.getPageSource();
        String expectedData="Gateway";
        if (actualData.contains(expectedData)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        //sehifenin window handle kodunun yazin

        System.out.println("Window Handle : " + driver.getWindowHandle());

        //Sehifeni baglayin
        driver.close();
    }
}

package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClassAfterClas {
    static WebDriver driver;
    //befereClass ve AfterClass'in digerinden fergi static olmasidir, ilk once browser acilacaq
    //ilk olaraq amaon'a sonra ise walmart'a gedecek daha sonra ise qapadacaq
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void test(){
        driver.get("https://amazon.com.tr");
    }

    @Test
    public void test1(){
        driver.get("https://walmart.com");
    }

}

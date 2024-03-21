package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void Test() {
        //amazon sehifesine gedin
        driver.get("https://amazon.com.tr");
    }

    @Test
    public void Test1() {
        //facebook sehifesine gedin
        driver.get("https://facebook.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}

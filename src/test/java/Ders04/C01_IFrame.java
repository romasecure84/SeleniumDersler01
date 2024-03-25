package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_IFrame {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        //driver.quit();
    }

    @Test
    public void IframeTest() {
        //https://html.com/tags/iframe/ saytina gedin
        driver.get("https://html.com/tags/iframe/");
        //Saytdaki youtube videosuna baxin
        List<WebElement> iframe=driver.findElements(By.xpath("//iframe"));
        driver.switchTo().frame(iframe.get(0));
        driver.findElement(By.xpath("//*[@aria-label='Смотреть']")).click();
        driver.switchTo().defaultContent();
    }
}

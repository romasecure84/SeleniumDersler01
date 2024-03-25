package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_WindowHandlePractice {
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
    public void windowHandleTest() throws InterruptedException {
        //Amazon sehifesine gedin
        driver.get("https://amazon.com.tr/");
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        String amazonWindowHandle= driver.getWindowHandle();
        //url'nin amazon icerdiyini test edin
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        //Yeni bir pencere acib turbo.az anasehifesine gedin(https://www.turbo.az)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.turbo.az");
        String turboWindowHandle= driver.getWindowHandle();
        //title'in avtomobil icerdiyini test edin
        Assert.assertTrue(driver.getTitle().contains("avtomobil"));
        //ilk sehifeye donub sehifede java axtarisi edin
        driver.switchTo().window(amazonWindowHandle);
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("java", Keys.ENTER);
        //Axtaris neticelerinin java icerdiyini test edin
        WebElement actualText=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult=actualText.getText();
        String expectedText="java";
        Assert.assertTrue(actualResult.contains(expectedText));
        //yeniden turbo.az sehifesine gedin
        driver.switchTo().window(turboWindowHandle);
        //Logo'nun movcudlugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//img)[1]")).isDisplayed());
    }
}

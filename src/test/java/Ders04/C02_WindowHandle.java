package Ders04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class C02_WindowHandle {
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
        //https://the-internet.herokuapp.com/windows adresine gedin
        driver.get("https://the-internet.herokuapp.com/windows");
        String herokuappWindowHandle= driver.getWindowHandle();
        //Sehifedeki textin "Opening a new window" oldugunu test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //Title'in "The Internet" oldugunu test edin
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
        //Click Here button'una basin
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //Acilan yeni pencerenin sehife basliginin "New Window" oldugunu test edin
        List<String> windowList=new ArrayList<>(driver.getWindowHandles()); //acilacaq butun pencerelerin hash kodlarini alib liste qeyd edir!!
        System.out.println("windowList = " + windowList);
        driver.switchTo().window(windowList.get(1));
        Thread.sleep(2000);
        String actualTitle= driver.getTitle();
        String expectedTitle="New Window";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        //Sehifedeki textin "new Window" oldugunu dogrulayin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
        //Bir onceki pencereye geri dondukden sonrs sehife basliginin "The Internet" oldugunu dogrulayin
        driver.switchTo().window(windowList.get(0));
        Assert.assertTrue(driver.getTitle().contains("The Internet"));
    }
}

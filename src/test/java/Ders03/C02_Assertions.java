package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.youtube.com/");
        //driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        //driver.quit();
    }

    //youtube adresine gedin
    //Asagidaki adlari istifade ederek 4 test medodu yaradin ve lazimi testleri edin
    //titleTest ==> Sehifenin basliginin YouTube oldugunu test edin
    //imageTest ==> youtube resminin gorunurluyunu test edin
    //SearchBox'un istifade edilebilirliyini test edin
    //wrongTitleTest ==> sehife basliginin "youtube"  olmadigini test edin


    @Test
    public void titleTest() {
        String actualTitle=driver.getTitle();
        String expectedTitle="YouTube";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void imageTest() {
        WebElement icon= driver.findElement(By.xpath("(//*[@class='yt-spec-icon-shape'])[5]"));
        Assert.assertTrue(icon.isDisplayed());
    }

    @Test
    public void searchBox() {
        WebElement searchBox= driver.findElement(By.xpath("(//*[@id='search'])[2]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    public void wrongTitleTest() {
        String actualTitle=driver.getTitle();
        String expectedTitle="youtube";
        Assert.assertFalse(actualTitle.contains(expectedTitle));
    }
}

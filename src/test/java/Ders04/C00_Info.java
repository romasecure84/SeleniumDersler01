package Ders04;

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

public class C00_Info {
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
    public void IFrameTest() throws InterruptedException {
        //herokuapp sehifesine gedin
        driver.get("https://the-internet.herokuapp.com/iframe");
        //"An IFrame containing... " textinin movcudlugunu test edin ve yazdirin
        WebElement iframeText= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeText.isDisplayed());
        System.out.println(iframeText.getText());
        //Text box'a "Salam dunya" yazin
        WebElement iframeTextBox= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeTextBox);
        WebElement textBox= driver.findElement(By.xpath("//p"));
        textBox.clear();
        Thread.sleep(1000);
        textBox.sendKeys("Salam Dunya");
        //TextBox'un altindali "Elemental Selenium" linkinim textinin gorunduyunu test edin ve yazdirin
        //driver.switchTo().parentFrame(); //Bir ust seviyyedeki frame'e kecir
        driver.switchTo().defaultContent(); //En ust seviyyedeki frame'e cixir
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).isDisplayed());
        System.out.println(driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).getText());
    }
}

package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_BasicAuthentication {
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
    public void basicAuthenticationsTest() {
        //herokuapp saytina gedin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //asagidaki usullari ve test datalarinin istfade ederek authentication edin
        //HTML komandasi : https://username:password@URL
        //username : admin
        //password : admin
        //Muveffeqiyyetle seyfeye girildiyini dogrulayin

        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }
}

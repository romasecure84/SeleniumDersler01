package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class C05_Alerts {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        //driver.quit();
    }
    /*
    Bir web sayta girdiyimizde qarsimiza bir xeberdarliq mesaji ya da bir button'a basdigimizda bir xeberdarliq cixa
    biler. Eger bu xeberdarliga inspect ede bilirikse bu cur alert'lere HTML xeberdarliqlar deyilir ve istediyimiz
    locate'i ala bilerik. Amma gelen xeberdarliq qutusuna inspect ede bilmeyirikse bu cur alertler'e js alert deyilir.
    JS Alert'lere mudaxile ede bilmek ucun
    - tamam yada ok ucun driver.switchTo().alert().accept() istifade olunur
    - legv et ucun driver.switchTo().alert().dismiss() metodu istifade olunur
    - Alert icerisindeki mesaji almaq ucun driver.switchTo().alert().getText() istifade edilir
    - Alert bizden metn isteyirse driver.switchTo().alert().sendKeys("") istifade edilir
     */

    //herokuapp saytina gedin
    @Test
    public void acceptAlert() throws InterruptedException {
    //bir metod yaradin: acceptAlert
    //1. button'a basin, xeberdarliqdaki OK 'u basin ve result mesajinin "You successfully clicked an alert" oldugunu yoxlayin

        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        WebElement resultText= driver.findElement(By.xpath("//*[@id='result']"));
        String actualText= resultText.getText();
        String expectedText="You successfully clicked an alert";
        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void dismissAlert() throws InterruptedException {
    //Bir metod yaradin: dissmissAlert
    //2. button'a basin, xeberdarliqdaki Cancel'a basin ve resultun successfully icermediyini test edin, mesaji yazdirin
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        Thread.sleep(1000);
        System.out.println("Alert'in icerisindeki mesaj : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
        WebElement resultText= driver.findElement(By.xpath("//*[@id='result']"));
        String actualText= resultText.getText();
        String expectedText="successfully";
        Assert.assertNotEquals(expectedText,actualText);

    }
    @Test
    public void sendKeyAlert() throws InterruptedException {
    //Bir metod yaradin: sendKeysAlert
    //3. buttona basin, xeberdarliqdaki metn qutusuna adinizi yazib, ok'e basin ve result mesajinda gorunduyunu test edin
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);
        System.out.println("Alert'in icerisindeki mesaj : "+driver.switchTo().alert().getText());
        driver.switchTo().alert().sendKeys("Rafail");
        driver.switchTo().alert().accept();
        WebElement resultText= driver.findElement(By.xpath("//*[@id='result']"));
        String actualText= resultText.getText();
        String expectedText="Rafail";
        Assert.assertTrue(actualText.contains(expectedText));


    }
}

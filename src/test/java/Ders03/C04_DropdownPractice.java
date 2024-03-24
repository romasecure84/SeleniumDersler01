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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropdownPractice {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com.tr/");
        //driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        //driver.quit();
    }

    @Test
    public void amazonTest() {

    //amazon sehifesine gedin
    //cookies'i reddedin
        driver.findElement(By.xpath("/html/body/div[1]/span/form/div[2]/span[2]/span/button")).click();
    //axtaris qutusunun yannindaki kategiriyalarin sayinin 40 oldugunun test edin
        List<WebElement> ddm=driver.findElements(By.xpath("//option"));
        System.out.println(ddm.size());
        for (WebElement w:ddm){
            System.out.println(w.getText());
        }
        int actualDropDown=ddm.size();
        int expectedDropDown=40;
        Assert.assertNotEquals(expectedDropDown,actualDropDown);
    //kateqoriyalardan Kitaplar'u secin
        WebElement ddmlist= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select=new Select(ddmlist);
        select.selectByVisibleText("Kitaplar");
    //axtarma qututsuna java yazin ve axtaris edin
        WebElement searchBox= driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        searchBox.sendKeys("Java", Keys.ENTER);
    //tapilan netice sayisisini yazdirin
        WebElement sonucText=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        System.out.println(sonucText.getText());
    //neticenin java kelimesini icerdiyini test edin
        String actualText=sonucText.getText();
        String expectedText="Java";
        Assert.assertTrue(actualText.contains(expectedText));

    }
}

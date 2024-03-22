package Ders03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_Dropdown {
    WebDriver driver;
    @Before
    public void setUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //driver.findElement(By.xpath("//*[@id='a-autoid-1']")).click();
    }

    @After
    public void tearDown() throws InterruptedException {
        //driver.quit();
    }
    //https://the-internet.herokuapp.com/dropdown adresine gedin


    @Test
    public void dropdownTest() throws InterruptedException {
        WebElement ddmList= driver.findElement(By.cssSelector("#dropdown"));
        Select select=new Select(ddmList);
        //Index istifade ederek Option 1'i secin ve yazdirin
        select.selectByIndex(1);
        Thread.sleep(1000);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        //Value istifade ederek Option 2'i secin ve yazdirin
        select.selectByValue("2");
        Thread.sleep(1000);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        //Visible istifade ederek Option 1'i ve Option 2'i secin ve yazdirin
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        Thread.sleep(1000);
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("========================================");
        //Butun dropdown deyerlerinin yazdirin
        List<WebElement> butunddm=driver.findElements(By.xpath("//option"));
        for (WebElement w:butunddm){
            System.out.println(w.getText());
        }
        //Dropdown'un olculerini tapin, Dropdownda 4element varsa konsolda True, deyilse False yazdirin
        System.out.println("dropdown'daki element sayisi = "+butunddm.size());
        if (butunddm.size()==4){
            System.out.println("TRUE");
        }else {
            System.out.println("FALSE");
        }
    }
}

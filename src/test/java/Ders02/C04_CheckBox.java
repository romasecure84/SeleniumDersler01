package Ders02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBox {
    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    /*
        a. Verilen web sehifesine gedin: https://the-internet.herokuapp.com/checkboxes
        b. Checkbox1 ve checkbox2 elementlerini locate edin
        c. Checkbox1 secili deyilse tesdiq qutusuna basin
        d. Checkbox2 secili deyilse tesdiq qutusuna basin
    */
    @Test
    public  void test(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkBox1= driver.findElement(By.xpath("(//*[@type='checkbox'])[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("(//*[@type='checkbox'])[2]"));

        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
    }
}

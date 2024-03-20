package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Xpath {
    public static void main(String[] args) throws InterruptedException {
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gedin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Add Element butonuna basin
        WebElement addElement=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();
        //Delete butonunun gorunur oldugunu test edin
        WebElement deleteButton= driver.findElement(By.xpath("//*[text()='Delete']"));
        if (deleteButton.isDisplayed()){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
        //Delete butonuna basin
        Thread.sleep(2000);
        deleteButton.click();
        //"Add.Remove Elements" yazisinin gorunur oldugunu test edin
        if (driver.findElement(By.xpath("//*[text()='Add/Remove Elements']")).isDisplayed()){
            System.out.println("Test Passed");
        }
        else {
            System.out.println("Test Failed");
        }
        //Browseri baglayin
        driver.close();
    }
}

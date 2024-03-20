package Ders01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Practice {
    public static void main(String[] args) throws InterruptedException {
        //heroku.com/home adresine gedin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.heroku.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Sign Up Butonuna basin
        WebElement signUp= driver.findElement(By.linkText("Sign Up"));
        signUp.click();
        //Firstname textbox, lastname textbox, company elementlerini locate edin
        WebElement firstName=driver.findElement(By.id("first_name"));
        WebElement lastName=driver.findElement(By.id("last_name"));
        WebElement email=driver.findElement(By.id("email"));
        WebElement company= driver.findElement(By.name("company"));
        //bosluqlara veri gonderin
        Thread.sleep(2000);
        firstName.sendKeys("Roma");
        lastName.sendKeys("Secure");
        email.sendKeys("email@gmail.com");
        company.sendKeys("Shern");
    }
}

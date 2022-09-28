package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_HandleAllerts {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);
        // Click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(1000);
        // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        // "You successfully clicked an alert" yasının cıktıgını test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());

    }

    @After
    public void tearDown() {
        driver.close();
    }
}


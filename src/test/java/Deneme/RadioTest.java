package Deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RadioTest {
    // 1. Bir class oluşturun : RadioButtonTest
    WebDriver driver;
    // 2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void methot() throws InterruptedException {
        // 3.  - https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");
        Thread.sleep(1000);
        // 4.  - Cookies’i kabul edin
        driver.findElement(By.xpath("//*[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        Thread.sleep(1000);
        // 5.  - “Create an Account” button’una basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        Thread.sleep(1000);
        // 6.  - “radio buttons” elementlerini locate edin
        driver.findElement(By.xpath("//*[text()='15']")).click();
        driver.findElement(By.xpath("//*[text()='Eyl']")).click();
        driver.findElement(By.xpath("//*[text()='1989']")).click();
        Thread.sleep(1000);
        // 7.  - Secili degilse cinsiyet butonundan size uygun olani secin
        //    Secili degilse cinsiyet butonundan size uygun olani secin
        WebElement femaleButton = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));
        //    Secili degilse cinsiyet butonundan size uygun olani secin
        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(2000);
        femaleButton.click();
        Thread.sleep(2000);
        customButton.click();
    }

    // 8 Sayfayi kapatin
    @After
    public void tearDown() {
        driver.close();
    }
}
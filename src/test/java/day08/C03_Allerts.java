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

public class C03_Allerts {
    WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);
    }

    @Test
    public void test1() throws InterruptedException {
        // Click for JS Alert butonuna tıklayalım
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(1000);
        // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        // "You successfully clicked an alert" yasının cıktıgını test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You successfully clicked an alert']")).isDisplayed());

    }

    @Test
    public void test2() throws InterruptedException {
       // 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(2000);
        String result="successfuly";
        String actualMesaj=driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertFalse(actualMesaj.contains(result));
        //Assert.assertNotEquals(result,actualMesaj);


    }

    @Test
    public void test3() throws InterruptedException {
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Yusuf");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You entered: Yusuf']")).isDisplayed());

    }


    @After
    public void tearDown() {
        driver.close();
    }
}


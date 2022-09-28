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

public class C02_Allerts {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

        /*
            Bir web sitesine girdigimizde karsımıza bir uyarı mesajı yada bir buttona tıkladığımızda bir uyarı cıkabilir
        eğer bu uyarıya incele(mause sağ-tik inspect) yapabiliyorsak bu tür alert lere html alert denir.
        ve istedigimiz locate'i alabiliriz. Ama gelen uyarı kutusuna müdahale (sağ tik inspect ile) edemiyorsak
        bu tür alertlere  js alert denir.
        js alert'lere müdahale edebilmek icin

        -- tamam ya da ok icin
        driver.switchTo().alert().accept();

        --iptal icin
        driver.switchTo().alert().dismiss();

        --alert icindeki mesajı almak icin
        driver.switchTo().alert().getText();

        --alert bizden bir metin istiyorsa
        driver.switchTo().alert().sendKeys("");

        Methodları kullanilir!!
        */

    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(500);
        // Click for JS Alert butonuna tıklayalım ve "I am a JS Alert" mesajını yazdıralım ve gorundugunu test edelim
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(500);
        String extectedMesaj="I am a JS Alert";
        String actualMesaj=driver.switchTo().alert().getText();
        Assert.assertEquals(extectedMesaj,actualMesaj);
        System.out.println(actualMesaj);
        // Tıkladıktan sonra çıkan uyarı mesajına (Alerte) tamam diyelim
        driver.switchTo().alert().accept();
        Thread.sleep(500);
        // Click for JS Confirm butonuna tıklayalım iptal diyelim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
        driver.switchTo().alert().dismiss();
        Thread.sleep(500);
        // Click for JS Prompt butonuna tıklayalım ismimizi yazalım ve ekranda gorundugunu test edelim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(500);
        driver.switchTo().alert().sendKeys("Yusuf");
        Thread.sleep(500);
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='You entered: Yusuf']")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


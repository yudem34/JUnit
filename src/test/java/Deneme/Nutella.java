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

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Nutella {

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void methot() throws InterruptedException {
        // 1-C01_TekrarTesti isimli bir class olusturun
        // Olusturuldu
        // 2- https://www.google.com/ adresine gidin
        driver.get("https://google.com");
        Thread.sleep(500);
        // 3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();
        Thread.sleep(500);
        // 4 Sayfa basliginin “Google” ifadesi icerdigini test edin
        if (driver.getTitle().contains("Google")) {
            System.out.println("Title test PASSED");
        } else {
            System.out.println("Title test FAILED");
        }
        // 5 Arama cubuguna “Nutella” yazip aratin
        WebElement google = driver.findElement(By.xpath("//*[@title='Ara']"));
        Thread.sleep(500);
        google.sendKeys("Nutella", Keys.ENTER);
        Thread.sleep(500);
        // 6 Bulunan sonuc sayisini yazdirin
        String list = driver.findElement(By.id("result-stats")).getText();
        String[] arr = list.split(" ");
        System.out.println("Sonuc Sayisi : " + arr[1]);
        Integer sonucSayisi=Integer.parseInt(arr[1].replace(".",""));
        // 7 sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        Integer onMilyon = 10000000;
        if (sonucSayisi > onMilyon) {
            System.out.println("Sonuc sayisi 10 milyon'dan fazladır");
        } else {
            System.out.println("Sonuc sayisi 10 milyon'dan azdir");
        }
    }

    // 8 Sayfayi kapatin
    @After
    public void tearDown() {
        driver.close();
    }
}


package day07;

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

import java.time.Duration;
import java.util.List;

public class C02_DropDownHandle {
      /*
        ●Bir class oluşturun:C3_DropDownAmazon
        ●https://www.amazon.com/ adresinegidin.
        -Test1
        Arama kutusunun yanindaki kategori menusundeki kategori sayisinin45
        oldugunu testedin
        -Test2
        1.Kategori menusunden Books seceneginisecin
        2.Arama kutusuna Java yazin vearatin
        3.Bulunan sonuc sayisiniyazdirin
        4.Sonucun Java kelimesini icerdigini testedin
     */
      WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");

    }

    @Test
    public void test1() {
    // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 OLMADIGINI testedin.
        List<WebElement> list=driver.findElements(By.xpath("//option"));
        System.out.println("Kategori Sayisi : "+list.size()); //28
        for (WebElement w:list
             ) {
            System.out.println(w.getText());
        }
        Assert.assertNotEquals(list.size(),45);
    }
    @Test
    public void test2() throws InterruptedException {
        // 1.Kategori menusunden Books secenegini secin
        WebElement books=driver.findElement(By.xpath("(//*[text()='Books'])[1]"));
        books.click();
        Thread.sleep(2000);
        // 2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);
        // 3.Bulunan sonuc sayisiniyazdirin
        List<WebElement> javaSonuc=driver.findElements(By.xpath("//*[text()='1-16 of over 30,000 results for']"));
        String [] arr=javaSonuc.get(0).getText().split(" ");
        System.out.println("Java iceren sonuc sayisi : "+arr[3]);
        // 4.Sonucun Java kelimesini icerdigini testedin
        String sonuc=driver.findElement(By.xpath("//*[text()='\"Java\"']")).getText();
        Assert.assertTrue(sonuc.contains("Java"));


    }
    @After
    public void tearDown() {
        driver.close();
    }
}


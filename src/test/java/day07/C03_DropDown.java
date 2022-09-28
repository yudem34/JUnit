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
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C03_DropDown {
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
    Select select;
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
        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 olmadıgını testedin.
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);
        /*
        DropDown menuye ulasmak icin select class'indan bir obje olustururuz
        ve locate ettigimiz dropdown webelement'inin select class'ina tanimlariz
        ve getOption methodunu kullanarak dropdown'u bir liste atarak dropdown menunun
        butun elemanlarının sayısına ulasabiliriz
        */
        List<WebElement> ddmList=select.getOptions();
        System.out.println(ddmList.size());
        int expectedSayi=45;
        int actualDdsayisi=ddmList.size();
        Assert.assertNotEquals(expectedSayi,actualDdsayisi);
    }
    @Test
    public void test2() throws InterruptedException {
        // 1.Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select=new Select(ddm);
        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        /* Eğer Dropdown menudeki option'a string olarak ulaşmak istersek bu methodu kullanırız
        select.selectByIndex(5); // Eğer dropdown menusünun index'i ile ulasmak istersek bu methodu kullanırız
        select.selectByValue("search-alias=stripbooks-intl-ship");
        // Eğer dropdown menusundeki optiona value ile ulaşmak istersek bu methodu kullanırız
        Dropdown menude seçtiğimiz optiona ismini yazarak ulaşmak istersek select.getFirstSelectedOption()
        methodunu kullanırız
         */
        // 2.Arama kutusuna Java yazin vearatin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);
        // 3.Bulunan sonuc sayisiniyazdirin
        List<WebElement> javaSonuc=driver.findElements(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String [] arr=javaSonuc.get(0).getText().split(" ");
        //System.out.println("Java iceren sonuc sayisi : "+arr[3]);
        System.out.println(javaSonuc.get(0).getText());
        Thread.sleep(2000);
        // 4.Sonucun Java kelimesini icerdigini testedin
        String sonuc=driver.findElement(By.xpath("//*[text()='\"Java\"']")).getText();
        Assert.assertTrue(sonuc.contains("Java"));


    }
    @After
    public void tearDown() {
        driver.close();
    }
}




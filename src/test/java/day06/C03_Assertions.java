package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    /*
    1) Bir class oluşturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
    testleri yapin
         ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
         ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
         ○ logoTest => BestBuy logosunun görüntülendigini test edin
         ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    */
    static WebDriver driver;
    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void test1() {
        // 1- Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        String ectectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,ectectedUrl);
    }

    @Test
    public void test2() {
        // 2- titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        String title="Rest";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(title));
    }

    @Test
    public void test3() {
        // 3- logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logo=driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        // 4- FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francis=driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(francis.isDisplayed());
    }



    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
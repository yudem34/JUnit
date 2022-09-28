package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_WindowHandle {
    /*
    //1- Amazon Sayfasina girelim
    //2- Url'nin amazon içerdiğini test edelim
    //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
    //4- title'in BestBuy içerdiğini test edelim
    //5- İlk sayfaya dönüp sayfada java aratalım
    //6- Arama sonuclarının java içerdiğini test edelim
    //7- Yeniden bestbuy sayfasına gidelim
    //8- Logonun görünürlüğünü test edelim
    //9- Sayfaları Kapatalım
    */
    WebDriver driver;
    /*
    Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
    driver'ın window handle değerini string bir değişkene atarız
    Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
    String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
    */

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {
        //1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle=driver.getWindowHandle();
        //2- Url'nin amazon içerdiğini test edelim
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
        //3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle=driver.getWindowHandle();
        //4- title'in Best Buy içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Best Buy"));
        //5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle).findElement(By.id("twotabsearchtextbox")).sendKeys("java", Keys.ENTER);
        Thread.sleep(1000);
        //6- Arama sonuclarının java içerdiğini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText().contains("java"));
        //7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        //8- Logonun görünürlüğünü test edelim
        Assert.assertTrue(driver.findElement(By.xpath("(//*[@alt='Best Buy Logo'])[1]")).isDisplayed());


    }
    //9- Sayfaları Kapatalım
    @After
    public void tearDown() {
       driver.quit();
    }
}


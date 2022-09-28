package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*
    Amazon sayfasina git
    3 farkli test method'u olustur
    1- url'in "amazon" icergini test et
    2- title'in "facebook" icermedigini test et
    3- sol ust kosede amazon logosunun gorundugunu test et
    */
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @Test
    public void test1() {
        // 1- url'in "amazon" icergini test et
        Assert.assertTrue(driver.getCurrentUrl().contains("amazon"));
    }

    @Test
    public void test2() {
        // 2- title'in "facebook" icermedigini test et
        Assert.assertFalse(driver.getTitle().contains("faceboook"));
    }

    @Test
    public void test3() {
        // 3- sol ust kosede amazon logosunun gorundugunu test et
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test4(){
        // 4- url nin https://www.facebook.com icermedigini test edelim
        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);
        /*
        Assert.assertEquals("Url'ler esit degil",expectedUrl,actualUrl);
        Hata Mesajı
        org.junit.ComparisonFailure:
        Expected :https://www.facebook.com
        Actual   :https://www.amazon.com/
        <Click to see difference>
        */
        //Assert.assertFalse(actualUrl.contains(expectedUrl));
    }



    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}

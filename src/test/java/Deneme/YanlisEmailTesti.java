package Deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class YanlisEmailTesti {
    // 1- Bir Class olusturalim YanlisEmailTesti
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test1() throws InterruptedException {
        // 2- http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
        Thread.sleep(2000);
        // 3- Sign in butonuna basalim
        driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
        Thread.sleep(2000);
        // 4- Email kutusuna @isareti olmayan bir mail yazip enter’a
        driver.findElement(By.xpath("(//*[@class='is_required validate account_input form-control'])[1]")).sendKeys("yusufdmsmdgmail.com", Keys.ENTER);
        Thread.sleep(10000);
        // 5- Bastigimizda “Invalid email address” uyarisi ciktigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Invalid email address.']")).isDisplayed());
        Thread.sleep(2000);
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}

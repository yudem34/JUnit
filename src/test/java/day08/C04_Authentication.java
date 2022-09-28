package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_Authentication {

    WebDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {
    /*  https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        Html komutu : https://username:password@URL
        Username    : admin
        password    : admin
        Basarili sekilde sayfaya girildigini dogrulayin  */
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(1000);
        Assert.assertTrue(driver.findElement(By.xpath("//p")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


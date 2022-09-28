package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {
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
        driver.get("https://www.koalaresorthotels.com/");
        driver.findElement(By.xpath("(//*[@class='nav-link'])[7]")).click();
        Thread.sleep(500);
        Assert.assertEquals("Login Ekranına Giris Yapılmadi","https://www.koalaresorthotels.com/Account/Logon",driver.getCurrentUrl());
        driver.findElement(By.id("UserName")).sendKeys("yusuf");
        Thread.sleep(500);
        driver.findElement(By.id("Password")).sendKeys("yusuf+");
        Thread.sleep(500);
        //driver.findElement(By.xpath("//*[@value='Log in']")).click();
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


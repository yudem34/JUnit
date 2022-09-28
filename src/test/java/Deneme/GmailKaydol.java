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

import java.time.Duration;

public class GmailKaydol {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void methot() throws InterruptedException {
        driver.get("https://google.com");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();
        Thread.sleep(500);
        WebElement google=driver.findElement(By.xpath("//*[@title='Ara']"));
        Thread.sleep(500);
        google.sendKeys("gmail", Keys.ENTER);
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[text()='Gmail - Google']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[@class='laptop-desktop-only'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.id("firstName")).sendKeys("Emin");
        Thread.sleep(500);
        driver.findElement(By.id("lastName")).sendKeys("Bey");
        Thread.sleep(500);
        driver.findElement(By.id("username")).sendKeys("yasindmrl1.2.34.S");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[@class='whsOnd zHQkBf'])[4]")).sendKeys("Klm123.ydyd");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[@class='whsOnd zHQkBf'])[5]")).sendKeys("Klm123.ydyd");
        Thread.sleep(500);
        driver.findElement(By.xpath("(//*[@class='VfPpkd-vQzf8d'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//*[@jsname='V67aGc'])[3]")).click();
        Thread.sleep(4000);
    }
    @After
    public void tearDown(){
        driver.close();
    }
}

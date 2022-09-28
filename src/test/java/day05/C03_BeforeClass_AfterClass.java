package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeClass_AfterClass {
      /*
        BeforeClass ve AfterClass notasyonlari kullaniyorsak
        olusturacagimiz method'u static yapmammiz gerekiyor
      */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    // Calısmasını ıstemedigimiz test icin @Test 'in altına "@Ignore" yazılır.
    // @Ignore("....") acıklamada yazılabilir
    @Test
    public void method1() throws InterruptedException {
        driver.get("https://amazon.com");
    }
    @Test
    public void method2() throws InterruptedException {
        driver.get("https://techproeducation.com");
    }
    @Test
    public void method3() throws InterruptedException {
        driver.get("https://hepsiburada.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}

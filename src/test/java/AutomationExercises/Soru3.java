package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru3 {
    /*
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' url'sine gidin
    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
    5. 'Hesabınıza giriş yapın' ifadesinin görünür olduğunu doğrulayın
    6. Yanlış e-posta adresi ve şifre girin
    7. 'Giriş' düğmesini tıklayın
    8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
    */
    WebDriver driver;

    @Before
    public void setup() {
        // 1. Tarayıcıyı başlatın
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test1() throws InterruptedException {
        // 2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");
        Thread.sleep(400);
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isDisplayed());
        Thread.sleep(400);
        // 4. 'Signup / Login' düğmesine tıklayın
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        Thread.sleep(400);
        // 5. 'Login to your account' ifadesinin görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Login to your account']")).isDisplayed());
        // 6. Yanlış e-posta adresi ve şifre girin
        driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("asddadsadssasd@gmail.com");
        Thread.sleep(400);
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("sadqwdad5444asd");
        Thread.sleep(400);
        // 7. 'Giriş' düğmesini tıklayın
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        Thread.sleep(2000);
        // 8. 'E-postanız veya şifreniz yanlış!' hatasını doğrulayın. görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


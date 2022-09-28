package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru5 {
    /*
    1. Tarayıcıyı başlatın
    2. 'http://automationexercise.com' url'sine gidin
    3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
    4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
    5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
    6. Adı ve kayıtlı e-posta adresini girin
    7. 'Kaydol' düğmesini tıklayın
    8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
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
    public void test1() {
        // 2. 'http://automationexercise.com' url'sine gidin
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        // 4. 'Kayıt Ol / Giriş Yap' düğmesine tıklayın
        // 5. 'Yeni Kullanıcı Kaydı'nı doğrulayın! görünür
        // 6. Adı ve kayıtlı e-posta adresini girin
        // 7. 'Kaydol' düğmesini tıklayın
        // 8. 'E-posta Adresi zaten var!' hatasını doğrulayın. görünür
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


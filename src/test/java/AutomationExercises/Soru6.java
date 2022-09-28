package AutomationExercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Soru6 {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() {
        //1. Tarayıcıyı başlatın
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com/");
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın

        //4. 'Bize Ulaşın' düğmesine tıklayın

        //5. 'GET IN TOUCH'un görünür olduğunu doğrulayın

        //6. Adı, e-posta adresini, konuyu ve mesajı girin

        //7. Dosya yükle

        //8. 'Gönder' düğmesini tıklayın

        //9. Tamam düğmesine tıklayın

        //10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür

        //11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın


    }

    @After
    public void tearDown() {
        driver.close();
    }
}


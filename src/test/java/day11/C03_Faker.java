package day11;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

public class C03_Faker extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // "https://facebook.com"  Adresine gidin
        driver.get("https://www.facebook.com");
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        WebElement firstNameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
         /* faker olarak 2 defa ayni maili veremez
            bu sebeple bir konteyner a biz faker mail atadik
            asagida da direk onlari kullanacagiz */
        String email=faker.internet().emailAddress();
        actions.click(firstNameBox).
                // “firstName” giris kutusuna bir isim yazin
                sendKeys(faker.name().firstName()).
                sendKeys(Keys.TAB).
                // “surname” giris kutusuna bir soyisim yazin
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                // “email” giris kutusuna bir email yazin
                sendKeys(email).
                sendKeys(Keys.TAB).
                // “email” onay kutusuna emaili tekrar yazin
                sendKeys(email).
                sendKeys(Keys.TAB).
                // Bir sifre girin
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                // Tarih icin gun secin
                sendKeys("15").
                sendKeys(Keys.TAB).
                // Tarih icin ay secin
                sendKeys("Eyl").
                sendKeys(Keys.TAB).
                // Tarih icin yil secin
                sendKeys("1989").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                // Cinsiyeti secin
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.LEFT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                // Kaydol butonuna basın
                /*sendKeys(Keys.ENTER).*/ //Kayıt Olmaması icin Kaydol butonunu yoruma aldık.
                perform();
                // Sayfayi kapatin
                driver.close();

    }
}

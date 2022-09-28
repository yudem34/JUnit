package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

public class C02_Facebook extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        // 2- Yeni hesap olustur butonuna basalim
        driver.findElement(By.xpath("//*[text()='Temel ve isteğe bağlı çerezlere izin ver']")).click();
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();
        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement box = driver.findElement(By.xpath("//input[@name='firstname']"));
        box.sendKeys("Mehmet");
        actions.sendKeys(Keys.TAB).
                sendKeys("Gunduz").
                sendKeys(Keys.TAB).
                sendKeys("eminhshshdh23@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("eminhshshdh23@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("Desemki.2515").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Eyl").
                sendKeys(Keys.TAB).
                sendKeys("1991").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.RIGHT).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();
        // 4- Kaydol tusuna basalim
    }
}

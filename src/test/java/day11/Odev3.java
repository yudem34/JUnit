package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforAfter;

import java.util.List;

public class Odev3 extends TestBaseBeforAfter {
    @Test
    public void test1() throws InterruptedException {
        // Test01
        // -amazon gidin
        driver.get("https://www.amazon.com");
        // Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> ddmAll = select.getOptions();
        for (WebElement w:ddmAll
             ) {
            System.out.println(w.getText());
        }
        // dropdown menude 40 eleman olduğunu doğrulayın
        System.out.println(ddmAll.size());
        Assert.assertNotEquals(40,ddmAll.size());

        // dropdown menuden elektronik bölümü seçin
        select.selectByIndex(10);
        // arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        WebElement sonucYazisi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(sonucYazisi.getText());
        // sonuc sayisi bildiren yazinin iphone icerdigini test edin
        Assert.assertTrue(sonucYazisi.getText().contains("iphone"));
        // ikinci ürüne relative locater kullanarak tıklayin
        driver.findElement(By.xpath("(//*[@class='a-size-base-plus a-color-base a-text-normal'])[3]")).click();
        // ürünün title'ni ve fiyatını variable'a  assign edip ürünü sepete ekleyelim
        String tile=driver.findElement(By.xpath("//*[text()='Apple iPhone XR, US Version, 128GB, Blue - Unlocked (Renewed)']")).getText();
        String fiyat=driver.findElement(By.xpath("//*[text()='$269.99']")).getText();
        driver.findElement(By.id("add-to-cart-button")).click();
        // yeni bir sekme açarak amazon anasayfaya gidin
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.amazon.com");
        Thread.sleep(2000);
        // dropdown'dan bebek bölümüne secin
        WebElement ddm2 = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select2 = new Select(ddm2);
        select2.selectByIndex(3);
        // bebek puset aratıp bulundan sonuç sayısını yazdırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("puset", Keys.ENTER);
        // sonuç yazsının puset içerdiğini test edin
        String sonucYazisiPuset=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        Assert.assertTrue(sonucYazisiPuset.contains("puset"));
        // üçüncü ürüne relative locater kullanarak tıklayin

        // title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin

        // sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayın

    }
}

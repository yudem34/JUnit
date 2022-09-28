package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforAfter;

public class Odev2 extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // "http://webdriveruniversity.com/IFrame/index.html" sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");
        // "Our Products" butonuna basin
        WebElement frame=driver.findElement(By.xpath("//iframe"));
        driver.switchTo().frame(frame);
        driver.findElement(By.xpath("//*[text()='Our Products']")).click();
        // "Cameras product"i tiklayin
        driver.findElement(By.id("container-product1")).click();
        // Popup mesajini yazdirin
        System.out.println(driver.findElement(By.xpath("//*[@class='modal-body']")).getText());
        // "close" butonuna basin
        WebElement closeButton=driver.findElement(By.xpath("//*[@class='btn btn-default']"));
        closeButton.click();
        driver.switchTo().defaultContent();
        // "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.findElement(By.id("nav-title")).click();
        // "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        Assert.assertEquals(driver.getCurrentUrl(),"http://webdriveruniversity.com/index.html");
    }
}

package day15;

import org.apache.commons.io.FileUtils;
import org.apache.hc.core5.util.Asserts;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBaseBeforAfter;

import java.io.File;
import java.io.IOException;

public class C05_Odev1 extends TestBaseBeforAfter {
    @Test
    public void test1() throws IOException, InterruptedException {
        // 1- amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        // 2- amazon anasayfaya gittiginizi test edin ve tum sayfanin goruntusunu kaydedin
        String extectedUrl = "Amazon.com";
        Assert.assertTrue(driver.getTitle().contains(extectedUrl));
        TakesScreenshot ts = (TakesScreenshot) driver;
        File tumSayfaResmini = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tumSayfaResmini, new File("target/ekranGoruntusu/day15_Odev1/amazonTitle.jpeg"));
        // 3- Nutella icin arama yapin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //4- sonucun Nutella icerdigini test edin ve ilk urunun goruntusunu alin
        String actualText = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(actualText.contains("Nutella"));
        WebElement NutellaScreen=driver.findElement(By.xpath("(//*[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        File geciciImg=NutellaScreen.getScreenshotAs(OutputType.FILE);
        File ilkUrunIMG=new File("target/ekranGoruntusu/day15_Odev1/Nutella.jpeg");
        FileUtils.copyFile(geciciImg,ilkUrunIMG);
        //FileUtils.copyFile(tumSayfaResmini, new File("target/ekranGoruntusu/day15_Odev1/Nutella.jpeg"));
    }
}

package day15;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBaseBeforAfter;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.OffsetTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

public class C04_GetScreenShot extends TestBaseBeforAfter {
    @Test
    public void test1() throws IOException, InterruptedException {
        // Amazon sayfasına gidelim tum sayfanın resmini alalım
        driver.get("https://www.duolingo.com/");
        Thread.sleep(2000);
        TakesScreenshot ts= (TakesScreenshot) driver;
        /*
        Bir web sayfanin resmini alabilmek icin TakesScreenshot class'indan obje olusturup
        gecici bir File class'indan degiskene TakesScreenShot'tan olusturdugum obje'den
        tss.getScreenshotAs method'unu kullanarak gecici bir file olustururuz
        */

        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih = date.format(formater);

        String url= driver.getCurrentUrl().substring(12);
        String format=url.concat(tarih);
        File tumSayfaResmini =ts.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(tumSayfaResmini,new File("target/ekranGoruntusu/"+format+".jpeg"));
    }
}

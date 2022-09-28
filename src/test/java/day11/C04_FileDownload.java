package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBaseBeforAfter;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBaseBeforAfter {
    @Test
    public void downloadTest() {
        // 4-https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        // 5-test.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='test.txt']")).click();
    }

    @Test
    public void isExist() {
        // 6-Ardından isExist( )  methodunda dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:\\Users\\yusuf\\Downloads\\test.txt";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        System.out.println(Files.exists(Paths.get(dosyaYolu)));

    }
}

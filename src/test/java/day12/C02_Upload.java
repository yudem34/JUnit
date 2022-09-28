package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforAfter;

public class C02_Upload extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // https://the-internet.herokuapp.com/upload adresine gidelim

        // chooseFile butonuna basalim
        /*String dosyaYolu="C:\\Users\\yusuf\\Downloads\\test.txt";
        dosyaSec.sendKeys(dosyaYolu);*/
        /*actions = new Actions(driver);
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        actions.click(dosyaSec).perform();*/
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec = driver.findElement(By.id("file-upload"));
        // Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\yusuf\\Downloads\\test.txt";
        dosyaSec.sendKeys(dosyaYolu);
        // Upload butonuna basalim.
        driver.findElement(By.xpath("//input[@value='Upload']")).click();
        // “File Uploaded!” textinin goruntulendigini test edelim.
        WebElement resultWE = driver.findElement(By.xpath("//h3[text()='File Uploaded!']"));
        String expectedText = "File Uploaded!";
        String actualText = resultWE.getText();
        Assert.assertEquals(expectedText, actualText);


    }
}

package day12;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev3 extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");
        // 2."Login Portal" a  kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        // 3."Login Portal" a tiklayin
        driver.findElement(By.xpath("//*[text()='LOGIN PORTAL']")).click();
        // 4.Diger window'a gecin
        List<String> windowList=new ArrayList<>(driver.getWindowHandles());
        /*driver.switchTo().newWindow(WindowType.TAB);*/
        driver.switchTo().window(windowList.get(1));
        // 5."username" ve  "password" kutularina deger yazdirin
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("username");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");
        // 6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();
        // 7.Popup'ta cikan yazinin "validation failed" oldugunu test edin  8.Ok diyerek Popup'i kapatin
        Assert.assertEquals("validation failed",driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        // 10.Ilk sayfaya geri donun
        driver.switchTo().window(windowList.get(0));
        // 11.Ilk sayfaya donuldugunu test edin
        Assert.assertEquals("http://webdriveruniversity.com/",driver.getCurrentUrl());
    }
}

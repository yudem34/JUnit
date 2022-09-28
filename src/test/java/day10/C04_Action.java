package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforAfter;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class C04_Action extends TestBaseBeforAfter {
    @Test
    public void test1() throws InterruptedException {
        // https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // Cizili alan uzerinde sag click yapalim
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        Actions action = new Actions(driver);
        action.moveToElement(ciziliAlan).contextClick().perform();
        // Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.
        Assert.assertEquals("You selected a context menu", driver.switchTo().alert().getText());
        // Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        // Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        // Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        List<String> newTabArr = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(newTabArr.get(1));
        Assert.assertEquals("Elemental Selenium", driver.findElement(By.xpath("//h1")).getText());

    }
}

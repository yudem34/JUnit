package day12;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforAfter;

public class Odev1 extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // 1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        // 2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"))).perform();
        // Link 1" e tiklayin
        driver.findElement(By.xpath("//*[text()='Link 1']")).click();
        // Popup mesajini yazdirin
        System.out.println(driver.switchTo().alert().getText());
        // Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        // "Click and hold" kutusuna basili tutun
        actions.clickAndHold(driver.findElement(By.id("click-box"))).perform();
        // 7-"Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(driver.findElement(By.id("click-box")).getText());
        // 8- "Double click me" butonunu cift tiklayin
        actions.doubleClick(driver.findElement(By.id("double-click"))).perform();
    }
}

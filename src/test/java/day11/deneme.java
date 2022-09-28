package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforAfter;

public class deneme extends TestBaseBeforAfter {

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement menu=driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions action=new Actions(driver);
        action.moveToElement(menu).perform();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[text()='Music Library']")).click();

    }
}

package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforAfter;
import org.junit.Test;


public class C01_Actions extends TestBaseBeforAfter {

    @Test
    public void test1() {
        // - Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        // - account menusunden create a list linkine tıklayalım
        WebElement accountMenu = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions=new Actions(driver);
        actions.moveToElement(accountMenu).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
    }
}

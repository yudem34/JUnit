package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

public class KeyboardActions1 extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        // Arama kutusuna actions method’larine kullanarak  samsung A71 yazdirin ve Enter’a basarak arama  yaptirin
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        actions.click(searchBox).
                sendKeys("s").
                sendKeys("a").
                sendKeys("m").
                sendKeys("s").
                sendKeys("u").
                sendKeys("n").
                sendKeys("g").
                sendKeys(" ").keyDown(Keys.SHIFT).
                sendKeys("a").keyUp(Keys.SHIFT).
                sendKeys("7").
                sendKeys("1",Keys.ENTER).perform();

        // aramanin gerceklestigini test edin
        WebElement sonuc= driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        Assert.assertTrue(sonuc.isDisplayed());

    }
}

package day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

import java.util.ArrayList;
import java.util.List;

public class Odev2 extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // https://html.com/tags/iframe/ sayfasina gidelim
        driver.get("https://html.com/tags/iframe/");
        // 3- video’yu gorecek kadar asagi inin
        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).perform();
        // videoyu izlemek icin Play tusuna basin
        List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
        driver.switchTo().frame(iframeList.get(0));
        WebElement play=driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        play.click();
        // videoyu calistirdiginizi test edin
        Assert.assertFalse(play.isDisplayed());
        //Assert.assertTrue(play.isEnabled());

    }
}

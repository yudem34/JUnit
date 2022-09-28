package practise.day04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 extends TestBaseBeforAfter {
    @Test
    public void test1() throws InterruptedException {
        // go to the URL https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        // ikinci emojiye tıklayın (hayvan emojisini seçin)
        WebElement iframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
        // tüm hayvan emojilerine tıklayın
        List<WebElement> animals = driver.findElements(By.xpath("//*[@class='mdl-tabs__panel is-active']//img"));
        for (WebElement w : animals) {
            w.click();
        }
        driver.switchTo().defaultContent();
        // formu doldurun (dilediğinizi yazabilirsiniz)
        List<WebElement> metinList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));
        List<String> text=new ArrayList<>(Arrays.asList("bu","listi","kullanarak","her","bir","webelementi","kolayca","metinliste","gonderme","imkanimiz","oldu"));
        // yada text.get(i) yerine faker().name().name() yazabiliriz!
        for (int i = 0; i <metinList.size() ; i++) {
            metinList.get(i).sendKeys(text.get(i));
        }
        /* Lambda : driver.findElements(By.cssSelector("input[class=\"mdl-textfield__input\"]")).forEach(t->t.sendKeys(faker.name().name()));*/
        // apply butonuna tıklayın
        driver.findElement(By.xpath("//*[@id='send']")).click();
    }
}

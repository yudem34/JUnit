package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforAfter;

public class C05_Actions extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        // “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement dropHere = driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        actions.dragAndDrop(dragMe, dropHere).perform();
        //3 "Drop here" yazisi yerine "Dropped!" oldugunu test edin
        Assert.assertEquals(dropHere.getText(),"Dropped!");

    }
}

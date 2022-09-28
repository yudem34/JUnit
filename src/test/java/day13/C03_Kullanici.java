package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

import java.util.Scanner;

public class C03_Kullanici extends TestBaseBeforAfter {
    @Test
    public void test1() throws InterruptedException {

        /*Bir onceki class'taki adrese gidelim
          login() methodunu kullanarak sayfaya giris yapalim
          input olarak verilen satir ve sutun sayisina sahip
          cell'deki texti yazdiralim.*/
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(2000);
        // satir ve sutun
        int satir = 2;
        int sutun = 5;
        System.out.println(driver.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]")).getText());

    }
}

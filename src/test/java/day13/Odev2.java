
package day13;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

public class Odev2 extends TestBaseBeforAfter {
    @Test
    public void test1() throws InterruptedException {
        // Bir metod oluşturun :
        // Satır(row) ve sütun(column) numarasını girdiğinizde, printData metodu bu
        // hücredeki(cell) veriyi yazdırmalıdır.
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
        Thread.sleep(2000);
        // printData(int row, int column);
        // Örnek: printData (3,5); => 3. satır, 5. Sütundaki veriyi yazdırmalıdır
        printData(3, 5);
        // yazdirilan datanin olmasi gereken dataya esit oldugunu test edin
        //Assert.assertEquals("izmir",driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]")).getText(););



    }

    public void printData(int row, int column) {
        System.out.println(driver.findElement(By.xpath("//tbody//tr[" + row + "]//td[" + column + "]")).getText());
    }
}

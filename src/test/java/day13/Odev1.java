package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

import java.util.List;

public class Odev1 extends TestBaseBeforAfter {
    @Test
    public void test1() throws InterruptedException {
        // Bir class oluşturun : Odev1
        // login( ) metodun oluşturun
        login();
        // table( ) metodu oluşturun
        table();
        // printRows( ) metodu oluşturun //tr
        printRows();
        // printCells( ) metodu oluşturun //td
        printCells();
        // printColumns( ) metodu oluşturun
        printColums();
    }

    private void login() throws InterruptedException {
        // https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin ve oturum açın.
        driver.get("https://qa-environment.concorthotel.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        // Username : manager  ○ Password : Manager2!
        actions.click(driver.findElement(By.xpath("//*[@id='UserName']"))).
                sendKeys("manager").sendKeys(Keys.TAB).sendKeys("Manager1!").
                sendKeys(Keys.ENTER).perform();
        Thread.sleep(2000);
    }

    private void table() {
        // Tüm table body'sinin boyutunu(sutun sayisi) bulun.
        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//th"));
        System.out.println("Sutun Sayisi : " + sutunBasliklari.size());
        // Table'daki tum body'i ve başlıkları(headers) konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        System.out.println("Sutun Basliklari");
        System.out.println(driver.findElement(By.xpath("//thead//tr[1]")).getText());

    }

    private void printRows() {
        // table body'sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir Sayisi : "+satirSayisi.size());
        // Table body'sinde bulunan satirlari(rows) konsolda yazdırın.
        int sayac=1;
        //satirSayisi.forEach(t-> System.out.println(t.getText()));
        for (WebElement w:satirSayisi) {
            System.out.println(sayac+" . satir : "+w.getText());
            sayac++;
        }
        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4. Satir : "+satirSayisi.get(3).getText());
    }

    private void printCells() {
        // table body'sinde bulunan toplam hücre(cell) sayısını bulun.
        List<WebElement> sutunSayisi = driver.findElements(By.xpath("//th"));
        List<WebElement> satirSayisi=driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("toplam hucre sayisi : "+sutunSayisi.size()*satirSayisi.size());
        // Table body'sinde bulunan hücreleri(cells) konsolda yazdırın.
        System.out.println(driver.findElement(By.xpath("//tbody")).getText());
    }

    private void printColums() {
        // table body'sinde bulunan toplam sutun(column) sayısını bulun.
        List<WebElement> sutunBasliklari = driver.findElements(By.xpath("//th"));
        System.out.println("Sutun Sayisi : " + sutunBasliklari.size());
        // Table body'sinde bulunan sutunlari(column) konsolda yazdırın.
        //System.out.println(driver.findElement(By.xpath("//thead")).getText());
        //System.out.println(driver.findElement(By.xpath("//tbody")).getText());
        // 5.column daki elementleri konsolda yazdırın.*/
        List<WebElement> besinciSutun=driver.findElements(By.xpath("//tbody//td[5]"));
        System.out.println("Besinci Sutun");
        besinciSutun.forEach(t-> System.out.println(t.getText()));

    }
}

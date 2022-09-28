package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

import java.util.List;
import java.util.Scanner;

public class C02_WebTable extends TestBaseBeforAfter {
    @Test
    public void test1() {
        // login( ) metodun oluşturun.
        login();
        // table( ) metodu oluşturun
        table();
        // printRows( ) metodu oluşturun
        printRows();


       /*Genel HTML kodlari acisindan tablo elementleri tag'lerle belirlenmistir.
                - <table>
                - <header> tablonun baslik kismini belirler
                - <tr> veya <th> satirlari
                - <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)
                - <tbody> tablo body'si
                - <tr> satirlari
                - <td> satirdaki cell numarasini verir(bunu sutun diye adlandirabiliriz ama kodlarda sutun yoktur)*/
    }

    public void login() {
        // https://www.hotelmycamp.com/admin/HotelRoomAdmin adresine gidin oturum açın
        // Username : manager
        // Password : Manager1!
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }

    private void table() {
        // Tüm table body’sinin boyutunu(sutun sayisini) bulun.
        List<WebElement> sutunsayisi = driver.findElements(By.xpath("//th"));
        System.out.println("sutun sayisi : " + sutunsayisi.size());
        // Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        List<WebElement> tumBody=driver.findElements(By.xpath("//tbody"));
        for (WebElement w:tumBody) {
            System.out.println(w.getText());
        }
        // basliklar
        for (WebElement w : sutunsayisi) {
            System.out.print(w.getText() + " ");
        }
    }

    private void printRows() {
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirSayisi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println();
        System.out.println("Satir Sayisi : " + satirSayisi.size());
        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        int sayac = 1;
        for (WebElement w : satirSayisi) {
            System.out.println(sayac + " . satir : " + w.getText());
            sayac++;
        }
        // 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4.satir : " + satirSayisi.get(3).getText());
    }
}

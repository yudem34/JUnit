package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Soru_DropDown {
    /*
    Bir class oluşturun: DropDown
    https://the-internet.herokuapp.com/dropdown adresine gidin.
    Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
    Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
    Tüm dropdown değerleri(value) yazdırın
    Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse
    False yazdırın.
    */

    WebDriver driver;
    Select select;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void test1() {
        WebElement ddm = driver.findElement(By.xpath("//*[@id='dropdown']"));
        select = new Select(ddm);
        // 1- Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("====================");
        // 2- Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("====================");
        // 3- Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 2");
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println("====================");
        // 4- Tüm dropdown değerleri(value) yazdırın
        List<WebElement> ddrSayisi=select.getOptions();
        for (WebElement w:ddrSayisi
             ) {
            System.out.println(w.getText());
        }
        // 5- Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
        int optionSayisi=ddrSayisi.size();
        System.out.println(optionSayisi==4?"True":"False");
        Assert.assertNotEquals(optionSayisi,4);
        /* 2.Yol System.out.println(ddrSayisi.size()==4?"True":"False");*/
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


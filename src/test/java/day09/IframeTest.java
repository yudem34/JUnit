package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class IframeTest {
    WebDriver driver;

    /*
    ● Bir class olusturun: IframeTest
    ● https://the-internet.herokuapp.com/iframe adresine gidin.
    ● Bir metod olusturun: iframeTest
       ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
       ○ Text Box’a “Merhaba Dunya!” yazin.
       ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
         dogrulayin ve konsolda yazdirin
     */

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void iframeTest() throws InterruptedException {
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isEnabled());
        System.out.println(driver.findElement(By.xpath("//h3")).getText());
        // Text Box’a “Merhaba Dunya!” yazin.
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        WebElement textBox2 = driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox2.clear();
        textBox2.sendKeys("Merhaba Dunya");
        // TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
        // dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
        WebElement elementalSelenium = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementalSelenium.isDisplayed());
        System.out.println(elementalSelenium.getText());
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


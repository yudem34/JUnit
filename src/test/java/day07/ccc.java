package day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ccc {

    /*
      Amazon'a gidip dropdown dan books seceneğini secip java aratalim
      ve arama sonuclarının java icerdigini test edin
       */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
    }
    @Test
    public void test1() throws InterruptedException {
        //Amazon'a gidip dropdown dan books seceneğini secip java aratalim
        //    ve arama sonuclarının java icerdigini test edin
        driver.get("https://www.amazon.com");
        //dropdown dan bir option secmek icin 3 adım vardır.
        //1.adın dropdown'ı locate edelim
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2.adım: bir select objesi olusturup parametre olarak bir önceki adımda locate ettigimiz ddm'yu gerilem
        Select select=new Select(dropDownMenu);
        //3.adım :dropdown'da var olan optionlardan istedigimiz bir taneini secelim
        select.selectByVisibleText("Books");//görünür isimle secer
        // select.selectByIndex(); //index ile secer
        // select.selectByValue(); //value değeri ile secer
        //value ve görünür isim farklı olabilir.
        //4.adım arama kutusuna java yazın
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisistr=sonucYazisiElementi.getText();
        String arananKelime="java";
        Thread.sleep(1000);
        Assert.assertFalse(sonucYazisistr.contains(arananKelime));
        Thread.sleep(1000);
    }
}

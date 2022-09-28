package Deneme;

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

public class Zero2 {
    /*
        1. http://zero.webappsecurity.com/ Adresine gidin
        2. Sign in butonuna basin
        3. Login kutusuna “username” yazin
        4. Password kutusuna “password.” yazin
        5. Sign in tusuna basin
        6. Pay Bills sayfasina gidin
        7. “Purchase Foreign Currency” tusuna basin
        8. “Currency” drop down menusunden Eurozone’u secin
        9. “amount” kutusuna bir sayi girin
        10. “US Dollars” in secilmedigini test edin
        11. “Selected currency” butonunu secin
        12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test1() throws InterruptedException {
        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        Thread.sleep(500);
        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();
        Thread.sleep(500);
        // 3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        Thread.sleep(500);
        // 4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        Thread.sleep(500);
        // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@value='Sign in']")).click();
        Thread.sleep(500);
        // 6. Online Bankink sekmesine tıklayın ve Pay Bills sayfasina gidin
        driver.navigate().back();
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(500);
        // 7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();
        Thread.sleep(500);
        // 8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dDC=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(dDC);
        select.selectByValue("EUR");
        Thread.sleep(500);
        // 9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("120");
        Thread.sleep(500);
        // 10. “US Dollars” in secilmedigini test edin
        WebElement uS=driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertTrue(uS.isDisplayed());
        Thread.sleep(500);
        // 11. “Selected currency” butonunu secin
        driver.findElement(By.id("pc_inDollars_false")).click();
        Thread.sleep(1000);
        // 12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.id("purchase_cash")).click();
        Thread.sleep(500);
        // 13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        WebElement successfully=driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        Assert.assertFalse(successfully.isSelected());
        Thread.sleep(1000);
    }

    @After
    public void tearDown() {
        driver.close();
    }
}


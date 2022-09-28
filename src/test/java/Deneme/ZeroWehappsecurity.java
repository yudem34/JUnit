package Deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ZeroWehappsecurity {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void methot() throws InterruptedException {
        //1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //3. Login alanine “username” yazdirin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        //4. Password alanine “password” yazdirin
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        //5. Sign in buttonuna tiklayin
        Thread.sleep(1000);
        driver.findElement(By.xpath(" //*[@class='btn btn-primary']")).click();
        driver.navigate().back();
        Thread.sleep(1000);
        //6. Online Banking sekmesine tıklayın ve sonra Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1000);
        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@id='sp_amount']")).sendKeys("100");
        Thread.sleep(1000);
        //8. tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        Thread.sleep(1000);
        //9. Pay buttonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        Thread.sleep(1000);
        //10. “The payment was successfully submitted.” mesajinin ciktigini control edin
        Assert.assertTrue(driver.findElement(By.xpath("//*[@title='$ 100 payed to payee sprint']")).isDisplayed());
    }
    @After
    public void tearDown(){
        driver.close();
    }
}

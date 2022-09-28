package day16;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforAfter;

public class C02_JSExecutor extends TestBaseBeforAfter{
    @Test
    public void test1() {
        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Asagidaki carreers butonunu gorunceye kadar js ile scroll yapalim
        WebElement careers = driver.findElement(By.xpath("//*[text()='Careers']"));
        JavascriptExecutor jsE = (JavascriptExecutor) driver;
        jsE.executeScript("arguments[0].scrollIntoView(true);",careers);
        // Careers butonuna js ile click yapalim
        // Açıklaması  : Locate ettiğimiz careers kısmı  görünene kadar mouse'un aşağı-yukarı tuşları ile web sayfasını kaydır.
        jsE.executeScript("arguments[0].click();",careers);
    }
}

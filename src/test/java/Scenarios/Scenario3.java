package Scenarios;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario3 {
    public static void execute(WebDriver driver) throws InterruptedException {
        driver.get("https://service.northeastern.edu/tech?id=classrooms");
        driver.findElement(By.xpath("//*[@id=\"x77ea03d9972dd1d8beddb4221153afa6\"]/div/div[2]/span/div/div/div[1]/div/div/div/a")).click();
        //driver.get("https://service.northeastern.edu/tech?id=classroom_details&classroom=9ac92fb397291d905a68bd8c1253afd0");
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"x51d2fa949721d518beddb4221153af23\"]/div/div[2]/span/table[1]/tbody/tr[1]/td[2]/a"))).click();
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"x51d2fa949721d518beddb4221153af23\"]/div/div[2]/span/table[1]/tbody/tr[1]/td[2]/a")));
        String url = driver.findElement(By.xpath("//*[@id=\"x51d2fa949721d518beddb4221153af23\"]/div/div[2]/span/table[1]/tbody/tr[1]/td[2]/a")).getAttribute("href");
        System.out.println(url);
        try {
            URLDownloader.downloadURL(url, "/Users/zhaozihan/Downloads/downloaded.pdf");
            Thread.sleep(3000);
            List<String> handles = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(handles.get(0));
            System.out.println("downloaded from url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
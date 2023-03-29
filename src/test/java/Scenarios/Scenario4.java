package Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Scenario4 {
    public static void execute(WebDriver driver) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        // a) open https://onesearch.library.northeastern.edu/discovery/search?vid=01NEU_INST:NU&lang=en
        driver.get("https://onesearch.library.northeastern.edu/discovery/search?vid=01NEU_INST:NU&lang=en");
        assert driver.getTitle().contains("SOS");

        // and click on "Digital Repository Service"
        driver.findElement(By.xpath("//*[@id=\"mainMenu\"]/div[5]/a/span")).click();

        // switch handle to the new tab
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size()-1));

        // b) click on "Datasets" under the featured content and open any dataset
        driver.findElement(By.xpath("//*[@id=\"main-content\"]/div[1]/section/div[1]/a[5]")).click();
//        WebElement dataBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"main-content\\\"]/div[1]/section/div[1]/a[5]")));
//        dataBtn.click();

        // c) Click on “Zip File” and download the dataset.
        WebElement zipBtn = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[title='Zip File']")));
        zipBtn.click();

        Thread.sleep(3000);

        driver.switchTo().window(handles.get(0));
    }
}

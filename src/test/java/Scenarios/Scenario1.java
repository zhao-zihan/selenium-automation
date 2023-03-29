package Scenarios;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Scenario1 {
    public static void execute(WebDriver driver) throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://northeastern.sharepoint.com/sites/StudentHub");
        // c) Hit the Resources tab
        driver.findElement(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a/span")).click();

        // d) Go to Academics, Classes, and Registration
        WebElement ACRBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[1]/div[2]/div/div[1]/div/div/img")));
        ACRBtn.click();

        // e) Go to My Transcripts
//        WebElement myTransBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[18]/div/div/a")));
        WebElement myTransBtn = driver.findElement(By.linkText("My Transcript"));
        js.executeScript("arguments[0].scrollIntoView();", myTransBtn);
        myTransBtn.click();

        // switch handle to the new tab
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size()-1));

        // f) Select Transcript Level as “Graduate” and Transcript Type as “Audit Transcript”
        assert driver.getTitle().contains("Academic Transcript Options");

        WebElement selectElement = driver.findElement(By.name("levl"));
        Select select = new Select(selectElement);
        select.selectByValue("GR");
        WebElement submitBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/form/input")));
        submitBtn.click();

        // g) Click on Print and Save as Pdf
        js.executeScript("setTimeout(function() { window.print(); }, 0);");

        // switch handle to the new tab
        handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(handles.size()-1));

        String jsPath = "document.querySelector(\"body > print-preview-app\").shadowRoot.querySelector(\"#sidebar\").shadowRoot.querySelector(\"print-preview-button-strip\").shadowRoot.querySelector(\"div > cr-button.action-button\")";

        WebElement printBtn = (WebElement) js.executeScript("return " + jsPath);
        printBtn.click();

        Thread.sleep(5000);

        driver.switchTo().window(handles.get(0));
    }
}

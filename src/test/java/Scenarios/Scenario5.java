package Scenarios;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Scenario5 {

    public static void execute(WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.get("https://northeastern.sharepoint.com/sites/StudentHub");

        WebElement getStartedBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[2]/button[2]/span/span")));
        getStartedBtn.click();

        //go to resource
        WebElement resourceBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a")));
        resourceBtn.click();
//        driver.findElement(By.xpath("//*[@id=\"spSiteHeader\"]/div/div[2]/div/div[3]/div/div/div/span[4]/a")).click();
        Thread.sleep(2000);
        //career and employment
        driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[1]/div[2]/div/div[2]/div/div/img")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"7b3083e7-1956-4f64-968b-920d938ba636\"]/div/div/div/div[2]/div/div/div[1]/div/div[1]/div/div")).click();
        Thread.sleep(2000);

        //open another tab
        List<String> handles = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(handles.size());
        driver.switchTo().window(handles.get(handles.size() - 1));

        //click find a job
        driver.findElement(By.xpath("//*[@id=\"post-2\"]/div/div/div/div[1]/div[3]/div[2]/div/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"post-2071\"]/div/div/div/div[1]/section/div[1]/div/div/a[1]")).click();
        Thread.sleep(2000);


        //workday login
        WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='tdCheckbox']")));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
        driver.findElement(By.xpath("//*[@id=\"submitButton\"]")).click();
        Thread.sleep(2000);

        //click menu
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app-chrome-container\"]/div/div[6]/div[1]/div[1]/button"))).click();
//        driver.findElement(By.xpath("//*[@id=\"app-chrome-container\"]/div/div[6]/div[1]/div[1]/button")).click();
//        Thread.sleep(1000);

        //jobs and career hub

//        driver.findElement(By.xpath("//*[@id=\"tabpanel-z3m00-app\"]/div/div[2]/div/ul/li[3]/a")).click();
//        Thread.sleep(1000);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tabpanel-z3m00-app\"]/div/div[2]/div/ul/li[3]/a/div"))).click();

//        Actions objectAction = new Actions(driver);
//        Capabilities cap = ((RemoteWebDriver)driver).getCapabilities();
//        String options= cap.getBrowserName().toLowerCase();
//
//        switch (options){
//            case "personal information":
//
//        }


//        Thread.sleep(5000);
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        String jsPath = "document.querySelector(\"#tabpanel-p5xe0-app > div > div.css-1nawy27-MainContent.e1lshut73 > div > ul > li:nth-child(3) > a > div > span > span:nth-child(1) > span\")";
//
//        WebElement clickEle = (WebElement) js.executeScript("return " + jsPath);
//        System.out.println(clickEle.getAttribute("outerHTML"));
//        clickEle.click();


        //driver.get("https://www.myworkday.com/northeastern/d/inst/13102!CK5mGhIKBggDEMenAhIICgYI1A0Q5wE~*AmKOdsyb7NU~/cacheable-task/23748$4.htmld#backheader=true&TABINDEX=0");

        //click student employment
        driver.findElement(By.xpath("//*[@id=\"tab_0d936efb-4d90-4b40-a052-e6f69d747e85\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@id=\"0f7f8bfbb9244272b73a66b5d7be7cdf\"]/div/div/div[1]")).click();
        Thread.sleep(1000);

        //open another tab

        driver.switchTo().window(handles.get(handles.size() - 1));

        //click student
        driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/span/div/div/div[4]/div[1]/a")).click();


//        driver.get("https://studentemployment.northeastern.edu/part-time/");
//        driver.findElement(By.xpath("//*[@id=\"post-2071\"]/div/div/div/div[1]/section/div[1]/div/div/a[1]")).click();
//        //click menu
//        driver.findElement(By.xpath("//*[@id=\"app-chrome-container\"]/div/div[6]/div[1]/div[1]/button")).click();
//        //jobs and career hub
//        driver.findElement(By.xpath("//*[@id=\"tabpanel-bk6j0-app\"]/div/div[2]/div/ul/li[3]/a")).click();
//
//        driver.findElement(By.xpath("//*[@id=\"tab_bcbd461f-ea4e-43da-b065-35bea62f9a63\"]/div[2]/div")).click();
//        driver.findElement(By.xpath("//*[@id=\"e94285541c5144dbb0e12697dacc4fee\"]/div/div")).click();
        driver.quit();
    }
}
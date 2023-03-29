package Scenarios;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginHelper {
    public WebDriver login(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/zhaozihan/Downloads/chromedriver_mac_arm64 (1)/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://me.northeastern.edu/");

        driver.findElement(By.className("idpDescription")).click();

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='username']"))).sendKeys(username);
        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']"))).sendKeys(password);

        WebElement loginBtn = driver.findElement(By.name("_eventId_proceed"));
        loginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("duo_iframe"));

        // Wait for the button to be displayed and clickable
        WebElement duoBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='auth_methods']/fieldset/div[1]/button")));

        // Click the button
        duoBtn.click();

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"idSIButton9\"]"))).click();

        return driver;
    }
}

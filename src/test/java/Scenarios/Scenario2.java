package Scenarios;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario2 {
    public static void execute(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        driver.get("https://northeastern.instructure.com/");
        System.out.println("Opened Canvas URL");

        driver.get("https://northeastern.instructure.com/calendar#view_name=month&view_start=2023-03-26");
        System.out.println("Opened calendar");

        // Add button
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div[2]/div/div[2]/div[1]/div/div[1]/div/div/div/div[2]/a/i")));
        addButton.click();

        // Click My To-Do
        WebElement myToDo = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'My To Do')]")));
        myToDo.click();

        // Enter title
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("planner_note_title")));
        title.sendKeys("class presentation");

        // Date picker
        WebElement datePicker = driver.findElement(By.xpath("//*[@id=\"edit_planner_note_form_holder\"]/form/div[1]/table/tbody/tr[2]/td[2]/div/div[1]/button"));
        datePicker.click();
        WebElement specificDate = driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[4]/a"));
        specificDate.click();

        // Time input
        WebElement time = driver.findElement(By.xpath("//*[@id=\"planner_note_time\"]"));
        time.sendKeys("9:00");

        // Details input
        WebElement details = driver.findElement(By.xpath("//*[@id=\"details_textarea\"]"));
        details.sendKeys("Selenium presentation");

        // Submit
        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"edit_planner_note_form_holder\"]/form/div[2]/button"));
        submitButton.click();

        // Wait for a few seconds before closing the browser to observe the result
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("edit_planner_note_form_holder")));

    }
}
package Scenarios;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Scenarios {
    WebDriver driver;
    @Test(priority = 1)
    public void Scenario1() throws InterruptedException {
        LoginHelper loginHelper = new LoginHelper();
        driver = loginHelper.login(Constants.NEU_USERNAME, Constants.NEU_PASSWORD);
        Scenario1 scenario1 = new Scenario1();
        scenario1.execute(driver);
    }

    @Test(priority = 2)
    public void Scenario2() throws InterruptedException {
        Scenario2 scenario2 = new Scenario2();
        scenario2.execute(driver);
    }

    @Test(priority = 3)
    public void Scenario3() throws InterruptedException {
        Scenario3 scenario3 = new Scenario3();
        scenario3.execute(driver);
    }

    @Test(priority = 4)
    public void Scenario4() throws InterruptedException {
        Scenario4 scenario4 = new Scenario4();
        scenario4.execute(driver);
    }

    @Test(priority = 5)
    public void Scenario5() throws InterruptedException {
        Scenario5 scenario5 = new Scenario5();
        scenario5.execute(driver);
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}

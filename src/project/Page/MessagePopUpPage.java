package project.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MessagePopUpPage {
    private WebDriver driver;

    public MessagePopUpPage(WebDriver driver) {
        this.driver = driver;
    }
    public void waitForPopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@role, 'status')]")));
    }
    public void waitForErrorPopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'error')]")));
    }
    public void waitForImportantPopUpToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@role, 'status')]")));
    }
    public WebElement getMessageTextFromSuccesPopUp(){
        return this.driver.findElement(By.xpath("//div[contains(@class,'success')]/div"));
    }
    public void waitForPopUpDeleteCityToBeVisible() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By
                .xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]")));

    }
    public WebElement getElementsWithVisibleMessagesForCities(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-snack')]/div[contains(@class, 'success')]"));
    }
}
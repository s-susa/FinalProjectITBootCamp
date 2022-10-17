package project.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignupPage {
    private WebDriver driver;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getInputName (){
        return this.driver.findElement(By.id("name"));
    }
    public WebElement getInputEmail(){
        return this.driver.findElement(By.id("email"));
    }
    public WebElement getInputPassword(){
        return this.driver.findElement(By.id("password"));
    }
    public WebElement getConfirmPassword(){
        return this.driver.findElement(By.id("confirmPassword"));
    }
    public WebElement getSignMeUpButton(){
        return this.driver.findElement(By.xpath("//button[contains(@type, 'submit')]"));
    }
    public WebElement getCloseButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'v-card__actions')]/button"));
    }

}
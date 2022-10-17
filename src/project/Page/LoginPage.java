package project.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement getEmailInput(){
        return this.driver.findElement(By.id("email"));
    }
    public WebElement getPasswordInput() {
        return this.driver.findElement(By.id("password"));
    }
    public WebElement getSubmitLoginButton() {
        return this.driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[1]/div[2]/div[1]/div[1]/div[3]/span[1]/form[1]/div[1]/div[3]/button[1]"));
    }
}

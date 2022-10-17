package project.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavigationPage {
    private WebDriver driver;


    public NavigationPage(WebDriver driver) {

        this.driver = driver;
    }

    public WebElement getHomeLink () {
        return this.driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a"));

    }
    public WebElement getAboutLink (){
        return  this.driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[2]"));
    }
    public WebElement getMyProfileButton(){
        return  this.driver.findElement(By.xpath("//a[contains(@class, 'btnProfile')]"));
    }
    public WebElement getAdminButton() {
        return this.driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton(){
        return this.driver.findElement(By.xpath("//a[contains(@class, 'btnAdminCities')]"));
    }
    public WebElement getUsersButton (){
        return this.driver.findElement(By.xpath("//a[contains(@class, 'btnAdminUsers')]"));
    }
    public WebElement getLogOutButton(){
        return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
    }
    public WebElement getLanguageButton(){
        return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }
    public WebElement getLanguageENButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnEN')]"));
    }
    public WebElement getLanguageESButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnES')]"));
    }
    public WebElement getLanguageFRButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnFR')]"));
    }
    public WebElement getLanguageCNButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnCN')]"));
    }
    public WebElement getLoginButton(){
        return this.driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')]"));
    }
    public WebElement getSignUpButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[4]"));
    }
    public WebElement getHeader (){
        return this.driver.findElement(By.tagName("h1"));
    }
}

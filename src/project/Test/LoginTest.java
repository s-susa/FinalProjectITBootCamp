package project.Test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BasicTests {
    @Test(priority = 1)
    public void visitLoginPage() throws InterruptedException {
        this.driver.get(baseUrl);
        navPage.getLanguageButton().click();
        navPage.getLanguageENButton().click();
        navPage.getLoginButton().click();

        Thread.sleep(1000);

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/login",
                "[ERROR] The URL does not contain /login part.");
    }

    @Test (priority = 2)
    public void checkInputTypes (){
        navPage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Attributes does not contain type 'email'.");

        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Attributes does not contain type 'password'.");
    }
    @Test(priority = 3)
    public void displayErrorsWhenUserDoesNotExist (){

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getSubmitLoginButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(this.driver.findElement(By.xpath("//div[contains(@role, 'status')]/ul/li")).getText(),
                "User does not exists",
                "[ERROR] Text does not contain 'User does not exists'.");

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/login",
                "[ERROR] This URL does not have /login.");
    }
    @Test(priority = 4)
    public void displayErrorsWhenPasswordIsWrong (){

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getSubmitLoginButton().click();

        messagePopUpPage.waitForErrorPopUpToBeVisible();

        Assert.assertEquals(this.driver.findElement(By.xpath("//div[contains(@role, 'status')]/ul/li")).getText(),
                "Wrong password",
                "[ERROR] Text does not contain 'Wrong Password'.");

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/login",
                "[ERROR] This URL does not have /login.");
    }
    @Test (priority = 5)
    public void logIn () throws InterruptedException {

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getSubmitLoginButton().click();


        Thread.sleep(1500);

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/home",
                "[ERROR] This URL does not have /home.");
    }
    @Test (priority = 6)
    public void logOut (){
        Assert.assertTrue(navPage.getLogOutButton().isDisplayed(),
                "[ERROR] The element does not exists.");

        navPage.getLogOutButton().click();

    }

}
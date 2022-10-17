package project.Test;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTests {
    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getSubmitLoginButton().click();

        navPage.getAdminButton().click();

        Thread.sleep(1000);

        navPage.getCitiesButton().click();

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/admin/cities",
                "[ERROR] The URL does not contain '/admin/cities'");

    }
    @Test(priority = 2)
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {


        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemBoxToBeVisible();

        Thread.sleep(1500);


        Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),
                "text",
                "[ERROR] The input button does not contain attribute 'text'.");
    }
    @Test (priority = 3)
    public void createNewCity() throws InterruptedException {


        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemBoxToBeVisible();
        citiesPage.getNewItemInput().sendKeys("Graz");
        citiesPage.getSaveButton().click();
        citiesPage.waitForSuccessfullyPopUpToBeVisible();

        Thread.sleep(1500);

        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp().getText().contains("Saved successfully"),
                "[ERROR] The pop up does not contain text 'Saved successfully'.");



    }

    @Test(priority = 4)
    public void editCity() throws InterruptedException {

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getInputSearchButton().sendKeys("Graz");
        citiesPage.waitForNumbersOfRowsToBe(1);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getNewItemInput().click();

        Thread.sleep(1500);

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys(Keys.BACK_SPACE)
                .perform();


        citiesPage.getNewItemInput().sendKeys("");
        citiesPage.getNewItemInput().sendKeys("Bec");
        citiesPage.getSaveButton().click();



        citiesPage.waitForSuccessfullyPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp().getText().contains("Saved successfully"),
                "[ERROR] The message from pop-up should be 'Saved successfully'" );

        Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void searchCity() throws InterruptedException {

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getInputSearchButton().sendKeys("Bec");
        citiesPage.waitForNumbersOfRowsToBe(1);

        Thread.sleep(1500);

        Assert.assertTrue(citiesPage.getTableCell(1,2).getText().contains("Bec"),
                "[ERROR] The names do not match.");
    }
    @Test (priority = 6)
    public void  deleteCity (){

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getInputSearchButton().sendKeys("Bec");
        citiesPage.waitForNumbersOfRowsToBe(1);

        Assert.assertTrue(citiesPage.getTableCell(1,2).getText().contains("Bec"),
                "[ERROR] The names do not match.");

        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitForDeleteBoxToBeVisible();
        citiesPage.getDeleteButton().click();

        messagePopUpPage.waitForPopUpDeleteCityToBeVisible();

        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Deleted"),
                "[ERROR] City is not deleted");

    }
}
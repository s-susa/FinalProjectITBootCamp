package project.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTests {
    @Test(priority = 1)
    public void setLocaleToES (){

        navPage.getLanguageButton().click();
        navPage.getLanguageESButton().click();

        Assert.assertTrue(navPage.getHeader().getText().contains("Página de aterrizaje"),
                "[ERROR] The header does not contain 'Página de aterrizaje'.");
    }
    @Test (priority = 2)
    public void setLocaleToEN(){
        navPage.getLanguageButton().click();
        navPage.getLanguageENButton().click();

        Assert.assertTrue(navPage.getHeader().getText().contains("Landing"),
                "[ERROR] The header does not contain 'Landing'.");
    }
    @Test (priority = 3)
    public void setLocaleToCN(){
        navPage.getLanguageButton().click();
        navPage.getLanguageCNButton().click();

        Assert.assertTrue(navPage.getHeader().getText().contains("首页"),
                "[ERROR] The header does not contain '首页'.");
    }
    @Test (priority = 4)
    public void setLocaleToFR(){
        navPage.getLanguageButton().click();
        navPage.getLanguageFRButton().click();

        Assert.assertTrue(navPage.getHeader().getText().contains("Page d'atterrissage"),
                "[ERROR] The header does not contain 'Page d'atterrissage'.");
    }
}
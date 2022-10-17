package project.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import project.Page.*;

import java.time.Duration;

public abstract class BasicTests {

    protected static WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";
    protected static LoginPage loginPage;
    protected NavigationPage navPage;
    protected static SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        this.driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        navPage = new NavigationPage(driver);
        loginPage = new LoginPage(driver);
        signupPage = new SignupPage(driver);
        citiesPage = new CitiesPage(driver);
        messagePopUpPage = new MessagePopUpPage(driver);
    }
    @BeforeMethod
    public void beforeMethod(){
        this.driver.get(baseUrl);
    }
    @AfterClass
    public void afterClass(){
        this.driver.quit();
    }

}
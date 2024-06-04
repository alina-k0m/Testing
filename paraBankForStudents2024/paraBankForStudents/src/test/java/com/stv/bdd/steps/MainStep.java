package com.stv.bdd.steps;

import com.stv.factory.factorypages.MainFactoryPage;
import com.stv.factory.factorytests.BasicFactoryTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.junit.After;
import com.stv.framework.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static com.stv.framework.core.lib.ParaBankPageURLs.START_URL;

public class MainStep extends BasicFactoryTest {
    public static WebDriver getDriver() {
        return MyDriver.getDriver();
    }

    WebDriver driver = getDriver();

    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @Before
    public void beforeClass() {
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Given("^I am on the home page$")
    public void homePage() {
        driver.get(START_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @When("I enter empty username {string}")
    public void enterEmptyUsernameBDD(String usernameBDD) {
        mainFactoryPage.userNameMBDD(usernameBDD);
    }

    @When("I enter password {string}")
    public void enterPasswordBDD(String passwordBDD) {
        mainFactoryPage.passWordMBDD(passwordBDD);
    }

    @Then("^I click LogIn$")
    public void clickLogin() {
        mainFactoryPage.clickOnLogIn();
    }

    @And("^I should see Error Message$")
    public void errorMessage() {
        mainFactoryPage.isErrorMessage();
    }

    @When("^I click to About Us page$")
    public void aboutUsPage() {
        mainFactoryPage.clickOnAboutUs();
    }

    @Then("^ParaSoft Demo Website appears$")
    public void paraSoftDemoPage() {
        mainFactoryPage.isParasoftDemoPage();
    }

    @And("^I should see www.parasoft.com link")
    public void parasoftLink() {
        mainFactoryPage.isParasoftLink();
    }

    @Given("^I am on the About Us page$")
    public void isAboutUsPage() {
        driver.get("https://parabank.parasoft.com/parabank/about.htm");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @When("^I click on ParaSoft Logo$")
    public void clickParasoftLogo() {
        mainFactoryPage.clickOnLogoParaBankLink();
    }

    @Then("^I am exactly on the home page$")
    public void exactlyHomePage() {
        mainFactoryPage.isStartPage();
    }

    @And("^There is no ParaSoft Demo page$")
    public void parasoftDemoCLose() {
        mainFactoryPage.isParasoftDemoClose();
    }


    @When("^I click on ParaSoft Logo twice$")
    public void doubleClickParasoftLogo() {
        mainFactoryPage.doubleClickOnLogoParaBankLink();
    }


    @After
    public void afterClass() throws Exception {
        getDriver().quit();
    }

}

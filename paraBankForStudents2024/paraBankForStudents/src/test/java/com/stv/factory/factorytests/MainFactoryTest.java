package com.stv.factory.factorytests;


import com.stv.factory.factorypages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.stv.framework.core.utils.Waiters.waitForElementVisible;


public class MainFactoryTest extends BasicFactoryTest {

    MainFactoryPage mainFactoryPage = new MainFactoryPage();

    @Test(description = "Assert the main page is loaded and main logl is visible")
    public void assertAccountIconIsDisplayed() {
        boolean actualResult = mainFactoryPage.isMainLogoDisplayed();
        Assert.assertEquals(actualResult, true, "Main Logo isn't visible");
    }

    @Test(description = "Assert the Admin panel is loaded", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void assertAdminPanelOpened() {
        waitForElementVisible(getDriver(), Duration.ofSeconds(3), mainFactoryPage.getAdminLogo());
        mainFactoryPage.clickOnAdminLogo();
        Assert.assertEquals(mainFactoryPage.isAdminPanelDisplayed(), true, "Admin panel isn't visible");
    }


    @Test(description = "Error Message is displayed", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void testErrorWithEmptyUsername() {
        String usernameEnter = "";
        String passwordEnter = "Password123";
        mainFactoryPage.userName(usernameEnter);
        mainFactoryPage.passWord(passwordEnter);
        mainFactoryPage.clickOnLogIn();
        Assert.assertEquals(mainFactoryPage.isErrorMessage(), true, "There is no Error Message");
    }




    @Test(description = "Final Project", dependsOnMethods = "assertAccountIconIsDisplayed")
    public void testFinalProject() {
        mainFactoryPage.clickOnAboutUs();
        mainFactoryPage.isParasoftLink();
        Assert.assertEquals(mainFactoryPage.isParasoftLink(), true, "There is no Parasoft Link");
        mainFactoryPage.isParasoftLink();
        Assert.assertEquals(mainFactoryPage.isParasoftDemoPage(), true, "There is no Parasoft Demo Page");
        mainFactoryPage.clickOnLogoParaBankLink();
        Assert.assertEquals(mainFactoryPage.isParasoftDemoClose(), true, "There is no ParasoftDemo");
        mainFactoryPage.doubleClickOnLogoParaBankLink();
        Assert.assertEquals(mainFactoryPage.isStartPage(), true, "There is not a Star Page");


    }


}

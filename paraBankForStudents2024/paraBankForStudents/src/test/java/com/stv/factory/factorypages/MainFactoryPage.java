package com.stv.factory.factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class MainFactoryPage extends FactoryPage {

    @FindBy(css = "img.admin")
    private WebElement adminLogo;

    @FindBy(css = "img[alt='ParaBank']")
    private WebElement parabankLogo;

    @FindBy(xpath = "//h1[contains(text(),'Administration')]")
    private WebElement adminRightPanel;

    public WebElement getAdminLogo() {
        return adminLogo;
    }

    public void clickOnAdminLogo() {
        adminLogo.click();
    }

    public boolean isMainLogoDisplayed() {
        return parabankLogo.isDisplayed();
    }

    public boolean isAdminPanelDisplayed() {
        return adminRightPanel.isDisplayed();
    }


    @FindBy(xpath = "//input[@name='username']")
    private WebElement usernameLogin;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordLogin;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//p[@class='error']")
    private WebElement errorMessage;


    public void userName(String usernameEnter) {
        usernameLogin.sendKeys(usernameEnter);
    }

    public void passWord(String passwordEnter) {
        passwordLogin.sendKeys(passwordEnter);
    }

    public void userNameMBDD(String usernameBDD) {
        usernameLogin.sendKeys(usernameBDD);
    }

    public void passWordMBDD(String passwordBDD) {
        passwordLogin.sendKeys(passwordBDD);
    }

    public void clickOnLogIn() {
        loginButton.click();
    }


    public boolean isErrorMessage() {
        return errorMessage.isDisplayed();
    }


    @FindBy(xpath = ".//*[text()='www.parasoft.com']/..")
    private WebElement parasoftLinkAtAboutUs;

    public boolean isParasoftLink() {
        return parasoftLinkAtAboutUs.isDisplayed();
    }

    @FindBy(xpath = ".//*[text()='About Us']/..")
    private WebElement aboutUsLink;

    public void clickOnAboutUs() {
        aboutUsLink.click();
    }

    @FindBy(xpath = "//img[@alt='ParaBank']")
    private WebElement logoParaBankLink;

    public void clickOnLogoParaBankLink() {
        logoParaBankLink.click();
    }

    @FindBy(xpath = ".//*[text()='www.parasoft.com']/..")
    private WebElement parasoftDemoClose;

    public boolean isParasoftDemoClose() {
        return parasoftDemoClose.isDisplayed();
    }


    public void doubleClickOnLogoParaBankLink() {
        //создаем объекты
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        actions.doubleClick(logoParaBankLink);
    }

    @FindBy(xpath = "//p[@class='more']")
    private WebElement startPageView;

    public boolean isStartPage() {
        return startPageView.isDisplayed();
    }

    @FindBy(xpath = ".//*[text()='ParaSoft Demo Website']/..")
    private WebElement parasoftDemoPage;

    public boolean isParasoftDemoPage() {
        return parasoftDemoPage.isDisplayed();
    }

}

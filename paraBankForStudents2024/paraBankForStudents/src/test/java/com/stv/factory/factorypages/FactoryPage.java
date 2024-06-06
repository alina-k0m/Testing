package com.stv.factory.factorypages;

import com.stv.framework.core.drivers.MyDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


public abstract class FactoryPage {
    private static WebDriver getDriver() {
        return MyDriver.getDriver();
    }

    protected FactoryPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public static Actions doubleClick(){
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        return actions.doubleClick();}

}

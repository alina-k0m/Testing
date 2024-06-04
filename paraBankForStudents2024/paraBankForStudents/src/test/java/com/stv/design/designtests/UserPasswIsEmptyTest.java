package com.stv.design.designtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.stv.framework.core.lib.ParaBankPageURLs.START_URL;

public class UserPasswIsEmptyTest {
    public static void main(String[] args) {
        // путь к драйверу ChromeDriver
        System.setProperty("webdriver.chrome.driver", "E:\\ALINA\\Programs\\chromedriver-win64\\chromedriver.exe");

        // создаем экземпляр WebDriver
        WebDriver driver = new ChromeDriver();

        // открываем главную страницу
        driver.get(START_URL);

        // находим поле логина и очищаем его
        WebElement loginField = driver.findElement(By.name("username"));
        loginField.clear();

        // находим поле пароля и очищаем его
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.clear();

        // находим кнопку входа и кликаем по ней
        WebElement loginButton = driver.findElement(By.className("button"));
        loginButton.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // проверяем наличие сообщения об ошибке
        WebElement errorMessage = driver.findElement(By.className("button"));
        if (errorMessage.isDisplayed() && errorMessage.getText().contains("Please enter a username and password.")) {
            System.out.println("Тест пройден: ошибка отображается корректно.");
        } else {
            System.out.println("Тест провален: сообщение об ошибке отсутствует или некорректно.");
        }

        // закрываем браузер
        // driver.quit();
    }
}


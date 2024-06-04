package com.stv.design.designtests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//для двойного клика
import org.openqa.selenium.interactions.Actions;
//для задержки при автоматическом переходе на другую страницу
import java.time.Duration;

import static com.stv.framework.core.lib.ParaBankPageURLs.START_URL;

public class FinalTest {
    public static void main(String[] args) {
        // путь к драйверу ChromeDriver

        // создаем экземпляр WebDriver
        WebDriver driver = new ChromeDriver();


        //ТЕСТ 1. Переход на страницу About Us и поиск ссылки www.parasoft.com
        // найти ссылку по тексту

        // открыть веб-страницу
        driver.get(START_URL);

        WebElement linkElement = driver.findElement(By.linkText("About Us"));

        // переход по ссылке
        linkElement.click();

        //загружается новая страница
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // ищем ссылку на новой странице
        boolean isTextPresent = driver.getPageSource().contains("www.parasoft.com");

        System.out.println(isTextPresent ? "ТЕСТ 1 пройден успешно!" : "ТЕСТ 1 не пройден!");


        //ТЕСТ 2. Переход с About us на Главную с помощью LOGO, панель ParaSoft Demo Website должна исчезнуть
        try {
            // страница, на которой мы остановились
            driver.get("https://parabank.parasoft.com/parabank/about.htm");

            // смотрим URL начальной страницы
            String initialUrl2 = driver.getCurrentUrl();

            // найти элемент и выполнить клик по LOGO для перехода на другую страницу
            WebElement link = driver.findElement(By.className("logo"));
            link.click();

            // задержка, чтобы страница успела загрузиться
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // смотрим URL новой страницы
            String newUrl2 = driver.getCurrentUrl();

            // проверить, что URL изменился
            if (!initialUrl2.equals(newUrl2)) {
                System.out.println("ТЕСТ 2. Переход на новую страницу выполнен успешно.");
            } else {
                System.out.println("ТЕСТ 2. Не удалось перейти на новую страницу.");
            }

            // ищем ссылку на новой странице
            boolean isParaSoftDemo = driver.getPageSource().contains("ParaSoft Demo Website");

            System.out.println(isParaSoftDemo ? "ТЕСТ 2. Панель ParaSoft Demo Website не исчезла!" : "ТЕСТ 2. Панель ParaSoft Demo Website исчезла!");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //ТЕСТ 3. Двойной клик по LOGO, надо убедиться, что мы находимся на той же сранице
        // и накуда не перешли
        try {
            // открыть веб-страницу
            driver.get(START_URL);

            // получение текущего URL
            String initialUrl3 = driver.getCurrentUrl();

            // находим логотип по селектору
            WebElement logo = driver.findElement(By.className("logo"));

            // создаем экземпляр Actions для двойного клика
            Actions actions = new Actions(driver);
            actions.doubleClick(logo).perform();

            // задержка, чтобы страница успела загрузиться
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            // получаем нового URL после двойного клика
            String newUrl3 = driver.getCurrentUrl();

            // сравниваем URL
            if (initialUrl3.equals(newUrl3)) {
                System.out.println("ТЕСТ 3. Тест пройден: URL остался тем же после двойного клика на логотип.");
            } else {
                System.out.println("ТЕСТ 3. Тест не пройден: URL изменился после двойного клика на логотип.");
                System.out.println("Начальный URL: " + initialUrl3);
                System.out.println("Новый URL: " + newUrl3);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        // закрыть браузер
        //driver.quit();
    }
}

package lib;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.fail;

/**
 * Created by iboidachenko on 24.04.17.
 */
public class Lib {

    public static WebDriver driver;
    public static WebDriverWait wait;

    //Путь к файлу с настройками
    private static String pathToSettings = "Settings.properties";
    //Настройки
    private static String pathToScreenshotsWithErrors;
//______________________________________________________________________________________
    /**
     * Функция открытия страницы авторизации пользователя
     *
     * @String pathToDriver - путь к драйверу
     * @String url - ссылка на тестовую среду
     */
    public static void openLoginPage (String pathToDriver, String url) throws Exception {
        //Открытие браузера
        System.setProperty(
                "webdriver.chrome.driver",
                pathToDriver
        );
        driver = new ChromeDriver();
        //Открытие тестовой среды
        driver.get(url);
        //Окно браузера во весь экран
        driver.manage().window().maximize();
    }
//______________________________________________________________________________________
    /**
     * Функция выхода из системы
     */
    public static void logout() throws Exception {
        StringBuffer verificationErrors = new StringBuffer();
        driver.quit();
        //Если ошибка при выходе
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
//______________________________________________________________________________________
    /**
     * Функция ожидания элемента
     *
     * @By element - элемент
     */
    public static void waitElement(By element) {
        try {
            //Таймаут ожидания элементов
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        } catch (Exception e) {
            fail("Не найден элемент - " +element);
        }
    }
//______________________________________________________________________________________
    /**
     * Функция ожидания доступности нажатия на элемент
     *
     * @By element - элемент
     */
    public static void waitElementToBeClickable(By element) throws Exception {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { driver.findElement(element).click(); break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
    }
//______________________________________________________________________________________
    /**
     * Функция нажатия клавиши "Enter"
     */
    public static void pressEnter() throws Exception {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ENTER).perform();
        builder.sendKeys(Keys.NULL).perform();
    }
//______________________________________________________________________________________
    /**
     * Функция ввода текста с клавиатуры
     */
    public static void pressKeys(String keys) throws Exception {
        Actions builder = new Actions(driver);
        builder.sendKeys(keys).perform();
        builder.sendKeys(Keys.NULL).perform();
    }
//______________________________________________________________________________________
    /**
     * Функция нажатия клавиши "Tab"
     */
    public static void pressTab() throws Exception {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.TAB).perform();
        builder.sendKeys(Keys.NULL).perform();
    }
//______________________________________________________________________________________
    /**
     * Функция ожидания элемента true/false
     *
     * @By element - элемент
     */
    public static boolean waitElementTF(By element) {
        try {
            //Таймаут ожидания элементов
            wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
//______________________________________________________________________________________
    /**
     * Функция нажатия клавиш "Shift+Tab"
     */
    public static void pressShiftTab() throws Exception {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.chord(Keys.SHIFT,Keys.TAB)).perform();
        builder.sendKeys(Keys.NULL).perform();
    }
//______________________________________________________________________________________
    /**
     * Функция нажатия клавиш "Ctrl+a"
     */
    public static void pressCrrlA() throws Exception {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"a")).perform();
        builder.sendKeys(Keys.NULL).perform();
    }
//______________________________________________________________________________________
    /**
     * Функция нажатия клавиш "Delete"
     */
    public static void pressDelete() throws Exception {
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.DELETE).perform();
        builder.sendKeys(Keys.NULL).perform();
    }
//______________________________________________________________________________________
}

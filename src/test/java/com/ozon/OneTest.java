package com.ozon;

import lib.Lib;
import lib.LoginWindow;
import lib.MenuOzon;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import static lib.Lib.driver;
import static org.junit.Assert.fail;

/**
 * Created by iboidachenko on 24.04.17.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OneTest {
    //Путь к файлу с настройками
    private static String pathToSettings = "src\\main\\resources\\Settings.properties";
    //Настройки
    private static String pathToDriver;
    private static String url;

    //Путь к файлу с параметрами
    private static String pathToProperties = "src\\main\\resources\\Properties.properties";
    //Параметры
    private static String wrongLogin;
    private static String wrongPassword;
    private static String correctLogin;
    private static String correctPassword;

    @BeforeClass
    public static void initialize() throws Exception {
        //Инициализация специального объекта Properties
        //типа Hashtable для удобной работы с данными
        Properties scriptSettings = new Properties();

        //Обращение к файлу и получение данных
        scriptSettings.load(new FileInputStream(pathToSettings));
        pathToDriver = scriptSettings.getProperty("pathToDriver");
        url = scriptSettings.getProperty("url");
        //Печать полученных данных в консоль
        System.out.println("Cсылка на тестовую среду - "+url);

        //Инициализация специального объекта Properties
        //типа Hashtable для удобной работы с данными
        Properties scriptProperties = new Properties();
        //Обращение к файлу и получение данных
        scriptProperties.load(new FileInputStream(pathToProperties));
        wrongLogin = scriptProperties.getProperty("wrongLogin");
        wrongPassword = scriptProperties.getProperty("wrongPassword");
        correctLogin = scriptProperties.getProperty("correctLogin");
        correctPassword = scriptProperties.getProperty("correctPassword");

        System.out.println("Открытие стартовой страницы");
        Lib.openLoginPage(pathToDriver, url);
    }
//______________________________________________________________________________________
    @Test

    public void тестOzon() throws Exception {
        System.out.println("Отрицательный сценарий");
        MenuOzon.менюМойОзон();
        MenuOzon.нажатиеВход();
        LoginWindow.вводПолеЛогин(wrongLogin);
        System.out.println("Выбор поля \"Пароль\"");
        Lib.pressTab();
        LoginWindow.вводПолеПароль(wrongPassword);
        System.out.println("Выбор поля \"Пароль\"");
        Lib.pressTab();
        Lib.pressTab();
        LoginWindow.нажатиеКнопкаВойти();
        if(Lib.waitElementTF(By.xpath("//div/span[@class='ePanelLinks_Label' and contains(text(), 'Мой OZON')]")) == true) {
            System.out.println("Вход не выполнен");
        } else {
            fail("Выполнен вход!");
        }

        System.out.println("Положительный сценарий");
        System.out.println("Очистка поля \"Логин\"");
        LoginWindow.окноЛогинПароль();
        Lib.pressCrrlA();
        Lib.pressDelete();
        LoginWindow.вводПолеЛогин(correctLogin);
        System.out.println("Выбор поля \"Пароль\"");
        Lib.pressTab();
        LoginWindow.вводПолеПароль(correctPassword);
        System.out.println("Выбор поля \"Пароль\"");
        Lib.pressTab();
        Lib.pressTab();
        LoginWindow.нажатиеКнопкаВойти();
        if(Lib.waitElementTF(By.xpath("//div/span[@class='ePanelLinks_Label' and contains(text(), 'Мой OZON')]")) ==true ) {
            fail("Вход не выполнен!");
        } else {
            System.out.println("Выполнен вход");
        }
    }
//______________________________________________________________________________________
    @AfterClass
    public static void finishTest() throws Exception {
        Lib.logout();
    }

}

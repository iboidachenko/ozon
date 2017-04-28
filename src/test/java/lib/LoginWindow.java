package lib;

import com.sun.deploy.trace.Trace;
import com.sun.glass.ui.Clipboard;
import com.thoughtworks.selenium.Selenium;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;
import org.openqa.selenium.security.UserAndPassword;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;



import static org.junit.Assert.*;


import static lib.Lib.driver;

/**
 * Created by iboidachenko on 24.04.17.
 */
public class LoginWindow {
    public static void окноЛогинПароль() throws Exception {
        System.out.println("Ожидание окна \"Логин/Пароль\"");
        Lib.waitElement(By.xpath("//form[@name='form1']"));
    }

    public static void вводПолеЛогин(String login) throws Exception {
        System.out.println("Заполнение поля \"Логин\"");
        окноЛогинПароль();
        Lib.pressKeys(login);
    }

    public static void вводПолеПароль(String password) throws Exception {
        System.out.println("Заполнение поля \"Пароль\"");
        окноЛогинПароль();
        Lib.pressKeys(password);
    }

    public static void нажатиеКнопкаВойти() throws Exception {
        System.out.println("Нажатие кнопки \"Войти\"");
        Lib.pressEnter();
    }
}

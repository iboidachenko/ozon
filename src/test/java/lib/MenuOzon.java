package lib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static lib.Lib.driver;
import static org.junit.Assert.fail;

/**
 * Created by dark on 24.04.17.
 */
public class MenuOzon {
    public static void менюМойОзон() throws Exception {
        System.out.println("Ожидание меню \"Мой озон\"");
        Lib.waitElement(By.xpath("//div/span[@class='ePanelLinks_Label' and contains(text(), 'Мой OZON')]"));
    }
//______________________________________________________________________________________
    public static void нажатиеВход() throws Exception {
        System.out.println("Нажатие \"Вход\"");
        Actions builder = new Actions(Lib.driver);
        builder.moveToElement(Lib.driver.findElement(By.xpath("//div/span[@class='ePanelLinks_Label' and contains(text(), 'Мой OZON')]"))).click(Lib.driver.findElement(By.xpath("//div[@class='ePanelLinks_term jsOption  jsClearTilesFromStorage jsLoginPanel jsBottomPart']")));
        Action mouseoverAndClick = builder.build();
        mouseoverAndClick.perform();
    }
//______________________________________________________________________________________
}

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YandexTest extends AbstractTest {
    @Order(1)
    @Test
    void myActiontest() throws InterruptedException {
        new WebDriverWait(getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.urlContains("https://yandex.ru/pogoda/?lat=43.785049&lon=131.971069&win=564"));
        String URL = getDriver().getCurrentUrl(); //Проверяем урл главной страницы
        Assertions.assertEquals(URL, "https://yandex.ru/pogoda/?lat=43.785049&lon=131.971069&win=564" );
    }
    @Order(2)
    @Test
    void inputTest() {
        WeatherPage weatherPage =new WeatherPage(getDriver());
        weatherPage.buttonLogin();
        weatherPage.inputEmail();
        weatherPage.inputEmailSend();
        weatherPage.signIn();
        weatherPage.failedPassword();
        weatherPage.signIn();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement errorMessage = getDriver().findElement(By.id("field:input-passwd:hint"));
        Assertions.assertEquals(errorMessage.getText(),"Неверный пароль");
        weatherPage.inputPassword();
        weatherPage.password();
        weatherPage.signIn();
    }
    @Order(3)
    @Test
    void mapTest() {
        WeatherPage weatherPage =new WeatherPage(getDriver());
        weatherPage.showOnMap();

        Assertions.assertNotNull(getDriver().findElement(By.cssSelector(".b-page button")).isDisplayed());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Order(4)
    @Test
    void
    sectionsMapTest(){
        WeatherPage weatherPage =new WeatherPage(getDriver());
        weatherPage.showOnMap();
        weatherPage.rainfall();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//span[text()='Молнии']")).isDisplayed());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherPage.nowcast();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//div[text()='см']")).isDisplayed());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherPage.temperature();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//div[text()='°C']")).isDisplayed());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherPage.wind();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//div[text()='м/с']")).isDisplayed());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        weatherPage.pressure();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//div[text()='мм рт. ст.']")).isDisplayed());

    }
    @Order(5)
    @Test
    void forecastTenDayTest() {
        WeatherPage weatherPage =new WeatherPage(getDriver());
        weatherPage.yandex();
        //Assert проверяем что находимся на главной
        String URL = getDriver().getCurrentUrl(); //Проверяем урл главной страницы //для данного пользователя
        Assertions.assertEquals(URL, "https://yandex.ru/pogoda/?lat=43.785049&lon=131.971069&via=hnav" );
        weatherPage.tenDay();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//p[text()='Прогноз погоды в Уссурийске на сегодня, завтра и на ближайшую неделю с точностью до района — рассчитан с помощью ']")).isDisplayed());
        getDriver().navigate().back();
    }

    @Order(6)
    @Test void searchCityTest(){
        WeatherPage weatherPage =new WeatherPage(getDriver());
        weatherPage.search();
        weatherPage.searchSendKeys();
        weatherPage.enter();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//h1[text()='Вы искали: Мурманск']")).isDisplayed());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Order(7)
    @Test
    void weatherMonthTest() {
        WeatherPage weatherPage =new WeatherPage(getDriver());
        weatherPage.month();
        Assertions.assertNotNull(getDriver().findElement(By.xpath(".//span[text()='Сравнить']")).isDisplayed());
    }

}
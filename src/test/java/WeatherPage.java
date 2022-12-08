import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WeatherPage {
    private WebDriver driver;

    private final String button_login_id = "button_1";
    private final String button_mail = "Поле_ввода_эмейл";

    public WeatherPage(WebDriver driver) {
        this.driver = driver;
    }

    public void mapWeather() {
        driver.findElement(By.xpath(".//span[text()='Карта осадков']")).click();
    }

    //YandexTest
    public void buttonLogin() {
        driver.findElement(By.xpath("//span[text()='Войти']")).click();
    }

    public void inputEmail() {
        driver.findElement(By.id("passp-field-login")).click();
    }

    public void inputEmailSend() {
        driver.findElement(By.id("passp-field-login")).sendKeys("AnTONTON111");
    }

    public void signIn() {
        driver.findElement(By.id("passp:sign-in")).click();
    }

    public void inputPassword() {
        driver.findElement(By.id("passp-field-passwd")).click();
    }

    public void failedPassword() {
        driver.findElement(By.id("passp-field-passwd")).sendKeys("Anton111anto");
    }

    public void password() {
        driver.findElement(By.id("passp-field-passwd")).sendKeys("Anton111anton");
    }

    //test 3
    public void showOnMap() {
        driver.findElement(By.xpath(".//div[text()='Показать на карте']")).click();
    }

    //Test 4
    public void rainfall() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/span/label[1]")).click();
    }

    public void nowcast() {
        driver.findElement(By.xpath("/html/body/div[3]/div[2]/span/label[2]")).click();
    }

    public void temperature() {
        driver.findElement(By.xpath(".//input[@value='temperature']")).click();
    }

    public void wind() {
        driver.findElement(By.xpath(".//input[@value='wind']")).click();
    }

    public void pressure() {
        driver.findElement(By.xpath(".//input[@value='pressure']")).click();
    }

    //test5
    public void yandex() {
        driver.findElement(By.xpath(".//span[text()='Прогноз на 10 дней']")).click();
    }

    public void tenDay() {
        driver.findElement(By.xpath(".//a[text()='Подробный прогноз на 10 дней']")).click();
    }

    //Test6
    public void search() {
        driver.findElement(By.cssSelector(".mini-suggest__input")).click();
    }

    public void searchSendKeys() {
        driver.findElement(By.cssSelector(".mini-suggest__input")).sendKeys("Мурманск");
    }

    public void enter() {
        driver.findElement(By.cssSelector(".mini-suggest__input")).sendKeys(Keys.ENTER);
    }

    //Test7
    public void month() {
        driver.findElement(By.xpath(".//a[text()='На месяц']")).click();
    }

}
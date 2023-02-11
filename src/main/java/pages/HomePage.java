package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver webDriver) {
        driver = webDriver;
    }

    public final By constructorHeader = By.xpath(".//h1[text()='Соберите бургер']");

    public final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");

    public final By signInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    public final By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    public final By bunSection = By.xpath(".//div[@style='display: flex;']");
    public final By sauceSection = By.xpath(".//span[text()='Соусы']");
    public final By fillingSection = By.xpath(".//span[text()='Начинки']");

    public final By bunSelected = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Булки']");

    public final By sauceSelected = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Соусы']");

    public final By fillingSelected = By.xpath(".//h2[@class='text text_type_main-medium mb-6 mt-10' and text()='Начинки']");

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    public void clickBunSection() {
        driver.findElement(bunSection).click();
    }

    public void clickSauceSection() {
        driver.findElement(sauceSection).click();
    }

    public void clickFillingSection() {
        driver.findElement(fillingSection).click();
    }

    public void waitForLoadElement(By element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}

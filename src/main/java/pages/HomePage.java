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

    public final By constructorActive = By.xpath(".//a[@class='AppHeader_header__link__3D_hX AppHeader_header__link_active__1IkJo']/p[text()='Конструктор']");
    public final By constructorHeader = By.xpath(".//h1[text()='Соберите бургер']");

    public final By personalAccount = By.xpath(".//p[text()='Личный Кабинет']");

    public final By signInButton = By.xpath(".//button[text() = 'Войти в аккаунт']");

    public final By orderButton = By.xpath(".//button[text() = 'Оформить заказ']");

    public final By bunSection = By.xpath(".//div[@style='display: flex;']");
    public final By sauceSection = By.xpath(".//div[@style='display: flex;']/div/span[text()='Соусы']");
    public final By fillingSection = By.xpath(".//div[@style='display: flex;']/div/span[text()='Начинки']");

    public final By bunSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']");

    public final By sauceSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']");

    public final By fillingSelected = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']");

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

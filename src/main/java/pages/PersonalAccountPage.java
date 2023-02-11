package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {
    private WebDriver driver;

    public PersonalAccountPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public final By constructor = By.xpath(".//p[text()='Конструктор']");

    public final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public final By profile = By.xpath(".//a[text()='Профиль']");

    public final By exitButton = By.xpath(".//button[text()='Выход']");

    public void waitForLoadProfile() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(profile));
    }

    public void clickConstructor() {
        driver.findElement(constructor).click();
    }

    public void clickLogo() {
        driver.findElement(logo).click();
    }

    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public final By emailField = By.xpath(".//input[@type='text']");

    public final By passwordField = By.xpath(".//input[@type='password']");

    public final By signInButton = By.xpath(".//button[text()='Войти']");

    public final By signUpButton = By.xpath(".//a[text()='Зарегистрироваться']");

    public final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");


    public void waitForLoadSignInButton() {
        new WebDriverWait(driver, 8).until(ExpectedConditions.visibilityOfElementLocated(signInButton));
    }

    public void waitForLoadSignUpButton() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(signUpButton));
    }

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickRestoreButton() {
        driver.findElement(restorePasswordButton).click();
    }

    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignInButton();
    }
}

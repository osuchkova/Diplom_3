package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {

    private WebDriver driver;

    public final By textField = By.xpath(".//input[@type = 'text']");
    public final By passwordField = By.xpath(".//input[@type = 'password']");
    public final By signUpButton = By.xpath(".//button[text()='Зарегистрироваться']");

    public final By signInButton = By.xpath(".//a[text()='Войти']");
    public final By passwordError = By.xpath(".//p[text()='Некорректный пароль']");

    public SignUpPage(WebDriver webDriver) {
        driver = webDriver;
    }

    public void waitForLoadElement(By element) {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void setName(String username) {
        driver.findElements(textField).get(0).sendKeys(username);
    }

    public void setEmail(String email) {
        driver.findElements(textField).get(1).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void signUp(String username, String email, String password) {
        setName(username);
        setEmail(email);
        setPassword(password);
        clickSignUpButton();
    }
}

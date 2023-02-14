import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import pages.HomePage;
import pages.LoginPage;
import pages.SignUpPage;
import config.BrowserEnv;

import com.github.javafaker.Faker;

import static org.junit.Assert.assertEquals;

public class SignUpTest {

    private WebDriver driver;
    private String name;
    private String email;
    private String password;
    private LoginPage objLoginPage;

    @Before
    public void setUp() {
        BrowserEnv objBrowser = BrowserEnv.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.clickSignInButton();
        objLoginPage = new LoginPage(driver);
        objLoginPage.waitForLoadSignUpButton();
        objLoginPage.clickSignUpButton();
        Faker faker = new Faker();
        name = faker.name().username();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
    }

    @Test
    public void shouldSignUp() {
        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.waitForLoadElement(objSignUpPage.signUpButton);
        objSignUpPage.signUp(name, email, password);
        objLoginPage.waitForLoadSignInButton();
        assertEquals("Вход", driver.findElement(objLoginPage.signInHeader).getText());
    }

    @Test
    public void shouldNotSignUp() {
        SignUpPage objSignUpPage = new SignUpPage(driver);
        objSignUpPage.waitForLoadElement(objSignUpPage.signUpButton);
        objSignUpPage.signUp(name, email, "test1");
        objSignUpPage.waitForLoadElement(objSignUpPage.passwordError);
        assertEquals("Некорректный пароль", driver.findElement(objSignUpPage.passwordError).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

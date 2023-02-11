import config.BrowserEnv;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.junit.Test;
import org.junit.After;
import pages.HomePage;
import pages.LoginPage;
import pages.RestorePassPage;
import pages.SignUpPage;

public class LoginTest {

    private WebDriver driver;
    HomePage objHomePage;
    LoginPage objLoginPage;

    @Before
    public void setUp() {
        BrowserEnv objBrowser = BrowserEnv.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
    }

    @Test
    public void shouldLoginViaSignInButton() {
        objHomePage.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("xyzshanoa@yandex.ru", "password");
        objHomePage.waitForLoadElement(objHomePage.orderButton);
    }

    @Test
    public void shouldLoginViaPersonalAccount() {
        objHomePage.clickPersonalAccount();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("xyzshanoa@yandex.ru", "password");
        objHomePage.waitForLoadElement(objHomePage.orderButton);
    }

    @Test
    public void shouldLoginViaSignUpForm() {
        objHomePage.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.clickSignUpButton();
        SignUpPage objSignUp = new SignUpPage(driver);
        objSignUp.waitForLoadElement(objSignUp.signInButton);
        objSignUp.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("xyzshanoa@yandex.ru", "password");
        objHomePage.waitForLoadElement(objHomePage.orderButton);
    }

    @Test
    public void shouldLoginViaRestorePassword() {
        objHomePage.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.clickRestoreButton();
        RestorePassPage objRestorePass = new RestorePassPage(driver);
        objRestorePass.waitForLoadElement(objRestorePass.signInButton);
        objRestorePass.clickSignInButton();
        objLoginPage.waitForLoadSignInButton();
        objLoginPage.login("xyzshanoa@yandex.ru", "password");
        objHomePage.waitForLoadElement(objHomePage.orderButton);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

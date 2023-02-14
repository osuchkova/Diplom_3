import config.BrowserEnv;
import org.openqa.selenium.WebDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import pages.HomePage;
import pages.LoginPage;
import pages.PersonalAccountPage;

import static org.junit.Assert.assertEquals;

public class PersonalAccountTest {

    private WebDriver driver;
    private HomePage objHomePage;
    private LoginPage objLoginPage;

    @Before
    public void setUp() {
        BrowserEnv objBrowser = BrowserEnv.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
        objHomePage.clickSignInButton();
        objLoginPage = new LoginPage(driver);
        objLoginPage.login("xyzshanoa@yandex.ru", "testtest1");
    }

    @Test
    public void shouldOpenPersonalAccount() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        assertEquals("Профиль", driver.findElement(obgAccountPage.profile).getText());
    }

    @Test
    public void shouldOpenConstructorByButton() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickConstructor();
        objHomePage.waitForLoadElement(objHomePage.constructorActive);
        assertEquals("Соберите бургер", driver.findElement(objHomePage.constructorHeader).getText());
    }

    @Test
    public void shouldOpenConstructorByLogo() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickLogo();
        objHomePage.waitForLoadElement(objHomePage.constructorActive);
        assertEquals("Соберите бургер", driver.findElement(objHomePage.constructorHeader).getText());
    }

    @Test
    public void shouldExit() {
        objHomePage.clickPersonalAccount();
        PersonalAccountPage obgAccountPage = new PersonalAccountPage(driver);
        obgAccountPage.waitForLoadProfile();
        obgAccountPage.clickExitButton();
        objLoginPage.waitForLoadSignInButton();
        assertEquals("Вход", driver.findElement(objLoginPage.signInHeader).getText());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

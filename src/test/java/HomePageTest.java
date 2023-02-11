import config.BrowserEnv;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class HomePageTest {

    private WebDriver driver;
    HomePage objHomePage;

    @Before
    public void setUp() {
        BrowserEnv objBrowser = BrowserEnv.CHROME;
        driver = objBrowser.getDriver();
        driver.get("https://stellarburgers.nomoreparties.site/");
        objHomePage = new HomePage(driver);
    }

    @Test
    public void shouldOpenBunSection() {
        objHomePage.waitForLoadElement(objHomePage.bunSection);
        objHomePage.clickBunSection();
        objHomePage.waitForLoadElement(objHomePage.bunSelected);
    }

    @Test
    public void shouldOpenSauceSection() {
        objHomePage.waitForLoadElement(objHomePage.sauceSection);
        objHomePage.clickSauceSection();
        objHomePage.waitForLoadElement(objHomePage.sauceSelected);
    }

    @Test
    public void shouldOpenFillingSection() {
        objHomePage.waitForLoadElement(objHomePage.fillingSection);
        objHomePage.clickFillingSection();
        objHomePage.waitForLoadElement(objHomePage.fillingSelected);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

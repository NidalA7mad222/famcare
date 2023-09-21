package app.famcare.base;



import app.famcare.factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



public class BaseTest {

    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }
    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    public void setUp(){
        WebDriver driver = new DriverFactory().initializeDriver();
        setDriver(driver);
    }
    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }




}

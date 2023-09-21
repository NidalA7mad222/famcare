package app.famcare.pages.home;

import app.famcare.base.PageBase;
import app.famcare.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase {
    private static HomePage homePage;

    // Elements
    private By joinAsSpecialist_buttonLocator = By.xpath("//*[@id='navbarContent']/button");
    private By joinAsSpecialistForm_divLocator = By.xpath("//*[@id='joinUsModal']/div");
    private By joinAsSpecialistForm_yourName_inputLocator = By.cssSelector("#joinUsModal form input[name='your-name']");
    private By joinAsSpecialistForm_yourPhone_inputLocator = By.cssSelector("#joinUsModal form input[name='your-phone']");
    private By joinAsSpecialistForm_degree_inputLocator = By.cssSelector("#joinUsModal form input[name='degree']");
    private By joinAsSpecialistForm_specialization_inputLocator = By.cssSelector("#joinUsModal form input[name='specialization']");
    private By joinAsSpecialistForm_experience_inputLocator = By.cssSelector("#joinUsModal form input[name='experience']");
    private By joinAsSpecialistForm_socialmedia_inputLocator = By.cssSelector("#joinUsModal form input[name='socialmedia']");
    private By joinAsSpecialistForm_send_inputLocator = By.cssSelector("#joinUsModal form input[type='submit']\n");

    // Constructor
    private HomePage() {
        super();
    }

    public static HomePage getInstance() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }


    @Step("Visiting the home page")
    public HomePage visit(WebDriver driver) {
        visit(driver, ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    @Step("Open Join as specialist form")
    public HomePage openJoinAsSpecialistForm(WebDriver driver) {
        click(driver, joinAsSpecialist_buttonLocator);
        return HomePage.getInstance();
    }

    @Step("Check if the open join as specialist form is displayed")
    public boolean isJoinAsSpecialistFormDisplayed(WebDriver driver) {
        return isDisplayed(driver, joinAsSpecialistForm_divLocator);
    }
    @Step("Fill your name,your phone,degree,specialization,experience,social media of join as specialist form")
    public HomePage fillJoinAsSpecialistForm(WebDriver driver,String name,String phone,String degree,String specialization,String experience,String socialmedia) {
        type(driver,joinAsSpecialistForm_yourName_inputLocator,name);
        type(driver,joinAsSpecialistForm_yourPhone_inputLocator,phone);
        type(driver,joinAsSpecialistForm_degree_inputLocator,degree);
        type(driver,joinAsSpecialistForm_specialization_inputLocator,specialization);
        type(driver,joinAsSpecialistForm_experience_inputLocator, experience);
        type(driver,joinAsSpecialistForm_socialmedia_inputLocator,socialmedia);
        click(driver,joinAsSpecialistForm_send_inputLocator);
        return HomePage.getInstance();
    }

}

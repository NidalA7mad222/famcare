package app.famcare.testcases.GUIs.home;

import app.famcare.base.BaseTest;
import app.famcare.pages.home.HomePage;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Home Page Test Cases")
public class HomeTest extends BaseTest {

    @Story("Open join as specialist form")
    @Description("it will open join as specialist form by clicking on join as specialist button")
    @Test(description = "Should be able to open join as specialist form by clicking on join as specialist button")
    public void shouldBeAbleToOpenJoinAsSpecialistForm() {

        //Visit the Home page
        HomePage
                .getInstance()
                .visit(getDriver());

        //Clicking on join as specialist button

        boolean isJoinAsSpecialistFormDisplayed = HomePage
                .getInstance()
                .openJoinAsSpecialistForm(getDriver())
                .isJoinAsSpecialistFormDisplayed(getDriver());


        Assert.assertTrue(isJoinAsSpecialistFormDisplayed);

    }
    @Test
    public void shouldBeAbleToFillJoinAsSpecialistForm(){

        HomePage
                .getInstance()
                .visit(getDriver())
                .openJoinAsSpecialistForm(getDriver());



        String name = Faker.instance().name().name();
        String phone = Faker.instance().phoneNumber().phoneNumber();
        String degree = Faker.instance().company().name();
        String specialization = Faker.instance().company().profession();
        String experience = Faker.instance().number().numberBetween(1,10) + "";
        String socialmedia = Faker.instance().address().cityName();

        HomePage
                .getInstance()
                .fillJoinAsSpecialistForm(getDriver(),name,phone,degree,specialization,experience,socialmedia);


    }
}

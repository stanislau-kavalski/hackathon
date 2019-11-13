package com.applitools.hackathon.task.test;

import com.applitools.hackathon.task.assertion.WebElementAssert;
import com.applitools.hackathon.task.driver.DriverProvider;
import com.applitools.hackathon.task.page.LoginPage;
import com.applitools.hackathon.task.utils.PropertiesProvider;

import org.junit.Test;

/**
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public class TraditionalTestLoginPageUi extends TraditionalBaseTest {
    private LoginPage loginPage = new LoginPage();


    @Test
    public void task1() {
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        WebElementAssert.assertThat(loginPage.getHeader())
            .isDisplayed()
            .hasManipulatedText("Login Form", String::trim);
        WebElementAssert.assertThat(loginPage.getLogo())
            .isDisplayed();
        WebElementAssert.assertThat(loginPage.getUsernameLabel())
            .hasText("Username");
        WebElementAssert.assertThat(loginPage.getUsernameField())
            .isDisplayed()
            .hasAttribute("placeholder", "Enter your username");
        WebElementAssert.assertThat(loginPage.getUsernameIcon())
            .isDisplayed();
        WebElementAssert.assertThat(loginPage.getPasswordLabel())
            .hasText("Password");
        WebElementAssert.assertThat(loginPage.getPasswordField())
            .isDisplayed()
            .hasAttribute("placeholder", "Enter your password");
        WebElementAssert.assertThat(loginPage.getPasswordIcon())
            .isDisplayed();
        WebElementAssert.assertThat(loginPage.getSignInButton())
            .isDisplayed()
            .hasText("Log In");
        WebElementAssert.assertThat(loginPage.getRememberMeCheckBox())
            .isDisplayed()
            .isUnChecked();
        WebElementAssert.assertThat(loginPage.getRememberMeLabel())
            .isDisplayed()
            .hasText("Remember Me");
        WebElementAssert.assertThat(loginPage.getTwitterIcon())
            .isDisplayed();
        WebElementAssert.assertThat(loginPage.getLinkedinIcon())
            .isDisplayed();
        WebElementAssert.assertThat(loginPage.getFacebookIcon())
            .isDisplayed();
    }

}

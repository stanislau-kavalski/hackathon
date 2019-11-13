package com.applitools.hackathon.task.test;

import com.applitools.hackathon.task.assertion.WebElementAssert;
import com.applitools.hackathon.task.driver.DriverProvider;
import com.applitools.hackathon.task.page.LoginPage;
import com.applitools.hackathon.task.page.MainPage;
import com.applitools.hackathon.task.utils.PropertiesProvider;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Test 2.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
@RunWith(value = Parameterized.class)
public class TraditionalTestLoginTest extends TraditionalBaseTest {
    private String login;
    private String password;
    private OutcomeChecker outcome;
    private LoginPage loginPage = new LoginPage();

    public TraditionalTestLoginTest(String login, String password, OutcomeChecker outcome) {
        this.login = login;
        this.password = password;
        this.outcome = outcome;
    }

    @Test
    public void task2() {
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        tryLogin(login, password);
        outcome.invoke();
    }

    @Parameters()
    public static Collection<Object[]> sampleData() {
        return Arrays.asList(new Object[][]{
            {StringUtils.EMPTY, StringUtils.EMPTY, checkException("Both Username and Password must be present")},
            {"login", StringUtils.EMPTY, checkException("Password must be present")},
            {StringUtils.EMPTY, "password", checkException("Username must be present")},
            {"login", "password", (OutcomeChecker) () -> {
                MainPage mainPage = new MainPage();
                WebElementAssert.assertThat(mainPage.getLogo()).isDisplayed().hasText("ACME");
            }
            }
        });
    }

    private static OutcomeChecker checkException(String exception) {
        return () -> {
            LoginPage l = new LoginPage();
            WebElementAssert
                .assertThat(l.getLoginException())
                .isDisplayed()
                .hasManipulatedText(exception, String::trim);
        };
    }


    @FunctionalInterface
    private interface OutcomeChecker {
        void invoke();
    }

}

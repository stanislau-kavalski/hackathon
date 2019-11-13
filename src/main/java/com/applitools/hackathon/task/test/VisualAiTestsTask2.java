package com.applitools.hackathon.task.test;

import com.applitools.eyes.RectangleSize;
import com.applitools.hackathon.task.driver.DriverProvider;
import com.applitools.hackathon.task.utils.PropertiesProvider;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

/**
 * Visual AI test task 2.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
@RunWith(value = Parameterized.class)
public class VisualAiTestsTask2 extends VisualAiBaseTest {
    private String testName;
    private String login;
    private String pass;

    public VisualAiTestsTask2(String testName, String login, String pass) {
        this.testName = testName;
        this.login = login;
        this.pass = pass;
    }

    @Test
    public void task2() {
        eyes.open(DriverProvider.getDriver(), "Demo App", testName,
            new RectangleSize(900, 700));
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        tryLogin(login, pass);
        eyes.checkWindow("Login Window Test");
    }

    @Parameters()
    public static Collection<Object[]> sampleData() {
        return Arrays.asList(new Object[][]{
            {"1", StringUtils.EMPTY, StringUtils.EMPTY},
            {"2", "login", StringUtils.EMPTY},
            {"3", StringUtils.EMPTY, "password"},
            {"4", "login", "password"}
        });
    }

}

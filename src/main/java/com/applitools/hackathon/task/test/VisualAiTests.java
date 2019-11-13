package com.applitools.hackathon.task.test;

import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;
import com.applitools.hackathon.task.driver.DriverProvider;
import com.applitools.hackathon.task.page.MainPage;
import com.applitools.hackathon.task.utils.PropertiesProvider;

import org.junit.Before;
import org.junit.Test;

/**
 * Visual AI tests.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public class VisualAiTests extends VisualAiBaseTest {

    @Test
    public void task1() {
        eyes.open(DriverProvider.getDriver(), "Demo App", "Smoke Test", new RectangleSize(900, 700));
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        eyes.checkWindow("Login Window");
    }

    @Test
    public void task3() {
        eyes.open(DriverProvider.getDriver(), "Demo App", "Task  3", new RectangleSize(1300, 700));
        eyes.setForceFullPageScreenshot(true);
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        tryLogin("login", "password");
        MainPage mainPage = new MainPage();
        mainPage.sortByAmount();
        eyes.checkWindow("Main Page Window");
    }

    @Test
    public void task4() {
        eyes.open(DriverProvider.getDriver(), "Demo App", "Task  4", new RectangleSize(1300, 700));
        eyes.setForceFullPageScreenshot(true);
        DriverProvider.getDriver().get(PropertiesProvider.getAppUrl());
        tryLogin("login", "password");
        MainPage mainPage = new MainPage();
        mainPage.openExpensesPage();
        eyes.checkWindow("Expenses Window");
    }


    @Test
    public void task5() {
        eyes.setMatchLevel(MatchLevel.EXACT);
        eyes.open(DriverProvider.getDriver(), "Demo App", "Task 5", new RectangleSize(1300, 700));
        eyes.setForceFullPageScreenshot(true);
        DriverProvider.getDriver().get(PropertiesProvider.getDynamicAppUrl());
        tryLogin("login", "password");
        eyes.checkWindow("Main Window Banner");
    }

}

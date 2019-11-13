package com.applitools.hackathon.task.test;

import com.applitools.hackathon.task.page.LoginPage;

/**
 * Common logic.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public abstract class CommonTest {
    protected void tryLogin(String login, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.getUsernameField().sendKeys(login);
        loginPage.getPasswordField().sendKeys(password);
        loginPage.getSignInButton().click();
    }
}

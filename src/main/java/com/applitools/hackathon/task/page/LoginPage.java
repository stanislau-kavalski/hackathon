package com.applitools.hackathon.task.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Login page.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
public class LoginPage extends BasePage{
    private static final By HEADER = By.xpath("//*[@class='auth-header']");
    private static final By LOGO = By.xpath("//div[@class='logo-w']//img");
    private static final By USER_NAME_LABEL = By.xpath("//label[text()='Username']");
    private static final By PASSWORD_LABEL = By.xpath("//label[text()='Password']");
    private static final By USER_NAME_FIELD = By.id("username");
    private static final By USER_NAME_ICON = By.className("os-icon-user-male-circle");
    private static final By PASSWORD_FIELD = By.id("password");
    private static final By PASSWORD_ICON = By.className("os-icon-fingerprint");
    private static final By SIGN_IN_BUTTON = By.id("log-in");
    private static final By TWITTER_ICON = By.xpath("//img[@src='img/social-icons/twitter.png']");
    private static final By FACEBOOK_ICON = By.xpath("//img[@src='img/social-icons/facebook.png']");
    private static final By LINKEDIN_ICON = By.xpath("//img[@src='img/social-icons/linkedin.png']");
    private static final By LOGIN_EXCEPTION = By.className("alert-warning");

    public WebElement getHeader() {
        return findElement(HEADER);
    }

    public WebElement getLogo() {
        return findElement(LOGO);
    }

    public WebElement getUsernameLabel() {
        return findElement(USER_NAME_LABEL);
    }

    public WebElement getUsernameField() {
        return findElement(USER_NAME_FIELD);
    }

    public WebElement getUsernameIcon() {
        return findElement(USER_NAME_ICON);
    }

    public WebElement getPasswordLabel() {
        return findElement(PASSWORD_LABEL);
    }

    public WebElement getPasswordField() {
        return findElement(PASSWORD_FIELD);
    }

    public WebElement getPasswordIcon() {
        return findElement(PASSWORD_ICON);
    }

    public WebElement getSignInButton() {
        return findElement(SIGN_IN_BUTTON);
    }

    public WebElement getRememberMeCheckBox() {
        return findElement(By.className("form-check-inline"));
    }

    public WebElement getRememberMeLabel() {
        return findElement(By.className("form-check-label"));
    }

    public WebElement getTwitterIcon() {
        return findElement(TWITTER_ICON);
    }

    public WebElement getLinkedinIcon() {
        return findElement(LINKEDIN_ICON);
    }

    public WebElement getFacebookIcon() {
        return findElement(FACEBOOK_ICON);
    }

    public WebElement getLoginException() {
        return findElement(LOGIN_EXCEPTION);
    }

}

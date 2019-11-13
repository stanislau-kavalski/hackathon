package com.applitools.hackathon.task.assertion;

import static com.applitools.hackathon.task.assertion.SoftAssert.softly;

import com.applitools.hackathon.task.utils.FileUtil;

import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.function.Function;

/**
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
public class WebElementAssert extends AbstractAssert<WebElementAssert, WebElement> {
    private WebElementAssert(WebElement webElement) {
        super(webElement, WebElementAssert.class);
    }

    public static WebElementAssert assertThat(WebElement element) {
        return new WebElementAssert(element);
    }

    public WebElementAssert isDisplayed() {
        softly().assertThat(actual.isDisplayed())
            .as("Element is not visible.")
            .isTrue();
        return this;
    }

    public WebElementAssert hasText(String text) {
        String actualText = actual.getText();
        softly().assertThat(actualText)
            .as("Expected text %s is not equal to %s.", text, actualText)
            .isEqualTo(text);
        return this;
    }

    public WebElementAssert hasManipulatedText(String text, Function<String, String> func) {
        String actualText = func.apply(actual.getText());
        softly().assertThat(actualText)
            .as("Expected text %s is not equal to %s.", text, actualText)
            .isEqualTo(text);
        return this;
    }

    public WebElementAssert hasAttribute(String attribute, String value) {
        String actualAttributeValue = actual.getAttribute(attribute);
        softly().assertThat(actualAttributeValue)
            .as("Expected attribute %s is not equal to actual %s.", value, actualAttributeValue)
            .isEqualTo(value);
        return this;
    }

    public WebElementAssert isUnChecked() {
        softly().assertThat(actual.isSelected())
            .as("Checkbox not checked.")
            .isFalse();
        return this;
    }

    public WebElementAssert hasImage() {
        WebElement img = actual.findElement(By.tagName("img"));
        softly().assertThat(img.isDisplayed()).isTrue();
        return this;
    }

    public WebElementAssert imageIsAnimated() {
        WebElement img = actual.findElement(By.tagName("img"));
        softly().assertThat(FileUtil.isGifAnimated(img.getAttribute("src"))).isTrue();
        return this;
    }

}

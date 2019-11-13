package com.applitools.hackathon.task.assertion;

import org.assertj.core.api.SoftAssertions;

/**
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/12/2019
 *
 * @author Stanislau Kavalski
 */
public class SoftAssert {
    private static SoftAssertions softAssertions;

    private SoftAssert() {
        throw new RuntimeException("No direct initialization.");
    }

    public static void reset() {
        softAssertions = new SoftAssertions();
    }

    public static SoftAssertions softly() {
        if (null == softAssertions) {
            reset();
        }
        return softAssertions;
    }


}

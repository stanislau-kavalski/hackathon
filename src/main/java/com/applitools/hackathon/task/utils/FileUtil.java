package com.applitools.hackathon.task.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 * File utils.
 * <p>
 * Company (C) 2019
 * <p>
 * Date: 11/13/2019
 *
 * @author Stanislau Kavalski
 */
public class FileUtil {
    private FileUtil() {
        throw new AssertionError("Should never be instantiated.");
    }

    public static boolean isGifAnimated(String src) {
        int numberOfImages = 0;
        try {
            File file = new File("temp.gif");
            FileUtils.copyURLToFile(new URL(src), file);
            ImageInputStream iis = ImageIO.createImageInputStream(file);
            ImageReader is = ImageIO.getImageReadersBySuffix("GIF").next();
            is.setInput(iis);
            numberOfImages = is.getNumImages(true);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the image file.");
        }

        return numberOfImages > 1;
    }
}

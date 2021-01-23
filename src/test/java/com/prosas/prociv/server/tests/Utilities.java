
package com.prosas.prociv.server.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *     
 * @author sasoRP
 */
public class Utilities {
    public static String readMock(String fileName) throws IOException {
        return Files.readString(Path.of("src/test/resources/mocks/", fileName));
    }
}
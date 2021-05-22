package com.epam.web.logic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class IdGenerator {
    public static String generateString() {
        byte[]array = new byte[7];//length is bounded by 7
        new Random().nextBytes(array);
        return new String(array, StandardCharsets.UTF_8);
    }
}

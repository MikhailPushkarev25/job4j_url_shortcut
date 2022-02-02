package ru.job4j.service;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class StringGenerator {

    public String newUrl() {
        return RandomStringUtils.randomAlphabetic(7);
    }

    public String newLogin() {
        return RandomStringUtils.randomAlphabetic(3) + RandomStringUtils.randomAlphabetic(3);
    }

    public String newPassword() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}

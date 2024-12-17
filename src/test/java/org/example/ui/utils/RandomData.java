package org.example.ui.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {
    public static String randomString(){
        return RandomStringUtils.randomAlphabetic(10);
    }
}

//Класс для рандомизации данных. Потом юзаем в ParaBankUiTest

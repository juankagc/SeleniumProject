package com.luma.utilities;

public class RandomEmail {
    public static String randomEmail(){
        return "juan.gimenez+test" + (int) (Math.random() * 1000) + "@test.com";
    }
}

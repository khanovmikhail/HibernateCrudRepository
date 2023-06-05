package com.github.khanovmikhail;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Test {
    public String test = "test";
    public static List<String> list = new ArrayList<>();

    static {
        list.add("test");
        list.add("cow");
    }
}

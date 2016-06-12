package com.udacity.gradle;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Jokes {
    private static final List<String> JOKES = Arrays.asList(
            "This is a joke from a Java Library",
            "This is another joke from a Java Library",
            "This is yet another joke from a Java Library",
            "derp.",
            "how many jokes are in this library?",
            "You can tell I'm a very serious Computer Scientist who doesn't know any jokes"
    );

    public static String getJoke(){
        int index = new Random().nextInt(JOKES.size());
        return JOKES.get(index);
    }
}

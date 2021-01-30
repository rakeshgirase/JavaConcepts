package com.exuberant.tutorials.javaconcept.json;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class JsonParser {

    public static void main(String[] args) throws FileNotFoundException {
        Reader targetReader = new FileReader("src/main/resources/json/sample.json");
        Accounts accounts = new Gson().fromJson(targetReader, Accounts.class);
        System.err.println(accounts);
        for (Wcis wci : accounts.getWcis()) {
            System.err.println("All Accounts" + wci);
        }
    }

}

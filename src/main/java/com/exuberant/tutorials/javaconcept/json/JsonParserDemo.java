package com.exuberant.tutorials.javaconcept.json;

import com.google.gson.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class JsonParserDemo {

    public static void main(String[] args) throws FileNotFoundException {
        Reader targetReader = new FileReader("src/main/resources/json/sample.json");
        Accounts accounts = new Gson().fromJson(targetReader, Accounts.class);
        try {
            JsonObject jsonObject = new JsonParser().parse("{ \"name\": \"Rakesh\", \"language\": \"java\" }").getAsJsonObject();
            System.err.println("Before: " + jsonObject);
            JsonObject value = new JsonObject();
            value.addProperty("myKey", "myValue");
            jsonObject.add("accounts", value);
            System.err.println("After: " + jsonObject);
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        System.err.println(accounts);
        for (Wcis wci : accounts.getWcis()) {
            System.err.println("All Accounts" + wci);
        }
    }

}

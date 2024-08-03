package org.example;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setName("Andrii");
        user.setLastName("Khshanovskyi");

        Gson json = new Gson();

        System.out.println(json.toJson(user));

    }
}
package com.epam.web.logic;

public class CommandFactory {

    public static Command create(String command) {
        switch (command) {
            case "login":
                return new LoginCommand();
            case "sign-in":
                return new SignInCommand();
            case "view-beats":
                return new CatalogCommand();
            case "to-main":
                return new HomeCommand();
            default: throw new IllegalArgumentException();
        }
    }
}

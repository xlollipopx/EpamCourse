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
            case "view-beats-to-admin":
              return new ViewAdminCatalogCommand();
            case "view-beats-to-customer":
                return new ViewCustomerCatalogCommand();
            case "add-beat":
                return new AddBeatCommand();
            case "log-out":
                return new LogOutCommand();
            case "to-authorized-home":
                return new ToAuthorizedHomeCommand();
            case "view-comments":
                return new ViewCommentsCommand();
            case "add-comment":
                return new AddCommentCommand();
            case "set-locale-command":
                return new SetLocaleCommand();
            default: throw new IllegalArgumentException();
        }
    }


}

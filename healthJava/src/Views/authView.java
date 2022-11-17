package Views;

import java.util.Scanner;

import Controllers.authControllers;
import Controllers.authControllers.EnumView;
import Models.Account;

public class authView {
    public static EnumView viewName;
    public static void authView() {
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("-------------Healthy App-------------");
        System.out.println("1.Login");
        System.out.println("2.Register");
        System.out.println("3.Forgot Password");
        System.out.println("4.Exit");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                authControllers.changeView(viewName.LOGIN);
                break;
            case 2:
                authControllers.changeView(viewName.REGISTER);
                break;
            case 3:
                authControllers.changeView(viewName.FORGOT);
                break;
            case 4:
                authControllers.changeView(viewName.EXIT);
                break;
        }
    }

    public static void loginView(){
        Scanner scanner = new Scanner(System.in);
        Account newAccount = new Account();
        System.out.println("-------------Login-------------");
        System.out.println("Accout Number: ");
        newAccount.setAccountName(scanner.next());
        System.out.println("Password: ");
        newAccount.setPassword(scanner.next());
        authControllers.checkLogin(newAccount);
    }

    public static void registerView(){
        Scanner scanner = new Scanner(System.in);
        Account newAccount = new Account();
        System.out.println("-------------Register-------------");
        System.out.println("Accout Number: ");
        newAccount.setAccountName(scanner.next());
        System.out.println("Password: ");
        newAccount.setPassword(scanner.next());
        authControllers.register(newAccount);
    }

    public static void forgotView(){
        Scanner scanner = new Scanner(System.in);
        Account newAccount = new Account();
        System.out.println("-------------Forgot PassWord-------------");
        System.out.println("Accout Number: ");
        newAccount.setAccountName(scanner.next());
        authControllers.forgot(newAccount);
    }

    public static void ExitView(){
        System.out.println("Bye!!");
        return;
    }

}

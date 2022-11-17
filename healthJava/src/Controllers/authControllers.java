package Controllers;


import java.text.DecimalFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;


import Models.Account;
import Views.MainView;
import Views.authView;

public class authControllers {
    private static final DecimalFormat df = new DecimalFormat("0.0");
    static ArrayList<Account> listAccount = new ArrayList<Account>();
    static Account defaultAccount = new Account("test", "test");
    static int count = 0;


    public static enum EnumView{
        AUTH, LOGIN , REGISTER , FORGOT, EXIT
    }

    public static enum EnumMainView{
        BMI, BOOK, DECLARATION, VACCINE 
    }

    public static void changeView(EnumView view) {
        listAccount.add(defaultAccount);
        switch (view) {
            case AUTH:
                authView.authView();
                break;
            case LOGIN:
                authView.loginView();
                break;
            case REGISTER:
                authView.registerView();
                break;
            case FORGOT:
                authView.forgotView();
                break;
            case EXIT:
                authView.ExitView();
                break;
            default:
                throw new IllegalStateException("View no found!!!");
        }
    }

    public static void changeMainView(EnumMainView view) {
        switch (view) {
            case BMI:
                MainView.BMIView();
                break;
            case BOOK:
                MainView.BookView();
                break;
            case DECLARATION:
                MainView.DeclarationView();
                break;
            case VACCINE:
                MainView.VaccineView();
                break;
        
            default:
                throw new IllegalStateException("View no found!!!");
        }
    }

    public static void checkLogin(Account account){
        boolean authCheck = false;

        for (Account a : listAccount) {
            if(account.getAccountName().equals(a.getAccountName()) && account.getPassword().equals(a.getPassword())){
                authCheck = true;
            }
        }
        if (authCheck){
            MainView.showMainView();
        } else {
            System.out.println("Error login");
            count++;
            if (count > 3){
                System.out.println("Bye!!! No see you");
                return;
            } else changeView(EnumView.LOGIN);
        }
    }

    public static void register(Account account){
        if(checkExistAccount(account)){
            System.out.println("Register false . Again with new Account:  ");
            changeView(EnumView.REGISTER);
        } else {
            System.out.println("Successfully registered");
            listAccount.add(account);
            changeView(EnumView.LOGIN);
        }
    }

    public static void forgot(Account account){
        if(checkExistAccount(account)){
            System.out.println("Please check your mail!!");
        } else {
            System.out.println("Again!!");
            changeView(EnumView.REGISTER);
        }
    }
    
    public static boolean checkExistAccount(Account account){
        for (Account a : listAccount) {
            if(account.getAccountName().equals(a.getAccountName())){
                return true;
            }
        }
        return false;
    }


    // MainView

    public static void checkBMI(Account account){
        double bmi = account.getWeigh() / (account.getHeigh()*2);
        System.out.println("Bmi is " + df.format(bmi));
        if (bmi < 18.5) {
            System.out.println("Thin");
        } else if ( 18.5 <= bmi && bmi <= 24.9) {
            System.out.println("Normal");
        } else if (25 <= bmi && bmi<= 29.9) {
            System.out.println("Weight gain");
        } else if (30 <= bmi && bmi <= 34.9) {
            System.out.println("First-degree obesity");
        } else if (bmi >= 35  && bmi <= 39.9) {
            System.out.println("Second-degree obesity");
        } else if ( bmi >= 40){
            System.out.println("Third-degree obesity");
        }
    } 

    public static void currentDate(){
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        String formatted = current.format(formatter);
        System.out.println(formatted);
    }

}

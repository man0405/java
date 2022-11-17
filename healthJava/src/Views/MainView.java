package Views;

import java.util.Scanner;

import Controllers.Date;
import Controllers.authControllers;
import Controllers.authControllers.EnumMainView;
import Models.Account;

public class MainView {

    private static int day,month,year;

    public static EnumMainView viewMainName;

    public static void showMainView() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("-----------Welcome to Inferno----------");
        System.out.println("1.Body mass index");
        System.out.println("2.Book health check-up");
        System.out.println("3.Medical declaration");
        System.out.println("4.Sign up for the vaccine");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                authControllers.changeMainView(viewMainName.BMI);
                break;
            case 2:
                authControllers.changeMainView(viewMainName.BOOK);
                break;
            case 3:
                authControllers.changeMainView(viewMainName.DECLARATION);
                break;
            case 4:
                authControllers.changeMainView(viewMainName.VACCINE);
                break;
        }

    }

    public static void BMIView(){
        System.out.println("----------BMI----------");
        Scanner scanner = new Scanner(System.in);
        Account account = new Account();
        System.out.println("Enter weight: ");
        account.setWeigh(scanner.nextDouble());
        System.out.println("Enter height: ");
        account.setHeigh(scanner.nextDouble());
        authControllers.checkBMI(account);
    }

    public static void BookView(){
        System.out.println("----------Book health check-up----------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Heart");
        System.out.println("2.Skeletons");
        System.out.println("3.Eyes");
        System.out.println("4.All in");

        int choice = scanner.nextInt();

        switch (choice){
            case 1: 
                System.out.println("Update late");
                break;
            case 2:
                System.out.println("Update late");
                break;
            case 3:
                System.out.println("Update lates");
                break;
            case 4:
                System.out.println("Update late");
                break;
        }
        System.out.println("Enter day");
        day = scanner.nextInt();
        System.out.println("Enter month");
        month = scanner.nextInt();
        System.out.println("Enter year");
        year = scanner.nextInt();
        Date date = new Date(year, month, day);
        System.out.println("Date: " + date.toString());


    }

    public static void DeclarationView(){
        System.out.println("------------Declaration---------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choice y/n: ");
        String choice = scanner.next();
        if (choice.equals("y")){
            System.out.println("You are positive");
            System.out.println("Enter day");
            day = scanner.nextInt();
            System.out.println("Enter month");
            month = scanner.nextInt();
            System.out.println("Enter year");
            year = scanner.nextInt();
            Date date = new Date(year, month, day);
            System.out.println("date: " + date);
        } else {
            System.out.println("You are negative");
            authControllers.currentDate(); 

    }
        

    }

    public static void VaccineView(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------date sign vaccine-------- ");
        System.out.println("Enter day");
        day = scanner.nextInt();
        System.out.println("Enter month");
        month = scanner.nextInt();
        System.out.println("Enter year");
        year = scanner.nextInt();
        Date date = new Date(year, month, day);
        System.out.println("Success!! " + date);

    }

    



}






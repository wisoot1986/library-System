package com.company;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    private static ArrayList<User> user = new ArrayList<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
	    // write your code here
        Books.demoArraylist();

        //Add user
        user.add(new User("Wisoot","Admin"));
        user.add(new User("Tanaphom","User"));
        user.add(new User("Ilada","User"));
        Start ();
    }

    public static void Start (){
        System.out.println("========Menu========");
        System.out.println("Key :1 Borrow/Return Book");
        System.out.println("Key :2 Show All Book");
        System.out.println("Key :3 Show All User");
        System.out.println("Key :4 Search Books");
        System.out.println("Key :5 Exit Program");

        int number = scan.nextInt();
        if (number == 1) {
            System.out.println("Login ID");
            int input = scan.nextInt();
            if (user.get(input - 1).getPosition().equals("Admin")) {
                System.out.println("Cannot Borrow");
                Start();
            } else {
                showMenuUser();
            }
        } else if (number == 2){
            headMenu();
            Books.ShowAllBook();
            Start ();
        } else if (number == 3) {
            Showuser();
            Start ();
        } else if (number == 4) {
            Books.SearchBooks();
            Start ();
        } else if (number == 5) {
            Runtime.getRuntime().exit(0);
        } else {
            Start ();
        }
    }

    public static void Showuser(){
        System.out.println("[Name]\t [Position]");
        for (int i= 0 ;i<user.size();i++){
            System.out.println( (i+1)+"\t"+user.get(i).getUsername()+"\t"+user.get(i).getPosition());
        }
    }

    public static void showMenuUser(){
        System.out.println("=========Menu User========");
        System.out.println("1 Borrow Book");
        System.out.println("2 Return Book");
        System.out.println("3 Main Menu");

        int inputMenu = scan.nextInt();
        switch (inputMenu) {
            case 1:
                Books.BorrowBook();
                if (inputMenu == 1) {
                    Books.BorrowBook();
                } else if (inputMenu == 2) {
                    Books.Reverse();
                } else if (inputMenu == 3) {
                    Start();
                } else {
                    Start();
                }
                break;
            case 2:
                Books.Reverse();
                if (inputMenu == 1) {
                    Books.BorrowBook();
                } else if (inputMenu == 2) {
                    Books.Reverse();
                } else if (inputMenu == 3) {
                    Start();
                } else {
                    Start();
                }
                break;
            case 3:
                Start();
                break;
            default:
        }

    }
    public static void headMenu(){
        System.out.println("[BorrowCode]\t[Code]\t[Category]\t[Class]\t[Name]\t[BorrowDate]\t[ReverseDate]\t[UserBorrow]\t[Status]");

    }

}

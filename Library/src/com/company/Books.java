package com.company;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Books {

    private static ArrayList<Books> menus = new ArrayList();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

    private String Code, Category, Class, Name,Key,BorrowDate,ReverseDate,UserBorrow,Status;

//    public Books() {
//        demoArraylist();
//    }

    public Books(String code, String category, String aClass, String name, String key, String borrowDate, String reverseDate, String userBorrow, String status) {

        Code = code;
        Category = category;
        Class = aClass;
        Name = name;
        Key = key;
        BorrowDate = borrowDate;
        ReverseDate = reverseDate;
        UserBorrow = userBorrow;
        Status = status;
    }

    @Override
    public String toString() {

        return

                " "+ Key+"\t"+Code+"\t"+Category+"\t"+Class+"\t"+ Name+"\t"+BorrowDate+"\t"+ReverseDate+"\t"+UserBorrow+"\t"+Status+"";
    }

    public static void demoArraylist() {

        //Thai
        menus.add(new Books("001", "A", "01", "A SECRET AFFAIR","A001","-","-","-","N"));
        menus.add(new Books("001", "A", "01", "CHILDREN OF THE JACARANDA TREE","A002","-","-","-","N"));
        menus.add(new Books("001", "A", "01", "The Broken Man (Hardback)","A003","-","-","-","N"));
        menus.add(new Books("001", "A", "01", "The Observations (Hardback)","A004","-","-","-","N"));
        //Eng
        menus.add(new Books("002", "B", "02", "The Pop Larkin Chronicles","B001","-","-","-","N"));
        menus.add(new Books("002", "B", "02", "To Fear A Painted Devil","B002","-","-","-","N"));
        menus.add(new Books("002", "B", "02", "The Burning Mountain","B003","-","-","-","N"));
        menus.add(new Books("002", "B", "02", "Cry of Silence","B004","-","-","-","N"));
        //arithmetic
        menus.add(new Books("003", "C", "02", "The Black Seraphim","C001","-","-","-","N"));
        menus.add(new Books("003", "C", "02", "Emerald Decision","C002","-","-","-","N"));
        menus.add(new Books("003", "C", "02", "The Mayan Prophecies","C003","-","-","-","N"));
        menus.add(new Books("003", "C", "02", "RED DRAGON","C004","-","-","-","N"));


    }

    public static void ShowAllBook(){
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + " " + menus.get(i));
        }
    }

//    public String getBookName(int i) {
//        final String s = "[ Class : " + menus.get(i - 1).Class + " ] " + "[ Category : " + menus.get(i - 1).Category + " ]";
//        final String s1 = s + " " + menus.get(i - 1).Name;
//        return s1;
//
//    }

    public static void SearchBooks() {

        System.out.println("Do you want to search by\n" +
                "Key [1] = Code\n" +
                "Key [2] = Category\n" +
                "Key [3] = Name\n");

        Scanner input = new Scanner(System.in);
        String keysQuery;
        keysQuery = input.nextLine();

        switch (keysQuery) {
            case "1":
                System.out.println("Input The Code like : ");
                keysQuery = input.nextLine();
                Main.headMenu();
                QrySearch("Code", keysQuery);
                Main.Start();
                break;
            case "2":
                System.out.println("Input The Category like : ");
                keysQuery = input.nextLine();
                Main.headMenu();
                QrySearch("Category", keysQuery);
                Main.Start();
                break;
            case "3":
                System.out.println("Input The Name like : ");
                keysQuery = input.nextLine();
                Main.headMenu();
                QrySearch("Name", keysQuery);
                Main.Start();
                break;
            default:
                SearchBooks();
                break;
        }
    }

    public static String QrySearch(String sKey, String s) {
        //Scanner input = new Scanner(System.in);
        for (int i = 0; i < menus.size(); i++) {

            if (sKey.equals("Code")) {
                if (menus.get(i).Code.contains(s)) {
                    System.out.print((i + 1) + "" + menus.get(i) + "\n");
                }

            } else if (sKey.equals("Category")) {
                if (menus.get(i).Category.contains(s)) {
                    System.out.print(menus.get(i) + "\n");

                }
            } else  if (sKey.equals("Name")) {
                if (menus.get(i).Name.contains(s)) {
                    System.out.print(menus.get(i) + "\n");

                }
            }else  if (sKey.equals("Key")) {
                if (menus.get(i).Key.contains(s)) {
                    System.out.print(menus.get(i) + "\n");

                }
            }
        }
        return "success";
    }


    public  static  void  BorrowBook() {
        System.out.println("Do you want to search for borrow\n" +
                "Key [1] = Code\n" +
                "Key [2] = Category\n" +
                "Key [3] = Name\n");

        Scanner input = new Scanner(System.in);
        String keysQuery;
        keysQuery = input.nextLine();
        switch (keysQuery) {
            case "1":
                System.out.println("Input The Code like : ");
                keysQuery = input.nextLine();
                Main.headMenu();
                QrySearch("Code", keysQuery);
                System.out.print("Please choose Borrow Code\n");
                keysQuery = input.nextLine();
                QrySearch("Key", keysQuery);
                System.out.println("Do you want to borrow this book ?\n" +
                        "Key : Y=Yes ; N=No ");
                String s1 = input.nextLine();
                if (s1.equals("Y")) {
                    int inD = SearIndex(menus, keysQuery);
                    menus.get(inD).setStatus("Y");
                    menus.get(inD).setBorrowDate(dateFormat.format(new Date()));
                    Main.headMenu();
                    Books.ShowAllBook();
                } else if (s1.equals("N")) {
                    Main.Start();
                }
                Main.showMenuUser();
                break;
            case "2":
                System.out.println("Input The Category like : ");
                keysQuery = input.nextLine();
                QrySearch("Category", keysQuery);
                System.out.println("Please choose Borrow Code");
                keysQuery = input.nextLine();
                QrySearch("Key", keysQuery);
                System.out.println("Do you want to borrow this book ?\n" +
                        "Key : Y=Yes ; N=No ");
                String s2 = input.nextLine();
                if (s2.equals("Y")) {
                    int inD = SearIndex(menus, keysQuery);
                    menus.get(inD).setStatus("Y");
                    menus.get(inD).setBorrowDate(dateFormat.format(new Date()));
                    Main.headMenu();
                    Books.ShowAllBook();
                } else if (s2.equals("N")) {
                    Main.Start();
                }
                Main.showMenuUser();
                break;
            case "3":
                System.out.println("Input The Name like : ");
                keysQuery = input.nextLine();
                QrySearch("Name", keysQuery);
                System.out.println("Please choose Borrow Code");
                keysQuery = input.nextLine();
                QrySearch("Key", keysQuery);
                System.out.println("Do you want to borrow this book ?\n" +
                        "Key : Y=Yes ; N=No ");
                String s3 = input.nextLine();
                if (s3.equals("Y")) {
                    int inD = SearIndex(menus, keysQuery);
                    menus.get(inD).setStatus("Y");
                    menus.get(inD).setBorrowDate(dateFormat.format(new Date()));
                    Main.headMenu();
                    Books.ShowAllBook();
                } else if (s3.equals("N")) {
                    Main.Start();
                }
                Main.showMenuUser();
                break;
            default:
        }
    }

    public  static  void  Reverse() {
        System.out.println("Do you want to search for borrow\n" +
                "Key [1] = Code\n" +
                "Key [2] = Category\n" +
                "Key [3] = Name\n");

        Scanner input = new Scanner(System.in);
        String keysQuery;
        keysQuery = input.nextLine();
        switch (keysQuery) {
            case "1":
                System.out.println("Input The Code like : ");
                keysQuery = input.nextLine();
                Main.headMenu();
                QrySearch("Code", keysQuery);
                System.out.print("Please choose Reverse Code\n");
                keysQuery = input.nextLine();
                QrySearch("Key", keysQuery);
                System.out.println("Do you want to Reverse this book ?\n" +
                        "Key : Y=Yes ; N=No ");
                String s1 = input.nextLine();
                if (s1.equals("Y")) {
                    int inD = SearIndex(menus, keysQuery);
                    menus.get(inD).setStatus("N");
                    menus.get(inD).setReverseDate(dateFormat.format(new Date()));
                    Main.headMenu();
                    Books.ShowAllBook();
                } else if (s1.equals("N")) {
                    Main.Start();
                }
                Main.showMenuUser();
                break;
            case "2":
                System.out.println("Input The Category like : ");
                keysQuery = input.nextLine();
                QrySearch("Category", keysQuery);
                System.out.println("Please choose Reverse Code");
                keysQuery = input.nextLine();
                QrySearch("Key", keysQuery);
                System.out.println("Do you want to Reverse this book ?\n" +
                        "Key : Y=Yes ; N=No ");
                String s2 = input.nextLine();
                if (s2.equals("Y")) {
                    int inD = SearIndex(menus, keysQuery);
                    menus.get(inD).setStatus("N");
                    menus.get(inD).setReverseDate(dateFormat.format(new Date()));
                    Main.headMenu();
                    Books.ShowAllBook();
                } else if (s2.equals("N")) {
                    Main.Start();
                }
                Main.showMenuUser();
                break;
            case "3":
                System.out.println("Input The Name like : ");
                keysQuery = input.nextLine();
                QrySearch("Name", keysQuery);
                System.out.println("Please choose Reverse Code");
                keysQuery = input.nextLine();
                QrySearch("Key", keysQuery);
                System.out.println("Do you want to Reverse this book ?\n" +
                        "Key : Y=Yes ; N=No ");
                String s3 = input.nextLine();
                if (s3.equals("Y")) {
                    int inD = SearIndex(menus, keysQuery);
                    menus.get(inD).setStatus("N");
                    menus.get(inD).setReverseDate(dateFormat.format(new Date()));
                    Main.headMenu();
                    Books.ShowAllBook();
                } else if (s3.equals("N")) {
                    Main.Start();
                }
                Main.showMenuUser();
                break;
            default:
        }
    }

    public  static int SearIndex (ArrayList<Books> obj,String str){

        for(int i = 0; i < obj.size();i++){
            Books strSearch = obj.get(i);
            if(strSearch.Key.contains(str)){
                return i ;
            }
        }
        return -1 ;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }


    public String getBorrowDate() {
        return BorrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        BorrowDate = borrowDate;
    }

    public String getReverseDate() {
        return ReverseDate;
    }

    public void setReverseDate(String reverseDate) {
        ReverseDate = reverseDate;
    }
}

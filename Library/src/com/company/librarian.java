package com.company;

import java.util.ArrayList;

public class librarian {
    ArrayList<String> LibrarianName = new ArrayList<String>();

    public librarian() {
        LibrarianName.add("น.ส.วิชาญาดา  มาเรียน");
        LibrarianName.add("น.ส.สมสกุล  พรมโสภา");
        LibrarianName.add("นายมานิต  มาเแล้ว");
        LibrarianName.add("น.ส.หนึ่งฤทัย  ใจกล้า");
    }


    public String getLibra(int a) {
        String msg;
        if (LibrarianName.size() >= a && a > 0) {
            msg = LibrarianName.get(a - 1);
        } else {
            msg = "ไม่มีรหัสพนักงาน";
        }
        return msg;

    }


    public void getAllNameLibra() {

        for (int i = 0; i < LibrarianName.size(); i++) {
            System.out.println(LibrarianName.get(i));

        }
    }
}



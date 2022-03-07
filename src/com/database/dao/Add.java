package com.database.dao;

import com.database.connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Add {
    public void add(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Name :");
        String name = sc.nextLine();
        System.out.println("Enter Age :");
        int age = Integer. parseInt(sc.nextLine());
        System.out.println("Enter Email :");
        String email = sc.nextLine();


        try{
            Connection con = Connect.Con();
            PreparedStatement row=con.prepareStatement("INSERT INTO user VALUES(default,?,?,?)");
            row.setString(1,name);
            row.setInt(2,age);
            row.setString(3,email);
            if(row.executeUpdate() > 0) System.out.println("User Added Success");
            else  System.out.println("User Not Able To Added");
        }
        catch (Exception e){ e.printStackTrace(); }



        boolean a = true;
        while (a){
            System.out.println("Press C ( FOR GO BACK )");
            String b = sc.nextLine();
            if(b.equalsIgnoreCase("c")) a = false;
        }
    }
}

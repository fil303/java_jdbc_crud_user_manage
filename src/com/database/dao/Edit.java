package com.database.dao;

import com.database.connection.Connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Edit {
    public Integer id ;
    public void edit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User ID");
        if(id == null)
        id = Integer.parseInt(sc.nextLine());
        boolean d = true;
        try{
            Connection con = Connect.Con();
            Statement query = con.createStatement();
            ResultSet res = query.executeQuery("SELECT * FROM user WHERE id ="+id);
            res.next();

            if(!res.wasNull()){
                while (d){
                    System.out.println(" ID   |   NAME   |  AGE   |   EMAIL");
                    System.out.println("===================================");
                    System.out.print(res.getString(1)+"   |");
                    System.out.print(res.getString(2)+"  |");
                    System.out.print(res.getString(3)+"  |");
                    System.out.print(res.getString(4)+"  |");
                    System.out.print("\n");
                    System.out.print("\n");
                    System.out.println("Press 1 ( For Edit Name )");
                    System.out.println("Press 2 ( For Edit Age )");
                    System.out.println("Press 3 ( For Edit Email )");
                    System.out.println("Press 0 ( FOR GO BACK )");
                    Integer option = Integer.parseInt(sc.nextLine());
                    if(option == 1){ name(); break;}
                    if(option == 2){ age(); break;}
                    if(option == 3){ email(); break;}
                    if(option == 0) d = false;
                }
            }else {
                System.out.println("User Not Found ");
            }
        }
        catch (Exception e){ System.out.println("User Not Found "); }
    }
    public void name(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Name");
        String name = sc.nextLine();
        try{
            Connection con = Connect.Con();
            PreparedStatement query = con.prepareStatement("UPDATE user SET name = ? WHERE id = ?");
            query.setString(1,name);
            query.setInt(2,id);
            if(query.executeUpdate() > 0){
                System.out.println("User Name Updated!! ");
                edit();
            }else {
                System.out.println("User Name Update Failed!! ");
                edit();
            }
        }
        catch (Exception e){ e.printStackTrace(); }
    }
    public void  age(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Age");
        int age = Integer.parseInt(sc.nextLine());
        try{
            Connection con = Connect.Con();
            PreparedStatement query = con.prepareStatement("UPDATE user SET age = ? WHERE id = ?");
            query.setInt(1,age);
            query.setInt(2,id);
            if(query.executeUpdate() > 0){
                System.out.println("User Age Updated!! ");
                edit();
            }else {
                System.out.println("User Age Update Failed!! ");
                edit();
            }
        }
        catch (Exception e){ e.printStackTrace(); }
    }
    public void email(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Email");
        String email = sc.nextLine();
        try{
            Connection con = Connect.Con();
            PreparedStatement query = con.prepareStatement("UPDATE user SET email = ? WHERE id = ?");
            query.setString(1,email);
            query.setInt(2,id);
            if(query.executeUpdate() > 0){
                System.out.println("User Age Updated!! ");
                edit();
            }else {
                System.out.println("User Age Update Failed!! ");
                edit();
            }
        }
        catch (Exception e){ e.printStackTrace(); }
    }
}

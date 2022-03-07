package com.database.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.database.connection.Connect;

public class Show {
    public void show(){
        ArrayList<ArrayList> result = new ArrayList<>();
        try {
            Connection con = Connect.Con();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM user");
            while(rs.next()) {
//              Empty row
                ArrayList<String> row = new ArrayList<>();
//              Add to Empty Row
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
//              Add to Result
                result.add(row);
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("ID  |  NAME  |  AGE  |  Email");
        System.out.println("=============================");

        for (ArrayList<String> row:result){
            System.out.print(row.get(0)+"  |");
            System.out.print(row.get(1)+"  |");
            System.out.print(row.get(2)+"  |");
            System.out.print(row.get(3)+"  |");
            System.out.print("\n");
        }
        boolean a = true;
        Scanner sc = new Scanner(System.in);
        while (a){
            System.out.println("Press C ( FOR GO BACK )");
            String b = sc.nextLine();
            if(b.equalsIgnoreCase("c")) a = false;
        }
    }
}

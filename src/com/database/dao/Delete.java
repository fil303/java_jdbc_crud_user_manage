package com.database.dao;
import com.database.connection.Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Delete {
    public void delete(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Id");
        int id = Integer.parseInt(sc.nextLine());
        try {
            Connection con = Connect.Con();
            PreparedStatement row=con.prepareStatement("DELETE FROM user WHERE id=?");
            row.setInt(1,id);
            if(row.executeUpdate() > 0) System.out.println("User Delete Success");
            else  System.out.println("User Not Able To Delete");
        }catch (Exception e){ e.printStackTrace(); }

        boolean a = true;
        while (a){
            System.out.println("Press C ( FOR GO BACK )");
            String b = sc.nextLine();
            if(b.equalsIgnoreCase("c")) a = false;
        }
    }
}

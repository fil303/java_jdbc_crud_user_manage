import com.database.dao.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int option ;
        while (true) {
            System.out.println("Welcome To Simple CRUD Of User Management...");
            System.out.println("========  Menu Option  =======");
            System.out.println(" Press 1 ( To Add User )");
            System.out.println(" Press 2 ( To Edit User )");
            System.out.println(" Press 3 ( To Delete User )");
            System.out.println(" Press 4 ( To See All User List )");

            option = sc.nextInt();
            if(option == 1){
                Add s = new Add();
                s.add();
            }
            if(option == 2){
                Edit s = new Edit();
                s.edit();
            }
            if(option == 3){
                Delete s = new Delete();
                s.delete();
            }
            if(option == 4){
                Show s = new Show();
                s.show();
            }
            try {
                    Runtime.getRuntime().exec("clr");
            } catch (IOException ex) {}
        }


    }
}

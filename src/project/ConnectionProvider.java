package project;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ConnectionProvider {
    static Connection con=null;
    
 public static Connection getConnection(){
     try{
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url="jdbc:mysql://localhost:3306/inventory";
         String user="root";
         String pass="";
         con=DriverManager.getConnection(url,user,pass);
         
         return con;
     }
     catch(Exception e){
         System.out.println(e);
          return null;
     }
    
     
 }
 public static void main(String args[]) throws SQLException{
    
 
 }
}


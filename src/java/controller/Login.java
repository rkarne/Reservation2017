/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import DBUtils.DBConnection;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author rkarne
 */

@Named//correct one from java application 7 if u want to use java 6 then use facelets.*
@SessionScoped

public class Login implements Serializable{
    private String user;
    private int pass;

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(int pass) {
        this.pass = pass;
    }

    public String getUser() {
        return user;
    }

    public int getPass() {
        return pass;
    }
    
    public Login(){
        
    }
    
    public String dologin(){
        //if(user.equals("roja") && 123 == pass){
            //return username + " , " + password; 
            //return "loginsuccess";
        //}
        //else{
          //  return "Please try again";
        //
        try {
            Connection con = DBConnection.getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery("SELECT * FROM users");
             while (rs.next()) {
                 user = rs.getString(1);
                 int password = rs.getInt(2);
                 if(password == pass){
                     //return 'loginsuccess';
                    System.out.println(pass);
                    System.out.println(user);
                    System.out.println(rs.getInt(2));
                    return "loginsuccess";
                 }
                 else{
                      return "index";
                 }
                
             }
            
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return null;
        return "index";
    }
}

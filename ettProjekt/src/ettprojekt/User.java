/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ettprojekt;

/**
 *
 * @author EmelieD
 */
public class User {
    public int userId;
    
    private static User firstInstance = null;
    
    private User(){
        userId = 0;
    }
    
    public static User getInstance(){
        
        if(firstInstance == null){
            firstInstance = new User();
            
        }
        return firstInstance;
    }
    
    public void setId (int ID){
        userId = ID;
    }
    
    public int getID(){
        return userId;
    }
    }
    
    // User.firstInstance = this;


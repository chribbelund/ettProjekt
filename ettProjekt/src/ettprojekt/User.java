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

    public static int userId;
    public static int otherUserId;
    private static User firstInstance = null;

    private User() {
        userId = 0;
        otherUserId = 0;
    }

    public static User getInstance() {

        if (firstInstance == null) {
            firstInstance = new User();

        }
        return firstInstance;
    }

    public static void setId(int ID) {
        userId = ID;
    }
    
    public static void setOtherID(int ID) {
        otherUserId = ID;
    }

    public int getID() {
        return userId;
    }
    public int getOtherID() {
        return otherUserId;
    }
}

// User.firstInstance = this;


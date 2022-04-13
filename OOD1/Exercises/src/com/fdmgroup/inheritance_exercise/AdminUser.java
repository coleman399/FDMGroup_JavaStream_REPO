package com.fdmgroup.inheritance_exercise;

public class AdminUser extends UserAccount{

    public AdminUser(String username, String password, String fullName) {
        super(username, password, fullName);
    }

    @Override
    public void accessWebsites() {
        System.out.println("accessing website");     
    }  
}

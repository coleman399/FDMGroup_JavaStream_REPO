package com.fdmgroup.polymorphism_exercise;

public class AdminUser extends UserAccount{
    private static int minAdminPasswordLength;

    public AdminUser(String username, String password, String fullName) {
        super(username, password, fullName);
    }

    @Override
    public void accessWebsites() {
        System.out.println("accessing website");     
    }
    
    @Override
    public boolean changePassword(String newPass, String confirmPass) {
        boolean result = false;
        if (newPass.equals(confirmPass) && newPass.length() >= minAdminPasswordLength) {
            super.changePassword(newPass, confirmPass);
            result = true;
        }
        return result;
    }

    @Override
    public boolean changePassword(String newPass, String confirmPass, UserAccount user) {
        boolean result = false;
        if (newPass.equals(confirmPass) && newPass.length() >= minAdminPasswordLength) {
            user.changePassword(newPass, confirmPass);
            result = true;
        }
        return result;
    }

    public static int getMinAdminPasswordLength() {
        return minAdminPasswordLength;
    }

    public static void setMinAdminPasswordLength(int minAdminPasswordLength) {
        AdminUser.minAdminPasswordLength = minAdminPasswordLength;
    }

}

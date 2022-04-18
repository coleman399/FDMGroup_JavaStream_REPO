package com.fdmgroup.inheritance_exercise;
public class Runner {
    public static void main(String[] args) {
        AdminUser admin1 = new AdminUser("username1","password1","full name1");
        AdminUser admin2 = new AdminUser("username2","password2","full name2");

        Customer customer1 = new Customer("username3","password3","full name3");
        Customer customer2 = new Customer("username4","password4","full name4");

        System.out.println(admin1.changePassword("password5","password5"));
        System.out.println(admin1.changePassword("password1","password6"));
        System.out.println(admin1.getPassword());

        admin1.accessWebsites();

        UserAccountManager accountManager = new UserAccountManager();

        accountManager.addUser(admin1);
        accountManager.addUser(admin2);
        accountManager.addUser(customer1);
        accountManager.addUser(customer2);

        System.out.println(accountManager.login("username1", "password1"));
        System.out.println(accountManager.login("username2", "password2"));
        System.out.println(accountManager.login("username3", "password3"));
        System.out.println(accountManager.login("username4", "password4"));
        System.out.println(accountManager.login("username1", "password5"));

    }
}



public class Customer extends UserAccount {
    private static int minCustomerPasswordLength;

    public Customer(String username, String password, String fullName) {
        super(username, password, fullName); 
    }

    @Override
    public void accessWebsites() {
        System.out.println("accessing website");
    }

    @Override
    public boolean changePassword(String newPass, String confirmPass) {
        boolean result = false;
        if (newPass.equals(confirmPass) && newPass.length() >= minCustomerPasswordLength) {
            super.changePassword(newPass, confirmPass);
            result = true;
        }
        return result;
    }

    public static int getMinCustomerPasswordLength() {
        return minCustomerPasswordLength;
    }

    public static void setMinCustomerPasswordLength(int minCustomerPasswordLength) {
        Customer.minCustomerPasswordLength = minCustomerPasswordLength;
    }
}

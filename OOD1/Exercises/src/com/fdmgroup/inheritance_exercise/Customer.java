

public class Customer extends UserAccount {

    public Customer(String username, String password, String fullName) {
        super(username, password, fullName); 
    }

    @Override
    public void accessWebsites() {
        System.out.println("accessing website");
    }
}

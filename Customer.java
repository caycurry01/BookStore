public class Customer {

    enum CustomerLevel {
        REGULAR,
        PREMIUM
    }

    private String username;
    private CustomerLevel customerLevel;
    private double subscriptionPrice;

    public Customer(String username, CustomerLevel level) {
        switch (level) {
            case REGULAR:
                setSubscription(0.00);
            case PREMIUM:
                setSubscription(10.00);
            default:
                System.out.println("Please Select a given Subscription");

        }
    }

    public String getUsername() {
        return username;
    }

    public CustomerLevel getLevel() {
        return customerLevel;
    }

    public double getSubcription() {
        return subscriptionPrice;
    }

    public void setUsername(String name) {
        username = name;
    }

    public void setLevel(CustomerLevel level) {
        customerLevel = level;
    }

    public void setSubscription(double subscription) {
        subscriptionPrice = subscription;
    }

}

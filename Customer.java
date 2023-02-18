public class Customer {

    enum CustomerLevel {
        BASIC,
        PREMIUM
    }

    private String username;
    private CustomerLevel customerLevel;
    private double subscriptionPrice;
    private String paymentMethod;
    private double balance;
    private double monthlyFee;


    public Customer(String username, CustomerLevel level, String paymentMethod, double balance) {
        setUsername(username);
        setLevel(level);
        setPaymentMethod(paymentMethod);
        setBalance(balance);
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

    public String getPaymentMethod(){
        return paymentMethod;
    }

    public double getBalance(){
        return balance;
    } 
    
    public double getMonthlyFee() {
        return this.balance = (this.balance-10.00);
    }

    public void setUsername(String name) {
        this.username = name;
    }
    

    public void setLevel(CustomerLevel level) {
        this.customerLevel = level;
        if (level == CustomerLevel.BASIC) {
            setSubscription(0.00);
        } else if (level == CustomerLevel.PREMIUM) {
            setSubscription(10.00);
        } else {
            System.out.println("Please choose Subscription: Basic or Premium");
        }
    }

    public void setSubscription(double subscription) {
        this.subscriptionPrice = subscription;
    }

    public void setPaymentMethod(String payment){
        this.paymentMethod = payment;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }
}

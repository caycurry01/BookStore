
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Items> items = new ArrayList<>();
    public static Customer activeCustomer;
    public static int cart;

    public static void createCustomer() {
        Customer user1 = new Customer("kelvin123", Customer.CustomerLevel.BASIC, "card", 100.0);
        customers.add(user1);
        Customer user2 = new Customer("cindy345", Customer.CustomerLevel.BASIC, "cash", 50.00);
        customers.add(user2);
        Customer user3 = new Customer("cayla567", Customer.CustomerLevel.PREMIUM, "card", 100.0);
        customers.add(user3);
        Customer user4 = new Customer("kevin494", Customer.CustomerLevel.PREMIUM, "cash", 60.00);
        customers.add(user4);
        
    }

    public static void login(){
        Scanner scnrr = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scnrr.nextLine();
        for (Customer i : customers){
            if (i.getUsername().equals(username)){
                System.out.println("You have been logged in successfully. Your current membership monthly payment is: " + i.getSubcription());
                activeCustomer = i;
            }
        } 
    }


    public static void createItems() {
        Items item1 = new Items("Pride and Prejudice", Items.ItemType.Book);
        Items item2 = new Items("Titanic", Items.ItemType.CD);
        Items item3 = new Items("Beauty and the Beast", Items.ItemType.DVD);
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }

    public static void membership(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter new Username: ");
        String username = scnr.nextLine();

        System.out.println("Would you like to upgrade to our Premium membership? (y/n): ");
        String choice = scnr.nextLine();
        
        Customer newCustomer = new Customer(username, Customer.CustomerLevel.BASIC, "none", 0.0);
        if (choice.equals("y")){
            newCustomer.setLevel(Customer.CustomerLevel.PREMIUM);
            System.out.println("Thank you for joining our Premium membership!");
            System.out.println("Please select your payment method (cash/card)");
            choice = scnr.nextLine();
            if(choice.equals("cash")){
                newCustomer.setPaymentMethod("cash");
                System.out.println("You have chosen cash.");
                System.out.println("How much store credit would you like to deposit?");
                double money = scnr.nextDouble();
                newCustomer.setBalance(money);
                System.out.println("Your new store credit balance is " + newCustomer.getBalance() + "\n");
                System.out.println("You will now be charged $"+newCustomer.getSubcription()+ " a month to your account.");
                customers.add(newCustomer);
                monthlyFee();
            }
            else if (choice.equals("card")){
                newCustomer.setPaymentMethod("card");
                System.out.println("You have chosen card.");
                System.out.println("How much store credit would you like to deposit?");
                double money = scnr.nextDouble();
                newCustomer.setBalance(money);
                System.out.println("Your new store credit balance is " + newCustomer.getBalance() + "\n");
                System.out.println("You will now be charged $" + newCustomer.getSubcription() + " a month to your account.");
                customers.add(newCustomer);
                monthlyFee();
            }
            else{
                System.out.println("Invalid Input.");
            }

        }
        activeCustomer = newCustomer;
        
    }

    public static void monthlyFee(){
        System.out.println("Hello have you paid your monthly fee yet? (y/n)");
        Scanner scnr = new Scanner(System.in);
        String options = scnr.nextLine();
        if (options.equals("y")){
            System.out.println("Let me check your account");
            System.out.println("Yes you have, thank you, please continue shopping.");
        }
        else if (options.equals("n")){
            System.out.println("It is now the first of the Month, we will now subtract the monthly payment from everyone's store credit.");
            for(Customer i : customers){
                if (i.getLevel().equals(Customer.CustomerLevel.PREMIUM)){
                    i.getMonthlyFee();
                }
            }
        }
        else{
            System.out.println("Invalid Input.");
        }
    }

    public static void checkBalance(){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Would your like to check you store credit balance? y/n");
        String choice = scnr.nextLine();
        if (choice.equals("y")) {
            System.out.println("Please enter your username: ");
            String username = scnr.nextLine();
            for (Customer i : customers) {
                if (i.getUsername().equals(username)) {
                    System.out.println(i.getBalance());
                }
            }

        }
    }

    


    public static void main(String[] args) {
        createCustomer();

        Scanner scnr = new Scanner(System.in);
        while (customers.size() != 0){
            int option = 0;
            if (activeCustomer == null){
                System.out.println("\n/////////////////////////");
                System.out.println("Welcome to the Bookstore!");
                System.out.println("/////////////////////////");

                System.out.println("Please Select from the options below: ");
                System.out.println("1) Login\n" + "2) Create account");
                option = scnr.nextInt();
                if (option == 1){
                    login();
                    checkBalance();
                }

                else if(option == 2){
                    membership();
                    checkBalance();
                    
                }
                else{
                    break;
                }
            
                
                // String options = "1) See membership status\n" + "2) Change membership status\n" + "3) Check out";
                // System.out.println(options);
            }
            else{
                
                break;
            }
            

        }

    
    }

}

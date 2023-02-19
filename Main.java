
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Items> items = new ArrayList<>();
    public static ArrayList<Items> cartItems = new ArrayList<>();
    public static Customer activeCustomer;
    public static double cartTotal;
    public static double cartBalance;

    public static void createCustomer() {
        Customer user1 = new Customer("kelvin123", Customer.CustomerLevel.BASIC, "card", 100.0,0);
        customers.add(user1);
        Customer user2 = new Customer("cindy345", Customer.CustomerLevel.BASIC, "cash", 50.00,0);
        customers.add(user2);
        Customer user3 = new Customer("cayla567", Customer.CustomerLevel.PREMIUM, "card", 100.0,0);
        customers.add(user3);
        Customer user4 = new Customer("kevin494", Customer.CustomerLevel.PREMIUM, "cash", 60.00,0);
        customers.add(user4);
        
    }

    public static void login(){
        Scanner scnrr = new Scanner(System.in);
        System.out.println("Username: ");
        String username = scnrr.nextLine();
        for (Customer i : customers){
            if (i.getUsername().equals(username)){
                System.out.println("You have been logged in successfully."+ " Your membership status is: " + i.getLevel() + " " + 
                "\nYour current membership monthly payment is: " + i.getSubcription());
                activeCustomer = i;
            }
        } 
    }


    public static void createItems() {
        Items item1 = new Items("Pride and Prejudice", Items.ItemType.Book,5);
        Items item2 = new Items("Titanic", Items.ItemType.CD,10);
        Items item3 = new Items("Beauty and the Beast", Items.ItemType.DVD,20);
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
        
        Customer newCustomer = new Customer(username, Customer.CustomerLevel.BASIC, "none", 0.0,0);
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
            System.out.println("It is now the 1st of the Month, we will now subtract the monthly payment ($10.00) from everyone's store credit.");
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

    public static void subBalance(){
        Scanner scnr = new Scanner(System.in);
        String choice = scnr.nextLine();
        if (choice.equals("y")) {
            System.out.println("Please enter your username to access store credit: ");
            String username = scnr.nextLine();
            for (Customer i : customers) {
                if (i.getUsername().equals(username)) {
                    cartBalance = i.getBalance()-cartTotal;
                    if (cartBalance > 0){
                        System.out.println("Thank you for your purchase, your new balance is: $ " + cartBalance );
                        break;
                    }
                    else{
                        System.out.println("Insufficient Funds in store balance you owe: $ " + (cartBalance*-1));
                        System.out.println("The rest of the money was taken from the card we have on file.");
                    }
                }
            }

        }
    }


    public static void buyItems(){
        System.out.println("\nWelcome to Cayla's Bookstore");
        System.out.println("****************************\n");
        System.out.println("We currently have Books, CDs, and DVDs. Below are the items we have in stock and quantity: ");
        for(Items i : items){
            System.out.println("\nTitle: " + i.getName() + "\nItem Type: " + i.getType() + "\nQuantity: " + i.getitemQuantity());
        }
        boolean buying = true;
        while (buying == true){
            System.out.println("\nWhich item would you like to buy? \n1) Pride and Prejudice(Book) \n2) Titanic(CD) \n3) Beauty and the Beast(DVD) \n4) Exit to Cart");
            Scanner scnr = new Scanner(System.in);
            int option = scnr.nextInt();
            if (option == 1){
                System.out.println("This item is currently: $ "+items.get(0).getPrice()+"\nHow many would you like to purchase? There are currently " + items.get(0).getitemQuantity() + " copies of " + items
                        .get(0).getName()+ " in stock: ");
                option = scnr.nextInt();
                Items cartItem = new Items("Pride and Prejudice", Items.ItemType.Book, 0);
                cartItem.setQuantity(option);
                cartItems.add(cartItem);
                items.get(0).setQuantity(items.get(0).getitemQuantity() - cartItems.get(0).getitemQuantity());

                System.out.println("You now have " + cartItems.get(0).getitemQuantity() + " in your cart. There are now " + items
                        .get(0).getitemQuantity() + " left in stock.");
                System.out.println("Would you like to continue shopping? y/n ");
                scnr.nextLine();
                String answer = scnr.nextLine();
                if (answer.equals("n")){
                    System.out.println("Thank you for shopping with us. You will now be sent to your cart to pay for your items. ");
                    buying = false;
                }
                
                
            }
            else if (option == 2){
                System.out.println("This item is currently: $ " + items.get(1).getPrice()
                        + "\nHow many would you like to purchase? There are currently "
                        + items.get(1).getitemQuantity() + " copies of " + items
                                .get(1).getName()
                        + " in stock: ");
                option = scnr.nextInt();
                Items cartItem = new Items("Titanic", Items.ItemType.CD, 0);
                cartItem.setQuantity(option);
                cartItems.add(cartItem);
                items.get(1).setQuantity(items.get(1).getitemQuantity() - cartItems.get(0).getitemQuantity());
                System.out.println(
                        "You now have " + cartItems.get(0).getitemQuantity() + " in your cart. There are now " + items
                                .get(1).getitemQuantity() + " left in stock.");
                                
                System.out.println("Would you like to continue shopping? y/n ");
                scnr.nextLine();
                String answer = scnr.nextLine();
                if (answer.equals("n")) {
                    System.out.println(
                            "Thank you for shopping with us. You will now be sent to your cart to pay for your items. ");
                    buying = false;
                }
                
                
            }
            else if (option == 3){
                System.out.println("This item is currently: $ " + items.get(2).getPrice()
                        + "\now many would you like to purchase? There are currently "
                        + items.get(2).getitemQuantity() + " copies of " + items
                                .get(2).getName()
                        + " in stock: ");
                option = scnr.nextInt();
                Items cartItem = new Items("Beauty and the Beast", Items.ItemType.DVD, 0);
                cartItem.setQuantity(option);
                cartItems.add(cartItem);
                items.get(2).setQuantity(items.get(2).getitemQuantity() - cartItems.get(0).getitemQuantity());
                System.out.println(
                        "You now have " + cartItems.get(0).getitemQuantity() + " in your cart. There are now " + items
                                .get(2).getitemQuantity() + " left in stock.");
                System.out.println("Would you like to continue shopping? y/n ");
                scnr.nextLine();
                String answer = scnr.nextLine();
                if (answer.equals("n")) {
                    System.out.println(
                            "Thank you for shopping with us. You will now be sent to view your cart and pay for your items. ");
                    buying = false;
                }
                
            }
            else if (option == 4){
                System.out.println("Thank you for shopping with us, you will now be set to view your cart and pay for your items.");
                buying = false;
            }
            else{
                System.out.println("Invalid option. Please choose again: ");
            }
            
        }

        
    }
    public static void checkout(){
        for (Items i : cartItems){
            cartTotal = cartTotal+(double)i.getitemQuantity() * i.getPrice();
        }
        System.out.println("Your cart totals to: " + " $ "+cartTotal);
    }

    public static void main(String[] args) {
        createCustomer();
        createItems();

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
            
            }
            else{
                String options = "1) Begin Shopping\n" + "2) Check out";
                System.out.println(options);
                option = scnr.nextInt();
                if (option == 1){
                    buyItems();
                    checkout();
                }
                else{
                    if (cartTotal==0){
                        System.out.println("Your cart total is currently: " + cartTotal
                                + "\nYou have not purchased any items yet. ");
                    }
                    else{
                        System.out.println("Your cart total is currently: " + cartTotal);
                        System.out.println("Would you like to pay with 1)store credit or pay through 2)external payment method? (please select 1 or 2 to complete transaction)");
                        int answer = scnr.nextInt();
                        if (answer == 1){
                            subBalance();
                        }
                        else{
                            System.out.println("The purchase has been charged to your external payment method.");
                        }
                        System.out.println("Have a nice day.");
                        break;
                    }

                }

                
            }
        
        }

    
    }

}

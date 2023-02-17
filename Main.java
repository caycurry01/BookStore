import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Items> items = new ArrayList<>();

    public static void createCustomer() {
        Customer user1 = new Customer("kelvin123", Customer.CustomerLevel.Basic);
        Customer user2 = new Customer("cindy345", Customer.CustomerLevel.Premium);
        Customer user3 = new Customer("cayla567", Customer.CustomerLevel.Premium);
        customers.add(user1);
        customers.add(user2);
        customers.add(user3);
    }

    public static void createItems() {
        Items item1 = new Items("Pride and Prejudice", Items.ItemType.Book);
        Items item2 = new Items("Titanic", Items.ItemType.CD);
        Items item3 = new Items("Beauty and the Beast", Items.ItemType.DVD);
        items.add(item1);
        items.add(item2);
        items.add(item3);
    }

    public static void main(String[] args) {

    }

}

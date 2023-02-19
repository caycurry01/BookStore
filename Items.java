public class Items {

    enum ItemType {
        Book,
        CD,
        DVD,
    }

    private String itemTitle;
    private double itemPrice;
    private ItemType itemType;
    private int itemQuantity;

    public Items(String itemName, ItemType itemType, int itemQuantity) {
        setName(itemName);
        setType(itemType);
        setQuantity(itemQuantity);

        if(itemType == ItemType.Book){
            setPrice(25.00);
        }
        else if (itemType == ItemType.CD){
            setPrice(15.00);
        }
        else if (itemType == ItemType.DVD){
            setPrice(12.00);
        }
        else{
            System.out.println("Invalid Type");
        }
        
    }

    public String getName() {
        return itemTitle;
    }

    public double getPrice() {
        return itemPrice;
    }

    public ItemType getType() {
        return itemType;
    }
    
    public int getitemQuantity() {
        return itemQuantity;
    }

    public void setName(String title) {
        this.itemTitle = title;
    }

    public void setPrice(double price) {
        this.itemPrice = price;
    }

    public void setType(ItemType type) {
        this.itemType = type;
    }

    public void setQuantity (int itemQuantity){
        this.itemQuantity = itemQuantity;
    }
    
}
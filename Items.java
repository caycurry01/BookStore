public class Items {

    enum ItemType {
        Book,
        CD,
        DVD,
    }

    public Items(String itemName, ItemType itemType) {
        setName(itemName);
        setType(itemType);
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

    private String itemTitle;
    private double itemPrice;
    private ItemType itemType;

    public String getName() {
        return itemTitle;
    }

    public double getPrice() {
        return itemPrice;
    }

    public ItemType getType() {
        return itemType;
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

}
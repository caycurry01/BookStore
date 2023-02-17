public class Items {

    enum ItemType {
        Book,
        CD,
        DVD,
    }

    public Items(String itemName, ItemType itemType) {
        setName(itemName);
        setType(itemType);
        switch (itemType) {
            case Book:
                setPrice(10.00);
            case CD:
                setPrice(15.00);
            case DVD:
                setPrice(12.00);
            default:
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
        itemTitle = title;
    }

    public void setPrice(double price) {
        itemPrice = price;
    }

    public void setType(ItemType type) {
        itemType = type;
    }

}
package day0220.newCafe;

public class Menu {
    private String menuName;
    private int price;
    private String menuContent;

    public Menu(String menuName, int price, String menuContent) {
        this.menuName = menuName;
        this.price = price;
        this.menuContent = menuContent;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMenuContent() {
        return menuContent;
    }

    public void setMenuContent(String menuContent) {
        this.menuContent = menuContent;
    }
}

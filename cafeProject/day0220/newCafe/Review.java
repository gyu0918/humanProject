package day0220.newCafe;

public class Review {
    private String content;
    private String menuName;
    private String orderer;

    public Review(String content, String menuName, String orderer) {
        this.content = content;
        this.menuName = menuName;
        this.orderer = orderer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getOrderer() {
        return orderer;
    }

    public void setOrderer(String orderer) {
        this.orderer = orderer;
    }
}

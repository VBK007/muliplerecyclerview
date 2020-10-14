package nr.king.multiplerecyclerview.Data;

public class Movies {

    public String name;
    public String image;
    public String menuId;

    public Movies() {
    }

    public Movies(String name, String image, String menuId) {
        this.name = name;
        this.image = image;
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}

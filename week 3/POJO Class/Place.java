import java.util.List;

public class Place {
    private Integer id;
    private String address;
    private String phone;
    private String image;
    private List<Food> foods;

    public Place(Integer id, String address, String phone, String image, List<Food> foods) {
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.image = image;
        this.foods = foods;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }
}

import java.util.List;

public class Food {
    private Integer id;
    private String name;
    private String image;
    private String description;
    private Integer portion;
    private Unit unit;
    private double price;
    private Place place;
    private FoodType foodType;
    private List<CartFood> carts;

    public Food(Integer id, String name, String image, String description, Integer portion, Unit unit, double price, Place place, FoodType foodType, List<CartFood> carts) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.portion = portion;
        this.unit = unit;
        this.price = price;
        this.place = place;
        this.foodType = foodType;
        this.carts = carts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPortion() {
        return portion;
    }

    public void setPortion(Integer portion) {
        this.portion = portion;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public List<CartFood> getCarts() {
        return carts;
    }

    public void setCarts(List<CartFood> carts) {
        this.carts = carts;
    }
}

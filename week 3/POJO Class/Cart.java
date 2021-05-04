public class Cart {
    private Integer id;
    private User user;
    private List<CartFood> carts;
    private double total_price = 0.0;

    public Cart(Integer id, User user, List<CartFood> carts, double total_price) {
        this.id = id;
        this.user = user;
        this.carts = carts;
        this.total_price = total_price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<CartFood> getCarts() {
        return carts;
    }

    public void setCarts(List<CartFood> carts) {
        this.carts = carts;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
    }
}

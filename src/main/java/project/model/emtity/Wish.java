package project.model.emtity;

public class Wish {
    private int wishId;
    private User user;
    private Product product;
    private boolean wishStatus;

    public Wish() {
    }

    public Wish(int wishId, User user, Product product, boolean wishStatus) {
        this.wishId = wishId;
        this.user = user;
        this.product = product;
        this.wishStatus = wishStatus;
    }

    public int getWishId() {
        return wishId;
    }

    public void setWishId(int wishId) {
        this.wishId = wishId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public boolean isWishStatus() {
        return wishStatus;
    }

    public void setWishStatus(boolean wishStatus) {
        this.wishStatus = wishStatus;
    }
}

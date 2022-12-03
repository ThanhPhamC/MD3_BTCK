package project.model.emtity;

import java.util.Date;

public class Cart {
    private String cartName;
    private int cartId;
    private User user;
    private float totalAmount;
    private Date creatDate;
    private Date endDate;
    private String note;
    private int cartStatus;
    private int discount;
    private CupPon cupon;

    public Cart() {
    }

    public Cart(int cartId) {
        this.cartId = cartId;
    }

    public Cart(String cartName, int cartId, User user, float totalAmount, Date creatDate, Date endDate, String note, int cartStatus, int discount, CupPon cupon) {
        this.cartName = cartName;
        this.cartId = cartId;
        this.user = user;
        this.totalAmount = totalAmount;
        this.creatDate = creatDate;
        this.endDate = endDate;
        this.note = note;
        this.cartStatus = cartStatus;
        this.discount = discount;
        this.cupon = cupon;
    }

    public Cart(String cartName) {
        this.cartName = cartName;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getCartStatus() {
        return cartStatus;
    }

    public void setCartStatus(int cartStatus) {
        this.cartStatus = cartStatus;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public CupPon getCupon() {
        return cupon;
    }

    public void setCupon(CupPon cupon) {
        this.cupon = cupon;
    }
}

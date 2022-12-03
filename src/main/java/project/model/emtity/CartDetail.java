package project.model.emtity;


import java.util.Date;

public class CartDetail extends Cart{
    private int cartDetailId;
    private float priceCurent;
    private ProductDetail productDetail;
    private int detailCartquantity;
    private boolean cartDetailStatus;

    public CartDetail() {
    }


    public CartDetail(int cartId,  ProductDetail productDetail, int detailCartquantity) {
        super(cartId);
        this.productDetail = productDetail;
        this.detailCartquantity = detailCartquantity;
    }

    public CartDetail(String cartName, int cartId, User user, float totalAmount, Date creatDate, Date endDate, String note, int cartStatus, int discount, CupPon cupon, int cartDetailId, float priceCurent, ProductDetail productDetail, int detailCartquantity, boolean cartDetailStatus) {
        super(cartName, cartId, user, totalAmount, creatDate, endDate, note, cartStatus, discount, cupon);
        this.cartDetailId = cartDetailId;
        this.priceCurent = priceCurent;
        this.productDetail = productDetail;
        this.detailCartquantity = detailCartquantity;
        this.cartDetailStatus = cartDetailStatus;
    }

    public int getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(int cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public float getPriceCurent() {
        return priceCurent;
    }

    public void setPriceCurent(float priceCurent) {
        this.priceCurent = priceCurent;
    }

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public int getDetailCartquantity() {
        return detailCartquantity;
    }

    public void setDetailCartquantity(int detailCartquantity) {
        this.detailCartquantity = detailCartquantity;
    }

    public boolean isCartDetailStatus() {
        return cartDetailStatus;
    }

    public void setCartDetailStatus(boolean cartDetailStatus) {
        this.cartDetailStatus = cartDetailStatus;
    }
}

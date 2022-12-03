package project.model.emtity;

public class ProductDisplay extends Product{
    private float exportPrice;
    private String productImg;
    private int  starPoint;
    private int totalStart;
    private int discount;
    public ProductDisplay() {
    }

    public ProductDisplay(int productId, String productName, int productStatus, float exportPrice, String productImg, int starPoint, int totalStart, int discount) {
        super(productId, productName, productStatus);
        this.exportPrice = exportPrice;
        this.productImg = productImg;
        this.starPoint = starPoint;
        this.totalStart = totalStart;
        this.discount = discount;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
    }

    public int getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(int starPoint) {
        this.starPoint = starPoint;
    }

    public int getTotalStart() {
        return totalStart;
    }

    public void setTotalStart(int totalStart) {
        this.totalStart = totalStart;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}

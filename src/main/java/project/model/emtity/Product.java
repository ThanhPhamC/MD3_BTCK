package project.model.emtity;

public class Product {
    private int productId;
    private String productName;

    private int productStatus;
    public Product() {
    }

    public Product(int productId, String productName, int productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.productStatus = productStatus;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }
}

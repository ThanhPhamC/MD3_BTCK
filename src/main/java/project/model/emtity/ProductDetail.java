package project.model.emtity;

import java.util.Date;
import java.util.List;

public class ProductDetail extends ProductViewsAdmin {
    private int productDetailId;
    private Sizes sizes;
    private Colors colors;
    private int quantityDetail;
    private float exportPrice;
    private int discountDetail;
    private boolean detailStatus;
    public ProductDetail() {
    }


    public ProductDetail(int productId, String productName, int productStatus, float exportPrice, String productImg, int starPoint, int totalStart, int discount, List<String> listImg, List<String> listColor, List<String> listSize, List<String> listComment, String descriptions, String tittle, Date creatDate, float importPrice, Catalog catalog, int quantity, int productDetailId, Sizes sizes, Colors colors, int quantityDetail, float exportPrice1, int discountDetail, boolean detailStatus) {
        super(productId, productName, productStatus, exportPrice, productImg, starPoint, totalStart, discount, listImg, listColor, listSize, listComment, descriptions, tittle, creatDate, importPrice, catalog, quantity);
        this.productDetailId = productDetailId;
        this.sizes = sizes;
        this.colors = colors;
        this.quantityDetail = quantityDetail;
        this.exportPrice = exportPrice1;
        this.discountDetail = discountDetail;
        this.detailStatus = detailStatus;
    }

    public int getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(int productDetailId) {
        this.productDetailId = productDetailId;
    }

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public Colors getColors() {
        return colors;
    }

    public void setColors(Colors colors) {
        this.colors = colors;
    }

    public int getQuantityDetail() {
        return quantityDetail;
    }

    public void setQuantityDetail(int quantityDetail) {
        this.quantityDetail = quantityDetail;
    }

    @Override
    public float getExportPrice() {
        return exportPrice;
    }

    @Override
    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public int getDiscountDetail() {
        return discountDetail;
    }

    public void setDiscountDetail(int discountDetail) {
        this.discountDetail = discountDetail;
    }

    public boolean isDetailStatus() {
        return detailStatus;
    }

    public void setDetailStatus(boolean detailStatus) {
        this.detailStatus = detailStatus;
    }
}

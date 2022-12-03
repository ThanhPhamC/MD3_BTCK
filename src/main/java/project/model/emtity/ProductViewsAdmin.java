package project.model.emtity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductViewsAdmin extends ProductDisplay{
    private List<String> listImg= new ArrayList<>();
    private  List<String> listColor =new ArrayList<>();
    private List<String> listSize= new ArrayList<>();
    private List<String> listComment=new ArrayList<>();
    private String descriptions;

    private String tittle;
    private Date creatDate;
    private float importPrice;
    private Catalog catalog;
    private int quantity;


    public ProductViewsAdmin() {
    }

    public ProductViewsAdmin(int productId, String productName, int productStatus, float exportPrice, String productImg, int starPoint, int totalStart, int discount, List<String> listImg, List<String> listColor, List<String> listSize, List<String> listComment, String descriptions, String tittle, Date creatDate, float importPrice, Catalog catalog, int quantity) {
        super(productId, productName, productStatus, exportPrice, productImg, starPoint, totalStart, discount);
        this.listImg = listImg;
        this.listColor = listColor;
        this.listSize = listSize;
        this.listComment = listComment;
        this.descriptions = descriptions;
        this.tittle = tittle;
        this.creatDate = creatDate;
        this.importPrice = importPrice;
        this.catalog = catalog;
        this.quantity = quantity;
    }

    public List<String> getListImg() {
        return listImg;
    }

    public void setListImg(List<String> listImg) {
        this.listImg = listImg;
    }

    public List<String> getListColor() {
        return listColor;
    }

    public void setListColor(List<String> listColor) {
        this.listColor = listColor;
    }

    public List<String> getListSize() {
        return listSize;
    }

    public void setListSize(List<String> listSize) {
        this.listSize = listSize;
    }

    public List<String> getListComment() {
        return listComment;
    }

    public void setListComment(List<String> listComment) {
        this.listComment = listComment;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public Date getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(Date creatDate) {
        this.creatDate = creatDate;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

package project.model.emtity;

public class Sizes {
    private int sizeId;
    private String sizeName;
    private boolean sizeStatus;

    public Sizes() {
    }

    public Sizes(int sizeId, String sizeName, boolean sizeStatus) {
        this.sizeId = sizeId;
        this.sizeName = sizeName;
        this.sizeStatus = sizeStatus;
    }

    public int getSizeId() {
        return sizeId;
    }

    public void setSizeId(int sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeName() {
        return sizeName;
    }

    public void setSizeName(String sizeName) {
        this.sizeName = sizeName;
    }

    public boolean getSizeStatus() {
        return sizeStatus;
    }

    public void setSizeStatus(boolean sizeStatus) {
        this.sizeStatus = sizeStatus;
    }
}

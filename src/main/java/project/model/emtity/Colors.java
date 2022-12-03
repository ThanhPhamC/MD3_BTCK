package project.model.emtity;

public class Colors {
    private int coloId;
    private String colorName;
    private String colorHex;
    private boolean colorStatus;
    public Colors() {
    }

    public Colors(int coloId, String colorName, String colorHex, boolean colorStatus) {
        this.coloId = coloId;
        this.colorName = colorName;
        this.colorHex = colorHex;
        this.colorStatus = colorStatus;
    }

    public int getColoId() {
        return coloId;
    }

    public void setColoId(int coloId) {
        this.coloId = coloId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public String getColorHex() {
        return colorHex;
    }

    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }

    public boolean isColorStatus() {
        return colorStatus;
    }

    public void setColorStatus(boolean colorStatus) {
        this.colorStatus = colorStatus;
    }
}

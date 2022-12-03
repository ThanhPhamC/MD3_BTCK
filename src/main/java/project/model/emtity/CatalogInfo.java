package project.model.emtity;

public class CatalogInfo extends Catalog{
    private String parentName;

    public CatalogInfo() {
    }

    public CatalogInfo(int catalogId, String catalogName, String descriptions, int parentId, boolean catalogStatus, String parentName) {
        super(catalogId, catalogName, descriptions, parentId, catalogStatus);
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}

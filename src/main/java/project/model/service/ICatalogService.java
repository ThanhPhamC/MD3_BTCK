package project.model.service;

import java.util.List;

public interface ICatalogService<T,V> extends IFashionService<T,V> {
    List<T> getCatRoot();
    List<T> searchByName(String name);
    List<T> findChild(Integer parentId);
    List<T> getCatalogForCreat();
    T  searchForDelete (String name);
    List<T> getCatCreatProduct();

}

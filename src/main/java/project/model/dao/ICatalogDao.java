package project.model.dao;

import java.util.List;

public interface ICatalogDao<T,V> extends IFashionDao<T,V> {
    List<T> searchByName(String name);
    List<T> findChild(Integer parentId);
    List<T> getCatalogForCreat();
    T  searchForDelete (String name);
    List<T> getCatCreatProduct();
    List<T> getCatRoot();
}

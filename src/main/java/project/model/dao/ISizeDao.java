package project.model.dao;

import java.util.List;

public interface ISizeDao<T,V> extends IFashionDao<T,V>{
    List<T> searchByName(String name);
    List<T> findForCreatProduct();
    T getLastIndex();
    List<T> getSizeByProductId(Integer id);
}

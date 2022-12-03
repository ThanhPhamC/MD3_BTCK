package project.model.service;

import java.util.List;

public interface ISizeService<T,V> extends IFashionService<T,V> {
    List<T> searchByName(String name);
    List<T> findSizeForCreatProduct();
    T getLastIndex();
    List<T> getSizeByProductId(Integer id);
}

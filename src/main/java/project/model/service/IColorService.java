package project.model.service;

import java.util.List;

public interface IColorService<T,V> extends IFashionService<T,V>{
    List<T> searchByName(String name);
    List<T> findForCreatProduct();
    T getLastIndex();
    List<T> getColorByProductId(Integer id);
}

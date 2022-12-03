package project.model.dao;

import java.util.List;

public interface IProductDao<T,V> extends IFashionDao<T,V> {
    List<T> searchByName(String name);
    T searchByPrice(float price);
    T getLastIndex();
    boolean saveDetail(T t);
    T getLastDetailIndex();
    List<T> getDetailById(Integer id);
    List<T> getProductByCatId(Integer id);

}

package project.model.service;

import java.util.List;

public interface IProductService<T,V> extends IFashionService<T,V> {
    List<T> searchByName(String name);
    T searchByPrice(float price);
    T getLastIndex();
    boolean saveDetail(T t);
    T getLastDetailIndex();
    List<T> getDetailById(Integer id);
    List<T> getProductByCatId(Integer id);


}

package project.model.dao;

import java.util.List;

public interface IFashionDao<T,V> {
    List<T> findAll();
    boolean save(T t);
    boolean update(T t);
    boolean delete(V id);
    T searchById (V id);

}

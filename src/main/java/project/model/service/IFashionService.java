package project.model.service;

import java.util.List;

public interface IFashionService<T,V> {
    List<T> findAll();
    boolean save(T t);
    boolean update(T t);
    boolean delete(V id);
    T searchById (V id);
}

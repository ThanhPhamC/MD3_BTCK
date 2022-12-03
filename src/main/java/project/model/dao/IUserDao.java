package project.model.dao;

public interface IUserDao<T,V> extends IFashionDao<T,V> {
    T checkLogin(String userName, String pass);

}

package project.model.service;

public interface IUserService<T,V> extends IFashionService<T,V> {
    T checkLogin(String userName, String pass);

}

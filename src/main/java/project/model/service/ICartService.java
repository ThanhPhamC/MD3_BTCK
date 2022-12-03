package project.model.service;

import project.model.emtity.CartDetail;

import java.util.List;

public interface ICartService<T,V> extends IFashionService<T,V>{
    List<T> getListCartDetailByUserId(Integer userId);
    T getLastCartByUerId(Integer uId);
    boolean saveCartDetail(CartDetail cartDetail);
    boolean updateCartDetail(CartDetail cartDetail);
    boolean deleteCartDetail(Integer id);

}

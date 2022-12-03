package project.model.dao;



import project.model.emtity.CartDetail;

import java.util.List;

public interface ICartDao<T,V> extends IFashionDao<T,V>{
List<T> getListCartDetailByUserId(Integer userId);
T getLastCartByUerId(Integer uId);
boolean saveCartDetail(CartDetail cartDetail);
boolean updateCartDetail(CartDetail cartDetail);
    boolean deleteCartDetail(Integer id);

}

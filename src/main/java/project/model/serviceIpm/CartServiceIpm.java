package project.model.serviceIpm;

import project.model.dao.ICartDao;
import project.model.daoIpm.CartDaoIpm;
import project.model.emtity.Cart;
import project.model.emtity.CartDetail;
import project.model.service.ICartService;

import java.util.List;

public class CartServiceIpm implements ICartService<Cart,Integer> {
        private ICartDao<Cart,Integer> iCartDao= new CartDaoIpm();


    @Override
    public List<Cart> findAll() {
        return iCartDao.findAll();
    }

    @Override
    public boolean save(Cart cart) {
        return iCartDao.save(cart);
    }

    @Override
    public boolean update(Cart cart) {
        return iCartDao.update(cart);
    }

    @Override
    public boolean delete(Integer id) {
        return iCartDao.delete(id);
    }

    @Override
    public Cart searchById(Integer id) {
        return iCartDao.searchById(id);
    }


    @Override
    public List<Cart> getListCartDetailByUserId(Integer userId) {
        return iCartDao.getListCartDetailByUserId(userId);
    }

    @Override
    public Cart getLastCartByUerId(Integer uId) {
        return iCartDao.getLastCartByUerId(uId);
    }

    @Override
    public boolean saveCartDetail(CartDetail cartDetail) {
        return iCartDao.saveCartDetail(cartDetail);
    }

    @Override
    public boolean updateCartDetail(CartDetail cartDetail) {
        return iCartDao.updateCartDetail(cartDetail);
    }

    @Override
    public boolean deleteCartDetail(Integer id) {
        return iCartDao.deleteCartDetail(id);
    }


}

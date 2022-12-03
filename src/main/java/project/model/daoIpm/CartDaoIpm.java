package project.model.daoIpm;

import project.model.dao.ICartDao;
import project.model.emtity.*;
import project.model.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoIpm implements ICartDao<Cart, Integer> {


    @Override
    public List<Cart> findAll() {
        return null;
    }

    @Override
    public boolean save(Cart cart) {
        Connection conn = null;
        CallableStatement cast = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call saveCart(?)}");
            cast.setInt(1, cart.getUser().getUserId());
        } catch (SQLException ex) {
            result = false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public boolean update(Cart cart) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public Cart searchById(Integer id) {
        return null;
    }


    @Override
    public List<Cart> getListCartDetailByUserId(Integer userId) {
        Connection conn = null;
        CallableStatement cast = null;
        List<CartDetail> cartListDetails = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getCartDetailByLastCart(?)}");
            cast.setInt(1, userId);
            cartListDetails = new ArrayList<>();
            ResultSet rs = cast.executeQuery();
            while (rs.next()) {
                ProductDetail pr = new ProductDetail();
                Sizes sizes= new Sizes();
                Colors colors=new Colors();
                CartDetail cartDetail = new CartDetail();
                colors.setColorName(rs.getString("colorName"));
                sizes.setSizeName(rs.getString("sizeName"));
                pr.setSizes(sizes);
                pr.setColors(colors);
                pr.setProductImg(rs.getString("productImg"));
                pr.setProductDetailId(rs.getInt("productDetailId"));
                pr.setProductName(rs.getString("productName"));
                cartDetail.setCartDetailId(rs.getInt("cartDetailId"));
                cartDetail.setProductDetail(pr);
                cartDetail.setPriceCurent(rs.getFloat("priceCurent"));
                cartDetail.setDetailCartquantity(rs.getInt("quantity"));
//                cartDetail.setCartDetailStatus(rs.getBoolean("cartDetailStatus"));
                cartListDetails.add(cartDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        List<Cart> cartList = new ArrayList<>(cartListDetails);
        return cartList;

    }

    @Override
    public Cart getLastCartByUerId(Integer uId) {
        Connection conn = null;
        CallableStatement cast= null;
        Cart cart= null;
        try {
            conn=ConnectionDB.openConnection();
            cast= conn.prepareCall("{call getLastCartByUerId(?)}");
            cast.setInt(1,uId);
            ResultSet rs= cast.executeQuery();
            cart=new Cart();
            if (rs.next()){
                cart.setCartId(rs.getInt("cartId"));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cart;
    }

    @Override
    public boolean saveCartDetail(CartDetail cartDetail) {
        Connection conn= null;
        CallableStatement cast= null;
        boolean result= true;
        try {
            conn=ConnectionDB.openConnection();
            cast=conn.prepareCall("{call saveCartDetail(?,?,?,?) }");
            cast.setInt(1,cartDetail.getCartId());
            cast.setFloat(2,cartDetail.getProductDetail().getExportPrice() );
            cast.setInt(3,cartDetail.getProductDetail().getProductDetailId());
            cast.setInt(4,cartDetail.getDetailCartquantity());
            cast.executeUpdate();
        }catch (SQLException ex){
            result=false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        return result;
    }

    @Override
    public boolean updateCartDetail(CartDetail cartDetail) {
        Connection conn= null;
        CallableStatement cast= null;
        boolean result= true;
        try {
            conn=ConnectionDB.openConnection();
            cast=conn.prepareCall("{call updateCartDetail(?,?) }");
            cast.setInt(1,cartDetail.getCartDetailId());
            cast.setInt(2,cartDetail.getDetailCartquantity());
            cast.executeUpdate();
        }catch (SQLException ex){
            result=false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        return result;
    }

    @Override
    public boolean deleteCartDetail(Integer id) {
      Connection conn= null;
      CallableStatement cast =null;
      boolean result= true;
      try {
          conn = ConnectionDB.openConnection();
          cast= conn.prepareCall("{ call deleteCartDetail(?) }");
          cast.setInt(1,id);
          cast.executeUpdate();
      } catch (SQLException e) {
          result=false;
          throw new RuntimeException(e);
      }finally {
          ConnectionDB.closeConnection(conn,cast);
      }
      return result;
    }

}

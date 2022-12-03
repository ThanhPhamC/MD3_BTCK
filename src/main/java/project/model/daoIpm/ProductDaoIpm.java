package project.model.daoIpm;

import project.model.dao.IProductDao;
import project.model.emtity.*;
import project.model.until.ConnectionDB;

import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoIpm implements IProductDao<Product, Integer> {

    @Override
    public List<Product> findAll() {
        Connection conn = null;
        CallableStatement cast = null;
        List<ProductViewsAdmin> lists = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call findAllProduct()}");
            ResultSet rs = cast.executeQuery();
            lists = new ArrayList<>();
            while (rs.next()) {
                Catalog catalog = new Catalog();
                ProductViewsAdmin product = new ProductViewsAdmin();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setTittle(rs.getString("tittle"));
                product.setProductImg(rs.getString("productImg"));
                product.setCreatDate(rs.getDate("creatDate"));
                product.setImportPrice(rs.getFloat("importPrice"));
                product.setExportPrice(rs.getFloat("AvgExport"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStarPoint(rs.getInt("AvgStar"));
                product.setTotalStart(rs.getInt("reviews"));
                product.setProductStatus(rs.getInt("productStatus"));
                catalog.setCatalogName(rs.getString("parent"));
                catalog.setCatalogId(rs.getInt("catalogId"));
                product.setCatalog(catalog);
                lists.add(product);
            }
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        List<Product> productList = new ArrayList<>(lists);
        return productList;
    }

    @Override
    public boolean update(Product product) {
        ProductViewsAdmin pr = (ProductViewsAdmin) product;
        Connection conn = null;
        CallableStatement cast = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call deleteSubImgById(?) }");
            cast.setInt(1,pr.getProductId());
            cast.executeUpdate();
            CallableStatement cast1 = conn.prepareCall("{call updateProduct(?,?,?,?,?,?,?,?,?,?)}");
            cast1.setInt(1,pr.getProductId());
            cast1.setString(2, pr.getProductName());
            cast1.setString(3, pr.getTittle());
            cast1.setString(4, pr.getProductImg());
            cast1.setString(5, pr.getDescriptions());
            cast1.setFloat(6, pr.getImportPrice());
            cast1.setInt(7,pr.getCatalog().getCatalogId());
//            cast1.setInt(7, pr.getCatalogId());
            cast1.setDate(8, new Date(pr.getCreatDate().getTime()));
            cast1.setInt(9, pr.getDiscount());
            cast1.setInt(10,pr.getProductStatus());
            cast1.executeUpdate();
            for (String imgLink : pr.getListImg()) {
                CallableStatement cast2 = conn.prepareCall("{call saveImageProduct(?,?)}");
                cast2.setInt(1,pr.getProductId());
                cast2.setString(2,imgLink);
                cast2.executeUpdate();
                cast2.close();
            }
        } catch (SQLException e) {
            result=false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public boolean  save(Product product) {
        ProductViewsAdmin pr = (ProductViewsAdmin) product;
        Connection conn = null;
        CallableStatement cast = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call saveProduct(?,?,?,?,?,?,?,?,?)}");
            cast.setString(1, pr.getProductName());
            cast.setString(2, pr.getTittle());
            cast.setString(3, pr.getProductImg());
            cast.setString(4, pr.getDescriptions());
            cast.setFloat(5, pr.getImportPrice());
            cast.setInt(6,pr.getCatalog().getCatalogId());
//            cast.setInt(6, pr.getCatalogId());
            cast.setDate(7, new Date(pr.getCreatDate().getTime()));
            cast.setInt(8, pr.getDiscount());
            cast.registerOutParameter(9, Types.INTEGER);
            cast.execute();
            int pId = cast.getInt(9);
            for (String imgLink : pr.getListImg()) {
                CallableStatement cast2 = conn.prepareCall("{call saveImageProduct(?,?)}");
                cast2.setInt(1,pId);
                cast2.setString(2,imgLink);
                cast2.executeUpdate();
                cast2.close();
            }
        } catch (SQLException e) {
            result=false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn= null;
        CallableStatement cast= null;
        boolean result= true;
        try {
            conn= ConnectionDB.openConnection();
            cast= conn.prepareCall("{ call deleteProduct(?) }");
            cast.setInt(1,id);
            cast.executeUpdate();
        }catch (Exception ex){
            result=false;
            ex.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        return result;
    }

    @Override
    public Product searchById(Integer id) {
        Connection conn = null;
        CallableStatement cast = null;
       ProductViewsAdmin product=null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call searchProductById(?)}");
            cast.setInt(1,id);
            ResultSet rs = cast.executeQuery();
            product=new ProductViewsAdmin();
            if (rs.next()) {
                Catalog catalog =new Catalog();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setTittle(rs.getString("tittle"));
                product.setProductImg(rs.getString("productImg"));
                product.setCreatDate(rs.getDate("creatDate"));
                product.setDescriptions(rs.getString("descriptions"));
                product.setImportPrice(rs.getFloat("importPrice"));
                product.setExportPrice(rs.getFloat("AvgExport"));
                product.setProductStatus(rs.getInt("productStatus"));
                catalog.setCatalogId(rs.getInt("catalogId"));
                product.setDiscount(rs.getInt("discount"));
                product.setStarPoint(rs.getInt("AvgStar"));
                product.setTotalStart(rs.getInt("reviews"));
                product.setCatalog(catalog);
            }
            CallableStatement cast2 = conn.prepareCall("{call getImgByProductId(?) }");
            cast2.setInt(1,id);
            ResultSet rs2 = cast2.executeQuery();
            while (rs2.next()){
                product.getListImg().add(rs2.getString("imagesLinks"));
            }
            cast2.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        Product pr = product;
        return  pr;
    }
    @Override
    public List<Product> searchByName(String name) {
        Connection conn = null;
        CallableStatement cast = null;
        List<ProductViewsAdmin> lists = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call findProductByName(?)}");
            cast.setString(1,name);
            ResultSet rs = cast.executeQuery();
            lists = new ArrayList<>();
            while (rs.next()) {
                Catalog catalog = new Catalog();
                ProductViewsAdmin product = new ProductViewsAdmin();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setTittle(rs.getString("tittle"));
                product.setProductImg(rs.getString("productImg"));
                product.setCreatDate(rs.getDate("creatDate"));
                product.setImportPrice(rs.getFloat("importPrice"));
                product.setExportPrice(rs.getFloat("AvgExport"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStarPoint(rs.getInt("AvgStar"));
                product.setTotalStart(rs.getInt("reviews"));
                product.setProductStatus(rs.getInt("productStatus"));
                catalog.setCatalogName(rs.getString("parent"));
                catalog.setCatalogId(rs.getInt("catalogId"));
                product.setCatalog(catalog);
                lists.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        List<Product> productList = new ArrayList<>(lists);
        return  productList;
    }

    @Override
    public Product searchByPrice(float price) {
        return null;
    }

    @Override
    public Product getLastIndex() {
        Connection conn = null;
        CallableStatement cast = null;
        ProductViewsAdmin product=null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call getLastIndexProduct()}");
            ResultSet rs = cast.executeQuery();
            product=new ProductViewsAdmin();
            if (rs.next()) {
                product = new ProductViewsAdmin();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        Product pr = product;
        return  pr;
    }

    @Override
    public boolean saveDetail(Product product) {
        ProductDetail pr = (ProductDetail) product;
        Connection conn = null;
        CallableStatement cast = null;
        boolean result = true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call saveProductDetail(?,?,?,?,?,?)}");
            cast.setInt(1, pr.getQuantityDetail());
            cast.setFloat(2, pr.getExportPrice());
            cast.setInt(3, pr.getDiscountDetail());
            cast.setInt(4, pr.getProductId());
            cast.setInt(5,pr.getSizes().getSizeId());
            cast.setInt(6,pr.getColors().getColoId());
            cast.executeUpdate();
        } catch (SQLException e) {
            result=false;
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public Product getLastDetailIndex() {
        Connection conn = null;
        CallableStatement cast = null;
        ProductDetail product=null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call getLastIndexProductDetail()}");
            ResultSet rs = cast.executeQuery();
            product=new ProductDetail();
            if (rs.next()) {
                Sizes sizes= new Sizes();
                Colors colors =new Colors();
               product.setProductName(rs.getString("parentname"));
               product.setProductDetailId(rs.getInt("detailid"));
               product.setQuantityDetail(rs.getInt("detailquantity"));
               product.setExportPrice(rs.getFloat("exportPrice"));
               product.setDiscountDetail(rs.getInt("discountdetail"));
               sizes.setSizeName(rs.getString("sizeName"));
               product.setSizes(sizes);
               colors.setColorName(rs.getString("colorName"));
               product.setColors(colors);
               product.setDetailStatus(rs.getBoolean("status"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        Product pr = product;
        return  pr;
    }
    @Override
    public List<Product> getDetailById(Integer id) {
        Connection conn = null;
        CallableStatement cast = null;
        List<ProductDetail> productDetailList= null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call getDetailByPRoId(?)}");
            cast.setInt(1,id);
            ResultSet rs = cast.executeQuery();
            productDetailList= new ArrayList<>();
            while (rs.next()) {
                Sizes sizes= new Sizes();
                Colors colors =new Colors();
                ProductDetail product=new ProductDetail();
                product.setProductName(rs.getString("parentName"));
                product.setProductDetailId(rs.getInt("detailid"));
                product.setQuantityDetail(rs.getInt("detailquantity"));
                product.setExportPrice(rs.getFloat("exportPrice"));
                product.setDiscountDetail(rs.getInt("discountdetail"));
                sizes.setSizeId(rs.getInt("sizeId"));
                sizes.setSizeName(rs.getString("sizeName"));
                product.setSizes(sizes);
                colors.setColoId(rs.getInt("colorId"));
                colors.setColorName(rs.getString("colorName"));
                product.setColors(colors);
                product.setDetailStatus(rs.getBoolean("status"));
                productDetailList.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        List<Product> lists=new ArrayList<>(productDetailList);
        return  lists;
    }
    @Override
    public List<Product> getProductByCatId(Integer id) {
        Connection conn = null;
        CallableStatement cast = null;
        List<ProductViewsAdmin> lists = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{ call findProductByCatId(?)}");
            cast.setInt(1,id);
            ResultSet rs = cast.executeQuery();
            lists = new ArrayList<>();
            while (rs.next()) {
                ProductViewsAdmin product = new ProductViewsAdmin();
                product.setProductId(rs.getInt("productId"));
                product.setProductName(rs.getString("productName"));
                product.setTittle(rs.getString("tittle"));
                product.setProductImg(rs.getString("productImg"));
                product.setCreatDate(rs.getDate("creatDate"));
                product.setImportPrice(rs.getFloat("importPrice"));
                product.setExportPrice(rs.getFloat("AvgExport"));
                product.setQuantity(rs.getInt("Quantity"));
                product.setStarPoint(rs.getInt("AvgStar"));
                product.setTotalStart(rs.getInt("reviews"));
                product.setProductStatus(rs.getInt("productStatus"));
                Catalog catalog = new Catalog();
                catalog.setCatalogId(rs.getInt("catalogId"));
                product.setCatalog(catalog);
//                product.setCatalogId(rs.getInt("catalogId"));
                lists.add(product);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        List<Product> productList = new ArrayList<>(lists);
        return  productList;
    }

}

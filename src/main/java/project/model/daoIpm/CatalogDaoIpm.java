package project.model.daoIpm;

import project.model.dao.ICatalogDao;
import project.model.emtity.Catalog;
import project.model.emtity.CatalogForCreat;
import project.model.emtity.CatalogInfo;
import project.model.serviceIpm.CatalogServiceIpm;
import project.model.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDaoIpm implements ICatalogDao<CatalogForCreat, Integer>  {

    @Override
    public List<CatalogForCreat> searchByName(String name) {
        List<CatalogInfo> infoList= null;
        Connection conn = null;
        CallableStatement cast=null;
        try {
            conn=ConnectionDB.openConnection();
            cast= conn.prepareCall("{call getCatalogByName(?)}");
            cast.setString(1,name);
            ResultSet rs= cast.executeQuery();
            infoList=new ArrayList<>();
            while (rs.next()){
                CatalogInfo cat= new CatalogInfo();
                cat.setCatalogId(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setDescriptions(rs.getString("descriptions"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                cat.setParentId(rs.getInt("parentId"));
                cat.setParentName(rs.getString("ParentName"));
                infoList.add(cat);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        List<CatalogForCreat> lists=new ArrayList<>(infoList);
        return lists;
    }

    @Override
    public List<CatalogForCreat> findChild(Integer parentId) {
        Connection conn=null;
        CallableStatement cast=null;
        List<CatalogForCreat> lists=null;
        try {
            conn=ConnectionDB.openConnection();
            cast=conn.prepareCall("{call getCatalogChild(?) }");
            cast.setInt(1,parentId);
            ResultSet rs= cast.executeQuery();
            lists=new ArrayList<>();
            while (rs.next()){
                CatalogForCreat cat=new CatalogForCreat();
                cat.setCatalogId(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                lists.add(cat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        return lists;
    }

    @Override
    public List<CatalogForCreat> getCatalogForCreat() {
        List<CatalogForCreat> catalogForCreatList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getCatalogForCreat()}");
            ResultSet rs = cast.executeQuery();
            catalogForCreatList = new ArrayList<>();
            while (rs.next()) {
                CatalogForCreat cat = new CatalogForCreat();
                cat.setCatalogId(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                catalogForCreatList.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return catalogForCreatList;
    }

    @Override
    public CatalogForCreat searchForDelete(String name) {
        CatalogForCreat cat =null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getCatalogFordelete(?)}");
            cast.setString(1, name);
            ResultSet rs = cast.executeQuery();
            cat = new CatalogForCreat();
            if (rs.next()) {
                cat.setCatalogId(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return cat;
    }

    @Override
    public List<CatalogForCreat> getCatCreatProduct() {
        List<CatalogInfo> catalogForCreatList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getCatalogCreatProduct()}");
            ResultSet rs = cast.executeQuery();
            catalogForCreatList = new ArrayList<>();
            while (rs.next()) {
                CatalogInfo cat = new CatalogInfo();
                cat.setCatalogId(rs.getInt("cId"));
                cat.setCatalogName(rs.getString("cName"));
                cat.setParentName(rs.getString("parentName"));
                catalogForCreatList.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        List<CatalogForCreat> list=new ArrayList<>(catalogForCreatList);
        return list;
    }

    @Override
    public List<CatalogForCreat> getCatRoot() {
        Connection conn=null;
        CallableStatement cast=null;
        List<CatalogForCreat> lists=null;
        try {
            conn=ConnectionDB.openConnection();
            cast=conn.prepareCall("{call findRootCat() }");
            ResultSet rs= cast.executeQuery();
            lists=new ArrayList<>();
            while (rs.next()){
                CatalogForCreat cat=new CatalogForCreat();
                cat.setCatalogId(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                lists.add(cat);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        return lists;
    }


    @Override
    public List<CatalogForCreat> findAll() {
        List<CatalogInfo> catalogInfoList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getAllCatalog()}");
            ResultSet rs = cast.executeQuery();
            catalogInfoList = new ArrayList<>();
            while (rs.next()) {
                CatalogInfo cat = new CatalogInfo();
                cat.setCatalogId(rs.getInt("catalogId"));
                cat.setCatalogName(rs.getString("catalogName"));
                cat.setDescriptions(rs.getString("descriptions"));
                cat.setCatalogStatus(rs.getBoolean("catalogStatus"));
                cat.setParentId(rs.getInt("parentId"));
                cat.setParentName(rs.getString("ParentName"));
                catalogInfoList.add(cat);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        List<CatalogForCreat> catInfoList = new ArrayList<>(catalogInfoList);
        return catInfoList;
    }

    @Override
    public boolean save(CatalogForCreat catalogForCreat) {
        Catalog catalog = (Catalog) catalogForCreat;
        Connection conn = null;
        CallableStatement cast = null;
        boolean result =true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call insertCatalog(?,?,?)}");
            cast.setString(1,catalog.getCatalogName());
            cast.setString(2,catalog.getDescriptions());
            cast.setInt(3,catalog.getParentId());
            cast.executeUpdate();
        } catch (SQLException ex) {
            result =false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public boolean update(CatalogForCreat catalogForCreat) {
        Catalog catalog = (Catalog) catalogForCreat;
        Connection conn = null;
        CallableStatement cast = null;
        boolean result =true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call updateCatalog(?,?,?,?,?)}");
            cast.setInt(1,catalog.getCatalogId());
            cast.setString(2,catalog.getCatalogName());
            cast.setString(3,catalog.getDescriptions());
            cast.setInt(4,catalog.getParentId());
            cast.setBoolean(5,catalog.isCatalogStatus());
            cast.executeUpdate();
        } catch (SQLException ex) {
            result =false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement cast = null;
        boolean result =true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call deleteCatalog(?)}");
            cast.setInt(1,id);
            cast.executeUpdate();
        } catch (SQLException ex) {
            result =false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public CatalogForCreat searchById(Integer id) {
        CatalogForCreat catalog =new Catalog();;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getCatalogById(?)}");
            cast.setInt(1, id);
            ResultSet rs = cast.executeQuery();
            catalog = new Catalog();
            if (rs.next()) {
                catalog.setCatalogId(rs.getInt("catalogId"));
                catalog.setCatalogName(rs.getString("catalogName"));
                ((Catalog) catalog).setDescriptions(rs.getString("descriptions"));
                ((Catalog) catalog).setCatalogStatus(rs.getBoolean("catalogStatus"));
                ((Catalog) catalog).setParentId(rs.getInt("parentId"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return catalog;
    }
}

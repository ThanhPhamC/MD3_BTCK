package project.model.daoIpm;

import project.model.dao.ISizeDao;
import project.model.emtity.Colors;
import project.model.emtity.Sizes;
import project.model.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SizeDaoIpm implements ISizeDao<Sizes,Integer> {
    @Override
    public List<Sizes> findAll() {
        List<Sizes> sizesList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call finAllSize()}");
            ResultSet rs = cast.executeQuery();
            sizesList = new ArrayList<>();
            while (rs.next()) {
                Sizes sizes = new Sizes();
                sizes.setSizeId(rs.getInt("sizeId"));
                sizes.setSizeName(rs.getString("sizeName"));
                sizes.setSizeStatus(rs.getBoolean("sizeStatus"));
                sizesList.add(sizes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return sizesList;
    }
    @Override
    public boolean save(Sizes sizes) {
        Connection conn = null;
        CallableStatement cast = null;
        boolean result=true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call saveSize(?)}");
            cast.setString(1, sizes.getSizeName());
            cast.executeUpdate();
        } catch (SQLException ex) {
            result=false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }
    @Override
    public boolean update(Sizes sizes) {
        Connection conn = null;
        CallableStatement cast = null;
        boolean result=true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call updateSize(?,?,?)}");
            cast.setInt(1, sizes.getSizeId());
            cast.setString(2,sizes.getSizeName());
            cast.setBoolean(3,sizes.getSizeStatus());
            cast.executeUpdate();
        } catch (SQLException ex) {
            result=false;
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
        boolean result=true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call deleteSize(?)}");
            cast.setInt(1, id);
            cast.executeUpdate();
        } catch (SQLException ex) {
            result=false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }
    @Override
    public Sizes searchById(Integer id) {
        return null;
    }
    @Override
    public List<Sizes> searchByName(String name) {
        List<Sizes> sizesList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call searchSizeByName(?)}");
            cast.setString(1,name);
            ResultSet rs = cast.executeQuery();
            sizesList = new ArrayList<>();
            while (rs.next()) {
                Sizes sizes = new Sizes();
                sizes.setSizeId(rs.getInt("sizeId"));
                sizes.setSizeName(rs.getString("sizeName"));
                sizes.setSizeStatus(rs.getBoolean("sizeStatus"));
                sizesList.add(sizes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return sizesList;
    }

    @Override
    public List<Sizes> findForCreatProduct() {
        List<Sizes> sizesList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call findSizeForCreatProduct()}");
            ResultSet rs = cast.executeQuery();
            sizesList = new ArrayList<>();
            while (rs.next()) {
                Sizes sizes = new Sizes();
                sizes.setSizeId(rs.getInt("sizeId"));
                sizes.setSizeName(rs.getString("sizeName"));
                sizes.setSizeStatus(rs.getBoolean("sizeStatus"));
                sizesList.add(sizes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return sizesList;
    }

    @Override
    public Sizes getLastIndex() {
        Sizes sizes= null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getLastIndexSize()}");
            ResultSet rs = cast.executeQuery();
            if (rs.next()) {
                sizes = new Sizes();
                sizes.setSizeId(rs.getInt("sizeId"));
                sizes.setSizeName(rs.getString("sizeName"));
                sizes.setSizeStatus(rs.getBoolean("sizeStatus"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return sizes;
    }

    @Override
    public List<Sizes> getSizeByProductId(Integer id) {
        List<Sizes> sizesList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getSizeByProductId(?)}");
            cast.setInt(1,id);
            ResultSet rs = cast.executeQuery();
            sizesList = new ArrayList<>();
            while (rs.next()) {
                Sizes sizes = new Sizes();
                sizes.setSizeId(rs.getInt("sizeId"));
                sizes.setSizeName(rs.getString("sizeName"));
                sizes.setSizeStatus(rs.getBoolean("sizeStatus"));
                sizesList.add(sizes);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return sizesList;
    }
}

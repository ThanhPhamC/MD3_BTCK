package project.model.daoIpm;

import project.model.dao.IColorDao;
import project.model.emtity.Colors;
import project.model.until.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDaoIpm implements IColorDao<Colors,Integer> {
    @Override
    public List<Colors> findAll() {
        List<Colors> colorsList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call finAllColor()}");
            ResultSet rs = cast.executeQuery();
            colorsList = new ArrayList<>();
            while (rs.next()) {
                Colors colors = new Colors();
                colors.setColorName(rs.getString("colorName"));
                colors.setColoId(rs.getInt("colorId"));
                colors.setColorHex(rs.getString("colorHex"));
                colors.setColorStatus(rs.getBoolean("colorStatus"));
                colorsList.add(colors);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return colorsList;
    }

    @Override
    public boolean save(Colors colors) {
        Connection conn = null;
        CallableStatement cast = null;
        boolean result=true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call saveColor(?,?)}");
            cast.setString(1,colors.getColorName());
            cast.setString(2, colors.getColorHex());
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
    public boolean update(Colors colors) {
        Connection conn = null;
        CallableStatement cast = null;
        boolean result=true;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call updateColor(?,?,?,?)}");

            cast.setInt(1, colors.getColoId());
            cast.setString(2, colors.getColorName());
            cast.setString(3, colors.getColorHex());
            cast.setBoolean(4,colors.isColorStatus());
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
            cast = conn.prepareCall("{call deleteColor(?)}");
            cast.setInt(1, id);
             cast.executeQuery();
        } catch (SQLException ex) {
            result= false;
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public Colors searchById(Integer id) {
        return null;
    }


    @Override
    public List<Colors> searchByName(String name) {
        List<Colors> colorsList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call searchColorByName(?)}");
            cast.setString(1, name);
            ResultSet rs = cast.executeQuery();
            colorsList = new ArrayList<>();
            while (rs.next()) {
                Colors colors = new Colors();
                colors.setColorName(rs.getString("colorName"));
                colors.setColoId(rs.getInt("colorId"));
                colors.setColorHex(rs.getString("colorHex"));
                colors.setColorStatus(rs.getBoolean("colorStatus"));
                colorsList.add(colors);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return colorsList;
    }

    @Override
    public List<Colors> findForCreatProduct() {
        List<Colors> colorsList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call findColorForCreatProduct()}");
            ResultSet rs = cast.executeQuery();
            colorsList = new ArrayList<>();
            while (rs.next()) {
                Colors colors = new Colors();
                colors.setColorName(rs.getString("colorName"));
                colors.setColoId(rs.getInt("colorId"));
                colors.setColorHex(rs.getString("colorHex"));
                colors.setColorStatus(rs.getBoolean("colorStatus"));
                colorsList.add(colors);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return colorsList;
    }

    @Override
    public Colors getLastIndex() {
       Colors colors= null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getLastIndexColor()}");
            ResultSet rs = cast.executeQuery();
            if (rs.next()) {
                colors = new Colors();
                colors.setColorName(rs.getString("colorName"));
                colors.setColoId(rs.getInt("colorId"));
                colors.setColorHex(rs.getString("colorHex"));
                colors.setColorStatus(rs.getBoolean("colorStatus"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return colors;
    }

    @Override
    public List<Colors> getColorByProductId(Integer id) {
        List<Colors> colorsList = null;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call getColorByProductId(?)}");
            cast.setInt(1, id);
            ResultSet rs = cast.executeQuery();
            colorsList = new ArrayList<>();
            while (rs.next()) {
                Colors colors = new Colors();
                colors.setColorName(rs.getString("colorName"));
                colors.setColoId(rs.getInt("colorId"));
                colors.setColorHex(rs.getString("colorHex"));
                colors.setColorStatus(rs.getBoolean("colorStatus"));
                colorsList.add(colors);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return colorsList;
    }
}

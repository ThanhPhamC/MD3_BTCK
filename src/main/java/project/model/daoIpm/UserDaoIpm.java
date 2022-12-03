package project.model.daoIpm;

import jdk.nashorn.internal.codegen.CompilerConstants;
import project.model.dao.IUserDao;
import project.model.emtity.User;
import project.model.until.ConnectionDB;
import sun.util.resources.sl.CalendarData_sl;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class UserDaoIpm implements IUserDao<User, Integer> {
    @Override
    public List<User> findAll() {
        Connection conn = null;
        CallableStatement cast = null;
        List<User> usersList = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call findAllUser()}");
            ResultSet rs = cast.executeQuery();
            usersList = new ArrayList<>();
            while (rs.next()) {
                User user = new User();
                user.setUserId(rs.getInt("userId"));
                user.setFullName(rs.getString("fullName"));
                user.setBirthDate(rs.getDate("birthDate"));
                user.setGender(rs.getBoolean("gender"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setAddressUser(rs.getString("addressUser"));
                user.setCloseCustumer(rs.getInt("closeCustumer"));
                user.setPhoneUser(rs.getString("phoneUser"));
                user.setPermission(rs.getInt("permission"));
                user.setUserStatus(rs.getBoolean("userStatus"));
                usersList.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return usersList;
    }

    @Override
    public boolean save(User user) {
        boolean result = true;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call saveUser(?,?,?,?,?,?,?,?,?)}");
            cast.setString(1, user.getFullName());
            cast.setDate(2, new Date(user.getBirthDate().getTime()));
            cast.setBoolean(3, user.isGender());
            cast.setString(4, user.getEmail());
            cast.setString(5, user.getAddressUser());
            cast.setString(6, user.getPhoneUser());
            cast.setString(7, user.getUserName());
            cast.setString(8, user.getPassWords());
            cast.registerOutParameter(9,Types.INTEGER);
            cast.execute();
            int userId= cast.getInt(9);
            CallableStatement cast2 = conn.prepareCall("{call saveCart(?)}");
            cast2.setInt(1,userId);
            cast2.executeUpdate();
        } catch (SQLException e) {
            result = false;
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;

    }

    @Override
    public boolean update(User user) {
        boolean result = true;
        Connection conn = null;
        CallableStatement cast = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call updateUser(?,?,?,?,?,?,?,?)}");
            cast.setString(1, user.getFullName());
            cast.setDate(2, new Date(user.getBirthDate().getTime()));
            cast.setBoolean(3, user.isGender());
            cast.setString(4, user.getEmail());
            cast.setString(5, user.getAddressUser());
            cast.setString(6, user.getPhoneUser());
            cast.setString(7, user.getUserName());
            cast.setString(8, user.getPassWords());
            cast.executeUpdate();
        } catch (SQLException e) {
            result = false;
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return result;
    }

    @Override
    public boolean delete(Integer id) {
        Connection conn = null;
        CallableStatement cast= null;
        boolean resutl = true;
        try {
            conn= ConnectionDB.openConnection();
            cast= conn.prepareCall("{call lockUser(?)}");
            cast.setInt(1,id);
        } catch (SQLException e) {
            resutl=false;
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        return resutl;
    }

    @Override
    public User searchById(Integer id) {
        Connection conn = null;
        CallableStatement cast = null;
        User user = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call searchById(?)}");
            cast.setInt(1,id);
            ResultSet rs = cast.executeQuery();
            user = new User();
            if (rs.next()) {

                user.setUserId(rs.getInt("userId"));
                user.setFullName(rs.getString("fullName"));
                user.setBirthDate(rs.getDate("birthDate"));
                user.setGender(rs.getBoolean("gender"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setAddressUser(rs.getString("addressUser"));
                user.setCloseCustumer(rs.getInt("closeCustumer"));
                user.setPhoneUser(rs.getString("phoneUser"));
                user.setPermission(rs.getInt("permission"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, cast);
        }
        return user;
    }

    @Override
    public User checkLogin(String userName, String pass) {
        Connection conn = null;
        CallableStatement cast = null;
        User user = null;
        try {
            conn = ConnectionDB.openConnection();
            cast = conn.prepareCall("{call checkLogin(?,?)}");
            cast.setString(1,userName);
            cast.setString(2,pass);
            ResultSet rs = cast.executeQuery();
            user = new User();
            if (rs.next()) {
                user.setUserId(rs.getInt("userId"));
                user.setFullName(rs.getString("fullName"));
                user.setBirthDate(rs.getDate("birthDate"));
                user.setGender(rs.getBoolean("gender"));
                user.setAvatar(rs.getString("avatar"));
                user.setEmail(rs.getString("email"));
                user.setAddressUser(rs.getString("addressUser"));
                user.setCloseCustumer(rs.getInt("closeCustumer"));
                user.setPhoneUser(rs.getString("phoneUser"));
                user.setPermission(rs.getInt("permission"));
                user.setUserName(rs.getString("userName"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn,cast);
        }
        return user;
    }


}

package project.model.serviceIpm;

import project.model.dao.IUserDao;
import project.model.daoIpm.UserDaoIpm;
import project.model.emtity.User;
import project.model.service.IUserService;

import java.util.List;

public class UserServiceIpm implements IUserService<User,Integer> {
    private IUserDao<User,Integer> iUserDao= new UserDaoIpm();
    @Override
    public List<User> findAll() {
        return iUserDao.findAll();
    }

    @Override
    public boolean save(User user) {
        return iUserDao.save(user);
    }

    @Override
    public boolean update(User user) {
        return iUserDao.update(user);
    }

    @Override
    public boolean delete(Integer id) {
        return iUserDao.delete(id);
    }

    @Override
    public User searchById(Integer id) {
        return iUserDao.searchById(id);
    }

    @Override
    public User checkLogin(String userName, String pass) {
        return iUserDao.checkLogin(userName,pass);
    }


}

package project.model.serviceIpm;

import project.model.dao.IColorDao;
import project.model.daoIpm.ColorDaoIpm;
import project.model.emtity.Colors;
import project.model.service.IColorService;
import java.util.List;
public class ColorServiceIpm implements IColorService<Colors,Integer> {
  private IColorDao<Colors,Integer> colorDao=new ColorDaoIpm();
    @Override
    public List<Colors> findAll() {
        return colorDao.findAll();
    }

    @Override
    public boolean save(Colors colors) {
        return colorDao.save(colors);
    }

    @Override
    public boolean update(Colors colors) {
        return colorDao.update(colors);
    }

    @Override
    public boolean delete(Integer id) {
        return colorDao.delete(id);
    }

    @Override
    public Colors searchById(Integer id) {
        return colorDao.searchById(id);
    }

    @Override
    public List<Colors> searchByName(String name) {
        return colorDao.searchByName(name);
    }

    @Override
    public List<Colors> findForCreatProduct() {
        return colorDao.findForCreatProduct();
    }

    @Override
    public Colors getLastIndex() {
        return colorDao.getLastIndex();
    }

    @Override
    public List<Colors> getColorByProductId(Integer id) {
        return colorDao.getColorByProductId(id);
    }
}

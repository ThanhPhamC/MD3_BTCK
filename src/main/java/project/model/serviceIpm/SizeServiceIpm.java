package project.model.serviceIpm;

import project.model.dao.ISizeDao;
import project.model.daoIpm.SizeDaoIpm;
import project.model.emtity.Sizes;
import project.model.service.IColorService;
import project.model.service.ISizeService;

import java.util.List;

public class SizeServiceIpm implements ISizeService<Sizes,Integer> {
    private ISizeDao<Sizes,Integer> sizeDao=new SizeDaoIpm();

    @Override
    public List<Sizes> findAll() {
        return sizeDao.findAll();
    }

    @Override
    public boolean save(Sizes sizes) {
        return sizeDao.save(sizes);
    }
    @Override
    public boolean update(Sizes sizes) {
        return sizeDao.update(sizes);
    }

    @Override
    public boolean delete(Integer id) {
        return sizeDao.delete(id);
    }

    @Override
    public Sizes searchById(Integer id) {
        return sizeDao.searchById(id);
    }

    @Override
    public List<Sizes> searchByName(String name) {
        return sizeDao.searchByName(name);
    }

    @Override
    public List<Sizes> findSizeForCreatProduct() {
        return sizeDao.findForCreatProduct();
    }

    @Override
    public Sizes getLastIndex() {
        return sizeDao.getLastIndex();
    }

    @Override
    public List<Sizes> getSizeByProductId(Integer id) {
        return sizeDao.getSizeByProductId(id);
    }
}

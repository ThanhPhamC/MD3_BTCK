package project.model.serviceIpm;

import project.model.dao.ICatalogDao;
import project.model.daoIpm.CatalogDaoIpm;
import project.model.emtity.CatalogForCreat;
import project.model.service.ICatalogService;

import java.util.List;

public class CatalogServiceIpm implements ICatalogService<CatalogForCreat,Integer>  {
        private ICatalogDao<CatalogForCreat,Integer> catalogDAO= new CatalogDaoIpm();

    @Override
    public List<CatalogForCreat> getCatRoot() {
        return catalogDAO.getCatRoot();
    }

    @Override
    public List<CatalogForCreat> searchByName(String name) {
        return catalogDAO.searchByName(name);
    }

    @Override
    public List<CatalogForCreat> findChild(Integer parentId) {
        return catalogDAO.findChild(parentId);
    }

    @Override
    public List<CatalogForCreat> getCatalogForCreat() {
        return catalogDAO.getCatalogForCreat();
    }

    @Override
    public CatalogForCreat searchForDelete(String name) {
        return catalogDAO.searchForDelete(name);
    }

    @Override
    public List<CatalogForCreat> getCatCreatProduct() {
        return catalogDAO.getCatCreatProduct();
    }


    @Override
    public List<CatalogForCreat> findAll() {
        return catalogDAO.findAll();
    }

    @Override
    public boolean save(CatalogForCreat catalogForCreat) {
        return catalogDAO.save(catalogForCreat);
    }

    @Override
    public boolean update(CatalogForCreat catalogForCreat) {
        return catalogDAO.update(catalogForCreat);
    }

    @Override
    public boolean delete(Integer id) {
        return catalogDAO.delete(id);
    }

    @Override
    public CatalogForCreat searchById(Integer id) {
        return catalogDAO.searchById(id);
    }
}

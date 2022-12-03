package project.model.serviceIpm;

import project.model.dao.IProductDao;
import project.model.daoIpm.ProductDaoIpm;
import project.model.emtity.Product;
import project.model.service.IProductService;

import java.util.List;

public class ProductServiceIpm implements IProductService<Product,Integer> {
    private IProductDao<Product,Integer> productDao= new ProductDaoIpm();
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public Product searchById(Integer id) {
        return productDao.searchById(id);
    }

    @Override
    public List<Product>  searchByName(String name) {
        return productDao.searchByName(name);
    }

    @Override
    public Product searchByPrice(float price) {
        return productDao.searchByPrice(price);
    }

    @Override
    public Product getLastIndex() {
        return productDao.getLastIndex();
    }
    @Override
    public boolean saveDetail(Product product) {
        return productDao.saveDetail(product);
    }

    @Override
    public Product getLastDetailIndex() {
        return productDao.getLastDetailIndex();
    }

    @Override
    public List<Product> getDetailById(Integer id) {
        return productDao.getDetailById(id);
    }

    @Override
    public List<Product> getProductByCatId(Integer id) {
        return productDao.getProductByCatId(id);
    }




    @Override
    public boolean delete(Integer id) {
        return productDao.delete(id);
    }
}

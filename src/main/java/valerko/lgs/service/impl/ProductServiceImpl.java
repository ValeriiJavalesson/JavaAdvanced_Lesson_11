package valerko.lgs.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import valerko.lgs.dao.ProductDao;
import valerko.lgs.dao.impl.ProductDaoImpl;
import valerko.lgs.domain.Product;
import valerko.lgs.service.ProductService;

public class ProductServiceImpl implements ProductService {
	private static ProductService ProductServiceImpl;
	private ProductDao productDao;

	private ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}

	public static ProductService getProductService() {
		if (ProductServiceImpl == null) {
			ProductServiceImpl = new ProductServiceImpl();
		}

		return ProductServiceImpl;
	}

	@Override
	public Product create(Product t) {
		return productDao.create(t);
	}

	@Override
	public Product read(Integer id) {
		return productDao.read(id);
	}

	@Override
	public Product update(Product t) {
		return productDao.update(t);
	}

	@Override
	public void delete(Integer id) {
		productDao.delete(id);
	}

	@Override
	public List<Product> readAll() {
		return productDao.readAll();
	}

	@Override
	public Map<Integer, Product> readAllMap() {
		return  readAll().stream().collect(Collectors.toMap(Product::getId, Function.identity()));
	}

}

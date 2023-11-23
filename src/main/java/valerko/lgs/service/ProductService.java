package valerko.lgs.service;

import java.util.Map;

import valerko.lgs.domain.Product;
import valerko.lgs.shared.AbstractCRUD;

public interface ProductService extends AbstractCRUD<Product>{
	public Map<Integer, Product> readAllMap();

}

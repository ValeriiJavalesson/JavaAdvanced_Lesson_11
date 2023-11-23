package valerko.lgs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import valerko.lgs.dao.ProductDao;
import valerko.lgs.domain.Product;
import valerko.lgs.utils.ConnectionUtil;

public class ProductDaoImpl implements ProductDao {
	private static final String READ_ALL = "select * from product where is_deleted=false";
	private static final String CREATE = "insert into product(`title`, `description`, `price`) values (?,?,?)";
	private static final String READ_BY_ID = "select * from product where id=?";
	private static final String UPDATE_BY_ID = "update product set title=?, description=?, price = ? where id = ?";
	private static final String DELETE_BY_ID = "update product set is_deleted=true where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	private static Logger LOGGER = Logger.getLogger(ProductDaoImpl.class);
	
	public ProductDaoImpl() {
		this.connection = ConnectionUtil.getInstance().getConnection();
	}

	@Override
	public Product create(Product product) {
		try {
			preparedStatement = connection.prepareStatement(CREATE);
			preparedStatement.setString(1, product.getTitle());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

	@Override
	public Product read(Integer id) {
		Product product = null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			product = Product.map(result);
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

	@Override
	public Product update(Product product) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, product.getTitle());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setDouble(3, product.getPrice());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return product;
	}

	@Override
	public void delete(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public List<Product> readAll() {
		List<Product> listOProducts = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				listOProducts.add(Product.map(result));
			}
		} catch (SQLException e) {
			LOGGER.error(e);
		}
		return listOProducts;
	}

}
